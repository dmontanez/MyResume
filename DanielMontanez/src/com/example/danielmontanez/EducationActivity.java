package com.example.danielmontanez;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class EducationActivity extends Fragment {

	View view;
	ListView educationList;
	EdListAdapter edAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.content_education, container, false);
		
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		edAdapter = new EdListAdapter(getActivity());
		
		educationList = (ListView) getActivity().findViewById(R.id.educationList);
		educationList.setAdapter(edAdapter);
		super.onActivityCreated(savedInstanceState);
	}
	
}
