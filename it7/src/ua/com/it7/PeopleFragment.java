package ua.com.it7;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.adapters.PeopleAdapter;
import ua.com.it7.helpers.DataProvider;
import ua.com.it7.model.Person;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.ListView;

@EFragment(R.layout.fragment_main)
public class PeopleFragment extends Fragment {
	@ViewById(R.id.people_list)
	ListView	peopleList;
	
	@AfterViews
	void chew() {
		getData();
	}
	
	@UiThread
	void showItems(ArrayList<Person> s) {
		PeopleAdapter adapter = new PeopleAdapter(getActivity(), s);
		peopleList.setAdapter(adapter);
	}
	
	@Background
	void getData() {
		DataProvider dp = new DataProvider();
		showItems(dp.boo());
	}
	
	@ItemClick(R.id.people_list)
	void oi() {
		FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
		
		// MainActivity_.mNavigationDrawerFragment.mDrawerToggle.setDrawerIndicatorEnabled(false);
		
		/* fragmentManager.beginTransaction() .replace(R.id.container, new PeopleDetailFragment_()).addToBackStack(null) .commit(); */
		Intent i = new Intent(getActivity(), PeopleDetailActivity_.class);
		startActivity(i);
		
	}
}