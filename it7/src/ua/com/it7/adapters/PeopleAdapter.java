package ua.com.it7.adapters;

import java.util.ArrayList;

import ua.com.it7.R;
import ua.com.it7.model.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PeopleAdapter extends ArrayAdapter<Person> {
	
	private final Context			context;
	private final ArrayList<Person>	people;
	
	TextView						personName;
	TextView						personDate;
	
	public PeopleAdapter(Context context, ArrayList<Person> people) {
		super(context, R.layout.list_item_layout, people);
		this.context = context;
		this.people = people;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_item_layout, parent, false);
		
		personName = (TextView) rowView.findViewById(R.id.person_name_text);
		personName.setText(people.get(position).getName());
		
		personDate = (TextView) rowView.findViewById(R.id.person_date_text);
		personDate.setText(people.get(position).getDateBirth());
		
		return rowView;
	}
	
}
