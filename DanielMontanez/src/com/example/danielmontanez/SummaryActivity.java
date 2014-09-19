package com.example.danielmontanez;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SummaryActivity extends Fragment {
	
	private DBHelper db;
	private Profile profile;
	
	private TextView name;
	private TextView phone;
	private TextView email;
	private TextView address;
	private TextView summary;
	
	String full_name;
	String full_address;
	
	View view;
	
	public SummaryActivity() {}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.content_summary, container, false);
		
		db = new DBHelper(getActivity());
		profile = db.getProfile(1);
			
		mapObjects();
		formatName();
		formatAddress();	
		fillObjects();
		 
		return view;
	}

	//Map the view objects to class variables. ====================================================
		private void mapObjects () {
			name = (TextView) view.findViewById(R.id.profileName);
			phone = (TextView) view.findViewById(R.id.phoneNumber);
			email = (TextView) view.findViewById(R.id.emailAddress);
			address = (TextView) view.findViewById(R.id.address);
			summary = (TextView) view.findViewById(R.id.summary);
		}
		
		//Format the profile name. ===================================================================
		private void formatName () {
			full_name = profile.getLName() + ", " + profile.getFName() + " " + profile.getMInit();
		}
		
		//Format address to standard format. =========================================================
		private void formatAddress () {
			full_address = profile.getCity() + ", " + profile.getState() + " " + profile.getZip();
		}
		
		//Fill the view objects with profile data. =====================================================
		private void fillObjects () {
			name.setText(full_name);
			phone.setText(profile.getPhone());
			email.setText(profile.getEmail());
			address.setText(full_address);
			summary.setText(profile.getSummary());
		}
	
}
