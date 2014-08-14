package com.example.test;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ArrayList<DrawerItem> dataList;
	private String title, drawerTitle;
	DrawerLayout drawerLayout;
	ListView drawerList;
	DrawerAdapter drawerAdapter;
	ActionBarDrawerToggle actionBarDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ------- Initializing -------
		dataList = new ArrayList<DrawerItem>();
		title = drawerTitle = (String) getTitle();
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.left_drawer);
		// / drawerLayout.setdrawers
		// ------ Add Drawer Item to dataList -------
		int amount = Integer.valueOf(getString(R.string.drawer_amount));
		for (int i = 1; i <= amount; i++) {
			dataList.add(new DrawerItem(R.string.drawer_0_index + i, R.drawable.drawer_0_index + i));
		}
		DrawerAdapter drawerAdapter = new DrawerAdapter(this, R.layout.drawer_item, dataList);
		drawerList.setAdapter(drawerAdapter);
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
		actionBarDrawerToggle=new ActionBarDrawerToggle(this	, drawerLayout, R.drawable, openDrawerContentDescRes, closeDrawerContentDescRes)
	}

	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
