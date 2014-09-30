package experience;

import com.example.danielmontanez.R;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

public class ExSummaryDialog extends DialogFragment{
	private EditText mEditText;

    public ExSummaryDialog() {}

    public static ExSummaryDialog newInstance(String title) {
    	ExSummaryDialog frag = new ExSummaryDialog();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_experience_summary, container);
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        String title = getArguments().getString("title");
        getDialog().setTitle(title);
        // Show soft keyboard automatically
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        return view;
    }
}
