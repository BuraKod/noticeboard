package com.burakod.noticeboard;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by BuraKod on 14.12.2017.
 */

public class CustomListAdapater extends BaseAdapter {

    private ArrayList<String> author;
    private ArrayList<String> subject;
    private ArrayList<String> message;
    private AppCompatActivity activity;

    private int x=0;


    public CustomListAdapater(ArrayList<String> author,ArrayList<String> subject,ArrayList<String> message,AppCompatActivity activity){
        this.author=author;
        this.subject=subject;
        this.message = message;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return author.size();
    }

    @Override
    public Object getItem(int i) {
        return author.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =  LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.notice_list,viewGroup,false);
        ((TextView)view.findViewById(R.id.noticeName)).setText(String.valueOf(author.get(i)));
        ((TextView)view.findViewById(R.id.noticeSubject)).setText(subject.get(i));
        ((TextView)view.findViewById(R.id.noticeMessage)).setText(message.get(i));
        return view;
    }}