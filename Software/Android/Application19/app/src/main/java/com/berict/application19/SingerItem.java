package com.berict.application19;

public class SingerItem {

    public int imageId;
    String name;
    String tel;
    int memberCount;

    SingerItem(String name, String tel, int memberCount, int imageId) {
        this.name = name;
        this.tel = tel;
        this.memberCount = memberCount;
        this.imageId = imageId;
    }

    SingerItem(String name) {
        this.name = name;
    }
}
