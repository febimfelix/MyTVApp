package com.febi.mytvapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static java.net.HttpURLConnection.HTTP_OK;

public class WebService {
    private String mUrl;
    private String mHttpMethod;

    private static final int REQUEST_TIMEOUT        = 40000;
    private static final int REQUEST_IMAGE_TIMEOUT  = 60000;
    private static final int OPTIMAL_BUFFERSIZE     =  8096; //8K Ref : https://stackoverflow.com/a/11221907/640731

    //region Constructor
    public WebService(String url, String method) {
        mUrl        = url;
        mHttpMethod = method;
    }
    //endregion

    //region Http Request
    public WebResponse sendHttpRequest(JSONObject jsonParams) {
        AppUtils.longInfo("Request : " + mUrl);
        if(jsonParams != null)
            AppUtils.longInfo("Request Params : " +jsonParams.toString());

        URL url         = null;
        String response = "";
        int responseCode;

        try {
            url         = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url == null)
            return verifyResultAndReturnResponse(response);

        HttpURLConnection conn  = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("Content-Type", "application/json");
            conn.addRequestProperty("Accept", "application/json");
            conn.setReadTimeout(REQUEST_TIMEOUT);
            conn.setConnectTimeout(REQUEST_TIMEOUT);
            if(mHttpMethod.equals(Constants.HTTP_DELETE)) {
                if (Build.VERSION.SDK_INT > 19) {
                    conn.setRequestMethod(mHttpMethod);
                } else {
                    conn.setRequestProperty("X-HTTP-Method-Override", "DELETE");
                    conn.setRequestMethod("POST");
                }
            } else
                conn.setRequestMethod(mHttpMethod);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(conn == null)
            return verifyResultAndReturnResponse(response);

        String token = AppContext.getLoginToken(AppContext.getAppContext());
        if(token != null && !token.isEmpty())
            conn.addRequestProperty("Authorization", "Bearer " + token);

        if(jsonParams != null) {
            try {
                DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
                byte[] data = jsonParams.toString().getBytes("UTF-8");
                writer.write(data);

                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            responseCode = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK)
                response = getStringFromInputStream(conn.getInputStream());
            else
                response = getStringFromInputStream(conn.getErrorStream());
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return returnTimeOutResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppUtils.longInfo("Response : " +response);
        return verifyResultAndReturnResponse(response);
    }
    //endregion

    //region Profile Photo Upload Request
    public WebResponse postProfilePhotoUploadRequest(File file) {
        AppUtils.longInfo("Request : " + mUrl);

        String twoHyphens   = "--";
        String boundary     =  "*****" + Long.toString(System.currentTimeMillis()) + "*****";
        String lineEnd      = "\r\n";
        String response     = "";
        int responseCode;

        int bytesRead;
        int bufferSize      = OPTIMAL_BUFFERSIZE;

        URL url = null;
        try {
            url = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url == null)
            return verifyResultAndReturnResponse(response);

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(REQUEST_TIMEOUT);
            connection.setConnectTimeout(REQUEST_TIMEOUT);
            connection.setRequestMethod(mHttpMethod);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
            connection.addRequestProperty("Authorization", "Bearer " + AppContext.getLoginToken(AppContext.getAppContext()));
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(connection == null)
            return verifyResultAndReturnResponse(response);

        DataOutputStream outputStream = null;
        try {
            outputStream    = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream.writeBytes("Content-Disposition: form-data; name=\"" + "new_profile_picture"
                    + "\"; filename=\"" + "profile.jpeg" +"\"" + lineEnd);
            outputStream.writeBytes(lineEnd);
        } catch (IOException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        FileInputStream fiStream = null;
        try {
            fiStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        try {
            byte[] buffer = new byte[bufferSize];
            bytesRead = fiStream.read(buffer, 0, bufferSize);
            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesRead = fiStream.read(buffer, 0, bufferSize);
            }
            outputStream.writeBytes(lineEnd);
            outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
            fiStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        try {
            responseCode    = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK)
                response    = getStringFromInputStream(connection.getInputStream());
            else
                response    = getStringFromInputStream(connection.getErrorStream());
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return returnTimeOutResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppUtils.longInfo("Response : " +response);
        return verifyResultAndReturnResponse(response);
    }
    //endregion

    //region Service Photo Upload Request
    public WebResponse postServicePhotoUploadRequest(File file, String mediaName) {
        AppUtils.longInfo("Request : " + mUrl);

        String twoHyphens   = "--";
        String boundary     =  "*****" + Long.toString(System.currentTimeMillis()) + "*****";
        String lineEnd      = "\r\n";
        String response     = "";
        int responseCode;

        int bytesRead;
        int bufferSize      = OPTIMAL_BUFFERSIZE;
        byte[] buffer;

        URL url         = null;
        try {
            url = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url == null)
            return verifyResultAndReturnResponse(response);

        HttpURLConnection connection = null;
        try {
            connection      = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setReadTimeout(REQUEST_IMAGE_TIMEOUT);
            connection.setConnectTimeout(REQUEST_IMAGE_TIMEOUT);
            connection.setRequestMethod(mHttpMethod);
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary="+boundary);
            connection.addRequestProperty("Authorization", "Bearer " + AppContext.getLoginToken(AppContext.getAppContext()));
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(connection == null)
            return verifyResultAndReturnResponse(response);

        DataOutputStream outputStream = null;
        try {
            outputStream    = new DataOutputStream(connection.getOutputStream());
            outputStream.writeBytes(twoHyphens + boundary + lineEnd);
            outputStream.writeBytes("Content-Disposition: form-data; name=\"" + mediaName
                    + "\"; filename=\"" + "media.jpeg" +"\"" + lineEnd);
            outputStream.writeBytes(lineEnd);
        } catch (IOException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        buffer = new byte[bufferSize];
        try {
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            while (bytesRead > 0) {
                outputStream.write(buffer, 0, bufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            }

            outputStream.writeBytes(lineEnd);
            outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        try {
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return returnImageErrorResponse(e.getLocalizedMessage());
        }

        try {
            responseCode = connection.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK)
                response = getStringFromInputStream(connection.getInputStream());
            else
                response = getStringFromInputStream(connection.getErrorStream());
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return returnTimeOutResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppUtils.longInfo("Response : " +response);
        return verifyResultAndReturnResponse(response);
    }
    //endregion

    //region STRIPE Requests
    public WebResponse sendStripeApiRequest(HashMap<String, Object> jsonParams) {
        AppUtils.longInfo("Request : " + mUrl);
        if(jsonParams != null)
            AppUtils.longInfo("Request Params : " +jsonParams.toString());

        String response = "";
        int responseCode = -1;

        URL url = null;
        try {
            url = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url == null)
            return verifyResultAndReturnResponse(response);

        HttpsURLConnection conn  = null;
        try {
            conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(new StripeSSLSocketFactory());
            conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.addRequestProperty("Accept", "application/json");
            conn.setReadTimeout(REQUEST_TIMEOUT);
            conn.setConnectTimeout(REQUEST_TIMEOUT);
            conn.setRequestMethod(mHttpMethod);
            conn.addRequestProperty("Authorization", "Bearer " + Constants.STRIPE_API_KEY);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(conn == null)
            return verifyResultAndReturnResponse(response);

        if(jsonParams != null) {
            DataOutputStream writer;
            try {
                writer = new DataOutputStream(conn.getOutputStream());
                byte[] data = createQuery(jsonParams).getBytes("UTF-8");
                writer.write(data);

                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            responseCode = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK)
                response    = getStringFromInputStream(conn.getInputStream());
            else
                response    = getStringFromInputStream(conn.getErrorStream());
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return returnTimeOutResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppUtils.longInfo("Response : " +response);
        return verifyStripeResponse(response, responseCode);
    }

    private static String createQuery(Map<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder queryStringBuffer = new StringBuilder();
        List<Parameter> flatParams      = flattenParams(params);
        Iterator<Parameter> it          = flatParams.iterator();

        while (it.hasNext()) {
            if (queryStringBuffer.length() > 0)
                queryStringBuffer.append("&");
            Parameter param = it.next();
            queryStringBuffer.append(urlEncodePair(param.key, param.value));
        }

        AppUtils.longInfo(queryStringBuffer.toString());

        return queryStringBuffer.toString();
    }

    private static List<Parameter> flattenParams(Map<String, Object> params) {
        return flattenParamsMap(params, null);
    }

    private static String urlEncodePair(String k, String v) throws UnsupportedEncodingException {
        return String.format("%s=%s", urlEncode(k), urlEncode(v));
    }

    private static String urlEncode(String str) throws UnsupportedEncodingException {
        if (str == null)
            return null;
        else
            return URLEncoder.encode(str, Constants.CHARSET);
    }

    private static List<Parameter> flattenParamsMap(Map<String, Object> params, String keyPrefix) {
        List<Parameter> flatParams = new LinkedList<>();
        if (params == null)
            return flatParams;

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            String newPrefix = key;
            if (keyPrefix != null)
                newPrefix = String.format("%s[%s]", keyPrefix, key);
            flatParams.addAll(flattenParamsValue(value, newPrefix));
        }

        return flatParams;
    }

    private static List<Parameter> flattenParamsList(List<Object> params, String keyPrefix) {
        List<Parameter> flatParams = new LinkedList<>();
        Iterator<?> it = ((List<?>)params).iterator();
        String newPrefix = String.format("%s[]", keyPrefix);

        if (params.isEmpty()) {
            flatParams.add(new Parameter(keyPrefix, ""));
        } else {
            while (it.hasNext()) {
                flatParams.addAll(flattenParamsValue(it.next(), newPrefix));
            }
        }

        return flatParams;
    }

    private static List<Parameter> flattenParamsValue(Object value, String keyPrefix) {
        List<Parameter> flatParams = new LinkedList<>();

        if (value instanceof Map<?, ?>) {
            flatParams = flattenParamsMap((Map<String, Object>)value, keyPrefix);
        } else if (value instanceof List<?>) {
            flatParams = flattenParamsList((List<Object>)value, keyPrefix);
        } else if ("".equals(value)) {
            AppUtils.longInfo("You cannot set '"+ keyPrefix +"' to an empty string. "+
                    "We interpret empty strings as null in requests. "+
                    "You may set '"+ keyPrefix +"' to null to delete the property.");
        } else if (value == null) {
            flatParams = new LinkedList<>();
            flatParams.add(new Parameter(keyPrefix, ""));
        } else {
            flatParams = new LinkedList<>();
            flatParams.add(new Parameter(keyPrefix, value.toString()));
        }

        return flatParams;
    }

    private WebResponse verifyStripeResponse(String response, int responseCode) {
        WebResponse webResponse = new WebResponse();

        if(responseCode == HTTP_OK) {
            try {
                webResponse.setResponseCode(WebResponse.ResponseCode.success);
                if(new JSONObject(response).has("deleted")) {
                    if(new JSONObject(response).getBoolean("deleted"))
                        webResponse.setResponseCode(WebResponse.ResponseCode.stripeCustomerDeleted);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            webResponse.setResponse(response);
        } else {
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(response);
                JSONObject errorObject = jsonObject.optJSONObject("error");
                if(errorObject != null) {
                    webResponse.setResponseCode(WebResponse.ResponseCode.error);
                    String message = "\n" + (errorObject.isNull("message") ? "" : errorObject.getString("message"));
                    webResponse.setMessage(message);
                }
            } catch (JSONException e) {
                webResponse.setResponseCode(WebResponse.ResponseCode.error);
                webResponse.setMessage(AppContext.getAppContext().getResources().getString(R.string.api_invalid_response));
            }
        }

        return webResponse;
    }

    private final static class Parameter {
        public final String key;
        public final String value;

        public Parameter(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    //endregion

    //region Google API Request
    public WebResponse sendGoogleApiRequest() {
        AppUtils.longInfo("Request : " + mUrl);

        URL url         = null;
        String response = "";
        int responseCode;
        try {
            url         = new URL(mUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url == null)
            return verifyResults(response);

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(REQUEST_TIMEOUT);
            conn.setConnectTimeout(REQUEST_TIMEOUT);
            conn.setRequestMethod(mHttpMethod);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(conn == null)
            return verifyResults(response);

        try {
            responseCode    = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK)
                response    = getStringFromInputStream(conn.getInputStream());
            else
                response    = getStringFromInputStream(conn.getErrorStream());
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            return returnTimeOutResponse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        AppUtils.longInfo("Response : " +response);
        return verifyResults(response);
    }

    private WebResponse verifyResults(String response) {
        WebResponse webResponse = new WebResponse();

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
            String statusString = jsonObject.getString("status");
            if(statusString.equals(Constants.GEOCODE_STATUS_OK)) {
                webResponse.setResponseCode(WebResponse.ResponseCode.success);
                webResponse.setMessage("");
                webResponse.setResponse(response);
            } else if (statusString.equals(Constants.GEOCODE_STATUS_ZERO_RESULTS)
                    || statusString.equals(Constants.GEOCODER_STATUS_OVER_LIMIT)
                    || statusString.equals(Constants.GEOCODER_INVALID_REQUEST)
                    || statusString.equals(Constants.GEOCODER_STATUS_DENIED)) {
                webResponse.setResponseCode(WebResponse.ResponseCode.error);
                webResponse.setMessage(statusString);
            } else if (statusString.equals(Constants.GEOCODER_UNKNOWN_ERROR)) {
                webResponse.setResponseCode(WebResponse.ResponseCode.tryAgain);
                webResponse.setMessage("");
                webResponse.setResponse(response);
            }
        } catch (JSONException e) {
            webResponse.setResponseCode(WebResponse.ResponseCode.error);
            webResponse.setMessage(AppContext.getAppContext().getResources().getString(R.string.api_invalid_response));
        }

        return webResponse;
    }
    //endregion

    //region Verify Http Results
    private WebResponse returnTimeOutResponse() {
        WebResponse webResponse = new WebResponse();
        webResponse.setResponseCode(WebResponse.ResponseCode.error);
        webResponse.setMessage(AppContext.getAppContext().getResources().getString(R.string.api_socket_timeout_response));
        return webResponse;
    }

    private WebResponse returnImageErrorResponse(String error) {
        WebResponse webResponse = new WebResponse();
        webResponse.setResponseCode(WebResponse.ResponseCode.error);
        webResponse.setMessage(error);
        return webResponse;
    }

    private WebResponse verifyResultAndReturnResponse(String response) {
        WebResponse webResponse = new WebResponse();

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
            String statusString = jsonObject.getString("status");
            if(statusString.equals(WebResponse.ResponseCode.success.toString())) {
                webResponse.setResponseCode(WebResponse.ResponseCode.success);
                webResponse.setMessage(jsonObject.isNull("message")
                        ? "" : jsonObject.getString("message"));
                webResponse.setResponse(response);
            } else if (statusString.equals(WebResponse.ResponseCode.error.toString())) {
                webResponse.setResponseCode(WebResponse.ResponseCode.error);
                webResponse.setMessage(getCompleteErrorMessage(jsonObject));
                webResponse.setErrorCode(jsonObject.isNull("error_code")
                        ? 0 : jsonObject.getInt("error_code"));
            } else if (statusString.equals(WebResponse.ResponseCode.sessionOut.toString())) {
                webResponse.setResponseCode(WebResponse.ResponseCode.sessionOut);
                webResponse.setMessage(jsonObject.isNull("message")
                        ? AppContext.getAppContext().getResources().getString(
                                R.string.api_session_out_response) : jsonObject.getString("message"));
                webResponse.setResponse(response);
            }
        } catch (JSONException e) {
            webResponse.setResponseCode(WebResponse.ResponseCode.error);
            webResponse.setMessage(AppContext.getAppContext().getResources().getString(R.string.api_invalid_response));
        }

        return webResponse;
    }

    private String getCompleteErrorMessage(JSONObject object) {
        StringBuilder completeMessage = new StringBuilder();

        try {
            JSONObject errorObject  = object.optJSONObject("errors");
            if(errorObject != null) {
                Iterator<?> keys    = errorObject.keys();
                while (keys.hasNext()) {
                    String key      = (String) keys.next();
                    if (errorObject.get(key) instanceof JSONArray) {
                        JSONArray arrayForKey = errorObject.getJSONArray(key);
                        for (int i = 0; i < arrayForKey.length(); i++) {
                            String singleMessage = arrayForKey.getString(i);
                            completeMessage.append("\n" + singleMessage);
                        }
                    }
                }
            }

            if(completeMessage.toString().isEmpty()) {
                String messageValue  = object.isNull("message") ? "" : object.getString("message");
                completeMessage.append(messageValue);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String finalMessage = completeMessage.toString();
        if (finalMessage.trim().length() == 0)
            finalMessage    = AppContext.getAppContext().getResources().getString(R.string.api_invalid_response);
        return finalMessage;
    }
    //endregion

    //region Navigation Directions Request
    public WebResponse sendNavigationDirectionsRequest(String directionsUrl) {
        AppUtils.longInfo(directionsUrl);
        String data         = "";
        HttpURLConnection urlConnection = null;
        try {
            URL url         = new URL(directionsUrl);
            urlConnection   = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK)
                data        = getStringFromInputStream(urlConnection.getInputStream());
            else
                data        = getStringFromInputStream(urlConnection.getErrorStream());

            AppUtils.longInfo(data);
        } catch (Exception e) {
            AppUtils.longInfo(e.toString());
        } finally {
            if(urlConnection != null)
                urlConnection.disconnect();
        }
        return verifyDirectionsResponse(data);
    }

    private WebResponse verifyDirectionsResponse(String response) {
        WebResponse webResponse = new WebResponse();

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(response);
            String statusString = jsonObject.getString("status");
            if(statusString.equals("OK")) {
                webResponse.setResponseCode(WebResponse.ResponseCode.success);
                webResponse.setMessage("");
                webResponse.setResponse(response);
            } else {
                webResponse.setResponseCode(WebResponse.ResponseCode.error);
                webResponse.setMessage(statusString);
                webResponse.setResponse(response);
            }
        } catch (JSONException e) {
            webResponse.setResponseCode(WebResponse.ResponseCode.error);
            webResponse.setMessage(AppContext.getAppContext().getResources().getString(R.string.api_invalid_response));
        }

        return webResponse;
    }
    //endregion

    //region Download Share Image from Server
    public Bitmap downloadShareImageFromServer() {
        HttpURLConnection urlConnection = null;
        try {
            URL uri = new URL(mUrl);
            urlConnection = (HttpURLConnection) uri.openConnection();

            int statusCode = urlConnection.getResponseCode();
            if (statusCode != HttpsURLConnection.HTTP_OK)
                return null;

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream != null)
                return BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            AppUtils.longInfo("Download Image Error : " + e.toString());
            if (urlConnection != null)
                urlConnection.disconnect();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
        return null;
    }
    //endregion

    private String getStringFromInputStream(InputStream stream) throws IOException {
        int n;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader    = new InputStreamReader(stream, "UTF8");
        StringWriter writer         = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
    }
}
