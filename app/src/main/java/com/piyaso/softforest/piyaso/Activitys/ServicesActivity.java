package com.piyaso.softforest.piyaso.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.piyaso.softforest.piyaso.Adapters.MainGridAdapter;
import com.piyaso.softforest.piyaso.Adapters.ServicesGridAdapter;
import com.piyaso.softforest.piyaso.Interfaces.OnServicegridItemSelected;
import com.piyaso.softforest.piyaso.Main;
import com.piyaso.softforest.piyaso.R;

public class ServicesActivity extends AppCompatActivity implements OnServicegridItemSelected {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);



        GridView gridview = (GridView) findViewById(R.id.gridview);


        ServicesGridAdapter gridViewAdapter=new ServicesGridAdapter(this);
        gridview.setAdapter(gridViewAdapter);
        gridViewAdapter.GridItemSelectedCallbackServices(this);
    }

    @Override
    public void onGridItemSelected(View view, int possition) {

        Intent intent=new Intent(this, Main.class);
        startActivity(intent);

    }
}
