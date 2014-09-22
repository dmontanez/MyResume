package com.example.danielmontanez;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InListAdapter extends BaseAdapter {

	private Context context;
	private DBHelper db;
	List<Interest> inList;
	int[] interestLogos = { R.drawable.in_csub_logo, R.drawable.in_cchs_logo }; // Migrate
																				// to
																				// database.

	public InListAdapter(Context context) {
		this.context = context;
		db = new DBHelper(context);
		inList = db.getAllInterest();
	}

	@Override
	public int getCount() {
		return inList.size();
	}

	@Override
	public Object getItem(int position) {
		return inList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		Interest interest = (Interest) getItem(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.in_item_row, parent, false);
		} else {
			row = convertView;
		}
		
		ImageView rowImage = (ImageView) row.findViewById(R.id.inImage);
		TextView rowTitle = (TextView) row.findViewById(R.id.inTitle);
		TextView rowDesc = (TextView) row.findViewById(R.id.inDesc);
		TextView rowDate = (TextView) row.findViewById(R.id.inDate);
		
		rowTitle.setText(interest.getTitle());
		rowDesc.setText(interest.getDescription());
		rowImage.setImageResource(interestLogos[position]);
		rowDate.setText(interest.getDate());

		return row;
	}
}
