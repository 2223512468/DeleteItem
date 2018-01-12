package com.jaja.deleteitem;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;

import com.jaja.deleteitem.adapter.AppAdapter;
import com.jaja.deleteitem.listener.SwipeMenuCreator;
import com.jaja.deleteitem.widget.SwipeMenu;
import com.jaja.deleteitem.widget.SwipeMenuItem;
import com.jaja.deleteitem.widget.SwipeMenuListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ApplicationInfo> mAppList;
    private SwipeMenuListView listView;
    private AppAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mAppList = getPackageManager().getInstalledApplications(0);
        listView = (SwipeMenuListView) findViewById(R.id.listView);
        mAdapter = new AppAdapter(mAppList, this);
        listView.setAdapter(mAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                switch (menu.getViewType()) {
                    case 0:
                        createMenu1(menu);
                        break;
                    case 1:
                        createMenu2(menu);
                        break;
                    case 2:
                        createMenu3(menu);
                        break;
                }
            }
        };

        listView.setMenuCreator(creator);
        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                ApplicationInfo item = mAppList.get(position);
                switch (index) {
                    case 0:
                        // open
                        break;
                    case 1:
                        // delete
//					delete(item);
                        mAppList.remove(position);
                        mAdapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
    }

    private void createMenu1(SwipeMenu menu) {
        SwipeMenuItem item1 = new SwipeMenuItem(
                getApplicationContext());
        item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0x18,
                0x5E)));
        item1.setWidth(dp2px(90));
        item1.setIcon(R.mipmap.ic_action_favorite);
        menu.addMenuItem(item1);
        SwipeMenuItem item2 = new SwipeMenuItem(
                getApplicationContext());
        item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                0xCE)));
        item2.setWidth(dp2px(90));
        item2.setIcon(R.mipmap.ic_action_good);
        menu.addMenuItem(item2);
    }

    private void createMenu2(SwipeMenu menu) {
        SwipeMenuItem item1 = new SwipeMenuItem(
                getApplicationContext());
        item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0xE0,
                0x3F)));
        item1.setWidth(dp2px(90));
        item1.setIcon(R.mipmap.ic_action_important);
        menu.addMenuItem(item1);
        SwipeMenuItem item2 = new SwipeMenuItem(
                getApplicationContext());
        item2.setBackground(new ColorDrawable(Color.rgb(0xF9,
                0x3F, 0x25)));
        item2.setWidth(dp2px(90));
        item2.setIcon(R.mipmap.ic_action_discard);
        menu.addMenuItem(item2);
    }

    private void createMenu3(SwipeMenu menu) {
        SwipeMenuItem item1 = new SwipeMenuItem(
                getApplicationContext());
        item1.setBackground(new ColorDrawable(Color.rgb(0x30, 0xB1,
                0xF5)));
        item1.setWidth(dp2px(90));
        item1.setIcon(R.mipmap.ic_action_about);
        menu.addMenuItem(item1);
        SwipeMenuItem item2 = new SwipeMenuItem(
                getApplicationContext());
        item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                0xCE)));
        item2.setWidth(dp2px(90));
        item2.setIcon(R.mipmap.ic_action_share);
        menu.addMenuItem(item2);
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}


