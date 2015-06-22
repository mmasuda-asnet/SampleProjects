package com.example.gridviewsample;

import java.util.ArrayList;
import java.util.List;

import android.R.drawable;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends Activity implements OnClickListener {
	private GridViewAdapter adapter;
	private List<GridViewItem> itemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		itemList = new ArrayList<GridViewItem>();
		for(int i = 0; i < 5; i++) {
			addIcon("aaa");
		}
		
		adapter = new GridViewAdapter(this, R.layout.item, itemList);
		GridView gridView = (GridView) findViewById(R.id.grid);
		gridView.setAdapter(adapter);
		
		Button plusBtn = (Button) findViewById(R.id.plus_btn);
		plusBtn.setOnClickListener(this);
		
		Button removeBtn = (Button) findViewById(R.id.remove_btn);
		removeBtn.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.plus_btn:
			addIcon("bbb");
			adapter.setList(itemList);
			adapter.notifyDataSetChanged();
			break;
		
		case R.id.remove_btn:
			removeAllItem();
			adapter.setList(itemList);
			adapter.notifyDataSetChanged();
		default:
			break;
		}
		
	}
	
	private void addIcon(String name) {
		GridViewItem item = new GridViewItem();
		item.setItemId(R.drawable.icon);
		item.setName(name);
		itemList.add(item);
	}
	
	private void removeAllItem() {
		itemList.removeAll(itemList);
	}

}
