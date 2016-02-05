package com.comoelagua.android.braille.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.comoelagua.android.braille.R;

public class AlphabetAdapter extends BaseAdapter {

    private Context context;
    private String[] characters;
    private String[] brailleCharacters;

    public AlphabetAdapter(Context c) {
        context = c;
        Resources res = context.getResources();
        characters = res.getStringArray(R.array.characters);
        brailleCharacters = res.getStringArray(R.array.charactersBraille);
    }

    @Override
    public int getCount() {
        return characters.length;
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

        TextView characterTextView = (TextView) rowView.findViewById(R.id.characterTextView);
        characterTextView.setText( characters[position]);

        TextView brailleTextView = (TextView) rowView.findViewById(R.id.brailleTextView);
        brailleTextView.setText( brailleCharacters[position]);

        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.brailleFont));
        brailleTextView.setTypeface(typeFace);

        return rowView;
    }

    /*private final String[] characters = {
            "a", "á", "b", "c", "d", "e", "é", "f", "g", "h", "i", "í", "j",
            "k", "l", "m", "n", "ñ", "o", "ó", "p", "q", "r", "s", "t", "v",
            "u", "ú", "ü", "w", "x", "y", "z",
            "may.", "núm.",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ";", ":", ".", "-", "(", ")", "\"", "\"", "¿", "?", "¡", "!"
    };*/

    /*private final String[] brailleCharacters = {
            "a", "á", "b", "c", "d", "e", "é", "f", "g", "h", "i", "í", "j",
            "k", "l", "m", "n", "ñ", "o", "ó", "p", "q", "r", "s", "t", "v",
            "u", "ú", "ü", "w", "x", "y", "z",
            "´", "#",
            "#a", "#b", "#c", "#d", "#e", "#f", "#g", "#h", "#i", "#j",
            ",", ";", ":", ".", "-", "(", ")", "\"", "\"", "¿", "?", "¡", "!"
    };*/
}
