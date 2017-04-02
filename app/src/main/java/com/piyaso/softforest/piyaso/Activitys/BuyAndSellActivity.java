package com.piyaso.softforest.piyaso.Activitys;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.piyaso.softforest.piyaso.Beans.CategoryBean;
import com.piyaso.softforest.piyaso.Fragments.BuyAndSellproductFragment;
import com.piyaso.softforest.piyaso.Fragments.CategorySelectFragment;

import com.piyaso.softforest.piyaso.Fragments.FavoriteFragment;
import com.piyaso.softforest.piyaso.Fragments.MyAddsFragment;
import com.piyaso.softforest.piyaso.Fragments.ProfileFragment;

import com.piyaso.softforest.piyaso.HttpInterfaces.OnHttpRequestresponseListnerCategory;
import com.piyaso.softforest.piyaso.Interfaces.OnGridItemSelected;
import com.piyaso.softforest.piyaso.R;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSellActivity extends AppCompatActivity implements BuyAndSellproductFragment.OnFragmentInteractionListener,OnGridItemSelected,CategorySelectFragment.OnFragmentInteractionListener {
    private TabLayout mTabLayout;
    List<CategoryBean> categoryBeanList;

    private int[] mTabsIcons = {
            R.drawable.home,
            R.drawable.profile,
            R.drawable.bell,
            R.drawable.adjust};


    FloatingActionButton AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        AddButton=(FloatingActionButton)findViewById(R.id.fab);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getApplicationContext(),PostAddpage1.class);
                startActivity(in);
            }
        });

categoryBeanList=new ArrayList<>();

        // Setup the viewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        if (viewPager != null)
            viewPager.setAdapter(pagerAdapter);



        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(viewPager);

            for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(pagerAdapter.getTabView(i));
            }

            mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        }






    }




    @Override
    public void onFragmentInteraction() {

//
//        getSupportFragmentManager().beginTransaction().remove(fragment).
//                commitAllowingStateLoss();

        gpTo();





    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.e("Change In fragments","Fragments");
    }

//    @Override
//    public void OnHttpCategoryResponceSuccess(ArrayList<CategoryBean> categoryBeen, String error) {
//
//
//      int ss=categoryBeen.size();
//        Log.e("ss",""+ss);
//
//
//
//    }
//
//    @Override
//    public void OnHttpCategoryResponceFailure(Throwable throwable, boolean error) {
//
//
//
//    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public final int PAGE_COUNT = 4;

        private final String[] mTabsTitle = {"Discover", "Favourite", "MyAdds","Profile"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public View getTabView(int position) {
            // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
            View view = LayoutInflater.from(BuyAndSellActivity.this).inflate(R.layout.custom_tab, null);
            TextView title = (TextView) view.findViewById(R.id.title);
            title.setText(mTabsTitle[position]);
            ImageView icon = (ImageView) view.findViewById(R.id.icon);
            icon.setImageResource(mTabsIcons[position]);
            return view;
        }



        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                case 0:
                    return BuyAndSellproductFragment.newInstance(1);

                case 1:
                    return FavoriteFragment.newInstance(2);
                case 2:
                    return MyAddsFragment.newInstance(3);
                case 3:
                    return ProfileFragment.newInstance(4);
            }
            return null;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabsTitle[position];
        }


    }

    @Override
    public void onGridItemSelected(View view, int possition) {


//        Toast.makeText(this, "POSITION"+possition, Toast.LENGTH_SHORT).show();
//        Intent intent=new Intent(this,DetailsFragment_Product.class);
//        startActivity(intent);

//gpTo();
    }



    public void gpTo()
    {
        Intent inte=new Intent(getBaseContext(),CategorysAndSearchLocation.class);
        startActivity(inte);
        finish();
    }


}
