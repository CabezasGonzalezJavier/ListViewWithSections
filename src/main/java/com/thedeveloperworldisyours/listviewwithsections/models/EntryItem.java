package com.thedeveloperworldisyours.listviewwithsections.models;

import com.thedeveloperworldisyours.listviewwithsections.interfaces.Item;

/**
 * Created by javiergonzalezcabezas on 6/4/15.
 */
public class EntryItem implements Item {

    public final String title;
    public final String subtitle;

    public EntryItem(String title, String subtitle) {
        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public boolean isSection() {
        return false;
    }

}
