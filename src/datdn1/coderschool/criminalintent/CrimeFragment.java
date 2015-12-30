package datdn1.coderschool.criminalintent;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;


public class CrimeFragment extends Fragment{
	private Crime mCrime;
	private EditText mCrimeTitleEditText;
	private CheckBox mIsSolved;
	private Button mDateButton;
	
	public static final String EXTRA_CRIME_ID = "datdn1.coderschool.CrimeIntent.CrimeFragment.EXTRA_CRIME_ID";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		mCrime = new Crime();
		UUID crimeId = (UUID)getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
		mCrime = CrimeLab.getShareCrime(getActivity()).getCrime(crimeId);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View layout = inflater.inflate(R.layout.fragment_crime, container, false);
		mCrimeTitleEditText = (EditText)layout.findViewById(R.id.crime_title_edittext);
		mIsSolved = (CheckBox)layout.findViewById(R.id.solved_checkbox);
		mDateButton = (Button)layout.findViewById(R.id.date_button);
		
		mCrimeTitleEditText.setText(mCrime.getTitle());
		mIsSolved.setChecked(mCrime.isSolved());
		mDateButton.setText(mCrime.getDate().toString());
		
		
//		mDateButton.setText(mCrime.getDate().toString());
//		mDateButton.setEnabled(false);
		
		mIsSolved.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCrime.setSolved(isChecked);
			}
		});
		
		mCrimeTitleEditText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence title, int arg1, int arg2, int arg3) {
				mCrime.setTitle(title.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				
			}
		});
		return layout;
	}


	
}
