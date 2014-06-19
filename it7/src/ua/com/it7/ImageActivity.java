package ua.com.it7;

import java.util.ArrayList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.helpers.DataProvider;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@EActivity(R.layout.activity_image)
public class ImageActivity extends ActionBarActivity {
	@ViewById(R.id.textView1)
	TextView					view;
	
	private ArrayList<String>	imgs;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}
	
	@AfterViews
	void chew() {
		getData();
	}
	
	@UiThread
	void show() {
		view.setText(imgs.get(0));
	}
	
	@Background
	void getData() {
		DataProvider dp = new DataProvider();
		imgs = dp.getImage();
		Log.i("activity", imgs.toString());
		show();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
