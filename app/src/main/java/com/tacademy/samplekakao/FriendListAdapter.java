package com.tacademy.samplekakao;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2015-10-06.
 */
public class FriendListAdapter extends BaseExpandableListAdapter {
    List<FriendGroupItem> items = new ArrayList<>();

    public void add(String groupName, FriendItem child) {
        FriendGroupItem g = null;
        for (FriendGroupItem item : items) {
            if (item.groupName.equals(groupName)) {
                g = item;
                break;
            }
        }
        if (g == null) {
            g = new FriendGroupItem();
            g.groupName = groupName;
            items.add(g);
        }

        if (child != null) {
            g.children.add(child);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).children.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).children.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return (long)groupPosition << 32 | 0xFFFFFFFF;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return (long)groupPosition << 32 | childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FriendGroupItemView v;
        if (convertView != null) {
            v = (FriendGroupItemView)convertView;
        } else {
            v = new FriendGroupItemView(parent.getContext());
        }
        v.setGroupItem(items.get(groupPosition));
        return v;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        FriendItemView v;
        if (convertView != null) {
            v = (FriendItemView)convertView;
        } else {
            v = new FriendItemView(parent.getContext());
        }
        v.setFriendItem(items.get(groupPosition).children.get(childPosition));
        return v;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
