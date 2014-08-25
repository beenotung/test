package com.example.test;

import java.util.ArrayList;
import java.util.Random;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	public ArrayList<String> ramList;
	public Random random;
	public Button button;
	public TextView textView;
	public MyThread myThread;

	public void initvar() {
		ramList = new ArrayList<String>();
		random = new Random(System.currentTimeMillis());
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				addram();
			}
		});
		textView = (TextView) findViewById(R.id.textView1);
		myThread=new MyThread(ramList);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initvar();
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

	public void addram() {
		int I = random.nextInt(Integer.MAX_VALUE / 2 - 1);
		I = 3;
		// int I = random.nextInt(1024);
		// Toast.makeText(MainActivity.this, String.valueOf(I),
		// Toast.LENGTH_SHORT).show();
		myThread.start(I);
	}

	public class MyThread implements Runnable {
		private int I;
		private Thread thread;
		public ArrayList<String> ramList;
		public long l;

		public MyThread(ArrayList<String> ramList) {
			this.ramList = ramList;
			l=1000;
		}

		@Override
		public void run() {
			while (I > 0) {
				textView.setText(String.valueOf(I));
				ramList.add(" ");
				I--;
				SystemClock.sleep(l);
			}
		}

		void start(int I) {
			this.I = I;
			if (thread == null)
				thread = new Thread(this);
			thread.start();
		}
	}
}
