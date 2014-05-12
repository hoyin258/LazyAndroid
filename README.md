LazyAndroid
===========

#懶人Framework
這個Project 是想用最懶的方法寫Android App，
罐頭App 的Template。 （修改中)


有幾個目標
1. Convention over configuration
    名字改對了，就寫少了Code, Debug 更快


    Naming Standard

        JAVA Activity:      {XXX}Activity.java
        JAVA Fragment:      {XXX}Fragment.java
        JAVA View:          {XXX}View.java

        Layout Activity:    activity_{XXX}.xml
        Layout Fragment:    fragment_{XXX}.xml
        Layout View:        view_{XXX}.xml


        Control 命名:
            ViewGroup:      vg{XXX}
            TextView:       tv{XXX}
            CheckBox:       cb{XXX}
            如此類推

        Variable 命名:
            Class 內:       m{XXX}, 如 mNumber, mActivity(但不包括UI Control)
            Function 內:    {XXX} , 如 number, activity


        Other Library resource 命名：
            Drawable/Layout:
                {Library Name}_{Original Name}.xml      如: pull_to_refresh_indicator_bg_bottom.xml
            Values:
                {XXX}_attr.xml      如: pull_to_refresh_attr.xml



    Code Location (請使用Android Studio Plugin: Android LayoutID converter)

        Function 用途:

            assignViews:
                存放findViewById （使用Plugin自動生成)

            setListeners:
                存放event, such as setOnClickListener

            init:
                行動類的資料, 例如 setTitle("Lazy")

            getData:
                與API 接合



2. Do as lazy as I can


        ORM (Active Android)

        GSON (JSON parser)

        Imageloader (Universal Image Loader)

        Http Request (android-async-http)

        Slide Menu (SlidingMenu)

        Swip Back (改了部份)

        Pull to Refresh (改了部份)


3. No Gradle but Android Studio

    Gradle 太慢，Lazy 最重要快. 所以好快的Framework都放下來

    但建議用Android Studio ，快靚正

    如果Gradle 快點就好了.....


4. No Dependence library as it can

    懶得去Config,

    參考com.yintro.example 建立新的package

    修改 Android Manifest


5. Support Android 4.0+

    不鼓勵向下支援 Android 4.0以下，減低程式的複雜性

6. Build app faster > Performance turning.

    做好隻App,再慢慢Turn