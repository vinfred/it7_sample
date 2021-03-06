package ua.com.it7.views;

import java.util.ArrayList;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.R;
import ua.com.it7.helpers.BitmapLruCache;
import ua.com.it7.helpers.DataProvider;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.imagezoom.ImageAttacher;
import com.imagezoom.ImageAttacher.OnMatrixChangedListener;
import com.imagezoom.ImageAttacher.OnPhotoTapListener;

@EActivity(R.layout.activity_image)
public class ImageActivity extends ActionBarActivity {
	private ArrayList<String>	imgs;
	@ViewById(R.id.picture)
	NetworkImageView			picture;
	public RequestQueue			rQueue;
	public BitmapLruCache		cache;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		rQueue = Volley.newRequestQueue(this);
		cache = new BitmapLruCache();
		getData();
	}
	
	public void usingSimpleImage(ImageView imageView) {
		ImageAttacher mAttacher = new ImageAttacher(imageView);
		// ImageAttacher.MAX_ZOOM = 3.0f; // Double the current Size
		// ImageAttacher.MIN_ZOOM = 0.5f; // Half the current Size
		ImageAttacher.MAX_ZOOM = imageView.getWidth();
		ImageAttacher.MIN_ZOOM = 0.5f;
		
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
		ImageLoader mImageLoader = new ImageLoader(rQueue, cache);
		picture.setImageUrl(imgs.get(0), mImageLoader);
		usingSimpleImage(picture);
	}
	
	@Background
	void getData() {
		DataProvider dp = new DataProvider();
		imgs = dp.getImage();
		show();
	}
}
