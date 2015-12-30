package datdn1.coderschool.criminalintent;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment{
	private ArrayList<Crime> mCrimes;

	private static final String TAG = "CrimeListFragment";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crime_list_fragment_title);
		mCrimes = CrimeLab.getShareCrime(getActivity()).getCrimes();
		
//		ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
//		setListAdapter(adapter);
		CrimeAdapter adapter = new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Log.d(TAG, "Click item " + position);
		
		// start detail activity
		Crime selectedCrime = (Crime)getListAdapter().getItem(position);
		Intent detailIntent = new Intent(getActivity(), CrimeActivity.class);
		detailIntent.putExtra(CrimeFragment.EXTRA_CRIME_ID, selectedCrime.getId());
		startActivity(detailIntent);
	}

	private class CrimeAdapter extends ArrayAdapter<Crime> {
		public CrimeAdapter(ArrayList<Crime> crimes) {
			super(getActivity(), 0, crimes);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return super.getCount();
		}

		@Override
		public Crime getItem(int position) {
			// TODO Auto-generated method stub
			return super.getItem(position);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View listItemLayout = convertView;
			if (listItemLayout == null) {
				listItemLayout = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
			}
			
			TextView title = (TextView)listItemLayout.findViewById(R.id.list_item_title_textview);
			TextView date = (TextView)listItemLayout.findViewById(R.id.list_item_date_textview);
			CheckBox solved = (CheckBox)listItemLayout.findViewById(R.id.list_item_checkbox);
			
			Crime crime = (Crime)getListAdapter().getItem(position);
			title.setText(crime.getTitle());
			date.setText(crime.getDate().toString());
			solved.setChecked(crime.isSolved());
			
			return listItemLayout;
		}
		
		
		
		
	}
	
	
	
}
