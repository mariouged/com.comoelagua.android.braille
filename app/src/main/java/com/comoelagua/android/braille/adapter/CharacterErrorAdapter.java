package com.comoelagua.android.braille.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.comoelagua.android.braille.BrailleApplication;
import com.comoelagua.android.braille.R;
import com.comoelagua.android.braille.model.daos.containers.DaosContainer;
import com.comoelagua.android.braille.model.daos.interfaces.WordsDaoInterface;

import java.util.Hashtable;
import java.util.List;

public class CharacterErrorAdapter extends BaseAdapter {

    private Context context;
    protected List<String> charactersErrorsList;
    protected Hashtable<String, String> hashConverter;

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
        String charError = charactersErrorsList.get(position);
        if (isInteger(charError)) {
            charError = numberToBraille(charError);
        }
        brailleTextView.setText(charError);

        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), context.getString(R.string.brailleFont));
        brailleTextView.setTypeface(typeFace);

        return rowView;
    }

    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

    protected String numberToBraille(String s) {
        if (hashConverter == null || hashConverter.size() == 0) {
            WordsDaoInterface numbersDao = ((BrailleApplication) context.getApplicationContext()).getWordsDao(DaosContainer.NUMBERS_DAO_TYPE);
            hashConverter = numbersDao.getHashConverter();
        }
        String numberBraille = hashConverter.get(s);
        return numberBraille;
    }

}
