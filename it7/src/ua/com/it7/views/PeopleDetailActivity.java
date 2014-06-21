package ua.com.it7.views;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import ua.com.it7.R;
import ua.com.it7.model.Person;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

@EActivity(R.layout.people_detail)
public class PeopleDetailActivity extends ActionBarActivity {
	@Extra("person")
	Person		p;
	
	@ViewById(R.id.person_name_text_detail)
	TextView	name;
	
	@ViewById(R.id.person_date_text_detail)
	TextView	date;
	
	@ViewById(R.id.person_bio_text_detail)
	TextView	bio;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.DISPLAY_HOME_AS_UP);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setDisplayShowTitleEnabled(true);
	}
	
	@AfterViews
	void show() {
		// Person p = (Person) getIntent().getSerializableExtra("Editing");
		Log.i("oioi", p.getName());
		
		name.setText(p.getName());
		date.setText(p.getDateBirth());
		bio.setText(p.getBio());
	}
	
	// @AfterViews
	void showshow() {
		
	}
	/* @Override
	 * public void onNavigationDrawerItemSelected(int position) {
	 * // update the main content by replacing fragments
	 * // FragmentManager fragmentManager = getSupportFragmentManager();
	 * // if (position != -1) {
	 * // fragmentManager.beginTransaction().replace(R.id.container, new PeopleFragment_()).commit();
	 * // }
	 * Intent i = new Intent(this, MainActivity_.class);
	 * i.putExtra("fragment", position);
	 * startActivity(i);
	 * } */
	
}
