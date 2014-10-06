package experience;

import com.example.danielmontanez.DBHelper;
import com.example.danielmontanez.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ExperienceActivity extends Fragment implements OnItemClickListener{
	
	View view;
	ListView experienceList;
	ExListAdapter exAdapter;
	DBHelper db;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.content_experience, container, false);
		db = new DBHelper(getActivity());
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		exAdapter = new ExListAdapter(getActivity());
		
		experienceList = (ListView) getActivity().findViewById(R.id.experienceList);
		experienceList.setAdapter(exAdapter);
		
		experienceList.setOnItemClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		selectItem(position);
	}
	
	private void selectItem(int position) {	
		showEditDialog(position);
	}

	private void showEditDialog(int position) {
		
		Experience experience = db.getExperience(position + 1);
		
	    FragmentManager fm = getFragmentManager();
	    ExSummaryDialog editNameDialog = ExSummaryDialog.newInstance(experience.getPosition(), experience.getSummary());
	    editNameDialog.show(fm, "fragment_edit_name");
	  }
	
}
