LazyAndroid
===========

#懶人Framework
##這個Project 是想用最懶的方法寫Android App


有幾個目標

1. Convention over configuration
    名字改對了，就寫少了Code, Debug 更快

    *Naming Standard

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

    *Code Location (請使用Android Studio Plugin: Android LayoutID converter)

        assignViews: 存放findViewById （使用Plugin自動生成)
        setListeners: 存放event, such as setOnClickListener
        init: 行動類的資料, 例如 setTitle("Lazy")
        getData:

    *Folder Structure


2. Do as lazy as I can

    *ORM (Active Android)
    *GSON (JSON parser)
    *Imageloader (Universal Image Loader)
    *android-async-http (android-async-http)

