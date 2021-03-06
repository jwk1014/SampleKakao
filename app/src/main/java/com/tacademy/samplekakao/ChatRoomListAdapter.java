package com.tacademy.samplekakao;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2015-10-12.
 */
public class ChatRoomListAdapter extends BaseAdapter {
    List<ChatRoomItem> items = new ArrayList<ChatRoomItem>();

    public void add(ChatRoomItem item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatRoomItemView view = new ChatRoomItemView(parent.getContext());
        view.setChatRoomItem(items.get(position));
        return view;
    }
}
