package com.example.gridviewsample;

import java.util.List;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends ArrayAdapter<GridViewItem> {
	private Context context;
	private List<GridViewItem> list;
	private int resourceId;
	private LayoutInflater inflater;

	public GridViewAdapter(Context context, int resourceId, List<GridViewItem> list) {
		super(context, resourceId, list);
		this.context = context;
		this.list = list;
		this.resourceId = resourceId;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public void setList(List<GridViewItem> list) {
		this.list = list;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
            convertView = inflater.inflate(resourceId, null);
        }
		
		ImageView imageView = (ImageView) convertView.findViewById(R.id.imageview);
		imageView.setImageBitmap(BitmapFactory.decodeResource(
				context.getResources(), list.get(position).getItemId()));
		
		TextView textView = (TextView) convertView.findViewById(R.id.textview);
		textView.setText(list.get(position).getName());
				
		return convertView;
	}

}
