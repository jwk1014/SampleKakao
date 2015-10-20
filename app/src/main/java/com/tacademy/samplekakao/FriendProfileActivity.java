package com.tacademy.samplekakao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_profile);

        Intent intent = getIntent();
        int image_id = intent.getIntExtra("image_id",0);
        if(image_id != 0){
            ImageView iv = (ImageView)findViewById(R.id.friend_profile_imageview);
            iv.setImageResource(image_id);
        }

        String name = intent.getStringExtra("name");
        if(name != null){
            TextView tv = (TextView)findViewById(R.id.friend_profile_name_textview);
            tv.setText(name);
        }
    }
}
