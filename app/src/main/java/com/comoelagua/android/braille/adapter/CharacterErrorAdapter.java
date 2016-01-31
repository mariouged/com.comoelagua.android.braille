package com.comoelagua.android.braille.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.comoelagua.android.braille.R;

import java.util.List;

public class CharacterErrorAdapter extends BaseAdapter {

    private Context context;
    protected List<String> charactersErrorsList;

    public CharacterErrorAdapter(Context c, List charactersErrorsList) {
        context = c;
        this.charactersErrorsList = charactersErrorsList;
    }

    @Override
    public int getCount() {
        return charactersErrorsList.size();
    }

    @Override
    public Object getItem(int position) {
        return charactersErrorsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.alphabet_row, parent, false);

        TextView characterTextView = (TextView) rowView.findViewById(R.id.characterTextView);
        characterTextView.setText(charactersErrorsList.get(position));

        TextView brailleTextView = (TextView) rowView.findViewById(R.id.brailleTextView);
        brailleTextView.setText(charactersErrorsList.get(position));

        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.brailleFont));
        brailleTextView.setTypeface(typeFace);

        return rowView;
    }
}
