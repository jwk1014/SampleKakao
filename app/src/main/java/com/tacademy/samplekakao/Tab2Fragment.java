package com.tacademy.samplekakao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2Fragment extends Fragment {


    public Tab2Fragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_tab2, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_tab2_f1:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ListView listView;
    ChatRoomListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        listView = (ListView)view.findViewById(R.id.chat_list_tab2);
        View header = getActivity().getLayoutInflater().inflate(R.layout.chat_room_list_header, null);
        listView.addHeaderView(header, "header", true);
        mAdapter = new ChatRoomListAdapter();
        listView.setAdapter(mAdapter);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,14);
        c.set(Calendar.MINUTE, 24);
        mAdapter.add(new ChatRoomItem(0, "브로콜리", 5, false, "고마워요~", c.getTime()));
        c.set(Calendar.HOUR_OF_DAY, 11);
        c.set(Calendar.MINUTE, 24);
        mAdapter.add(new ChatRoomItem(0, "t전문가10기안드로이드", 22, false, "테스트1", c.getTime()));
        c.set(Calendar.HOUR_OF_DAY, 10);
        c.set(Calendar.MINUTE, 19);
        mAdapter.add(new ChatRoomItem(0, "가나다", 2, false, "테스트2", c.getTime()));
        c.add(Calendar.DATE,-1);
        mAdapter.add(new ChatRoomItem(0, "09", 18, true, "테스트3", c.getTime()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ChattingActivity.class);
                ChatRoomItem item = (ChatRoomItem)mAdapter.getItem(position-1);
                intent.putExtra("title",item.title);
                intent.putExtra("people",item.people);
                intent.putExtra("mute",item.mute);
                startActivity(intent);
            }
        });

        return view;
    }


}
