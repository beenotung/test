package com.example.test;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class DrawerItem {
	public String itemName;
	public Drawable img;

	public DrawerItem(String itemName, int imgResID) {
		this.itemName = itemName;
		this.img=Resources.getSystem().getDrawable(imgResID);
	}

	public DrawerItem(int itemNameResID, int imgResID) {
		this.itemName = Resources.getSystem().getString(itemNameResID);
		this.img=Resources.getSystem().getDrawable(imgResID);
	}
}
