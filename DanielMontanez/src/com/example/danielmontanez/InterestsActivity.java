package com.example.danielmontanez;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class InterestsActivity extends Fragment{
	
	View view;
	ListView interestList;
	InListAdapter inAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.content_interests, container, false);
		
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		inAdapter = new InListAdapter(getActivity());
		
		interestList = (ListView) getActivity().findViewById(R.id.interestList);
		interestList.setAdapter(inAdapter);
		super.onActivityCreated(savedInstanceState);
	}

}
