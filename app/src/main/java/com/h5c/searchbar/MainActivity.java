package com.h5c.searchbar;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<String> list = new ArrayList<>();
    AdapterClass adapterClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        list.add("abc");
        list.add("bcd");
        list.add("cde");
        list.add("def");
        list.add("efg");
        list.add("fgh");
        list.add("ghi");
        list.add("hij");
        list.add("ijk");
        list.add("klm");
        list.add("lmn");
        list.add("mno");
        list.add("nop");
        list.add("opq");
        list.add("pqr");
        list.add("qrs");
        list.add("rst");
        list.add("stu");
        list.add("tuv");
        list.add("uvw");
        list.add("vwx");
        list.add("wxy");
        list.add("wyz");

        adapterClass = new AdapterClass(MainActivity.this,list);
        recyclerView.setAdapter(adapterClass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                ArrayList<String> listsearch = new ArrayList<String>();
                for(int i = 0; i< list.size();i++){
                    if(((list.get(i)).toLowerCase()).contains(newText)){
                        listsearch.add(list.get(i));
                    }else{
                        Log.d("Harsh","Not Mached");
                    }
                }
                adapterClass.setFilter(listsearch);
                return true;
            }
        });
        return true;
    }
}
