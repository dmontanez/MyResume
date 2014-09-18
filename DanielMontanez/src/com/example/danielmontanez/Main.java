package com.example.danielmontanez;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends ActionBarActivity implements OnItemClickListener{

	private DrawerLayout drawerLayout;
	private ListView listView;
	private String[] drawerNavItems;
	private ActionBarDrawerToggle drawerListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerNavItems = getResources().getStringArray(R.array.drawerNavItems);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				Toast.makeText(Main.this, " Drawer Opened ", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				Toast.makeText(Main.this, " Drawer Closed ", Toast.LENGTH_SHORT).show();
			}
		};

		drawerLayout.setDrawerListener(drawerListener);
		
		listView = (ListView) findViewById(R.id.drawerList);
		listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, drawerNavItems));
		listView.setOnItemClickListener(this);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, drawerNavItems[position] + " was clicked.", Toast.LENGTH_LONG).show();
		selectItem(position);

	}

	private void selectItem(int position) {
		listView.setItemChecked(position, true);
		getSupportActionBar().setTitle(drawerNavItems[position]);
	}
}
