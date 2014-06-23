package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.R;

import java.util.HashMap;
import java.util.Map;

public class ButtonKeys {
    public enum Keys {
        k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, kDot,
        kAdd, kSubt, kMul, kDiv, kExp, kMod,
        kPlus, kMinus, kSin, kCos, kTan, kLog,
        kMC, kMR, kMemPlus, kMemMinus,
        kBrOpen, kBrClose,
        kAns
    }

    private static Map<Integer, Keys> keyMap = new HashMap<Integer, Keys>();
    private static Map<Keys, String> keySymbol = new HashMap<Keys, String>();

    public static Keys getKey(int id) {
        return keyMap.get(id);
    }

    public static String getKeySymbol(int id) {
        return keySymbol.get(getKey(id));
    }

    public static String getKeySymbol(Keys k) {
        return keySymbol.get(k);
    }

    static {
        keyMap.put(R.id.btn0, Keys.k0);
        keyMap.put(R.id.btn1, Keys.k1);
        keyMap.put(R.id.btn2, Keys.k2);
        keyMap.put(R.id.btn3, Keys.k3);
        keyMap.put(R.id.btn4, Keys.k4);
        keyMap.put(R.id.btn5, Keys.k5);
        keyMap.put(R.id.btn6, Keys.k6);
        keyMap.put(R.id.btn7, Keys.k7);
        keyMap.put(R.id.btn8, Keys.k8);
        keyMap.put(R.id.btn9, Keys.k9);
        keyMap.put(R.id.btnDot, Keys.kDot);
        keyMap.put(R.id.btnPlus, Keys.kAdd);
        keyMap.put(R.id.btnMinus, Keys.kSubt);
        keyMap.put(R.id.btnMultiply, Keys.kMul);
        keyMap.put(R.id.btnDivide, Keys.kDiv);
        keyMap.put(R.id.btnMC, Keys.kMC);
        keyMap.put(R.id.btnMPlus, Keys.kMemPlus);
        keyMap.put(R.id.btnAnswer, Keys.kAns);
    }

    static {
        keySymbol.put(Keys.k0, "0");
        keySymbol.put(Keys.k1, "1");
        keySymbol.put(Keys.k2, "2");
        keySymbol.put(Keys.k3, "3");
        keySymbol.put(Keys.k4, "4");
        keySymbol.put(Keys.k5, "5");
        keySymbol.put(Keys.k6, "6");
        keySymbol.put(Keys.k7, "7");
        keySymbol.put(Keys.k8, "8");
        keySymbol.put(Keys.k9, "9");
        keySymbol.put(Keys.kDot, ".");
        keySymbol.put(Keys.kAdd, "+");
        keySymbol.put(Keys.kSubt, "-");
        keySymbol.put(Keys.kMul, "*");
        keySymbol.put(Keys.kDiv, "/");
        keySymbol.put(Keys.kMC, "");
        keySymbol.put(Keys.kMemPlus, "");
        keySymbol.put(Keys.kAns, "");
        keySymbol.put(Keys.kBrClose, ")");
        keySymbol.put(Keys.kBrOpen, "(");
    }
}
