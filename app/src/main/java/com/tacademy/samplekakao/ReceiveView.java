package com.tacademy.samplekakao;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class ReceiveView extends FrameLayout {
    public ReceiveView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    ImageView iconView;

    private void init() {
        inflate(getContext(), R.layout.view_receive, this);
        messageView = (TextView)findViewById(R.id.chat_receive_textview);
        iconView = (ImageView)findViewById(R.id.chat_reveice_imageview);
    }

    public void setData(ReceiveData data) {

        messageView.setText(data.message);
        iconView.setImageResource(data.resId);
    }

}
