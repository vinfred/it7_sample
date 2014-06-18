package ua.com.it7;

import org.androidannotations.annotations.EFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

@EFragment
public class PeopleDetailFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		ActionBar a = ((ActionBarActivity) getActivity()).getSupportActionBar();
		// a.setHomeAsUpIndicator(R.id.up);
		a.setHomeButtonEnabled(true);
		a.setNavigationMode(ActionBar.DISPLAY_HOME_AS_UP);
		
		return super.onCreateView(inflater, container, savedInstanceState);
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// needed to indicate that the fragment would
		// like to add items to the Options Menu
		setHasOptionsMenu(true);
		// update the actionbar to show the up carat/affordance
		ActionBar a = ((ActionBarActivity) getActivity()).getSupportActionBar();
		a.setDisplayHomeAsUpEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Get item selected and deal with it
		switch (item.getItemId()) {
			case android.R.id.home:
				// called when the up affordance/carat in actionbar is pressed
				getActivity().onBackPressed();
				return true;
			default:
				return true;
		}
	}
}
