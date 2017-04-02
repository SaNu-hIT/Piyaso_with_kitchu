package com.piyaso.softforest.piyaso.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.piyaso.softforest.piyaso.Adapters.MainGridAdapter;
import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelectedMain;
import com.piyaso.softforest.piyaso.R;

import java.util.HashMap;

import butterknife.ButterKnife;

public class MainHome extends AppCompatActivity implements OnGridItemSelectedMain, ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener {

    private SliderLayout mDemoSlider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        ButterKnife.bind(this);
        mDemoSlider = (SliderLayout)findViewById(R.id.slider);

//        HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("SELL AND BUY",R.drawable.hotel2);
        file_maps.put("SERVICES",R.drawable.hotel1);
        file_maps.put("GROSSARY",R.drawable.hotel3);
        file_maps.put("DIRECTORY", R.drawable.hotel1);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);




        GridView gridview = (GridView) findViewById(R.id.gridview);


        MainGridAdapter gridViewAdapter=new MainGridAdapter(this);
        gridview.setAdapter(gridViewAdapter);
        gridViewAdapter.GridItemSelectedCallbackMain(this);

    }

    @Override
    public void onGridItemSelected(View view, int possition) {

        Log.e("HOME", "possition: "+possition );
        switch (possition)
        {
            case 0:
                Intent intent=new Intent(this,BuyAndSellActivity.class);
                startActivity(intent);
                break;
            case 1:
                Intent main=new Intent(this,ServicesActivity.class);
                startActivity(main);
                break;


        }


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
