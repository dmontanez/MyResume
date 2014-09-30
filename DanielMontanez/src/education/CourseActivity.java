package education;

import com.example.danielmontanez.DBHelper;
import com.example.danielmontanez.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CourseActivity extends ActionBarActivity{
	
	ImageView logo, seal;
	TextView status_date, school_name;
	DBHelper db;
	Education education;
	ListView crsList;
	String schlDate;
	String schlName;
	CrsListAdapter crsAdapter;
	int s_id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content2_courses);
		logo = (ImageView) findViewById(R.id.courseSchoolLogo);
		seal = (ImageView) findViewById(R.id.courseSchoolSeal);
		crsList = (ListView) findViewById(R.id.courseList);
		
		status_date = (TextView) findViewById(R.id.schoolDegStatus);
		school_name = (TextView) findViewById(R.id.schoolName);
		
		db = new DBHelper(this);
		
		Intent intent = getIntent();
		s_id = intent.getIntExtra("S_ID", 1);
		
		crsAdapter = new CrsListAdapter(this, s_id);
		
		Log.d("DMONT","S_ID is: " + s_id);
		Log.d("DMONT", "CrsList Size is: " + crsAdapter.getCount());
		education = db.getEducation(s_id);
		
		schlDate = education.getDegreeStatus() + "\n" + education.getDegreeDate();
		Log.d("DMONT", "Degree Status is: " + schlDate);
		schlName = education.getUniversity();
		
		status_date.setText(schlDate);
		school_name.setText(schlName);
		
		populateImageViews();
		
		crsList.setAdapter(crsAdapter);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setTitle(education.getUniversity());
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	            finish();
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	private void populateImageViews() {
		if (s_id == 1) {
			logo.setImageResource(R.drawable.lgo_psu);
			seal.setImageResource(R.drawable.sl_psu);
		} else {
			logo.setImageResource(R.drawable.lgo_csub);
			seal.setImageResource(R.drawable.sl_csub);
		}
	}
}
