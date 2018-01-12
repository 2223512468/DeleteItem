package com.jaja.deleteitem.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaja.deleteitem.R;

import java.util.List;

/**
 * Created by ${Terry} on 2018/1/11.
 */
public class AppAdapter extends BaseAdapter {

    private List<ApplicationInfo> mAppList;
    private Context mContext;

    public AppAdapter(List<ApplicationInfo> mAppList, Context mContext) {
        this.mAppList = mAppList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mAppList.size();
    }

    @Override
    public ApplicationInfo getItem(int i) {
        return mAppList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext,
                    R.layout.item_list_app, null);
            new ViewHolder(convertView);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        ApplicationInfo item = (ApplicationInfo) getItem(position);
        holder.iv_icon.setImageDrawable(item.loadIcon(mContext.getPackageManager()));
        holder.tv_name.setText(item.loadLabel(mContext.getPackageManager()));
        return convertView;
    }

    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;

        public ViewHolder(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(this);
        }
    }

}
