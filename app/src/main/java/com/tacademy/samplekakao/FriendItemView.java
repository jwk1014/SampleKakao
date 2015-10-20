package com.tacademy.samplekakao;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Tacademy on 2015-10-12.
 */
public class FriendItemView extends FrameLayout {
    public FriendItemView(Context context) {
        super(context);
        init();
    }
    ImageView imageView;
    TextView textView,talkstringTextView;
    FriendItem item;
    private void init() {
        inflate(getContext(), R.layout.friend_itemview, this);
        imageView = (ImageView)findViewById(R.id.friend_itemview_imageview);
        textView = (TextView)findViewById(R.id.friend_itemview_talk_textview);
        talkstringTextView = (TextView)findViewById(R.id.friend_itemview_talkstring_imageview);
    }

    public void setFriendItem(FriendItem item) {
        if(item.image_id > 0)
            imageView.setImageResource(item.image_id);
        textView.setText(item.name);
        if(item.talk_string != null){
            talkstringTextView.setVisibility(View.VISIBLE);
            talkstringTextView.setText(item.talk_string);
        }else{
            talkstringTextView.setVisibility(View.GONE);
        }
        this.item = item;
    }
}
