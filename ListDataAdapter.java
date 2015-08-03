package com.example.user.funstion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/2/2015.
 */
public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView USERNAME, PASSWORD, EMAIL;
    }

    @Override
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){ //if there is now row
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            //gets components from row
            layoutHandler.USERNAME = (TextView)row.findViewById(R.id.text_username);
            layoutHandler.PASSWORD = (TextView)row.findViewById(R.id.text_password);
            layoutHandler.EMAIL = (TextView)row.findViewById(R.id.text_email);
            //adds row into layout
            row.setTag(layoutHandler);
        }

        else { //if row exists
            layoutHandler = (LayoutHandler)row.getTag();
        }
        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.EMAIL.setText(dataProvider.getUsername());
        layoutHandler.PASSWORD.setText(dataProvider.getPassword());
        layoutHandler.EMAIL.setText(dataProvider.getEmail());


        return row;
    }
}
