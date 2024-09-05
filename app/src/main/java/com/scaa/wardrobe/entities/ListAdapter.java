package com.scaa.wardrobe.entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.scaa.wardrobe.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Cloth> {

    public ListAdapter(Context context, ArrayList<Cloth> cloths) {
        super(context, R.layout.list_item, cloths);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Cloth cloth = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.cloth_pic);
        TextView clothingName = convertView.findViewById(R.id.clothingName);
        TextView clothingType = convertView.findViewById(R.id.clothingType);
        TextView clothingColor= convertView.findViewById(R.id.clothingColor);

        imageView.setImageResource(cloth.imageId);
        clothingName.setText(cloth.name);
        clothingType.setText(cloth.type);
        clothingColor.setText(cloth.color);

        return convertView;
    }
}
