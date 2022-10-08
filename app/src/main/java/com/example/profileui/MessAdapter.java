package com.example.profileui;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class MessAdapter extends BaseAdapter {
    final ArrayList<Messenger> listMess;

    public MessAdapter(ArrayList<Messenger> listMess) {
        this.listMess = listMess;
    }

    @Override
    public int getCount() {
        return listMess.size();
    }

    @Override
    public Object getItem(int position) {
        return listMess.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listMess.get(position).ID;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewMess;
        if (view == null) {
            viewMess = View.inflate(viewGroup.getContext(), R.layout.activity_mess_item, null);
        } else viewMess = view;

        Messenger mess = (Messenger) getItem(position);
        ((RoundedImageView) viewMess.findViewById(R.id.avatar)).setBackgroundResource(Integer.parseInt(String.format("%d", mess.avatar)));
        ((TextView) viewMess.findViewById(R.id.name)).setText(String.format("%s", mess.name));
        ((TextView) viewMess.findViewById(R.id.content)).setText(String.format("%s ", mess.content));
        ((TextView) viewMess.findViewById(R.id.time)).setText(String.format("%s", mess.time));

        return viewMess;
    }
}
