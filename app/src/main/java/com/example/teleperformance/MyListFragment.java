package com.example.teleperformance;

import com.example.teleperformance.R;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListFragment extends ListFragment {
	
	private String myfriends[];
	  
	 public MyListFragment() {
		 myfriends = new String[] { "Sandeep Pal","Abhi Tripathi", "Amit Verma","Awadhesh Diwakar", "Shishir Verma", "Ravi",};
	 }
	  
	 @Override
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, myfriends);
		 setListAdapter(listAdapter);
	 }
	  
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		 return inflater.inflate(R.layout.list_fragment, container, false);
	 }
	  
	 @Override
	 public void onListItemClick(ListView list, View v, int position, long id) {
		 Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
	 }
}


