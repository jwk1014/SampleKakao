package com.tacademy.samplekakao;

import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabWidget;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    TabAdapter mAdapter;
    //TabHost tabHost;
    //ViewPager pager;
    //TabsAdapter mAdapter;
    //String tabIds[] = {"tab1","tab2","tab3","tab4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("친구");
        /*
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        pager = (ViewPager)findViewById(R.id.realtabcontent);
        mAdapter = new TabsAdapter(this, getSupportFragmentManager(), tabHost, pager);

        mAdapter.addTab(tabHost.newTabSpec(tabIds[0]).setIndicator("", getResources().getDrawable(R.drawable.tab_friend_icon_n)), Tab1Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(tabIds[1]).setIndicator("", getResources().getDrawable(R.drawable.tab_chatting_icon_n)), Tab2Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(tabIds[2]).setIndicator("", getResources().getDrawable(R.drawable.tab_channel_icon_n)), Tab3Fragment.class, null);
        mAdapter.addTab(tabHost.newTabSpec(tabIds[3]).setIndicator("", getResources().getDrawable(R.drawable.tab_more_icon_n)), Tab4Fragment.class, null);

        TabWidget tabWidget = tabHost.getTabWidget();
        for(int i=0; i < tabWidget.getChildCount(); i++)
            tabWidget.getChildAt(i).setBackgroundResource(R.drawable.tab_selector);

        if (savedInstanceState != null) {
            tabHost.setCurrentTab(savedInstanceState.getInt("tabIndex"));
            mAdapter.onRestoreInstanceState(savedInstanceState);
        }
        mAdapter.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int position = -1;
                for (int i = 0; i < 4; i++) {
                    if (tabIds[i].equals(tabId)) {
                        position = i;
                        break;
                    }
                }

            }
        });
        */
        tabLayout = (TabLayout)findViewById(R.id.tabs);
        pager = (ViewPager)findViewById(R.id.viewpager);

        pager.setAdapter(mAdapter = new TabAdapter(this, getSupportFragmentManager()));

        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(0).setIcon(R.drawable.tab_friend_icon_n);
        tabLayout.getTabAt(1).setIcon(R.drawable.tab_chatting_icon_n);
        tabLayout.getTabAt(2).setIcon(R.drawable.tab_channel_icon_n);
        tabLayout.getTabAt(3).setIcon(R.drawable.tab_more_icon_n);

        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                String actionbar_title = null;
                switch (tab.getPosition()) {
                    case 0:
                        actionbar_title = "친구";
                        break;
                    case 1:
                        actionbar_title = "채팅";
                        break;
                    case 2:
                        actionbar_title = "채널";
                        break;
                    case 3:
                        actionbar_title = "더보기";
                        break;
                }
                getSupportActionBar().setTitle(actionbar_title);
            }
        });
    }

    /*
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("tabIndex", tabHost.getCurrentTab());
        mAdapter.onSaveInstanceState(outState);
    }
    */
}
