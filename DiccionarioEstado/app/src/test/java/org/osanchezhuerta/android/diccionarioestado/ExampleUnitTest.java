package org.osanchezhuerta.android.diccionarioestado;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        Log.e("resultado test:","123456");
        Log.d("resultado test:","123456");
        Log.w("resultado test:","123456");
        System.out.println("resultado test:");

        assertEquals(4, 2 + 2);
    }
}