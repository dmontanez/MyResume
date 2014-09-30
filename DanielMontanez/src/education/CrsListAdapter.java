package education;

import java.util.List;

import com.example.danielmontanez.DBHelper;
import com.example.danielmontanez.R;
import com.example.danielmontanez.R.drawable;
import com.example.danielmontanez.R.id;
import com.example.danielmontanez.R.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CrsListAdapter extends BaseAdapter {

	private Context context;
	private DBHelper db;
	List<Course> crsList;


	public CrsListAdapter(Context context, int school_id) {
		this.context = context;
		db = new DBHelper(context);
		crsList = db.getEdCourses(school_id);
	}

	@Override
	public int getCount() {
		return crsList.size();
	}

	@Override
	public Object getItem(int position) {
		return crsList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		Course course = (Course) getItem(position);
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.crs_item_row, parent, false);
		} else {
			row = convertView;
		}
		
		TextView crsTitle;
		crsTitle = (TextView) row.findViewById(R.id.crsRowTitle);
		
		crsTitle.setText(course.getTitle());

		return row;
	}
}
