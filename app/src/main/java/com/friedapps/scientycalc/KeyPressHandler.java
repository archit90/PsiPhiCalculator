package com.friedapps.scientycalc;

import com.friedapps.scientycalc.calculator.ButtonKeys;
import com.friedapps.scientycalc.calculator.Tokenizer;
import com.friedapps.scientycalc.calculator.ButtonKeys.Key;
import com.friedapps.scientycalc.calculator.ButtonKeys.KeyKind;
import java.util.ArrayList;

public class KeyPressHandler {


    private ArrayList<ButtonKeys.Key> keys;
    private int posCursor;
    public Tokenizer tokens;

    public KeyPressHandler() {
        keys = new ArrayList<Key>();
        posCursor = 0;
    }

    public void addKey(Key k) {
        /* TODO
            Handle press of this key k
            If key = kAns evaluate to answer
            handle brackets
            distinguish between unary/binary operators
         */
        if(keys.size()==0){
            keys.add(k);
            ++posCursor;
            return;
        }
        Key lastKey = keys.get(posCursor-1);
        KeyKind lastKeyKind=ButtonKeys.getKeyKind(lastKey);
        KeyKind currKeyKind=ButtonKeys.getKeyKind(k);
        

    }

    public void moveCursor(int pos) {
        posCursor = pos;
    }
    /*

    public void handleKeypress(String keyText) {
        int idx;
        if ((idx = findInStringArray(numkey, keyText)) > 0) {
            keys.add(keyText);
        } else if ((idx = findInStringArray(binaryOps, keyText)) > 0) {
            keys.add(keyText);
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
    */
}
