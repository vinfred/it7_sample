package ua.com.it7;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.adapters.PeopleAdapter;
import ua.com.it7.helpers.DataProvider;
import ua.com.it7.model.Person;
import android.support.v4.app.Fragment;
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
		// Log.i("s", s);
		// textView.setText(s);
		
		PeopleAdapter adapter = new PeopleAdapter(getActivity().getApplicationContext(), s);
		
		peopleList.setAdapter(adapter);
	}
	
	@Background
	void getData() {
		DataProvider dp = new DataProvider();
		showItems(dp.boo());
	}
	
	/* @Override public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	 * super.onCreate(savedInstanceState); setRetainInstance(true);
	 * 
	 * return rootView; } */
}