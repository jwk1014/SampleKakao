package com.tacademy.samplekakao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {


    public Tab1Fragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_tab1, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_tab1_f1:
                return true;
            case R.id.menu_tab1_f2_s1:
                return true;
            case R.id.menu_tab1_f2_s2:
                return true;
            case R.id.menu_tab1_f2_s3:
                return true;
            case R.id.menu_tab1_f2_s4:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ExpandableListView listView;
    FriendListAdapter mAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        listView = (ExpandableListView)view.findViewById(R.id.friend_list_tab1);
        View header = getActivity().getLayoutInflater().inflate(R.layout.friend_list_header, null);
        listView.addHeaderView(header, "header", true);
        mAdapter = new FriendListAdapter();
        listView.setAdapter(mAdapter);
        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                listView.expandGroup(groupPosition);
            }
        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Toast.makeText(getContext(), groupPosition+"/"+childPosition, Toast.LENGTH_SHORT).show();
                FriendItem item = (FriendItem)mAdapter.getChild(groupPosition, childPosition);
                Intent intent = new Intent(getActivity(),FriendProfileActivity.class);
                intent.putExtra("image_id",item.image_id);
                intent.putExtra("name",item.name);
                startActivity(intent);
                return true;
            }
        });

        mAdapter.add("내 프로필", new FriendItem(0, "정원", null));
        mAdapter.add("그룹",new FriendItem(R.drawable.profile_plus,"플러스친구",null));
        mAdapter.add("친구",new FriendItem(0,"가나다","야호"));
        mAdapter.add("친구",new FriendItem(0,"나다라",null));
        mAdapter.add("친구",new FriendItem(0,"마바사",null));
        mAdapter.add("친구",new FriendItem(0,"아자차",null));
        mAdapter.add("친구",new FriendItem(0,"카타파","안드로이드잼"));
        mAdapter.add("친구", new FriendItem(0, "하하하", null));

        for (int i = 0; i < mAdapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }
        return view;
    }
}
