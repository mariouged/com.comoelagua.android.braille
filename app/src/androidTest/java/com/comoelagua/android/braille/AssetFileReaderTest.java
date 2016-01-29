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

import android.content.Context;
import android.test.InstrumentationTestCase;
import android.content.res.AssetManager;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AssetFileReaderTest extends InstrumentationTestCase {

    private Context context;

    @Before
    public void setUp() {
        context = getInstrumentation().getTargetContext();
    }

    @Test
    public void testReadFile() {
        AssetManager assetManager = context.getAssets();

        try {
            String[] list = assetManager.list("");
            String[] listRoot = assetManager.list("/");
            String[] listAssets = assetManager.list("assets");

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader reader;
        try {
            InputStream is = assetManager.open("data/words.txt");
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                Log.d("line ", line);
            }
            reader.close();
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
    }
}
