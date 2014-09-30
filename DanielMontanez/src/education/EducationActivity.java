package education;

import com.example.danielmontanez.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class EducationActivity extends Fragment implements OnItemClickListener{

	View view;
	ListView educationList;
	EdListAdapter edAdapter;
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.content_education, container, false);
		
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		edAdapter = new EdListAdapter(getActivity());
		
		educationList = (ListView) getActivity().findViewById(R.id.educationList);
		educationList.setAdapter(edAdapter);
		
		educationList.setOnItemClickListener(this);
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		selectItem(position);
	}
	
	private void selectItem(int position) {	
		Intent intent = new Intent(getActivity(), education.CourseActivity.class);
		intent.putExtra("S_ID", position + 1);
		startActivity(intent);
	}
}
