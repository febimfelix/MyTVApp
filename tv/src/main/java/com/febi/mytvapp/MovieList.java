package com.febi.mytvapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MovieList {
    public static final String MOVIE_CATEGORY[] = {
            "Comedy Movies",
            "Kids Movies",
            "Classic Movies",
            "Action Movies",
            "Thriller Movies",
            "Fantasy Movies",
    };

    public final static String[] comedyMovieImageUrls = new String[] {
            "https://lh4.googleusercontent.com/-GztnWEIiMz8/URqukVCU7bI/AAAAAAAAAbs/jo2Hjv6MZ6M/s1024/Countryside.jpg",
            "https://lh4.googleusercontent.com/-bEg9EZ9QoiM/URquklz3FGI/AAAAAAAAAbs/UUuv8Ac2BaE/s1024/Death%252520Valley%252520-%252520Dunes.jpg",
            "https://lh6.googleusercontent.com/-ijQJ8W68tEE/URqulGkvFEI/AAAAAAAAAbs/zPXvIwi_rFw/s1024/Delicate%252520Arch.jpg",
            "https://lh5.googleusercontent.com/-Oh8mMy2ieng/URqullDwehI/AAAAAAAAAbs/TbdeEfsaIZY/s1024/Despair.jpg",
            "https://lh5.googleusercontent.com/-gl0y4UiAOlk/URqumC_KjBI/AAAAAAAAAbs/PM1eT7dn4oo/s1024/Eagle%252520Fall%252520Sunrise.jpg",
            "https://lh3.googleusercontent.com/-hYYHd2_vXPQ/URqumtJa9eI/AAAAAAAAAbs/wAalXVkbSh0/s1024/Electric%252520Storm.jpg",
            "https://lh5.googleusercontent.com/-PyY_yiyjPTo/URqunUOhHFI/AAAAAAAAAbs/azZoULNuJXc/s1024/False%252520Kiva.jpg",
            "https://lh6.googleusercontent.com/-PYvLVdvXywk/URqunwd8hfI/AAAAAAAAAbs/qiMwgkFvf6I/s1024/Fitzgerald%252520Streaks.jpg",
            "https://lh4.googleusercontent.com/-KIR_UobIIqY/URquoCZ9SlI/AAAAAAAAAbs/Y4d4q8sXu4c/s1024/Foggy%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-9lzOk_OWZH0/URquoo4xYoI/AAAAAAAAAbs/AwgzHtNVCwU/s1024/Frantic.jpg",
            "https://lh3.googleusercontent.com/-0X3JNaKaz48/URqupH78wpI/AAAAAAAAAbs/lHXxu_zbH8s/s1024/Golden%252520Gate%252520Afternoon.jpg",
            "https://lh6.googleusercontent.com/-95sb5ag7ABc/URqupl95RDI/AAAAAAAAAbs/g73R20iVTRA/s1024/Golden%252520Gate%252520Fog.jpg",
            "https://lh3.googleusercontent.com/-JB9v6rtgHhk/URqup21F-zI/AAAAAAAAAbs/64Fb8qMZWXk/s1024/Golden%252520Grass.jpg",
            "https://lh4.googleusercontent.com/-EIBGfnuLtII/URquqVHwaRI/AAAAAAAAAbs/FA4McV2u8VE/s1024/Grand%252520Teton.jpg",
            "https://lh4.googleusercontent.com/-WoMxZvmN9nY/URquq1v2AoI/AAAAAAAAAbs/grj5uMhL6NA/s1024/Grass%252520Closeup.jpg",
            "https://lh3.googleusercontent.com/-6hZiEHXx64Q/URqurxvNdqI/AAAAAAAAAbs/kWMXM3o5OVI/s1024/Green%252520Grass.jpg",
    };

    public final static String[] kidsMovieImageUrls = new String[] {
            "https://lh5.googleusercontent.com/-6LVb9OXtQ60/URquteBFuKI/AAAAAAAAAbs/4F4kRgecwFs/s1024/Hanging%252520Leaf.jpg",
            "https://lh4.googleusercontent.com/-zAvf__52ONk/URqutT_IuxI/AAAAAAAAAbs/D_bcuc0thoU/s1024/Highway%2525201.jpg",
            "https://lh6.googleusercontent.com/-H4SrUg615rA/URquuL27fXI/AAAAAAAAAbs/4aEqJfiMsOU/s1024/Horseshoe%252520Bend%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-JhFi4fb_Pqw/URquuX-QXbI/AAAAAAAAAbs/IXpYUxuweYM/s1024/Horseshoe%252520Bend.jpg",
            "https://lh5.googleusercontent.com/-UGgssvFRJ7g/URquueyJzGI/AAAAAAAAAbs/yYIBlLT0toM/s1024/Into%252520the%252520Blue.jpg",
            "https://lh3.googleusercontent.com/-CH7KoupI7uI/URquu0FF__I/AAAAAAAAAbs/R7GDmI7v_G0/s1024/Jelly%252520Fish%2525202.jpg",
            "https://lh4.googleusercontent.com/-pwuuw6yhg8U/URquvPxR3FI/AAAAAAAAAbs/VNGk6f-tsGE/s1024/Jelly%252520Fish%2525203.jpg",
            "https://lh5.googleusercontent.com/-GoUQVw1fnFw/URquv6xbC0I/AAAAAAAAAbs/zEUVTQQ43Zc/s1024/Kauai.jpg",
            "https://lh6.googleusercontent.com/-8QdYYQEpYjw/URquwvdh88I/AAAAAAAAAbs/cktDy-ysfHo/s1024/Kyoto%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-vPeekyDjOE0/URquwzJ28qI/AAAAAAAAAbs/qxcyXULsZrg/s1024/Lake%252520Tahoe%252520Colors.jpg",
            "https://lh4.googleusercontent.com/-xBPxWpD4yxU/URquxWHk8AI/AAAAAAAAAbs/ARDPeDYPiMY/s1024/Lava%252520from%252520the%252520Sky.jpg",
            "https://lh3.googleusercontent.com/-897VXrJB6RE/URquxxxd-5I/AAAAAAAAAbs/j-Cz4T4YvIw/s1024/Leica%25252050mm%252520Summilux.jpg",
            "https://lh5.googleusercontent.com/-qSJ4D4iXzGo/URquyDWiJ1I/AAAAAAAAAbs/k2pBXeWehOA/s1024/Leica%25252050mm%252520Summilux.jpg",
            "https://lh6.googleusercontent.com/-dwlPg83vzLg/URquylTVuFI/AAAAAAAAAbs/G6SyQ8b4YsI/s1024/Leica%252520M8%252520%252528Front%252529.jpg",
            "https://lh3.googleusercontent.com/-R3_EYAyJvfk/URquzQBv8eI/AAAAAAAAAbs/b9xhpUM3pEI/s1024/Light%252520to%252520Sand.jpg",
            "https://lh3.googleusercontent.com/-fHY5h67QPi0/URqu0Cp4J1I/AAAAAAAAAbs/0lG6m94Z6vM/s1024/Little%252520Bit%252520of%252520Paradise.jpg",
    };

    public final static String[] classicMovieImageUrls = new String[]{
            "https://lh5.googleusercontent.com/-TzF_LwrCnRM/URqu0RddPOI/AAAAAAAAAbs/gaj2dLiuX0s/s1024/Lone%252520Pine%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/-4HdpJ4_DXU4/URqu046dJ9I/AAAAAAAAAbs/eBOodtk2_uk/s1024/Lonely%252520Rock.jpg",
            "https://lh6.googleusercontent.com/-erbF--z-W4s/URqu1ajSLkI/AAAAAAAAAbs/xjDCDO1INzM/s1024/Longue%252520Vue.jpg",
            "https://lh6.googleusercontent.com/-0CXJRdJaqvc/URqu1opNZNI/AAAAAAAAAbs/PFB2oPUU7Lk/s1024/Look%252520Me%252520in%252520the%252520Eye.jpg",
            "https://lh3.googleusercontent.com/-D_5lNxnDN6g/URqu2Tk7HVI/AAAAAAAAAbs/p0ddca9W__Y/s1024/Lost%252520in%252520a%252520Field.jpg",
            "https://lh6.googleusercontent.com/-flsqwMrIk2Q/URqu24PcmjI/AAAAAAAAAbs/5ocIH85XofM/s1024/Marshall%252520Beach%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-Y4lgryEVTmU/URqu28kG3gI/AAAAAAAAAbs/OjXpekqtbJ4/s1024/Mono%252520Lake%252520Blue.jpg",
            "https://lh4.googleusercontent.com/-AaHAJPmcGYA/URqu3PIldHI/AAAAAAAAAbs/lcTqk1SIcRs/s1024/Monument%252520Valley%252520Overlook.jpg",
            "https://lh4.googleusercontent.com/-vKxfdQ83dQA/URqu31Yq_BI/AAAAAAAAAbs/OUoGk_2AyfM/s1024/Moving%252520Rock.jpg",
            "https://lh5.googleusercontent.com/-CG62QiPpWXg/URqu4ia4vRI/AAAAAAAAAbs/0YOdqLAlcAc/s1024/Napali%252520Coast.jpg",
            "https://lh6.googleusercontent.com/-wdGrP5PMmJQ/URqu5PZvn7I/AAAAAAAAAbs/m0abEcdPXe4/s1024/One%252520Wheel.jpg",
            "https://lh6.googleusercontent.com/-6WS5DoCGuOA/URqu5qx1UgI/AAAAAAAAAbs/giMw2ixPvrY/s1024/Open%252520Sky.jpg",
            "https://lh6.googleusercontent.com/-u8EHKj8G8GQ/URqu55sM6yI/AAAAAAAAAbs/lIXX_GlTdmI/s1024/Orange%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-74Z5qj4bTDE/URqu6LSrJrI/AAAAAAAAAbs/XzmVkw90szQ/s1024/Orchid.jpg",
            "https://lh6.googleusercontent.com/-lEQE4h6TePE/URqu6t_lSkI/AAAAAAAAAbs/zvGYKOea_qY/s1024/Over%252520there.jpg",
            "https://lh5.googleusercontent.com/-cauH-53JH2M/URqu66v_USI/AAAAAAAAAbs/EucwwqclfKQ/s1024/Plumes.jpg",
    };

    public final static String[] fantasyMovieImageUrls = new String[] {
            "https://lh3.googleusercontent.com/-eDLT2jHDoy4/URqu7axzkAI/AAAAAAAAAbs/iVZE-xJ7lZs/s1024/Rainbokeh.jpg",
            "https://lh5.googleusercontent.com/-j1NLqEFIyco/URqu8L1CGcI/AAAAAAAAAbs/aqZkgX66zlI/s1024/Rainbow.jpg",
            "https://lh5.googleusercontent.com/-DRnqmK0t4VU/URqu8XYN9yI/AAAAAAAAAbs/LgvF_592WLU/s1024/Rice%252520Fields.jpg",
            "https://lh3.googleusercontent.com/-hwh1v3EOGcQ/URqu8qOaKwI/AAAAAAAAAbs/IljRJRnbJGw/s1024/Rockaway%252520Fire%252520Sky.jpg",
            "https://lh5.googleusercontent.com/-wjV6FQk7tlk/URqu9jCQ8sI/AAAAAAAAAbs/RyYUpdo-c9o/s1024/Rockaway%252520Flow.jpg",
            "https://lh6.googleusercontent.com/-6cAXNfo7D20/URqu-BdzgPI/AAAAAAAAAbs/OmsYllzJqwo/s1024/Rockaway%252520Sunset%252520Sky.jpg",
            "https://lh3.googleusercontent.com/-sl8fpGPS-RE/URqu_BOkfgI/AAAAAAAAAbs/Dg2Fv-JxOeg/s1024/Russian%252520Ridge%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-gVtY36mMBIg/URqu_q91lkI/AAAAAAAAAbs/3CiFMBcy5MA/s1024/Rust%252520Knot.jpg",
            "https://lh6.googleusercontent.com/-GHeImuHqJBE/URqu_FKfVLI/AAAAAAAAAbs/axuEJeqam7Q/s1024/Sailing%252520Stones.jpg",
            "https://lh3.googleusercontent.com/-hBbYZjTOwGc/URqu_ycpIrI/AAAAAAAAAbs/nAdJUXnGJYE/s1024/Seahorse.jpg",
            "https://lh3.googleusercontent.com/-Iwi6-i6IexY/URqvAYZHsVI/AAAAAAAAAbs/5ETWl4qXsFE/s1024/Shinjuku%252520Street.jpg",
            "https://lh6.googleusercontent.com/-amhnySTM_MY/URqvAlb5KoI/AAAAAAAAAbs/pFCFgzlKsn0/s1024/Sierra%252520Heavens.jpg",
            "https://lh5.googleusercontent.com/-dJgjepFrYSo/URqvBVJZrAI/AAAAAAAAAbs/v-F5QWpYO6s/s1024/Sierra%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-Z4zGiC5nWdc/URqvBdEwivI/AAAAAAAAAbs/ZRZR1VJ84QA/s1024/Sin%252520Lights.jpg",
            "https://lh4.googleusercontent.com/-_0cYiWW8ccY/URqvBz3iM4I/AAAAAAAAAbs/9N_Wq8MhLTY/s1024/Starry%252520Lake.jpg",
            "https://lh3.googleusercontent.com/-A9LMoRyuQUA/URqvCYx_JoI/AAAAAAAAAbs/s7sde1Bz9cI/s1024/Starry%252520Night.jpg",
    };

    public final static String[] thrillerMoviewImageUrls = new String[]{
            "https://lh3.googleusercontent.com/-KtLJ3k858eY/URqvC_2h_bI/AAAAAAAAAbs/zzEBImwDA_g/s1024/Stream.jpg",
            "https://lh5.googleusercontent.com/-dFB7Lad6RcA/URqvDUftwWI/AAAAAAAAAbs/BrhoUtXTN7o/s1024/Strip%252520Sunset.jpg",
            "https://lh5.googleusercontent.com/-at6apgFiN20/URqvDyffUZI/AAAAAAAAAbs/clABCx171bE/s1024/Sunset%252520Hills.jpg",
            "https://lh4.googleusercontent.com/-7-EHhtQthII/URqvEYTk4vI/AAAAAAAAAbs/QSJZoB3YjVg/s1024/Tenaya%252520Lake%2525202.jpg",
            "https://lh6.googleusercontent.com/-8MrjV_a-Pok/URqvFC5repI/AAAAAAAAAbs/9inKTg9fbCE/s1024/Tenaya%252520Lake.jpg",
            "https://lh5.googleusercontent.com/-B1HW-z4zwao/URqvFWYRwUI/AAAAAAAAAbs/8Peli53Bs8I/s1024/The%252520Cave%252520BW.jpg",
            "https://lh3.googleusercontent.com/-PO4E-xZKAnQ/URqvGRqjYkI/AAAAAAAAAbs/42nyADFsXag/s1024/The%252520Fisherman.jpg",
            "https://lh4.googleusercontent.com/-iLyZlzfdy7s/URqvG0YScdI/AAAAAAAAAbs/1J9eDKmkXtk/s1024/The%252520Night%252520is%252520Coming.jpg",
            "https://lh6.googleusercontent.com/-G-k7YkkUco0/URqvHhah6fI/AAAAAAAAAbs/_taQQG7t0vo/s1024/The%252520Road.jpg",
            "https://lh6.googleusercontent.com/-h-ALJt7kSus/URqvIThqYfI/AAAAAAAAAbs/ejiv35olWS8/s1024/Tokyo%252520Heights.jpg",
            "https://lh5.googleusercontent.com/-Hy9k-TbS7xg/URqvIjQMOxI/AAAAAAAAAbs/RSpmmOATSkg/s1024/Tokyo%252520Highway.jpg",
            "https://lh6.googleusercontent.com/-83oOvMb4OZs/URqvJL0T7lI/AAAAAAAAAbs/c5TECZ6RONM/s1024/Tokyo%252520Smog.jpg",
            "https://lh3.googleusercontent.com/-FB-jfgREEfI/URqvJI3EXAI/AAAAAAAAAbs/XfyweiRF4v8/s1024/Tufa%252520at%252520Night.jpg",
            "https://lh4.googleusercontent.com/-vngKD5Z1U8w/URqvJUCEgPI/AAAAAAAAAbs/ulxCMVcU6EU/s1024/Valley%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-DOz5I2E2oMQ/URqvKMND1kI/AAAAAAAAAbs/Iqf0IsInleo/s1024/Windmill%252520Sunrise.jpg",
            "https://lh5.googleusercontent.com/-biyiyWcJ9MU/URqvKculiAI/AAAAAAAAAbs/jyPsCplJOpE/s1024/Windmill.jpg",
            "https://lh4.googleusercontent.com/-PDT167_xRdA/URqvK36mLcI/AAAAAAAAAbs/oi2ik9QseMI/s1024/Windmills.jpg",
            "https://lh5.googleusercontent.com/-kI_QdYx7VlU/URqvLXCB6gI/AAAAAAAAAbs/N31vlZ6u89o/s1024/Yet%252520Another%252520Rockaway%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-e9NHZ5k5MSs/URqvMIBZjtI/AAAAAAAAAbs/1fV810rDNfQ/s1024/Yosemite%252520Tree.jpg",
    };

    public final static String[] actionMovieImageUrls = new String[] {
            "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg",
            "https://lh4.googleusercontent.com/--dq8niRp7W4/URquVgmXvgI/AAAAAAAAAbs/-gnuLQfNnBA/s1024/A%252520Song%252520of%252520Ice%252520and%252520Fire.jpg",
            "https://lh5.googleusercontent.com/-7qZeDtRKFKc/URquWZT1gOI/AAAAAAAAAbs/hqWgteyNXsg/s1024/Another%252520Rockaway%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/--L0Km39l5J8/URquXHGcdNI/AAAAAAAAAbs/3ZrSJNrSomQ/s1024/Antelope%252520Butte.jpg",
            "https://lh6.googleusercontent.com/-8HO-4vIFnlw/URquZnsFgtI/AAAAAAAAAbs/WT8jViTF7vw/s1024/Antelope%252520Hallway.jpg",
            "https://lh4.googleusercontent.com/-WIuWgVcU3Qw/URqubRVcj4I/AAAAAAAAAbs/YvbwgGjwdIQ/s1024/Antelope%252520Walls.jpg",
            "https://lh6.googleusercontent.com/-UBmLbPELvoQ/URqucCdv0kI/AAAAAAAAAbs/IdNhr2VQoQs/s1024/Apre%2525CC%252580s%252520la%252520Pluie.jpg",
            "https://lh3.googleusercontent.com/-s-AFpvgSeew/URquc6dF-JI/AAAAAAAAAbs/Mt3xNGRUd68/s1024/Backlit%252520Cloud.jpg",
            "https://lh5.googleusercontent.com/-bvmif9a9YOQ/URquea3heHI/AAAAAAAAAbs/rcr6wyeQtAo/s1024/Bee%252520and%252520Flower.jpg",
            "https://lh5.googleusercontent.com/-n7mdm7I7FGs/URqueT_BT-I/AAAAAAAAAbs/9MYmXlmpSAo/s1024/Bonzai%252520Rock%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-4CN4X4t0M1k/URqufPozWzI/AAAAAAAAAbs/8wK41lg1KPs/s1024/Caterpillar.jpg",
            "https://lh3.googleusercontent.com/-rrFnVC8xQEg/URqufdrLBaI/AAAAAAAAAbs/s69WYy_fl1E/s1024/Chess.jpg",
            "https://lh5.googleusercontent.com/-WVpRptWH8Yw/URqugh-QmDI/AAAAAAAAAbs/E-MgBgtlUWU/s1024/Chihuly.jpg",
            "https://lh5.googleusercontent.com/-0BDXkYmckbo/URquhKFW84I/AAAAAAAAAbs/ogQtHCTk2JQ/s1024/Closed%252520Door.jpg",
            "https://lh3.googleusercontent.com/-PyggXXZRykM/URquh-kVvoI/AAAAAAAAAbs/hFtDwhtrHHQ/s1024/Colorado%252520River%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/-ZAs4dNZtALc/URquikvOCWI/AAAAAAAAAbs/DXz4h3dll1Y/s1024/Colors%252520of%252520Autumn.jpg",
    };

    public final static String[] comedyMovieImageThumbUrls = new String[] {
            "https://lh4.googleusercontent.com/-GztnWEIiMz8/URqukVCU7bI/AAAAAAAAAbs/jo2Hjv6MZ6M/s240-c/Countryside.jpg",
            "https://lh4.googleusercontent.com/-bEg9EZ9QoiM/URquklz3FGI/AAAAAAAAAbs/UUuv8Ac2BaE/s240-c/Death%252520Valley%252520-%252520Dunes.jpg",
            "https://lh6.googleusercontent.com/-ijQJ8W68tEE/URqulGkvFEI/AAAAAAAAAbs/zPXvIwi_rFw/s240-c/Delicate%252520Arch.jpg",
            "https://lh5.googleusercontent.com/-Oh8mMy2ieng/URqullDwehI/AAAAAAAAAbs/TbdeEfsaIZY/s240-c/Despair.jpg",
            "https://lh5.googleusercontent.com/-gl0y4UiAOlk/URqumC_KjBI/AAAAAAAAAbs/PM1eT7dn4oo/s240-c/Eagle%252520Fall%252520Sunrise.jpg",
            "https://lh3.googleusercontent.com/-hYYHd2_vXPQ/URqumtJa9eI/AAAAAAAAAbs/wAalXVkbSh0/s240-c/Electric%252520Storm.jpg",
            "https://lh5.googleusercontent.com/-PyY_yiyjPTo/URqunUOhHFI/AAAAAAAAAbs/azZoULNuJXc/s240-c/False%252520Kiva.jpg",
            "https://lh6.googleusercontent.com/-PYvLVdvXywk/URqunwd8hfI/AAAAAAAAAbs/qiMwgkFvf6I/s240-c/Fitzgerald%252520Streaks.jpg",
            "https://lh4.googleusercontent.com/-KIR_UobIIqY/URquoCZ9SlI/AAAAAAAAAbs/Y4d4q8sXu4c/s240-c/Foggy%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-9lzOk_OWZH0/URquoo4xYoI/AAAAAAAAAbs/AwgzHtNVCwU/s240-c/Frantic.jpg",
            "https://lh3.googleusercontent.com/-0X3JNaKaz48/URqupH78wpI/AAAAAAAAAbs/lHXxu_zbH8s/s240-c/Golden%252520Gate%252520Afternoon.jpg",
            "https://lh6.googleusercontent.com/-95sb5ag7ABc/URqupl95RDI/AAAAAAAAAbs/g73R20iVTRA/s240-c/Golden%252520Gate%252520Fog.jpg",
            "https://lh3.googleusercontent.com/-JB9v6rtgHhk/URqup21F-zI/AAAAAAAAAbs/64Fb8qMZWXk/s240-c/Golden%252520Grass.jpg",
            "https://lh4.googleusercontent.com/-EIBGfnuLtII/URquqVHwaRI/AAAAAAAAAbs/FA4McV2u8VE/s240-c/Grand%252520Teton.jpg",
            "https://lh4.googleusercontenActiont.com/-WoMxZvmN9nY/URquq1v2AoI/AAAAAAAAAbs/grj5uMhL6NA/s240-c/Grass%252520Closeup.jpg",
            "https://lh3.googleusercontent.com/-6hZiEHXx64Q/URqurxvNdqI/AAAAAAAAAbs/kWMXM3o5OVI/s240-c/Green%252520Grass.jpg",
    };

    public final static String[] kidsMovieImageThumbUrls = new String[] {
            "https://lh5.googleusercontent.com/-6LVb9OXtQ60/URquteBFuKI/AAAAAAAAAbs/4F4kRgecwFs/s240-c/Hanging%252520Leaf.jpg",
            "https://lh4.googleusercontent.com/-zAvf__52ONk/URqutT_IuxI/AAAAAAAAAbs/D_bcuc0thoU/s240-c/Highway%2525201.jpg",
            "https://lh6.googleusercontent.com/-H4SrUg615rA/URquuL27fXI/AAAAAAAAAbs/4aEqJfiMsOU/s240-c/Horseshoe%252520Bend%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-JhFi4fb_Pqw/URquuX-QXbI/AAAAAAAAAbs/IXpYUxuweYM/s240-c/Horseshoe%252520Bend.jpg",
            "https://lh5.googleusercontent.com/-UGgssvFRJ7g/URquueyJzGI/AAAAAAAAAbs/yYIBlLT0toM/s240-c/Into%252520the%252520Blue.jpg",
            "https://lh3.googleusercontent.com/-CH7KoupI7uI/URquu0FF__I/AAAAAAAAAbs/R7GDmI7v_G0/s240-c/Jelly%252520Fish%2525202.jpg",
            "https://lh4.googleusercontent.com/-pwuuw6yhg8U/URquvPxR3FI/AAAAAAAAAbs/VNGk6f-tsGE/s240-c/Jelly%252520Fish%2525203.jpg",
            "https://lh5.googleusercontent.com/-GoUQVw1fnFw/URquv6xbC0I/AAAAAAAAAbs/zEUVTQQ43Zc/s240-c/Kauai.jpg",
            "https://lh6.googleusercontent.com/-8QdYYQEpYjw/URquwvdh88I/AAAAAAAAAbs/cktDy-ysfHo/s240-c/Kyoto%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-vPeekyDjOE0/URquwzJ28qI/AAAAAAAAAbs/qxcyXULsZrg/s240-c/Lake%252520Tahoe%252520Colors.jpg",
            "https://lh4.googleusercontent.com/-xBPxWpD4yxU/URquxWHk8AI/AAAAAAAAAbs/ARDPeDYPiMY/s240-c/Lava%252520from%252520the%252520Sky.jpg",
            "https://lh3.googleusercontent.com/-897VXrJB6RE/URquxxxd-5I/AAAAAAAAAbs/j-Cz4T4YvIw/s240-c/Leica%25252050mm%252520Summilux.jpg",
            "https://lh5.googleusercontent.com/-qSJ4D4iXzGo/URquyDWiJ1I/AAAAAAAAAbs/k2pBXeWehOA/s240-c/Leica%25252050mm%252520Summilux.jpg",
            "https://lh6.googleusercontent.com/-dwlPg83vzLg/URquylTVuFI/AAAAAAAAAbs/G6SyQ8b4YsI/s240-c/Leica%252520M8%252520%252528Front%252529.jpg",
            "https://lh3.googleusercontent.com/-R3_EYAyJvfk/URquzQBv8eI/AAAAAAAAAbs/b9xhpUM3pEI/s240-c/Light%252520to%252520Sand.jpg",
            "https://lh3.googleusercontent.com/-fHY5h67QPi0/URqu0Cp4J1I/AAAAAAAAAbs/0lG6m94Z6vM/s240-c/Little%252520Bit%252520of%252520Paradise.jpg",
    };

    public final static String[] classicMovieImageThumbUrls = new String[]{
            "https://lh5.googleusercontent.com/-TzF_LwrCnRM/URqu0RddPOI/AAAAAAAAAbs/gaj2dLiuX0s/s240-c/Lone%252520Pine%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/-4HdpJ4_DXU4/URqu046dJ9I/AAAAAAAAAbs/eBOodtk2_uk/s240-c/Lonely%252520Rock.jpg",
            "https://lh6.googleusercontent.com/-erbF--z-W4s/URqu1ajSLkI/AAAAAAAAAbs/xjDCDO1INzM/s240-c/Longue%252520Vue.jpg",
            "https://lh6.googleusercontent.com/-0CXJRdJaqvc/URqu1opNZNI/AAAAAAAAAbs/PFB2oPUU7Lk/s240-c/Look%252520Me%252520in%252520the%252520Eye.jpg",
            "https://lh3.googleusercontent.com/-D_5lNxnDN6g/URqu2Tk7HVI/AAAAAAAAAbs/p0ddca9W__Y/s240-c/Lost%252520in%252520a%252520Field.jpg",
            "https://lh6.googleusercontent.com/-flsqwMrIk2Q/URqu24PcmjI/AAAAAAAAAbs/5ocIH85XofM/s240-c/Marshall%252520Beach%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-Y4lgryEVTmU/URqu28kG3gI/AAAAAAAAAbs/OjXpekqtbJ4/s240-c/Mono%252520Lake%252520Blue.jpg",
            "https://lh4.googleusercontent.com/-AaHAJPmcGYA/URqu3PIldHI/AAAAAAAAAbs/lcTqk1SIcRs/s240-c/Monument%252520Valley%252520Overlook.jpg",
            "https://lh4.googleusercontent.com/-vKxfdQ83dQA/URqu31Yq_BI/AAAAAAAAAbs/OUoGk_2AyfM/s240-c/Moving%252520Rock.jpg",
            "https://lh5.googleusercontent.com/-CG62QiPpWXg/URqu4ia4vRI/AAAAAAAAAbs/0YOdqLAlcAc/s240-c/Napali%252520Coast.jpg",
            "https://lh6.googleusercontent.com/-wdGrP5PMmJQ/URqu5PZvn7I/AAAAAAAAAbs/m0abEcdPXe4/s240-c/One%252520Wheel.jpg",
            "https://lh6.googleusercontent.com/-6WS5DoCGuOA/URqu5qx1UgI/AAAAAAAAAbs/giMw2ixPvrY/s240-c/Open%252520Sky.jpg",
            "https://lh6.googleusercontent.com/-u8EHKj8G8GQ/URqu55sM6yI/AAAAAAAAAbs/lIXX_GlTdmI/s240-c/Orange%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-74Z5qj4bTDE/URqu6LSrJrI/AAAAAAAAAbs/XzmVkw90szQ/s240-c/Orchid.jpg",
            "https://lh6.googleusercontent.com/-lEQE4h6TePE/URqu6t_lSkI/AAAAAAAAAbs/zvGYKOea_qY/s240-c/Over%252520there.jpg",
            "https://lh5.googleusercontent.com/-cauH-53JH2M/URqu66v_USI/AAAAAAAAAbs/EucwwqclfKQ/s240-c/Plumes.jpg",
    };

    public final static String[] fantasyMovieImageThumbUrls = new String[] {
            "https://lh3.googleusercontent.com/-eDLT2jHDoy4/URqu7axzkAI/AAAAAAAAAbs/iVZE-xJ7lZs/s240-c/Rainbokeh.jpg",
            "https://lh5.googleusercontent.com/-j1NLqEFIyco/URqu8L1CGcI/AAAAAAAAAbs/aqZkgX66zlI/s240-c/Rainbow.jpg",
            "https://lh5.googleusercontent.com/-DRnqmK0t4VU/URqu8XYN9yI/AAAAAAAAAbs/LgvF_592WLU/s240-c/Rice%252520Fields.jpg",
            "https://lh3.googleusercontent.com/-hwh1v3EOGcQ/URqu8qOaKwI/AAAAAAAAAbs/IljRJRnbJGw/s240-c/Rockaway%252520Fire%252520Sky.jpg",
            "https://lh5.googleusercontent.com/-wjV6FQk7tlk/URqu9jCQ8sI/AAAAAAAAAbs/RyYUpdo-c9o/s240-c/Rockaway%252520Flow.jpg",
            "https://lh6.googleusercontent.com/-6cAXNfo7D20/URqu-BdzgPI/AAAAAAAAAbs/OmsYllzJqwo/s240-c/Rockaway%252520Sunset%252520Sky.jpg",
            "https://lh3.googleusercontent.com/-sl8fpGPS-RE/URqu_BOkfgI/AAAAAAAAAbs/Dg2Fv-JxOeg/s240-c/Russian%252520Ridge%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-gVtY36mMBIg/URqu_q91lkI/AAAAAAAAAbs/3CiFMBcy5MA/s240-c/Rust%252520Knot.jpg",
            "https://lh6.googleusercontent.com/-GHeImuHqJBE/URqu_FKfVLI/AAAAAAAAAbs/axuEJeqam7Q/s240-c/Sailing%252520Stones.jpg",
            "https://lh3.googleusercontent.com/-hBbYZjTOwGc/URqu_ycpIrI/AAAAAAAAAbs/nAdJUXnGJYE/s240-c/Seahorse.jpg",
            "https://lh3.googleusercontent.com/-Iwi6-i6IexY/URqvAYZHsVI/AAAAAAAAAbs/5ETWl4qXsFE/s240-c/Shinjuku%252520Street.jpg",
            "https://lh6.googleusercontent.com/-amhnySTM_MY/URqvAlb5KoI/AAAAAAAAAbs/pFCFgzlKsn0/s240-c/Sierra%252520Heavens.jpg",
            "https://lh5.googleusercontent.com/-dJgjepFrYSo/URqvBVJZrAI/AAAAAAAAAbs/v-F5QWpYO6s/s240-c/Sierra%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-Z4zGiC5nWdc/URqvBdEwivI/AAAAAAAAAbs/ZRZR1VJ84QA/s240-c/Sin%252520Lights.jpg",
            "https://lh4.googleusercontent.com/-_0cYiWW8ccY/URqvBz3iM4I/AAAAAAAAAbs/9N_Wq8MhLTY/s240-c/Starry%252520Lake.jpg",
            "https://lh3.googleusercontent.com/-A9LMoRyuQUA/URqvCYx_JoI/AAAAAAAAAbs/s7sde1Bz9cI/s240-c/Starry%252520Night.jpg",
    };

    public final static String[] thrillerMoviewImageThumbUrls = new String[]{
            "https://lh3.googleusercontent.com/-KtLJ3k858eY/URqvC_2h_bI/AAAAAAAAAbs/zzEBImwDA_g/s240-c/Stream.jpg",
            "https://lh5.googleusercontent.com/-dFB7Lad6RcA/URqvDUftwWI/AAAAAAAAAbs/BrhoUtXTN7o/s240-c/Strip%252520Sunset.jpg",
            "https://lh5.googleusercontent.com/-at6apgFiN20/URqvDyffUZI/AAAAAAAAAbs/clABCx171bE/s240-c/Sunset%252520Hills.jpg",
            "https://lh4.googleusercontent.com/-7-EHhtQthII/URqvEYTk4vI/AAAAAAAAAbs/QSJZoB3YjVg/s240-c/Tenaya%252520Lake%2525202.jpg",
            "https://lh6.googleusercontent.com/-8MrjV_a-Pok/URqvFC5repI/AAAAAAAAAbs/9inKTg9fbCE/s240-c/Tenaya%252520Lake.jpg",
            "https://lh5.googleusercontent.com/-B1HW-z4zwao/URqvFWYRwUI/AAAAAAAAAbs/8Peli53Bs8I/s240-c/The%252520Cave%252520BW.jpg",
            "https://lh3.googleusercontent.com/-PO4E-xZKAnQ/URqvGRqjYkI/AAAAAAAAAbs/42nyADFsXag/s240-c/The%252520Fisherman.jpg",
            "https://lh4.googleusercontent.com/-iLyZlzfdy7s/URqvG0YScdI/AAAAAAAAAbs/1J9eDKmkXtk/s240-c/The%252520Night%252520is%252520Coming.jpg",
            "https://lh6.googleusercontent.com/-G-k7YkkUco0/URqvHhah6fI/AAAAAAAAAbs/_taQQG7t0vo/s240-c/The%252520Road.jpg",
            "https://lh6.googleusercontent.com/-h-ALJt7kSus/URqvIThqYfI/AAAAAAAAAbs/ejiv35olWS8/s240-c/Tokyo%252520Heights.jpg",
            "https://lh5.googleusercontent.com/-Hy9k-TbS7xg/URqvIjQMOxI/AAAAAAAAAbs/RSpmmOATSkg/s240-c/Tokyo%252520Highway.jpg",
            "https://lh6.googleusercontent.com/-83oOvMb4OZs/URqvJL0T7lI/AAAAAAAAAbs/c5TECZ6RONM/s240-c/Tokyo%252520Smog.jpg",
            "https://lh3.googleusercontent.com/-FB-jfgREEfI/URqvJI3EXAI/AAAAAAAAAbs/XfyweiRF4v8/s240-c/Tufa%252520at%252520Night.jpg",
            "https://lh4.googleusercontent.com/-vngKD5Z1U8w/URqvJUCEgPI/AAAAAAAAAbs/ulxCMVcU6EU/s240-c/Valley%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-DOz5I2E2oMQ/URqvKMND1kI/AAAAAAAAAbs/Iqf0IsInleo/s240-c/Windmill%252520Sunrise.jpg",
            "https://lh5.googleusercontent.com/-biyiyWcJ9MU/URqvKculiAI/AAAAAAAAAbs/jyPsCplJOpE/s240-c/Windmill.jpg",
            "https://lh4.googleusercontent.com/-PDT167_xRdA/URqvK36mLcI/AAAAAAAAAbs/oi2ik9QseMI/s240-c/Windmills.jpg",
            "https://lh5.googleusercontent.com/-kI_QdYx7VlU/URqvLXCB6gI/AAAAAAAAAbs/N31vlZ6u89o/s240-c/Yet%252520Another%252520Rockaway%252520Sunset.jpg",
            "https://lh4.googleusercontent.com/-e9NHZ5k5MSs/URqvMIBZjtI/AAAAAAAAAbs/1fV810rDNfQ/s240-c/Yosemite%252520Tree.jpg",
    };

    public final static String[] actionMovieImageThumbUrls = new String[] {
            "https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s240-c/A%252520Photographer.jpg",
            "https://lh4.googleusercontent.com/--dq8niRp7W4/URquVgmXvgI/AAAAAAAAAbs/-gnuLQfNnBA/s240-c/A%252520Song%252520of%252520Ice%252520and%252520Fire.jpg",
            "https://lh5.googleusercontent.com/-7qZeDtRKFKc/URquWZT1gOI/AAAAAAAAAbs/hqWgteyNXsg/s240-c/Another%252520Rockaway%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/--L0Km39l5J8/URquXHGcdNI/AAAAAAAAAbs/3ZrSJNrSomQ/s240-c/Antelope%252520Butte.jpg",
            "https://lh6.googleusercontent.com/-8HO-4vIFnlw/URquZnsFgtI/AAAAAAAAAbs/WT8jViTF7vw/s240-c/Antelope%252520Hallway.jpg",
            "https://lh4.googleusercontent.com/-WIuWgVcU3Qw/URqubRVcj4I/AAAAAAAAAbs/YvbwgGjwdIQ/s240-c/Antelope%252520Walls.jpg",
            "https://lh6.googleusercontent.com/-UBmLbPELvoQ/URqucCdv0kI/AAAAAAAAAbs/IdNhr2VQoQs/s240-c/Apre%2525CC%252580s%252520la%252520Pluie.jpg",
            "https://lh3.googleusercontent.com/-s-AFpvgSeew/URquc6dF-JI/AAAAAAAAAbs/Mt3xNGRUd68/s240-c/Backlit%252520Cloud.jpg",
            "https://lh5.googleusercontent.com/-bvmif9a9YOQ/URquea3heHI/AAAAAAAAAbs/rcr6wyeQtAo/s240-c/Bee%252520and%252520Flower.jpg",
            "https://lh5.googleusercontent.com/-n7mdm7I7FGs/URqueT_BT-I/AAAAAAAAAbs/9MYmXlmpSAo/s240-c/Bonzai%252520Rock%252520Sunset.jpg",
            "https://lh6.googleusercontent.com/-4CN4X4t0M1k/URqufPozWzI/AAAAAAAAAbs/8wK41lg1KPs/s240-c/Caterpillar.jpg",
            "https://lh3.googleusercontent.com/-rrFnVC8xQEg/URqufdrLBaI/AAAAAAAAAbs/s69WYy_fl1E/s240-c/Chess.jpg",
            "https://lh5.googleusercontent.com/-WVpRptWH8Yw/URqugh-QmDI/AAAAAAAAAbs/E-MgBgtlUWU/s240-c/Chihuly.jpg",
            "https://lh5.googleusercontent.com/-0BDXkYmckbo/URquhKFW84I/AAAAAAAAAbs/ogQtHCTk2JQ/s240-c/Closed%252520Door.jpg",
            "https://lh3.googleusercontent.com/-PyggXXZRykM/URquh-kVvoI/AAAAAAAAAbs/hFtDwhtrHHQ/s240-c/Colorado%252520River%252520Sunset.jpg",
            "https://lh3.googleusercontent.com/-ZAs4dNZtALc/URquikvOCWI/AAAAAAAAAbs/DXz4h3dll1Y/s240-c/Colors%252520of%252520Autumn.jpg",
    };

    public static List<Movie> list;

    public static HashMap<String, List<Movie>> getRecommendationsList() {
        HashMap<String, List<Movie>> recommendationsList = new HashMap<>();
        recommendationsList.put("Recommended", setupComedyMovies());
        return recommendationsList;
    }

    public static List<Movie> setupComedyMovies() {
        list = new ArrayList<Movie>();
        String title[] = {
                "Comedy Title 1",
                "Comedy Title 2",
                "Comedy Title 3",
                "Comedy Title 4",
                "Comedy Title 5",
                "Comedy Title 6",
                "Comedy Title 7",
                "Comedy Title 8",
                "Comedy Title 9",
                "Comedy Title 10",
                "Comedy Title 11",
                "Comedy Title 12",
                "Comedy Title 13",
                "Comedy Title 14",
                "Comedy Title 15"
        };

        String description = "Comedy Movies Description for the corresponding video showing here. "
                + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.";

        String videoUrl[] = {
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };

        list.add(buildMovieInfo("category", title[0],
                description, "Comedy Title One Collection", videoUrl[0], comedyMovieImageThumbUrls[0], comedyMovieImageUrls[0]));
        list.add(buildMovieInfo("category", title[1],
                description, "Comedy Title Two Collection", videoUrl[1], comedyMovieImageThumbUrls[1], comedyMovieImageUrls[1]));
        list.add(buildMovieInfo("category", title[2],
                description, "Comedy Title Three Collection", videoUrl[2], comedyMovieImageThumbUrls[2], comedyMovieImageUrls[2]));
        list.add(buildMovieInfo("category", title[3],
                description, "Comedy Title Four Collection", videoUrl[3], comedyMovieImageThumbUrls[3], comedyMovieImageUrls[3]));
        list.add(buildMovieInfo("category", title[4],
                description, "Comedy Title Five Collection", videoUrl[4], comedyMovieImageThumbUrls[4], comedyMovieImageUrls[4]));
        list.add(buildMovieInfo("category", title[5],
                description, "Comedy Title One Collection", videoUrl[0], comedyMovieImageThumbUrls[5], comedyMovieImageUrls[5]));
        list.add(buildMovieInfo("category", title[6],
                description, "Comedy Title Two Collection", videoUrl[1], comedyMovieImageThumbUrls[6], comedyMovieImageUrls[6]));
        list.add(buildMovieInfo("category", title[7],
                description, "Comedy Title Three Collection", videoUrl[2], comedyMovieImageThumbUrls[7], comedyMovieImageUrls[7]));
        list.add(buildMovieInfo("category", title[8],
                description, "Comedy Title Four Collection", videoUrl[3], comedyMovieImageThumbUrls[8], comedyMovieImageUrls[8]));
        list.add(buildMovieInfo("category", title[9],
                description, "Comedy Title Five Collection", videoUrl[4], comedyMovieImageThumbUrls[9], comedyMovieImageUrls[9]));
        list.add(buildMovieInfo("category", title[10],
                description, "Comedy Title One Collection", videoUrl[0], comedyMovieImageThumbUrls[10], comedyMovieImageUrls[10]));
        list.add(buildMovieInfo("category", title[11],
                description, "Comedy Title Two Collection", videoUrl[1], comedyMovieImageThumbUrls[11], comedyMovieImageUrls[11]));
        list.add(buildMovieInfo("category", title[12],
                description, "Comedy Title Three Collection", videoUrl[2], comedyMovieImageThumbUrls[12], comedyMovieImageUrls[12]));
        list.add(buildMovieInfo("category", title[13],
                description, "Comedy Title Four Collection", videoUrl[3], comedyMovieImageThumbUrls[13], comedyMovieImageUrls[13]));
        list.add(buildMovieInfo("category", title[14],
                description, "Comedy Title Five Collection", videoUrl[4], comedyMovieImageThumbUrls[14], comedyMovieImageUrls[14]));

        return list;
    }

    public static List<Movie> setupActionMovies() {
        list = new ArrayList<Movie>();
        String title[] = {
                "Action Title 1",
                "Action Title 2",
                "Action Title 3",
                "Action Title 4",
                "Action Title 5",
                "Action Title 6",
                "Action Title 7",
                "Action Title 8",
                "Action Title 9",
                "Action Title 10",
                "Action Title 11",
                "Action Title 12",
                "Action Title 13",
                "Action Title 14",
                "Action Title 15"
        };

        String description = "Description for the corresponding video showing here. "
                + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.";

        String videoUrl[] = {
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };

        list.add(buildMovieInfo("category", title[0],
                description, "Action Title One Collection", videoUrl[0], actionMovieImageThumbUrls[0], actionMovieImageUrls[0]));
        list.add(buildMovieInfo("category", title[1],
                description, "Action Title Two Collection", videoUrl[1], actionMovieImageThumbUrls[1], actionMovieImageUrls[1]));
        list.add(buildMovieInfo("category", title[2],
                description, "Action Title Three Collection", videoUrl[2], actionMovieImageThumbUrls[2], actionMovieImageUrls[2]));
        list.add(buildMovieInfo("category", title[3],
                description, "Action Title Four Collection", videoUrl[3], actionMovieImageThumbUrls[3], actionMovieImageUrls[3]));
        list.add(buildMovieInfo("category", title[4],
                description, "Action Title Five Collection", videoUrl[4], actionMovieImageThumbUrls[4], actionMovieImageUrls[4]));
        list.add(buildMovieInfo("category", title[5],
                description, "Action Title One Collection", videoUrl[0], actionMovieImageThumbUrls[5], actionMovieImageUrls[5]));
        list.add(buildMovieInfo("category", title[6],
                description, "Action Title Two Collection", videoUrl[1], actionMovieImageThumbUrls[6], actionMovieImageUrls[6]));
        list.add(buildMovieInfo("category", title[7],
                description, "Action Title Three Collection", videoUrl[2], actionMovieImageThumbUrls[7], actionMovieImageUrls[7]));
        list.add(buildMovieInfo("category", title[8],
                description, "Action Title Four Collection", videoUrl[3], actionMovieImageThumbUrls[8], actionMovieImageUrls[8]));
        list.add(buildMovieInfo("category", title[9],
                description, "Action Title Five Collection", videoUrl[4], actionMovieImageThumbUrls[9], actionMovieImageUrls[9]));
        list.add(buildMovieInfo("category", title[10],
                description, "Action Title One Collection", videoUrl[0], actionMovieImageThumbUrls[10], actionMovieImageUrls[10]));
        list.add(buildMovieInfo("category", title[11],
                description, "Action Title Two Collection", videoUrl[1], actionMovieImageThumbUrls[11], actionMovieImageUrls[11]));
        list.add(buildMovieInfo("category", title[12],
                description, "Action Title Three Collection", videoUrl[2], actionMovieImageThumbUrls[12], actionMovieImageUrls[12]));
        list.add(buildMovieInfo("category", title[13],
                description, "Action Title Four Collection", videoUrl[3], actionMovieImageThumbUrls[13], actionMovieImageUrls[13]));
        list.add(buildMovieInfo("category", title[14],
                description, "Action Title Five Collection", videoUrl[4], actionMovieImageThumbUrls[14], actionMovieImageUrls[14]));

        return list;
    }

    public static List<Movie> setupThrillerMovies() {
        list = new ArrayList<Movie>();
        String title[] = {
                "Thriller Title 1",
                "Thriller Title 2",
                "Thriller Title 3",
                "Thriller Title 4",
                "Thriller Title 5",
                "Thriller Title 6",
                "Thriller Title 7",
                "Thriller Title 8",
                "Thriller Title 9",
                "Thriller Title 10",
                "Thriller Title 11",
                "Thriller Title 12",
                "Thriller Title 13",
                "Thriller Title 14",
                "Thriller Title 15"
        };

        String description = "Description for the corresponding video showing here. "
                + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.";

        String videoUrl[] = {
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };

        list.add(buildMovieInfo("category", title[0],
                description, "Thriller Title One Collection", videoUrl[0], thrillerMoviewImageThumbUrls[0], thrillerMoviewImageUrls[0]));
        list.add(buildMovieInfo("category", title[1],
                description, "Thriller Title Two Collection", videoUrl[1], thrillerMoviewImageThumbUrls[1], thrillerMoviewImageUrls[1]));
        list.add(buildMovieInfo("category", title[2],
                description, "Thriller Title Three Collection", videoUrl[2], thrillerMoviewImageThumbUrls[2], thrillerMoviewImageUrls[2]));
        list.add(buildMovieInfo("category", title[3],
                description, "Thriller Title Four Collection", videoUrl[3], thrillerMoviewImageThumbUrls[3], thrillerMoviewImageUrls[3]));
        list.add(buildMovieInfo("category", title[4],
                description, "Thriller Title Five Collection", videoUrl[4], thrillerMoviewImageThumbUrls[4], thrillerMoviewImageUrls[4]));
        list.add(buildMovieInfo("category", title[5],
                description, "Thriller Title One Collection", videoUrl[0], thrillerMoviewImageThumbUrls[5], thrillerMoviewImageUrls[5]));
        list.add(buildMovieInfo("category", title[6],
                description, "Thriller Title Two Collection", videoUrl[1], thrillerMoviewImageThumbUrls[6], thrillerMoviewImageUrls[6]));
        list.add(buildMovieInfo("category", title[7],
                description, "Thriller Title Three Collection", videoUrl[2], thrillerMoviewImageThumbUrls[7], thrillerMoviewImageUrls[7]));
        list.add(buildMovieInfo("category", title[8],
                description, "Thriller Title Four Collection", videoUrl[3], thrillerMoviewImageThumbUrls[8], thrillerMoviewImageUrls[8]));
        list.add(buildMovieInfo("category", title[9],
                description, "Thriller Title Five Collection", videoUrl[4], thrillerMoviewImageThumbUrls[9], thrillerMoviewImageUrls[9]));
        list.add(buildMovieInfo("category", title[10],
                description, "Thriller Title One Collection", videoUrl[0], thrillerMoviewImageThumbUrls[10], thrillerMoviewImageUrls[10]));
        list.add(buildMovieInfo("category", title[11],
                description, "Thriller Title Two Collection", videoUrl[1], thrillerMoviewImageThumbUrls[11], thrillerMoviewImageUrls[11]));
        list.add(buildMovieInfo("category", title[12],
                description, "Thriller Title Three Collection", videoUrl[2], thrillerMoviewImageThumbUrls[12], thrillerMoviewImageUrls[12]));
        list.add(buildMovieInfo("category", title[13],
                description, "Thriller Title Four Collection", videoUrl[3], thrillerMoviewImageThumbUrls[13], thrillerMoviewImageUrls[13]));
        list.add(buildMovieInfo("category", title[14],
                description, "Thriller Title Five Collection", videoUrl[4], thrillerMoviewImageThumbUrls[14], thrillerMoviewImageUrls[14]));

        return list;
    }

    public static List<Movie> setupClassicMovies() {
        list = new ArrayList<Movie>();
        String title[] = {
                "Classic Title 1",
                "Classic Title 2",
                "Classic Title 3",
                "Classic Title 4",
                "Classic Title 5",
                "Classic Title 6",
                "Classic Title 7",
                "Classic Title 8",
                "Classic Title 9",
                "Classic Title 10",
                "Classic Title 11",
                "Classic Title 12",
                "Classic Title 13",
                "Classic Title 14",
                "Classic Title 15"
        };

        String description = "Description for the corresponding video showing here. "
                + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.";

        String videoUrl[] = {
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };

        list.add(buildMovieInfo("category", title[0],
                description, "Classic Title One Collection", videoUrl[0], classicMovieImageThumbUrls[0], classicMovieImageUrls[0]));
        list.add(buildMovieInfo("category", title[1],
                description, "Classic Title Two Collection", videoUrl[1], classicMovieImageThumbUrls[1], classicMovieImageUrls[1]));
        list.add(buildMovieInfo("category", title[2],
                description, "Classic Title Three Collection", videoUrl[2], classicMovieImageThumbUrls[2], classicMovieImageUrls[2]));
        list.add(buildMovieInfo("category", title[3],
                description, "Classic Title Four Collection", videoUrl[3], classicMovieImageThumbUrls[3], classicMovieImageUrls[3]));
        list.add(buildMovieInfo("category", title[4],
                description, "Classic Title Five Collection", videoUrl[4], classicMovieImageThumbUrls[4], classicMovieImageUrls[4]));
        list.add(buildMovieInfo("category", title[5],
                description, "Classic Title One Collection", videoUrl[0], classicMovieImageThumbUrls[5], classicMovieImageUrls[5]));
        list.add(buildMovieInfo("category", title[6],
                description, "Classic Title Two Collection", videoUrl[1], classicMovieImageThumbUrls[6], classicMovieImageUrls[6]));
        list.add(buildMovieInfo("category", title[7],
                description, "Classic Title Three Collection", videoUrl[2], classicMovieImageThumbUrls[7], classicMovieImageUrls[7]));
        list.add(buildMovieInfo("category", title[8],
                description, "Classic Title Four Collection", videoUrl[3], classicMovieImageThumbUrls[8], classicMovieImageUrls[8]));
        list.add(buildMovieInfo("category", title[9],
                description, "Classic Title Five Collection", videoUrl[4], classicMovieImageThumbUrls[9], classicMovieImageUrls[9]));
        list.add(buildMovieInfo("category", title[10],
                description, "Classic Title One Collection", videoUrl[0], classicMovieImageThumbUrls[10], classicMovieImageUrls[10]));
        list.add(buildMovieInfo("category", title[11],
                description, "Classic Title Two Collection", videoUrl[1], classicMovieImageThumbUrls[11], classicMovieImageUrls[11]));
        list.add(buildMovieInfo("category", title[12],
                description, "Classic Title Three Collection", videoUrl[2], classicMovieImageThumbUrls[12], classicMovieImageUrls[12]));
        list.add(buildMovieInfo("category", title[13],
                description, "Classic Title Four Collection", videoUrl[3], classicMovieImageThumbUrls[13], classicMovieImageUrls[13]));
        list.add(buildMovieInfo("category", title[14],
                description, "Classic Title Five Collection", videoUrl[4], classicMovieImageThumbUrls[14], classicMovieImageUrls[14]));

        return list;
    }

    public static List<Movie> setupFantasyMovies() {
        list = new ArrayList<Movie>();
        String title[] = {
                "Fantasy Title 1",
                "Fantasy Title 2",
                "Fantasy Title 3",
                "Fantasy Title 4",
                "Fantasy Title 5",
                "Fantasy Title 6",
                "Fantasy Title 7",
                "Fantasy Title 8",
                "Fantasy Title 9",
                "Fantasy Title 10",
                "Fantasy Title 11",
                "Fantasy Title 12",
                "Fantasy Title 13",
                "Fantasy Title 14",
                "Fantasy Title 15"
        };

        String description = "Description for the corresponding video showing here. "
                + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.";

        String videoUrl[] = {
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };

        list.add(buildMovieInfo("category", title[0],
                description, "Fantasy Title One Collection", videoUrl[0], fantasyMovieImageThumbUrls[0], fantasyMovieImageUrls[0]));
        list.add(buildMovieInfo("category", title[1],
                description, "Fantasy Title Two Collection", videoUrl[1], fantasyMovieImageThumbUrls[1], fantasyMovieImageUrls[1]));
        list.add(buildMovieInfo("category", title[2],
                description, "Fantasy Title Three Collection", videoUrl[2], fantasyMovieImageThumbUrls[2], fantasyMovieImageUrls[2]));
        list.add(buildMovieInfo("category", title[3],
                description, "Fantasy Title Four Collection", videoUrl[3], fantasyMovieImageThumbUrls[3], fantasyMovieImageUrls[3]));
        list.add(buildMovieInfo("category", title[4],
                description, "Fantasy Title Five Collection", videoUrl[4], fantasyMovieImageThumbUrls[4], fantasyMovieImageUrls[4]));
        list.add(buildMovieInfo("category", title[5],
                description, "Fantasy Title One Collection", videoUrl[0], fantasyMovieImageThumbUrls[5], fantasyMovieImageUrls[5]));
        list.add(buildMovieInfo("category", title[6],
                description, "Fantasy Title Two Collection", videoUrl[1], fantasyMovieImageThumbUrls[6], fantasyMovieImageUrls[6]));
        list.add(buildMovieInfo("category", title[7],
                description, "Fantasy Title Three Collection", videoUrl[2], fantasyMovieImageThumbUrls[7], fantasyMovieImageUrls[7]));
        list.add(buildMovieInfo("category", title[8],
                description, "Fantasy Title Four Collection", videoUrl[3], fantasyMovieImageThumbUrls[8], fantasyMovieImageUrls[8]));
        list.add(buildMovieInfo("category", title[9],
                description, "Fantasy Title Five Collection", videoUrl[4], fantasyMovieImageThumbUrls[9], fantasyMovieImageUrls[9]));
        list.add(buildMovieInfo("category", title[10],
                description, "Fantasy Title One Collection", videoUrl[0], fantasyMovieImageThumbUrls[10], fantasyMovieImageUrls[10]));
        list.add(buildMovieInfo("category", title[11],
                description, "Fantasy Title Two Collection", videoUrl[1], fantasyMovieImageThumbUrls[11], fantasyMovieImageUrls[11]));
        list.add(buildMovieInfo("category", title[12],
                description, "Fantasy Title Three Collection", videoUrl[2], fantasyMovieImageThumbUrls[12], fantasyMovieImageUrls[12]));
        list.add(buildMovieInfo("category", title[13],
                description, "Fantasy Title Four Collection", videoUrl[3], fantasyMovieImageThumbUrls[13], fantasyMovieImageUrls[13]));
        list.add(buildMovieInfo("category", title[14],
                description, "Fantasy Title Five Collection", videoUrl[4], fantasyMovieImageThumbUrls[14], fantasyMovieImageUrls[14]));

        return list;
    }

    public static List<Movie> setupKidsMovies() {
        list = new ArrayList<Movie>();
        String title[] = {
                "Kids Title 1",
                "Kids Title 2",
                "Kids Title 3",
                "Kids Title 4",
                "Kids Title 5",
                "Kids Title 6",
                "Kids Title 7",
                "Kids Title 8",
                "Kids Title 9",
                "Kids Title 10",
                "Kids Title 11",
                "Kids Title 12",
                "Kids Title 13",
                "Kids Title 14",
                "Kids Title 15"
        };

        String description = "Description for the corresponding video showing here. "
                + "Donec tristique, orci sed semper lacinia, quam erat rhoncus massa, non congue tellus est "
                + "quis tellus. Sed mollis orci venenatis quam scelerisque accumsan. Curabitur a massa sit "
                + "amet mi accumsan mollis sed et magna. Vivamus sed aliquam risus. Nulla eget dolor in elit "
                + "facilisis mattis. Ut aliquet luctus lacus. Phasellus nec commodo erat. Praesent tempus id "
                + "lectus ac scelerisque. Maecenas pretium cursus lectus id volutpat.";

        String videoUrl[] = {
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Zeitgeist/Zeitgeist%202010_%20Year%20in%20Review.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/Demo%20Slam/Google%20Demo%20Slam_%2020ft%20Search.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Gmail%20Blue.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Fiber%20to%20the%20Pole.mp4",
                "http://commondatastorage.googleapis.com/android-tv/Sample%20videos/April%20Fool's%202013/Introducing%20Google%20Nose.mp4"
        };

        list.add(buildMovieInfo("category", title[0],
                description, "Kids Title One Collection", videoUrl[0], kidsMovieImageThumbUrls[0], kidsMovieImageUrls[0]));
        list.add(buildMovieInfo("category", title[1],
                description, "Kids Title Two Collection", videoUrl[1], kidsMovieImageThumbUrls[1], kidsMovieImageUrls[1]));
        list.add(buildMovieInfo("category", title[2],
                description, "Kids Title Three Collection", videoUrl[2], kidsMovieImageThumbUrls[2], kidsMovieImageUrls[2]));
        list.add(buildMovieInfo("category", title[3],
                description, "Kids Title Four Collection", videoUrl[3], kidsMovieImageThumbUrls[3], kidsMovieImageUrls[3]));
        list.add(buildMovieInfo("category", title[4],
                description, "Kids Title Five Collection", videoUrl[4], kidsMovieImageThumbUrls[4], kidsMovieImageUrls[4]));
        list.add(buildMovieInfo("category", title[5],
                description, "Kids Title One Collection", videoUrl[0], kidsMovieImageThumbUrls[5], kidsMovieImageUrls[5]));
        list.add(buildMovieInfo("category", title[6],
                description, "Kids Title Two Collection", videoUrl[1], kidsMovieImageThumbUrls[6], kidsMovieImageUrls[6]));
        list.add(buildMovieInfo("category", title[7],
                description, "Kids Title Three Collection", videoUrl[2], kidsMovieImageThumbUrls[7], kidsMovieImageUrls[7]));
        list.add(buildMovieInfo("category", title[8],
                description, "Kids Title Four Collection", videoUrl[3], kidsMovieImageThumbUrls[8], kidsMovieImageUrls[8]));
        list.add(buildMovieInfo("category", title[9],
                description, "Kids Title Five Collection", videoUrl[4], kidsMovieImageThumbUrls[9], kidsMovieImageUrls[9]));
        list.add(buildMovieInfo("category", title[10],
                description, "Kids Title One Collection", videoUrl[0], kidsMovieImageThumbUrls[10], kidsMovieImageUrls[10]));
        list.add(buildMovieInfo("category", title[11],
                description, "Kids Title Two Collection", videoUrl[1], kidsMovieImageThumbUrls[11], kidsMovieImageUrls[11]));
        list.add(buildMovieInfo("category", title[12],
                description, "Kids Title Three Collection", videoUrl[2], kidsMovieImageThumbUrls[12], kidsMovieImageUrls[12]));
        list.add(buildMovieInfo("category", title[13],
                description, "Kids Title Four Collection", videoUrl[3], kidsMovieImageThumbUrls[13], kidsMovieImageUrls[13]));
        list.add(buildMovieInfo("category", title[14],
                description, "Kids Title Five Collection", videoUrl[4], kidsMovieImageThumbUrls[14], kidsMovieImageUrls[14]));

        return list;
    }

    private static Movie buildMovieInfo(String category, String title,
                                        String description, String studio, String videoUrl, String cardImageUrl,
                                        String bgImageUrl) {
        Movie movie = new Movie();
        movie.setId(Movie.getCount());
        Movie.incCount();
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setStudio(studio);
        movie.setCategory(category);
        movie.setCardImageUrl(cardImageUrl);
        movie.setBackgroundImageUrl(bgImageUrl);
        movie.setVideoUrl(videoUrl);
        return movie;
    }
}
