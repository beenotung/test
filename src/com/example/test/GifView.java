package com.example.test;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.os.SystemClock;
import android.view.View;

public class GifView extends View {

	private Movie mMovie;
	private long mMoviestart;

	public GifView(Context context, InputStream is) {
		super(context);
		mMovie = Movie.decodeStream(is);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.TRANSPARENT);
		super.onDraw(canvas);
		final long now = SystemClock.uptimeMillis();

		if (mMoviestart == 0) {
			mMoviestart = now;
		}
		final int relTime = (int) ((now - mMoviestart) % mMovie.duration());
		mMovie.setTime(relTime);
		mMovie.draw(canvas, 10, 10);
		this.invalidate();
	}

}
