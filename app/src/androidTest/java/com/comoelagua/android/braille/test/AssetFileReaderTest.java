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
package com.comoelagua.android.braille.test;

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
    private AssetManager assetManager;

    @Before
    public void setUp() {
        context = getInstrumentation().getTargetContext();
        assetManager = context.getAssets();
    }

    @Test
    public void testAssetsList() {
        boolean assetsDataExists = false;
        boolean assetsFontExists = false;
        try {
            String[] list = assetManager.list("");
            for (int i = 0; i < list.length; i++) {
                Log.d("list assets/ ", list[i]);
                if ("data".equals( list[i] )) {
                    assetsDataExists = true;
                } else if("fonts".equals( list[i] )) {
                    assetsFontExists = true;
                }
            }
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
        org.junit.Assert.assertTrue("assets/data exists", assetsDataExists);
        org.junit.Assert.assertTrue("assets/fonts exists", assetsFontExists);
    }

    @Test
    public void testReadFile() {
        BufferedReader reader;
        String wordTxt = null;
        try {
            InputStream is = assetManager.open("data/words.txt");
            reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                wordTxt = line;
            }
            reader.close();
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
        }
        org.junit.Assert.assertNotNull(wordTxt);
    }
}
