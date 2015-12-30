package datdn1.coderschool.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class CrimeLab {
	private static CrimeLab sShareCrime;
	private Context mAppContext;
	private ArrayList<Crime> mCrimes;

	public ArrayList<Crime> getCrimes() {
		return mCrimes;
	}

	public Crime getCrime(UUID crimeId) {
		for (Crime crime : mCrimes) {
			if (crime.getId().equals(crimeId)) {
				return crime;
			}
		}
		return null;
	}

	private CrimeLab(Context appContext) {
		mAppContext = appContext;
		mCrimes = new ArrayList<Crime>();
		for (int i = 0; i < 100; i++) {
			Crime crime = new Crime();
			crime.setTitle("Crime #" + i);
			crime.setSolved(i % 2 == 0);
			mCrimes.add(crime);
		}
	}

	public static CrimeLab getShareCrime(Context context) {
		if (sShareCrime == null) {
			sShareCrime = new CrimeLab(context.getApplicationContext());
		}
		return sShareCrime;
	}
}
