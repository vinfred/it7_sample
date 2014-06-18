package ua.com.it7;

import org.androidannotations.annotations.EActivity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

@EActivity
public class PeopleDetailActivity extends ActionBarActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// needed to indicate that the fragment would
		// like to add items to the Options Menu
		// setHasOptionsMenu(true);
		// update the actionbar to show the up carat/affordance
		ActionBar a = getSupportActionBar();
		a.setDisplayHomeAsUpEnabled(true);
	}
	
}
