package ua.com.it7.views;

import java.util.ArrayList;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.R;
import ua.com.it7.helpers.BitmapLruCache;
import ua.com.it7.helpers.DataProvider;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.imagezoom.ImageAttacher;
import com.imagezoom.ImageAttacher.OnMatrixChangedListener;
import com.imagezoom.ImageAttacher.OnPhotoTapListener;

@EFragment(R.layout.fragment_image)
@OptionsMenu(R.menu.detail)
public class ImageFragment extends Fragment {
	private ArrayList<String>	imgs;
	
	@ViewById(R.id.picture)
	NetworkImageView			picture;
	@ViewById(R.id.text_warning_image)
	TextView					warning;
	public RequestQueue			rQueue;
	public BitmapLruCache		cache;
	private ImageLoader			mImageLoader;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rQueue = Volley.newRequestQueue(getActivity());
		cache = new BitmapLruCache();
		mImageLoader = new ImageLoader(rQueue, cache);
		getData();
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	public void usingSimpleImage(ImageView imageView) {
		ImageAttacher mAttacher = new ImageAttacher(imageView);
		ImageAttacher.MAX_ZOOM = 3.0f; // Double the current Size
		ImageAttacher.MIN_ZOOM = 0.5f; // Half the current Size
		// ImageAttacher.MAX_ZOOM = imageView.getWidth();
		
		MatrixChangeListener mMaListener = new MatrixChangeListener();
		mAttacher.setOnMatrixChangeListener(mMaListener);
		PhotoTapListener mPhotoTap = new PhotoTapListener();
		mAttacher.setOnPhotoTapListener(mPhotoTap);
	}
	
	private class PhotoTapListener implements OnPhotoTapListener {
		@Override
		public void onPhotoTap(View view, float x, float y) {
		}
	}
	
	private class MatrixChangeListener implements OnMatrixChangedListener {
		@Override
		public void onMatrixChanged(RectF rect) {
			
		}
	}
	
	@UiThread
	void show() {
		if (imgs != null) {
			picture.setVisibility(View.VISIBLE);
			warning.setVisibility(TextView.GONE);
			picture.setImageUrl(imgs.get(0), mImageLoader);
			usingSimpleImage(picture);
		}
		else {
			picture.setVisibility(View.GONE);
			warning.setVisibility(TextView.VISIBLE);
		}
	}
	
	@Background
	void getData() {
		DataProvider dp = new DataProvider();
		imgs = dp.getImage();
		show();
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
}
