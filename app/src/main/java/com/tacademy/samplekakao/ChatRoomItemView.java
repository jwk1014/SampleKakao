package com.tacademy.samplekakao;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Tacademy on 2015-10-12.
 */
public class ChatRoomItemView extends FrameLayout {
    public ChatRoomItemView(Context context) {
        super(context);
        init();
    }
    ImageView imageView,people_imageView,mute_imageView;
    TextView title_textView,content_textView,time_textView;
    ChatRoomItem item;
    private void init() {
        inflate(getContext(), R.layout.chat_room_itemview, this);
        imageView = (ImageView)findViewById(R.id.chat_room_itemview_imageview);
        title_textView = (TextView)findViewById(R.id.chat_room_itemview_title_textview);
        people_imageView = (ImageView)findViewById(R.id.chat_room_itemview_people_imageview);
        mute_imageView = (ImageView)findViewById(R.id.chat_room_itemview_mute_imageview);
        content_textView = (TextView)findViewById(R.id.chat_room_itemview_content_textview);
        time_textView = (TextView)findViewById(R.id.chat_room_itemview_time_textview);
    }

    public void setChatRoomItem(ChatRoomItem item) {
        if(item.image_id > 0)
            imageView.setImageResource(item.image_id);
        title_textView.setText(item.title);
        //people
        //mute
        content_textView.setText(item.talk_string);
        Calendar c = Calendar.getInstance();
        int today = c.get(Calendar.DATE);
        long current = c.getTimeInMillis();
        c.setTime(item.time);
        String time_string = null;
        if(current-c.getTimeInMillis() < 24*3600*1000 && c.get(Calendar.DATE) == today)
            time_string = "a hh:mm";
        else
            time_string = "yyyy/MM/dd";
        time_textView.setText(new SimpleDateFormat(time_string).format(item.time));
        this.item = item;
    }
}
