package com.friedapps.scificalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ButtonKeys {

    public static class KeyDetail {
        private int kLength;
        private String kSymbol;
        private KeyKind kKind;
        private String kButtonSymbol;

        public KeyDetail(int kLength, String kSymbol, String BSymbol, KeyKind kind) {
            this.kLength = kLength;
            this.kSymbol = kSymbol;
            this.kButtonSymbol = BSymbol;
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

        public String getButtonSymbol() {
            return kButtonSymbol;
        }
    }

    public enum KeyKind {
        Numeric, Variable, InfixOperator, PrefixOperator, PostfixOperator,
        OpenBracket, CloseBracket, Operation, MoveOperation;
    }

    public enum Key {
        k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, kDot, kPlusMinus,
        kAdd, kSubt, kMul, kDiv, kExp, kMod, kRoot, kBrOpen, kBrClose,
        kSin, kCos, kTan, kLog10, kLn, kLog2, kTHyp, kAbs, kFact,
        kConsts, kVarAJ,
        kAlt, kAns, kDel, kReset,
        kMoveLeft, kMoveRight, kHistUp, kHistDown;

        public String toString() {
            return getKeySymbol(this);
        }

        public int getLength() {
            return getKeyLength(this);
        }
    }

    private static Map<Integer, Key> keyMap = new HashMap<Integer, Key>();
    private static Map<Key, KeyDetail> keyDetailMap = new HashMap<Key, KeyDetail>();


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
        keyMap.put(R.id.btnNRoot, Key.kRoot);

        keyMap.put(R.id.btnBrackets, Key.kBrOpen);
        keyMap.put(R.id.btnAnswer, Key.kAns);
        keyMap.put(R.id.btnDel, Key.kDel);

        keyMap.put(R.id.btnHyp, Key.kTHyp);
        keyMap.put(R.id.btnSin, Key.kSin);
        keyMap.put(R.id.btnCos, Key.kCos);
        keyMap.put(R.id.btnTan, Key.kTan);
        keyMap.put(R.id.btnAbs, Key.kAbs);
        keyMap.put(R.id.btnLog10, Key.kLog10);
        keyMap.put(R.id.btnLog2, Key.kLog2);
        keyMap.put(R.id.btnLn, Key.kLn);
        keyMap.put(R.id.btnFact,Key.kFact);

        keyMap.put(R.id.btnMvLeft, Key.kMoveLeft);
        keyMap.put(R.id.btnMvRight, Key.kMoveRight);
        // up, down buttons
    }

    static {
        keyDetailMap.put(Key.k0, new KeyDetail(1, "0", "0", KeyKind.Numeric));
        keyDetailMap.put(Key.k1, new KeyDetail(1, "1", "1", KeyKind.Numeric));
        keyDetailMap.put(Key.k2, new KeyDetail(1, "2", "2", KeyKind.Numeric));
        keyDetailMap.put(Key.k3, new KeyDetail(1, "3", "3", KeyKind.Numeric));
        keyDetailMap.put(Key.k4, new KeyDetail(1, "4", "4", KeyKind.Numeric));
        keyDetailMap.put(Key.k5, new KeyDetail(1, "5", "5", KeyKind.Numeric));
        keyDetailMap.put(Key.k6, new KeyDetail(1, "6", "6", KeyKind.Numeric));
        keyDetailMap.put(Key.k7, new KeyDetail(1, "7", "7", KeyKind.Numeric));
        keyDetailMap.put(Key.k8, new KeyDetail(1, "8", "8", KeyKind.Numeric));
        keyDetailMap.put(Key.k9, new KeyDetail(1, "9", "9", KeyKind.Numeric));
        keyDetailMap.put(Key.kDot, new KeyDetail(1, ".", ".", KeyKind.Numeric));
        keyDetailMap.put(Key.kPlusMinus, new KeyDetail(1, "-", "+/-", KeyKind.PrefixOperator));

        keyDetailMap.put(Key.kAdd, new KeyDetail(1, "+", "+", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kSubt, new KeyDetail(1, "-", "-", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kMul, new KeyDetail(1, "&#215", "&#215;", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kDiv, new KeyDetail(1, "/", "&#247;", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kMod, new KeyDetail(1, "%", "%", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kExp, new KeyDetail(1, "^", "x<sup>y</sup>", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kRoot, new KeyDetail(1, "&#8730;", "<sup>x</sup>&#8730", KeyKind.InfixOperator));
        keyDetailMap.put(Key.kBrOpen, new KeyDetail(1, "(", "( )", KeyKind.OpenBracket));
        keyDetailMap.put(Key.kBrClose, new KeyDetail(1, ")", "( )", KeyKind.CloseBracket));

        keyDetailMap.put(Key.kSin, new KeyDetail(3, "Sin", "Sin", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kCos, new KeyDetail(3, "Cos", "Cos", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kTan, new KeyDetail(3, "Tan", "Tan", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kTHyp, new KeyDetail(3, "", "Hyp", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kAbs, new KeyDetail(3, "Abs", "|x|", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kFact, new KeyDetail(3, "!", "x!", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kLog10, new KeyDetail(4, "Log<sub>10</sub>", "Log<sub>10</sub>", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kLn, new KeyDetail(2, "Ln", "Ln", KeyKind.PrefixOperator));
        keyDetailMap.put(Key.kLog2, new KeyDetail(4, "Log<sub>2</sub>", "Log<sub>2</sub>", KeyKind.PrefixOperator));

        keyDetailMap.put(Key.kDel, new KeyDetail(0, "", "&lt;-", KeyKind.Operation));
        keyDetailMap.put(Key.kAlt, new KeyDetail(0, "", "Alt", KeyKind.Operation));
        keyDetailMap.put(Key.kReset, new KeyDetail(0, "", "Reset", KeyKind.Operation));
        keyDetailMap.put(Key.kAns, new KeyDetail(0, "", "Ans", KeyKind.Operation));

        keyDetailMap.put(Key.kMoveLeft, new KeyDetail(0, "", "&lt;", KeyKind.MoveOperation));
        keyDetailMap.put(Key.kMoveRight, new KeyDetail(0, "", "&gt;", KeyKind.MoveOperation));
        keyDetailMap.put(Key.kHistUp, new KeyDetail(0, "", "Up", KeyKind.MoveOperation));
        keyDetailMap.put(Key.kHistDown, new KeyDetail(0, "", "Dn", KeyKind.MoveOperation));


    }

    public static Key getKey(int id) {
        return keyMap.get(id);
    }

    public static String getKeySymbol(Key k) {
        return keyDetailMap.get(k).getSymbol();
    }

    public static int getKeyLength(Key k) {
        return keyDetailMap.get(k).getLength();
    }

    public static KeyKind getKeyKind(Key k) {
        return keyDetailMap.get(k).getKind();
    }

    public static String getKeyButtonSymbol(Key k) {
        return keyDetailMap.get(k).getButtonSymbol();
    }

    private static ArrayList<String> keysToStrings(ArrayList<Key> klist) {
        ArrayList<String> strs = new ArrayList<String>(klist.size());
        for (Key k : klist) {
            strs.add(k.toString());
        }
        return strs;
    }

    public static String keysToStringExpression(ArrayList<Key> klist, int cursor) {
        ArrayList<String> strs = keysToStrings(klist);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); ++i) {
            if (cursor == i)
                sb.append("|");
            sb.append(strs.get(i));
        }
        if (cursor == strs.size()) {
            sb.append("|");
        }
        return sb.toString();

    }
}
