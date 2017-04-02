package com.piyaso.softforest.piyaso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class Main extends AppCompatActivity {



    public int[] IMAGE = {R.drawable.home1, R.drawable.home2, R.drawable.home3, R.drawable.home4, R.drawable.home5, R.drawable.home1, R.drawable.home2, R.drawable.home3};
    public String[] AWESOM = {"Awesom Villa","Awesom Villa","Awesom Villa","Awesom Villa","Awesom Villa","Awesom Villa","Awesom Villa","Awesom Villa"};
    public String[] RATE = {"\u20B9 3200 / Night", "\u20B9 3200 / Night","\u20B9 3200 / Night", "\u20B9 3200 / Night", "\u20B9 3200 / Night", "\u20B9 3200 / Night","\u20B9 3200 / Night","\u20B9 3200 / Night"};
    public String[] NUMBER = {"3.3", "3", "4.5", "4", "3.5", "4.5","3","4"};


    private ArrayList<BeanClassForListView> beanClassArrayList;
    private listViewAdapter listViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_main_activity);


        ListView listview = (ListView) findViewById(R.id.listview);
        beanClassArrayList = new ArrayList<BeanClassForListView>();


        for (int i = 0; i < IMAGE.length; i++) {

            BeanClassForListView beanClass = new BeanClassForListView(IMAGE[i], AWESOM[i], RATE[i],NUMBER[i]);
            beanClassArrayList.add(beanClass);

        }
        listViewAdapter = new listViewAdapter(Main.this, beanClassArrayList);
        listview.setAdapter(listViewAdapter);






    }
}
