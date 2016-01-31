package com.comoelagua.android.braille.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.comoelagua.android.braille.R;

public class CharactersAdapter extends BaseAdapter {

    private Context context;

    private int charactersLength = 256;
    private int charIndex = 0;

    public CharactersAdapter(Context c) {
        context = c;
    }

    @Override
    public int getCount() {
        return charactersLength;
    }

    @Override
    public Object getItem(int position) {
        return null;
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

        String asciiChar = Character.toString((char) position);

        TextView characterTextView = (TextView) rowView.findViewById(R.id.characterTextView);
        characterTextView.setText(position + " " + asciiChar);

        TextView brailleTextView = (TextView) rowView.findViewById(R.id.brailleTextView);
        brailleTextView.setText(asciiChar);

        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.brailleFont));
        brailleTextView.setTypeface(typeFace);

        return rowView;
    }
}
