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

public class EdListAdapter extends BaseAdapter {

	private Context context;
	private DBHelper db;
	List<Education> edList;
	int[] educationLogos = { R.drawable.ed_psu_logo, R.drawable.ed_csub_logo }; // Migrate
																				// to
																				// database.

	public EdListAdapter(Context context) {
		this.context = context;
		db = new DBHelper(context);
		edList = db.getAllEducaion();
	}

	@Override
	public int getCount() {
		return edList.size();
	}

	@Override
	public Object getItem(int position) {
		return edList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		Education education = (Education) getItem(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.ed_item_row, parent, false);
		} else {
			row = convertView;
		}
		
		ImageView rowImage = (ImageView) row.findViewById(R.id.edImage);
		TextView rowMajor = (TextView) row.findViewById(R.id.edMajor);
		TextView rowMinor = (TextView) row.findViewById(R.id.edMinor);
		TextView rowDate = (TextView) row.findViewById(R.id.edDate);
		
		rowMajor.setText(education.getDegree() + ", " + education.getMajor());
		rowMinor.setText(education.getMinor());
		rowImage.setImageResource(educationLogos[position]);
		rowDate.setText(education.getDate());

		return row;
	}
}
