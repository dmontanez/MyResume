package experience;

import com.example.danielmontanez.R;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class ExSummaryDialog extends DialogFragment{
	private TextView exSummary, exTitle;

    public ExSummaryDialog() {}

    public static ExSummaryDialog newInstance(String title, String summary) {
    	ExSummaryDialog frag = new ExSummaryDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("summary", summary);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_experience_summary, container);
        exTitle = (TextView) view.findViewById(R.id.ex_summary_title);
        exSummary = (TextView) view.findViewById(R.id.ex_summary);
        
        String title = getArguments().getString("title");
        String summary = getArguments().getString("summary");
        
        exTitle.setText(title);
        exSummary.setText(summary);
        getDialog().setTitle("Summary");
        
        return view;
    }
}
