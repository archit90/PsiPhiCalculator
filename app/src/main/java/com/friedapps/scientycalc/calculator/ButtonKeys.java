package com.friedapps.scientycalc.calculator;

import com.friedapps.scientycalc.R;

import java.util.HashMap;
import java.util.Map;

public class ButtonKeys {

    public static class KeyDetail {
        private int kLength;
        private String kSymbol;
        private KeyKind kKind;

        public KeyDetail(int kLength, String kSymbol, KeyKind kind) {
            this.kLength = kLength;
            this.kSymbol = kSymbol;
            this.kKind = kind;
        }

        public int getLength() {
            return kLength;
        }

        public String getSymbol() {
            return kSymbol;
        }

        public KeyKind getKind() {
            return kKind;
        }
    }

    public enum KeyKind {
        Numeric, Variable, InfixOperator, PrefixOperator, PostfixOperator, Bracket, Operation
    }

    public enum Key {
        k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, kDot,
        kAdd, kSubt, kMul, kDiv, kExp, kMod,
        kPlusMinus, kSin, kCos, kTan, kLog,
        kBrOpenClose, kAns
    }

    private static Map<Integer, Key> keyMap = new HashMap<Integer, Key>();
    private static Map<Key, KeyDetail> keyDetailMap = new HashMap<Key, KeyDetail>();

    public static Key getKey(int id) {
        return keyMap.get(id);
    }

    public static String getKeySymbol(int id) {
        return keyDetailMap.get(getKey(id)).getSymbol();
    }

    public static String getKeySymbol(Key k) {
        return keyDetailMap.get(k).getSymbol();
    }

    public static int getKeyLength(int id) {
        return keyDetailMap.get(getKey(id)).getLength();
    }

    public static int getKeyLength(Key k) {
        return keyDetailMap.get(k).getLength();
    }
    public static KeyKind getKeyKind(int id) {
        return keyDetailMap.get(getKey(id)).getKind();
    }

    public static KeyKind getKeyKind(Key k) {
        return keyDetailMap.get(k).getKind();
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
    }

    static {
        keyDetailMap.put(Key.k0, new KeyDetail(1, "0", KeyKind.Numeric));
        keyDetailMap.put(Key.k1, new KeyDetail(1, "1", KeyKind.Numeric));
        keyDetailMap.put(Key.k2, new KeyDetail(1, "2", KeyKind.Numeric));
        keyDetailMap.put(Key.k3, new KeyDetail(1, "3", KeyKind.Numeric));
        keyDetailMap.put(Key.k4, new KeyDetail(1, "4", KeyKind.Numeric));
        keyDetailMap.put(Key.k5, new KeyDetail(1, "5", KeyKind.Numeric));
        keyDetailMap.put(Key.k6, new KeyDetail(1, "6", KeyKind.Numeric));
        keyDetailMap.put(Key.k7, new KeyDetail(1, "7", KeyKind.Numeric));
        keyDetailMap.put(Key.k8, new KeyDetail(1, "8", KeyKind.Numeric));
        keyDetailMap.put(Key.k9, new KeyDetail(1, "9", KeyKind.Numeric));
        keyDetailMap.put(Key.kDot, new KeyDetail(1, ".", KeyKind.Numeric));
        keyDetailMap.put(Key.kPlusMinus, new KeyDetail(1, "-", KeyKind.PrefixOperator));

        keyDetailMap.put(Key.kAdd, new KeyDetail(1, "+", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kSubt, new KeyDetail(1, "-", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kMul, new KeyDetail(1, "*", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kDiv, new KeyDetail(1, "/", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kMod, new KeyDetail(1, "%", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kExp, new KeyDetail(1, "^", KeyKind.InfixOperator));

        keyDetailMap.put(Key.kBrOpenClose, new KeyDetail(1, "", KeyKind.Bracket));
        keyDetailMap.put(Key.kAns, new KeyDetail(1, "=", KeyKind.Operation));

        keyDetailMap.put(Key.kSin, new KeyDetail(3, "Sin", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kCos, new KeyDetail(3, "Cos", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kTan, new KeyDetail(3, "Tan", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kLog, new KeyDetail(3, "Log", KeyKind.PrefixOperator));

    }
}
