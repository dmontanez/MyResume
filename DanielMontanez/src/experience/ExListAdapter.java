package experience;

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

public class ExListAdapter extends BaseAdapter {

	private Context context;
	private DBHelper db;
	List<Experience> exList;
	int[] experienceLogos = { R.drawable.ex_logo_csc, R.drawable.ex_logo_oxy }; // Migrate
																				// to
																				// database.

	public ExListAdapter(Context context) {
		this.context = context;
		db = new DBHelper(context);
		exList = db.getAllExperience();
	}

	@Override
	public int getCount() {
		return exList.size();
	}

	@Override
	public Object getItem(int position) {
		return exList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = null;
		Experience experience = (Experience) getItem(position);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.ex_item_row, parent, false);
		} else {
			row = convertView;
		}
		
		ImageView rowImage = (ImageView) row.findViewById(R.id.exImage);
		TextView rowTitle = (TextView) row.findViewById(R.id.exTitle);
		TextView rowPosition = (TextView) row.findViewById(R.id.exPosition);
		TextView rowDate = (TextView) row.findViewById(R.id.exDate);
		
		rowTitle.setText(experience.getTitle());
		rowPosition.setText(experience.getPosition());
		rowImage.setImageResource(experienceLogos[position]);
		rowDate.setText(experience.getDate());

		return row;
	}
}
