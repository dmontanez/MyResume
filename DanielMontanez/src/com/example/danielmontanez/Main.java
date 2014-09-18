package com.example.danielmontanez;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends ActionBarActivity implements OnItemClickListener{
	
	//Layout object declaration
	private DrawerLayout drawerLayout;
	private ListView listView;
	
	//Other declarations.
	private ActionBarDrawerToggle drawerListener; //listener for the drawer; handles the toggling.
	private MyAdapter myAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Initialize layout objects.
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		listView = (ListView) findViewById(R.id.drawerList);
		
		//Initialize other declarations.
		myAdapter = new MyAdapter(this);
		drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close) {
		
			
			@Override //What to do when the drawer is opened.
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				Toast.makeText(Main.this, " Drawer Opened ", Toast.LENGTH_SHORT).show();
			}

			@Override //What to do when the drawer is closed.
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				Toast.makeText(Main.this, " Drawer Closed ", Toast.LENGTH_SHORT).show();
			}
		};
		drawerLayout.setDrawerListener(drawerListener); //Set the  layout object listener.
		
		//Set the navigation drawer adapter.
		listView.setAdapter(myAdapter);
		listView.setOnItemClickListener(this);
		
		getSupportActionBar().setHomeButtonEnabled(true); //Enables the app icon home button.
		getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Displays the up directory indicator to the left of the icon.

	}

	@Override //Allows home button to open Navigation Drawer if applicable.
	public boolean onOptionsItemSelected(MenuItem item) {
		if(drawerListener.onOptionsItemSelected(item)) {return true;}
		return super.onOptionsItemSelected(item);
	}
	
	@Override //Lets the system change the Navigation Drawer configuration when needed.
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
	}
	
	@Override //Sync the state of the navigation drawer.
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}
	
	@Override //Handles the Navigation drawer item click.
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);
	}

	//Sets the Action bar title to the title of the navigation button that was clicked.
	private void selectItem(int position) {
		listView.setItemChecked(position, true);
	}
	
}


class MyAdapter extends BaseAdapter {
	
	private Context context;
	String[] drawerNavItems;
	int[] drawerNavIcons= {R.drawable.ic_summary, R.drawable.ic_education, R.drawable.ic_experience, R.drawable.ic_skills, R.drawable.ic_interests};
	
	public MyAdapter (Context context) {
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
