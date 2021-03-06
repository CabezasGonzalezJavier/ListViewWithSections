package com.thedeveloperworldisyours.listviewwithsections.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.thedeveloperworldisyours.listviewwithsections.R;
import com.thedeveloperworldisyours.listviewwithsections.interfaces.Item;
import com.thedeveloperworldisyours.listviewwithsections.models.EntryItem;
import com.thedeveloperworldisyours.listviewwithsections.models.SectionItem;

import java.util.ArrayList;

/**
 * Created by javiergonzalezcabezas on 6/4/15.
 */
public class EntryAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList items;
    private LayoutInflater vi;
    public EntryAdapter(Context context,ArrayList items) {
        super(context,0, items);
        this.context = context;
        this.items = items;
        vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        final Item i = (Item) items.get(position);
        if (i != null) {
            if(i.isSection()){
                SectionItem si = (SectionItem)i;
                v = vi.inflate(R.layout.item_section, null);
                v.setOnClickListener(null);
                v.setOnLongClickListener(null);
                v.setLongClickable(false);
                final TextView sectionView =
                        (TextView) v.findViewById(R.id.list_item_section_text);
                sectionView.setText(si.getTitle());
            } else {
                EntryItem ei = (EntryItem)i;
                v = vi.inflate(R.layout.item_entry, null);
                final TextView title =
                        (TextView)v.findViewById(R.id.list_item_entry_title);
                final TextView subtitle =
                        (TextView)v.findViewById(R.id.list_item_entry_summary);
                if (title != null) title.setText(ei.title);
                if(subtitle != null) subtitle.setText(ei.subtitle);
            }
        }
        return v;
    }
}
