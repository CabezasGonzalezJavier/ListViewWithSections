package com.thedeveloperworldisyours.listviewwithsections;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.thedeveloperworldisyours.listviewwithsections.adapters.EntryAdapter;
import com.thedeveloperworldisyours.listviewwithsections.interfaces.Item;
import com.thedeveloperworldisyours.listviewwithsections.models.EntryItem;
import com.thedeveloperworldisyours.listviewwithsections.models.SectionItem;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<Item> mItems = new ArrayList<Item>();
    private SwipeRefreshLayout mSwipeLayout;
    private ListView mListView;
    private boolean mChangeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_container);
        mSwipeLayout.setOnRefreshListener(this);
        mListView = (ListView) findViewById(R.id.activity_main_listView);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!mItems.get(position).isSection()) {

                    EntryItem item = (EntryItem) mItems.get(position);

                    Toast.makeText(MainActivity.this, item.title, Toast.LENGTH_SHORT).show();


                }
            }
        });
        getInfo();
    }
    public void fillItems(){
        mItems.add(new SectionItem("Android"));
        mItems.add(new EntryItem("Nexus 5", "The best"));
        mItems.add(new EntryItem("Galaxy 5", "Good"));
        mItems.add(new EntryItem("HTC One", "Good"));


        mItems.add(new SectionItem("iOS"));
        mItems.add(new EntryItem("iPhone 4", "Rubbish"));
        mItems.add(new EntryItem("iPhone 5", "Rubbish"));
        mItems.add(new EntryItem("iPhone 6", "Rubbish"));
        mItems.add(new EntryItem("iPad 3", "Only shit"));

        mItems.add(new SectionItem("Windows Phone"));
        mItems.add(new EntryItem("Lumia 910", "No bat"));
        mItems.add(new EntryItem("Lumia 520", "No bat"));
        mItems.add(new EntryItem("HTC one m7", "No bat"));
        mItems.add(new EntryItem("Samsung sgh-i917", "No bat"));
        mItems.add(new EntryItem("LG e900", "No bat"));
    }

    public void fillOthersItems(){
        mItems.add(new SectionItem("Android"));

        mItems.add(new EntryItem("Galaxy Core 2", "No bad"));
        mItems.add(new EntryItem("HTC One", "Good"));
        mItems.add(new EntryItem("Galaxy 5", "Good"));
        mItems.add(new EntryItem("Nexus 4", "No bad"));


        mItems.add(new SectionItem("iOS"));

        mItems.add(new EntryItem("iPhone 3", "Rubbish"));
        mItems.add(new EntryItem("iPad 2", "Only shit"));

        mItems.add(new SectionItem("Windows Phone"));
        mItems.add(new EntryItem("HTC one m9", "Good"));
        mItems.add(new EntryItem("Samsung sgh-i7", "No bad"));
        mItems.add(new EntryItem("LG e900", "No bad"));
        mItems.add(new EntryItem("Lumia 913", "No bad"));
        mItems.add(new EntryItem("Lumia 525", "No bad"));
        mItems.add(new EntryItem("Lumia 915", "No bad"));
        mItems.add(new EntryItem("Lumia 545", "No bad"));


    }

    public void getInfo(){

        if (mChangeInfo){
            mChangeInfo = false;
            fillItems();
        }else{
            mChangeInfo = true;
            fillOthersItems();
        }
        EntryAdapter adapter = new EntryAdapter(this, mItems);

        mListView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        mItems.clear();
        getInfo();
        mSwipeLayout.setRefreshing(false);
    }
}
