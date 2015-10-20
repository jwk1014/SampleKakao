package com.tacademy.samplekakao;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.Calendar;
import java.util.Date;

public class ChattingActivity extends SlidingFragmentActivity {
    boolean mute;
    ActionBar actionBar;
    EditText talkEditText;
    ImageView plusImageView,shapImageView,smileImageView;
    Button sendButton;
    AlertDialog dialog;
    ListView listView;
    ChattingAdapter mAdapter;
    Date date;
    SlidingMenu mSlidingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        setBehindContentView(R.layout.chatting_navigation_layout);

        mSlidingMenu = getSlidingMenu();
        mSlidingMenu.setMode(SlidingMenu.RIGHT);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.actionbar_icon_prev_black);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.chat_toolbar_layout);
        actionBar.setDisplayShowTitleEnabled(false);
        View v = actionBar.getCustomView();
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        if(title != null){
            TextView titleTextview = (TextView)v.findViewById(R.id.chat_toolbar_roomname_textview);
            titleTextview.setText(title);
        }
        int peoplecount = intent.getIntExtra("people",-1);
        if(peoplecount > 2){
            TextView peoplecountTextview = (TextView)v.findViewById(R.id.chat_toolbar_peoplecount_textview);
            peoplecountTextview.setVisibility(View.VISIBLE);
            peoplecountTextview.setText(""+peoplecount);
        }
        mute = intent.getBooleanExtra("mute", false);



        plusImageView = (ImageView)findViewById(R.id.chatting_plus_imageview);
        shapImageView = (ImageView)findViewById(R.id.chatting_shap_imageview);
        smileImageView = (ImageView)findViewById(R.id.chatting_smile_imageview);
        sendButton = (Button)findViewById(R.id.chatting_send_Button);
        talkEditText = (EditText)findViewById(R.id.chatting_talk_edittext);
        talkEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();
                if(text.length() > 0)
                    sendButton.setEnabled(true);
                else
                    sendButton.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listView = (ListView)findViewById(R.id.chatting_listview);
        mAdapter = new ChattingAdapter();
        listView.setAdapter(mAdapter);

        date = new Date();
    }

    public void onSendButton(View v){
        final View innerView = getLayoutInflater().inflate(R.layout.send_option_select_layout,null);
        Button leftButton = (Button)innerView.findViewById(R.id.send_option_left_button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.send_option_left_button: {
                        ReceiveData data = new ReceiveData();
                        data.message = talkEditText.getText().toString();
                        data.resId = R.drawable.img_chat_profile_send_default;
                        mAdapter.add(data);
                    }
                        break;
                    case R.id.send_option_right_button: {
                        SendData data = new SendData();
                        data.message = talkEditText.getText().toString();
                        mAdapter.add(data);
                    }
                        break;
                    case R.id.send_option_date_button: {
                        DateData data = new DateData();
                        data.date = date;
                        mAdapter.add(data);
                        Calendar c = Calendar.getInstance();
                        c.setTime(date);
                        c.add(Calendar.DATE, 1);
                        date = c.getTime();
                    }
                        dialog.dismiss();
                        return;
                }
                talkEditText.setText("");
                dialog.dismiss();
            }
        };
        leftButton.setOnClickListener(listener);
        Button dateButton = (Button)innerView.findViewById(R.id.send_option_date_button);
        dateButton.setOnClickListener(listener);
        Button rightButton = (Button) innerView.findViewById(R.id.send_option_right_button);
        rightButton.setOnClickListener(listener);
        AlertDialog.Builder ab = new AlertDialog.Builder(this).setView(innerView);
        dialog = ab.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        //if(drawer.isDrawerOpen(GravityCompat.END))
        //    drawer.closeDrawer(GravityCompat.END);
        //else
            super.onBackPressed();
    }
}
