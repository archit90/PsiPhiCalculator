package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.R;

import java.util.HashMap;
import java.util.Map;

public class ButtonKeys {
    public enum Key {
        k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, kDot,
        kAdd, kSubt, kMul, kDiv, kExp, kMod,
        kPlusMinus, kSin, kCos, kTan, kLog,
        kBrOpenClose, kAns
    }

    private static Map<Integer, Key> keyMap = new HashMap<Integer, Key>();
    private static Map<Key, String> keySymbol = new HashMap<Key, String>();

    public static Key getKey(int id) {
        return keyMap.get(id);
    }

    public static String getKeySymbol(int id) {
        return keySymbol.get(getKey(id));
    }

    public static String getKeySymbol(Key k) {
        return keySymbol.get(k);
    }

    static {
        keyMap.put(R.id.btn0, Key.k0);
        keyMap.put(R.id.btn1, Key.k1);
        keyMap.put(R.id.btn2, Key.k2);
        keyMap.put(R.id.btn3, Key.k3);
        keyMap.put(R.id.btn4, Key.k4);
        keyMap.put(R.id.btn5, Key.k5);
        keyMap.put(R.id.btn6, Key.k6);
        keyMap.put(R.id.btn7, Key.k7);
        keyMap.put(R.id.btn8, Key.k8);
        keyMap.put(R.id.btn9, Key.k9);
        keyMap.put(R.id.btnDot, Key.kDot);
        keyMap.put(R.id.btnPlusMinus, Key.kPlusMinus);

        keyMap.put(R.id.btnAdd, Key.kAdd);
        keyMap.put(R.id.btnSubtract, Key.kSubt);
        keyMap.put(R.id.btnMultiply, Key.kMul);
        keyMap.put(R.id.btnDivide, Key.kDiv);
        keyMap.put(R.id.btnModulus, Key.kMod);
        keyMap.put(R.id.btnExponent, Key.kExp);

        keyMap.put(R.id.btnBrackets, Key.kBrOpenClose);
        keyMap.put(R.id.btnAnswer, Key.kAns);

        keyMap.put(R.id.btnSin, Key.kSin);
        keyMap.put(R.id.btnCos, Key.kCos);
        keyMap.put(R.id.btnTan, Key.kTan);
        keyMap.put(R.id.btnLog, Key.kLog);
        // TODO: sin cos tan log
    }

    static {
        keySymbol.put(Key.k0, "0");
        keySymbol.put(Key.k1, "1");
        keySymbol.put(Key.k2, "2");
        keySymbol.put(Key.k3, "3");
        keySymbol.put(Key.k4, "4");
        keySymbol.put(Key.k5, "5");
        keySymbol.put(Key.k6, "6");
        keySymbol.put(Key.k7, "7");
        keySymbol.put(Key.k8, "8");
        keySymbol.put(Key.k9, "9");
        keySymbol.put(Key.kDot, ".");
        keySymbol.put(Key.kPlusMinus, "-");

        keySymbol.put(Key.kAdd, "+");
        keySymbol.put(Key.kSubt, "-");
        keySymbol.put(Key.kMul, "*");
        keySymbol.put(Key.kDiv, "/");
        keySymbol.put(Key.kMod, "%");
        keySymbol.put(Key.kExp, "^");

        keySymbol.put(Key.kBrOpenClose, "");
        keySymbol.put(Key.kAns, "=");

    }
}
