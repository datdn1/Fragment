package datdn1.coderschool.criminalintent;


import java.util.Date;
import java.util.UUID;

public class Crime {
	private UUID mId;
	private boolean mSolved;
	
	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}

	private Date mDate;
	
	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public UUID getId() {
		return mId;
	}

	private String mTitle; 
	
	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public Crime() {
		mId = UUID.randomUUID();
		mDate = new Date();
	}
	
	@Override
	public String toString() {
		return mTitle;
	}
}
