package com.friedapps.scientycalc;

import java.util.HashMap;
import java.util.Map;

public class ButtonKeys {
    public enum Keys{
        k0,k1,k2,k3,k4,k5,k6,k7,k8,k9,kDot,
        kAdd,kSubt,kMul,kDiv,kExp,kMod,
        kPlus,kMinus,kSin,kCos,kTan,kLog,
        kMC,kMR,kMemPlus,kMemMinus,
        kAns
    }
    public static Map<Integer,Keys> keymap=new HashMap<Integer, Keys>();

    static {
        keymap.put(R.id.btn0,Keys.k0);
        keymap.put(R.id.btn1,Keys.k1);
        keymap.put(R.id.btn2,Keys.k2);
        keymap.put(R.id.btn3,Keys.k3);
        keymap.put(R.id.btn4,Keys.k4);
        keymap.put(R.id.btn5,Keys.k5);
        keymap.put(R.id.btn6,Keys.k6);
        keymap.put(R.id.btn7,Keys.k7);
        keymap.put(R.id.btn8,Keys.k8);
        keymap.put(R.id.btn9,Keys.k9);
        keymap.put(R.id.btnDot,Keys.kDot);
        keymap.put(R.id.btnPlus,Keys.kAdd);
        keymap.put(R.id.btnMinus,Keys.kSubt);
        keymap.put(R.id.btnMultiply,Keys.kMul);
        keymap.put(R.id.btnDivide,Keys.kDiv);
        keymap.put(R.id.btnMC,Keys.kMC);
        keymap.put(R.id.btnMPlus,Keys.kMemPlus);
        keymap.put(R.id.btnAnswer,Keys.kAns);



    }
}
