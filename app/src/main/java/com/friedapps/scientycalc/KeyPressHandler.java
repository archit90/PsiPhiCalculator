package com.friedapps.scientycalc;

import com.friedapps.scientycalc.calculator.ButtonKeys;
import com.friedapps.scientycalc.calculator.ButtonKeys.Key;
import com.friedapps.scientycalc.calculator.ButtonKeys.KeyKind;
import com.friedapps.scientycalc.calculator.TokenBracket.BracketType;
import com.friedapps.scientycalc.calculator.Tokenizer;

import java.util.ArrayList;
import java.util.Stack;

public class KeyPressHandler {


    private ArrayList<ButtonKeys.Key> keys;
    private int posCursor;
    private Stack<BracketType> bracketsStack;
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
        if (keys.size() == 0) {
            keys.add(k);
            ++posCursor;
            return;
        }
        KeyKind currKeyKind = ButtonKeys.getKeyKind(k);
        switch (currKeyKind) {
            case OpenBracket:
            case CloseBracket:
                addKeyBracket(k);
                break;
            case Numeric:
                addKeyNumeric(k);
                break;
            case Variable:
                addKeyVariable(k);
                break;
            case InfixOperator:
                addKeyInfixOp(k);
                break;
            case PostfixOperator:
                addKeyPostfixOp(k);
                break;
            case PrefixOperator:
                addKeyPrefixOp(k);
                break;
            case Operation:
                addKeyOperation(k);
                break;
        }

    }

    private void addKeyNumeric(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
    }

    private void addKeyVariable(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
    }

    private void addKeyInfixOp(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
    }

    private void addKeyPrefixOp(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
    }

    private void addKeyPostfixOp(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
    }

    private void addKeyBracket(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
    }

    private void addKeyOperation(Key k) {
        Key lastKey = keys.get(posCursor - 1);
        KeyKind lastKeyKind = ButtonKeys.getKeyKind(lastKey);
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
