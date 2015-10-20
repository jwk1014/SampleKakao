package com.tacademy.samplekakao;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class FriendGroupItemView extends FrameLayout {
    public FriendGroupItemView(Context context) {
        super(context);
        init();
    }
    TextView nameView;
    private void init() {
        inflate(getContext(),R.layout.parent_friend_itemview, this);
        nameView = (TextView)findViewById(R.id.parent_friend_textview);
    }

    public void setGroupItem(FriendGroupItem item) {
        nameView.setText(item.groupName);
    }
}
