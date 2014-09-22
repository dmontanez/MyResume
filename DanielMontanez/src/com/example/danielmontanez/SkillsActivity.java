package com.example.danielmontanez;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SkillsActivity extends Fragment{
	
	DBHelper db;
	View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.content_skills, container, false);
		
		db = new DBHelper(getActivity());
		 
		return view;
	}

}
