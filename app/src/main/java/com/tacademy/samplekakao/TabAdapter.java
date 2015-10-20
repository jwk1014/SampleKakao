package com.tacademy.samplekakao;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

/**
 * Created by Tacademy on 2015-10-14.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private int[] imageResId = {
            R.drawable.tab_friend_icon_n,
            R.drawable.tab_chatting_icon_n,
            R.drawable.tab_channel_icon_n,
            R.drawable.tab_more_icon_n
    };

    Context context;
    public TabAdapter(Context context,FragmentManager manager){
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1Fragment();
            case 1:
                return new Tab2Fragment();
            case 2:
                return new Tab3Fragment();
            case 3:
                return new Tab4Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
