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
public class SettingItemView extends FrameLayout {
    public SettingItemView(Context context) {
        super(context);
        init();
    }
    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
        if(typedArray.getDrawable(R.styleable.SettingItemView_img_src) != null)
            imageView.setImageDrawable(typedArray.getDrawable(R.styleable.SettingItemView_img_src));
        if(typedArray.getString(R.styleable.SettingItemView_text_content) != null)
            textView.setText(typedArray.getString(R.styleable.SettingItemView_text_content));
    }
    ImageView imageView;
    TextView textView;
    SettingItem item;
    private void init() {
        inflate(getContext(), R.layout.setting_itemview, this);
        imageView = (ImageView)findViewById(R.id.setting_itemview_imageview);
        textView = (TextView)findViewById(R.id.setting_itemview_textview);
        RelativeLayout main_layout = (RelativeLayout)findViewById(R.id.setting_itemview_mainlayout);
        main_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mClickListener != null){
                    mClickListener.onSettingItemClick(SettingItemView.this,item);
                }
            }
        });
    }

    public void setItem(SettingItem item) {
        if(item.image_id > 0)
            imageView.setImageResource(item.image_id);
        textView.setText(item.name);
        this.item = item;
    }

    public interface OnSettingItemClickListener {
        public void onSettingItemClick(SettingItemView v, SettingItem item);
    }
    OnSettingItemClickListener mClickListener;
    public void setOnSettingItemClickListener(OnSettingItemClickListener listener) {
        mClickListener = listener;
    }
}
