package com.friedapps.scientycalc;

import android.util.Log;

import com.friedapps.scientycalc.ButtonKeys.Key;
import com.friedapps.scientycalc.ButtonKeys.KeyKind;
import com.friedapps.scientycalc.calculator.Expression;
import com.friedapps.scientycalc.calculator.ExpressionEvaluator;
import com.friedapps.scientycalc.calculator.ExpressionItem;
import com.friedapps.scientycalc.calculator.Tokenizer;

import java.util.ArrayList;
import java.util.Stack;

public class KeyPressHandler {


    public ArrayList<ButtonKeys.Key> keys;
    private int posCursor;
    private Tokenizer tokens;
    private EditTextExtended exprEdtxt;
    private EditTextExtended resEdtxt;
    private static KeyPressHandler instance;

    private KeyPressHandler(EditTextExtended expr, EditTextExtended res) {
        keys = new ArrayList<Key>();
        posCursor = 0;
        exprEdtxt = expr;
        resEdtxt = res;
    }

    public static KeyPressHandler newInstance(EditTextExtended etxtexpr, EditTextExtended etxtres) {
        if (instance == null) {
            instance = new KeyPressHandler(etxtexpr, etxtres);
        }
        return instance;
    }

    public void reset() {
        keys = new ArrayList<Key>();
        posCursor = 0;
        exprEdtxt.setText("");
        resEdtxt.setText("");
    }

