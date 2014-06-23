package com.friedapps.scientycalc;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeyPressHandler {
    private static final String[] numkey = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
    private static final String[] binaryOps = {"+", "-", "*", "/"};
    private static final String[] calcOps = {"Ans", "Del", "M+", "MC"};


    private static KeyPressHandler instance;
    private ArrayList<String> tokens;

    private KeyPressHandler() {
        tokens = new ArrayList<String>();
    }

    public static KeyPressHandler newInstance() {
        if (instance == null)
            instance = new KeyPressHandler();
        return instance;
    }

    private static final Map<Integer, View.OnClickListener> keysEvent = new HashMap<Integer, View.OnClickListener>();

    static {
        keysEvent.put(R.id.btn0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private static int findInStringArray(String[] ary, String item) {
        int arylen = ary.length, index = -1;
        for (int i = 0; i < arylen; ++i) {
            if (item.equals(ary[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void handleKeypress(String keyText) {
        int idx;
        if ((idx = findInStringArray(numkey, keyText)) > 0) {
            tokens.add(keyText);
        } else if ((idx = findInStringArray(binaryOps, keyText)) > 0) {
            tokens.add(keyText);
        } else if ((idx = findInStringArray(calcOps, keyText)) > 0) {
            // TODO: improve this brittle code
            switch (idx) {
                case 0:
                    // TODO: call function to calculate result
                    break;
                case 1:
                    // TODO: call function to backwards delete
                    break;
                case 2:
                    // TODO: call function to add to memory
                    break;
                case 3:
                    // TODO: call function to clear memory
                    break;
                default:
                    break;
            }

        } else {
            Log.d("Calc", "Unknown Token found " + keyText);
        }
    }

}
