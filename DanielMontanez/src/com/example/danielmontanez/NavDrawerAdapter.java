package com.example.danielmontanez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerAdapter extends BaseAdapter{
	
	private Context context;
	String[] drawerNavItems;
	int[] drawerNavIcons= {R.drawable.ic_summary, R.drawable.ic_education, R.drawable.ic_experience, R.drawable.ic_skills, R.drawable.ic_interests};
	
	public NavDrawerAdapter (Context context) {
		this.context = context;
		drawerNavItems = context.getResources().getStringArray(R.array.drawerNavItems);
	}
	
	@Override
	public int getCount() {
		return drawerNavItems.length;
	}

	@Override
	public Object getItem(int position) {
		return drawerNavItems[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		if (convertView==null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.nav_item_row, parent, false);
		} else {
			row = convertView;
		}
		ImageView rowImage = (ImageView) row.findViewById(R.id.navRowImage);
		TextView rowTitle = (TextView) row.findViewById(R.id.navRowTitle);
		
		rowImage.setImageResource(drawerNavIcons[position]);
		rowTitle.setText(drawerNavItems[position]);
		
		return row;
	}
}