    public void addKey(Key k) {
        int txtCursorPos = exprEdtxt.getCursorPosition(), ctrPos = 0;
        posCursor = txtCursorPos;
        for (int i = 0; i < keys.size(); i++) {
            int ksize = keys.get(i).getLength();
            if (ctrPos <= txtCursorPos) {
                ctrPos += ksize;
                posCursor -= ksize - 1;
            } else {
                break;
            }
        }
        KeyKind currKeyKind = ButtonKeys.getKeyKind(k);

        if (keys.size() == 0) {
            // TODO remove this ugly code
            switch (currKeyKind) {
                case Numeric:
                case Variable:
                case PrefixOperator:
                case OpenBracket:
                    keys.add(k);
                    ++posCursor;
                    break;
            }
            exprEdtxt.setText(ButtonKeys.keysToString(keys, posCursor));
            return;
        }

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
            case MoveOperation:
                addKeyMoveOperation(k);
                break;

        }
        // TODO: improve this method of displaying expression in exprEdtxt
        exprEdtxt.setText(ButtonKeys.keysToString(keys, posCursor));
    }

    private void addKeyNumeric(Key k) {
        if (posCursor == 0) {
            Key nextKey = keys.get(0);
            KeyKind nextKeyKind = ButtonKeys.getKeyKind(nextKey);
            switch (nextKeyKind) {
                case Numeric:
                case Variable:
                case InfixOperator:
                case PrefixOperator:
                case OpenBracket:
                    keys.add(posCursor++, k);
                    break;
                default:
                    // TODO: error, invalid key
            }
            return;
        }
        Key prevKey = keys.get(posCursor - 1);
        KeyKind prevKeyKind = ButtonKeys.getKeyKind(prevKey);
        switch (prevKeyKind) {
            case OpenBracket:
            case PrefixOperator:
            case InfixOperator:
            case Numeric:
                keys.add(posCursor++, k);
                break;
            case CloseBracket:
                keys.add(posCursor++, Key.kMul);
                keys.add(posCursor++, k);
                break;
            case PostfixOperator:
            case Variable:
                // TODO: error,
                break;
            default:
                // Should never reach here

        }
    }

    private void addKeyVariable(Key k) {
        if (posCursor == 0) {
            Key nextKey = keys.get(0);
            KeyKind nextKeyKind = ButtonKeys.getKeyKind(nextKey);
            switch (nextKeyKind) {
                case Numeric:
                case Variable:
                case InfixOperator:
                case PrefixOperator:
                case OpenBracket:
                    keys.add(posCursor++, k);
                    break;
                default:
                    // TODO: error, invalid key
            }
            return;
        }
        Key prevKey = keys.get(posCursor - 1);
        KeyKind prevKeyKind = ButtonKeys.getKeyKind(prevKey);
        switch (prevKeyKind) {
            case OpenBracket:
            case PrefixOperator:
            case InfixOperator:
                keys.add(posCursor++, k);
                break;
            case Numeric:
            case Variable:
            case CloseBracket:
                keys.add(posCursor++, Key.kMul);
                keys.add(posCursor++, k);
                break;
            case PostfixOperator:

                // TODO: error,
                break;
            default:
                // Should never reach here

        }
    }

    private void addKeyInfixOp(Key k) {
        if (posCursor == 0) {
            // TODO: Toast Cannot add operator
            return;
        }
        Key prevKey = keys.get(posCursor - 1);
        KeyKind prevKeyKind = ButtonKeys.getKeyKind(prevKey);
        switch (prevKeyKind) {
            case Numeric:
            case Variable:
            case CloseBracket:
                keys.add(posCursor++, k);
                break;
            case PrefixOperator:
            case InfixOperator:
            case PostfixOperator:
            case OpenBracket:
                // TODO: Toast Cannot add Operator here
                break;
            default:
                // Should never reach here

        }
    }

    private void addKeyPrefixOp(Key k) {
        boolean addOpenBracket;
        switch (k) {
            case kSin:
            case kCos:
            case kTan:
            case kLog:
                addOpenBracket = true;
                break;
            default:
                addOpenBracket = false;
                break;
        }
        if (posCursor == 0) {
            Key nextKey = keys.get(posCursor);
            KeyKind nextKeyKind = ButtonKeys.getKeyKind(nextKey);
            switch (nextKeyKind) {
                case Numeric:
                case Variable:
                case OpenBracket:
                    keys.add(posCursor++, k);
                    break;
                case PrefixOperator:
                    if (nextKey == Key.kPlusMinus && k == Key.kPlusMinus) {
                        keys.remove(posCursor--);
                    } else {
                        keys.add(posCursor++, k);
                    }
                    break;
                default:
                    // TODO: error, invalid key
            }
            return;
        }
        Key prevKey = keys.get(posCursor - 1);
        KeyKind prevKeyKind = ButtonKeys.getKeyKind(prevKey);
        switch (prevKeyKind) {
            case PrefixOperator:
                // k is current key to be inputted
                if (k == Key.kPlusMinus) {
                    if (posCursor < keys.size()) {
                        Key nextKey = keys.get(posCursor);
                        if (nextKey == Key.kPlusMinus) {
                            keys.remove(posCursor);
                        }
                    }
                    if (prevKey == Key.kPlusMinus) {
                        keys.remove(--posCursor);
                    } else {
                        keys.add(posCursor++, Key.kBrOpen);
                        keys.add(posCursor++, k);
                    }
                } else {
                    keys.add(posCursor++, k);
                    if (addOpenBracket)
                        keys.add(posCursor++, Key.kBrOpen);
                }
                break;
            case OpenBracket:
            case InfixOperator:
                keys.add(posCursor++, k);
                if (addOpenBracket)
                    keys.add(posCursor++, Key.kBrOpen);
                break;
            case Numeric:
            case Variable:
            case CloseBracket:
            case PostfixOperator:
                // TODO: error,
                break;
            default:
                // Should never reach here

        }
    }

    private void addKeyPostfixOp(Key k) {
        if (posCursor == 0) {
            // TODO: Toast Cannot add operator
            return;
        }
        Key prevKey = keys.get(posCursor - 1);
        KeyKind prevKeyKind = ButtonKeys.getKeyKind(prevKey);
        switch (prevKeyKind) {
            case Numeric:
            case Variable:
            case CloseBracket:
            case PostfixOperator:
                keys.add(posCursor++, k);
                break;
            case OpenBracket:
            case PrefixOperator:
            case InfixOperator:
                // TODO: Toast Cannot add operator
                break;
            default:
                // Should never reach here

        }
    }

    private void addKeyBracket(Key k) {
        // TODO
        if (posCursor == 0) {
            Key nextKey = keys.get(0);
            KeyKind nextKeyKind = ButtonKeys.getKeyKind(nextKey);
            switch (nextKeyKind) {
                case Numeric:
                case Variable:
                case OpenBracket:
                case PrefixOperator:
                    keys.add(posCursor++, Key.kBrOpen);
                    break;
                default:
                    // TODO: error, invalid key
            }
            return;
        }
        int bracketsStatus = matchBracketsStatus(posCursor - 1);
        if (bracketsStatus < 0) {
            // TODO: mismatch brackets
        } else {
            Key prevKey = keys.get(posCursor - 1);
            KeyKind prevKeyKind = ButtonKeys.getKeyKind(prevKey);

            if (bracketsStatus > 0) {
                // if open brackets are more
                switch (prevKeyKind) {

                    case Numeric:
                    case Variable:
                    case PostfixOperator:
                    case CloseBracket:
                        keys.add(posCursor++, Key.kBrClose);
                        break;
                    case OpenBracket:
                    case PrefixOperator:
                    case InfixOperator:
                        keys.add(posCursor++, Key.kBrOpen);
                        break;
                    default:
                        // logical error if reach here
                        break;
                }
            } else {
                // if open close brackets are equal
                switch (prevKeyKind) {
                    case CloseBracket:
                    case Numeric:
                    case Variable:
                    case PostfixOperator:
                        keys.add(posCursor++, Key.kMul);
                        keys.add(posCursor++, Key.kBrOpen);
                        break;
                    case InfixOperator:
                    case PrefixOperator:
                        keys.add(posCursor++, Key.kBrOpen);
                        break;
                    case OpenBracket:
                    default:
                        // TODO: throw Logical error
                        break;
                }
            }
        }
    }

    private int matchBracketsStatus(int index) {
        Stack<Key> parens = new Stack<Key>();
        for (Key k : keys) {
            if (k == Key.kBrOpen) {
                parens.push(k);
            }
            if (k == Key.kBrClose) {
                if (parens.empty()) {
                    // Mismatch parens at this point
                    return -1;
                } else {
                    parens.pop();
                }
            }
        }
        return parens.size();
    }

    private void addKeyOperation(Key k) {
        switch (k) {
            case kAns:
                Log.d("Calc", getKeysArrayString());
                tokens = new Tokenizer();
                for (Key ky : keys) {
                    tokens.addToken(ky);
                }
                tokens.addToken(Key.kAns); // To finalise the tokens expression

                Log.d("Calc", tokens.infix.toString());
                Expression postfix = ExpressionEvaluator.infixToPostfix(tokens.infix);
                Log.d("Calc", postfix.toString());
                ExpressionItem ans = ExpressionEvaluator.evaluateExpression(postfix);
                Log.d("Calc", ans.toString());
                resEdtxt.setText(ans.toString());
                break;
            case kDel:
                if (posCursor > 0) {
                    keys.remove(--posCursor);
                }
                break;
            default:
                break;
        }
    }

    private String getKeysArrayString() {
        StringBuilder sb = new StringBuilder();
        for (Key k : keys) {
            sb.append(k.toString()).append(" ");
        }
        return sb.toString();
    }

    private void addKeyMoveOperation(Key k) {
        switch (k) {
            case kMoveLeft:
                if (posCursor > 0)
                    --posCursor;
                break;
            case kMoveRight:
                if (posCursor < keys.size())
                    ++posCursor;
                break;
            case kMoveLeftEnd:
                posCursor = 0;
                break;
            case kMoveRightEnd:
                posCursor = keys.size();
                break;
            default:
                break;
        }
    }

    private void moveCursor(int pos) {
        posCursor = pos;
    }

}
