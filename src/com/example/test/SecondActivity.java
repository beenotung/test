package com.example.test;

import java.io.IOException;
import com.example.test.MainActivity;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Scene;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_second);
		// file:///android_res/drawable/example.png
		InputStream is = null;
		try {
			is = getAssets().open(getString(R.string.loading_path));			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (is != null) {
			Toast.makeText(SecondActivity.this, "gif dynamic loading", Toast.LENGTH_SHORT);
			GifView gifView = new GifView(this, is);
			setContentView(gifView);
		} else {
			Toast.makeText(SecondActivity.this, "gif static loading", Toast.LENGTH_SHORT);
			setContentView(R.layout.activity_second);
		}
	}

	private int getScale() {
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		Point outSize = new Point();
		display.getSize(outSize);
		int width = outSize.x;
		int imgWidth = getResources().getDrawable(R.drawable.loading).getIntrinsicWidth();
		double scale = (double) imgWidth / (double) width;
		return Double.valueOf(scale).intValue();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
