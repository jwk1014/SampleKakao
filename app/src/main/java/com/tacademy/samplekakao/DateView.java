package com.tacademy.samplekakao;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class DateView extends FrameLayout {
    public DateView(Context context) {
        super(context);
        init();
    }

    TextView dateView;

    private void init() {
        inflate(getContext(), R.layout.view_date, this);
        dateView = (TextView)findViewById(R.id.chat_date_textview);
    }

    public void setData(DateData data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
        dateView.setText(sdf.format(data.date));
    }

}
