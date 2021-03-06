package com.thedeveloperworldisyours.listviewwithsections.models;

import com.thedeveloperworldisyours.listviewwithsections.interfaces.Item;

/**
 * Created by javiergonzalezcabezas on 6/4/15.
 */
public class SectionItem implements Item {

    private final String title;

    public SectionItem(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public boolean isSection() {
        return true;
    }

}