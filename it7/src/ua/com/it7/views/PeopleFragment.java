package ua.com.it7.views;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.R;
import ua.com.it7.adapters.PeopleAdapter;
import ua.com.it7.helpers.DataProvider;
import ua.com.it7.model.Person;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.Toast;

@EFragment(R.layout.fragment_main)
public class PeopleFragment extends Fragment {
	@ViewById(R.id.people_list)
	ListView					peopleList;
	
	private ArrayList<Person>	s;
	
	@AfterViews
	void chew() {
		getData();
	}
	
	@UiThread
	void showItems() {
		if (s != null) {
			PeopleAdapter adapter = new PeopleAdapter(getActivity(), s);
			peopleList.setAdapter(adapter);
		}
		else {
			Toast.makeText(getActivity(), "No connection :'(", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Background
	void getData() {
		DataProvider dp = new DataProvider();
		s = dp.boo();
		showItems();
	}
	
	@ItemClick(R.id.people_list)
	void oi(Person p) {
		Intent i = new Intent(getActivity(), PeopleDetailActivity_.class);
		// Intent i = new Intent(getActivity(), DetailActivity_.class);
		i.putExtra("person", p);
		startActivity(i);
	}
}