package com.example.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentActivity extends Fragment {
	private int position;
	private View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		position = getArguments().getInt("position");
		rootView = getView();

		switch (position) {
		case 1:
			rootView = inflater.inflate(R.layout.fragment1, container, false);
			break;
		case 2:
			rootView = inflater.inflate(R.layout.fragment2, container, false);
			break;
		}

		// getActivity().setContentView(rootView);

		return rootView;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}
}
