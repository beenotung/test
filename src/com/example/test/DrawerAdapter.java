package com.example.test;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends ArrayAdapter<DrawerItem> {

	private List<DrawerItem> drawerListItem;
	private Context context;
	private int layoutResourceID;

	public DrawerAdapter(Context context, int layoutResourceID, List<DrawerItem> listItem) {
		super(context, layoutResourceID, listItem);
		this.context = context;
		this.layoutResourceID = layoutResourceID;
		this.drawerListItem = drawerListItem;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		DrawerHolder drawerHolder;
		View view = convertView;
		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			drawerHolder = new DrawerHolder();
			view = inflater.inflate(layoutResourceID, parent, false);
			drawerHolder.itemName = (TextView) view.findViewById(R.id.drawer_itemName);
			drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);
			view.setTag(drawerHolder);
		} else {
			drawerHolder = (DrawerHolder) view.getTag();
		}
		DrawerItem drawerItem=this.drawerListItem.get(position);
		drawerHolder.itemName.setText(drawerItem.itemName);
		drawerHolder.icon.setImageDrawable(drawerItem.img);
		return view;
	}

	private static class DrawerHolder {
		TextView itemName;
		ImageView icon;
	}
}
