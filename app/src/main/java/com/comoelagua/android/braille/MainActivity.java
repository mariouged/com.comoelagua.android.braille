/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact: <mario.ugedo@gmail.com>
 */
package com.comoelagua.android.braille;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String WORD_TYPE = "com.comoelagua.android.braille.WORD_TYPE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showAlphabet = (Button) findViewById(R.id.showAlphabet);
        showAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlphabetActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionHelp) {
            startActivity(new Intent(this, HelpActivity.class));
            return true;
        } else if (item.getItemId() == R.id.actionAlphabet) {
            startActivity(new Intent(this, AlphabetActivity.class));
            return true;
        } else if (item.getItemId() == R.id.actionSettings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }/* else if (item.getItemId() == R.id.testFont) {
            startActivity(new Intent(this, CharactersActivity.class));
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public void openCharactersExercises(View view) {
        startActivity(new Intent(this, CharactersExercisesActivity.class));
    }

    public  void openWordExercises(View view) {
        startActivity(new Intent(this, WordExercisesActivity.class));
    }

    public void openNumbersExercises(View view) {
        startActivity(new Intent(this, NumbersExercisesActivity.class));
    }

    public void openPhraseExercises(View view) {
        startActivity(new Intent(this, PhraseExercisesActivity.class));
    }

    public boolean checkSdk() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.sdk_dialog_message)
                    .setTitle(R.string.sdk_dialog_title);
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
        return true;
    }
}
