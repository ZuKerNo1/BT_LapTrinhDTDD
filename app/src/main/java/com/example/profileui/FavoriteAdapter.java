package com.example.profileui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

public class FavoriteAdapter extends BaseAdapter {
    final ArrayList<Favorite> listFavo;

    public FavoriteAdapter(ArrayList<Favorite> listFavo) {
        this.listFavo = listFavo;
    }

    @Override
    public int getCount() {
        return listFavo.size();
    }

    @Override
    public Object getItem(int position) {
        return listFavo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listFavo.get(position).ID;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View viewFavo;
        if (view == null) {
            viewFavo = View.inflate(viewGroup.getContext(), R.layout.activity_favorite_item, null);
        } else viewFavo = view;

        Favorite favo = (Favorite) getItem(position);
        ((TextView) viewFavo.findViewById(R.id.num)).setText(String.format("%s", favo.ID));
        ((TextView) viewFavo.findViewById(R.id.name)).setText(String.format("%s", favo.nameSong));
        ((TextView) viewFavo.findViewById(R.id.singer)).setText(String.format("%s ", favo.singer));

        return viewFavo;
    }
}
