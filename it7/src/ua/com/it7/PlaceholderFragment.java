package ua.com.it7;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.helpers.DataProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@EFragment
public class PlaceholderFragment extends Fragment {
	@ViewById(R.id.section_label)
	TextView	textView;
	
	public static PlaceholderFragment_ newInstance(int sectionNumber) {
		return new PlaceholderFragment_();
	}
	
	public PlaceholderFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);
		System.out.println(":< :<");
		return rootView;
	}
	
	@AfterViews
	void chew() {
		boo();
	}
	
	@UiThread
	void oioi(String s) {
		Log.i("s", s);
		textView.setText(s);
	}
	
	@Background
	void boo() {
		DataProvider dp = new DataProvider();
		// oioi("chew");
		oioi(dp.boo().get(0).toString());
	}
}