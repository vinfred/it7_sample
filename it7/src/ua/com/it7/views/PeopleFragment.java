package ua.com.it7.views;

import java.util.ArrayList;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.R;
import ua.com.it7.adapters.PeopleAdapter;
import ua.com.it7.helpers.DataProvider;
import ua.com.it7.model.Person;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

@EFragment(R.layout.fragment_main)
@OptionsMenu(R.menu.detail)
public class PeopleFragment extends Fragment {
	@ViewById(R.id.people_list)
	ListView					peopleList;
	Activity					parent;
	@ViewById(R.id.text_warning)
	TextView					warning;
	private ArrayList<Person>	s;
	PeopleAdapter				adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		hasOptionsMenu();
		getData();
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parent = activity;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_refresh:
				getData();
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@UiThread
	void showItems() {
		if (s != null) {
			warning.setVisibility(TextView.GONE);
			adapter = new PeopleAdapter(getActivity(), s);
			peopleList.setAdapter(adapter);
		}
		else {
			peopleList.setAdapter(null);
			warning.setVisibility(TextView.VISIBLE);
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
		i.putExtra("person", p);
		startActivity(i);
	}
}