package com.friedapps.scientycalc;

import android.util.Log;
import android.widget.TextView;

import com.friedapps.scientycalc.ButtonKeys.Key;
import com.friedapps.scientycalc.ButtonKeys.KeyKind;
import com.friedapps.scientycalc.calculator.Expression;
import com.friedapps.scientycalc.calculator.ExpressionEvaluator;
import com.friedapps.scientycalc.calculator.ExpressionItem;
import com.friedapps.scientycalc.calculator.TokenBracket.BracketType;
import com.friedapps.scientycalc.calculator.Tokenizer;

import java.util.ArrayList;
import java.util.Stack;

public class KeyPressHandler {


    public ArrayList<ButtonKeys.Key> keys;
    private int posCursor;
    private Stack<BracketType> bracketsStack;
    public Tokenizer tokens;
    private TextView exprTV;

    public KeyPressHandler(TextView tv) {
        keys = new ArrayList<Key>();
        posCursor = 0;
        exprTV = tv;

    }

    public void addKey(Key k) {
        /* TODO
            Handle press of this key k
            If key = kAns evaluate to answer
            handle brackets
            distinguish between unary/binary operators
         */
        KeyKind currKeyKind = ButtonKeys.getKeyKind(k);
        if (keys.size() == 0) {
            switch (currKeyKind) {
                case Numeric:
                case Variable:
                case PrefixOperator:
                case OpenBracket:
                    keys.add(k);
                    ++posCursor;
                    break;
            }
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
        //exprTV.setText(keys.toString());
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
                if (k == Key.kPlusMinus) {
                    if (posCursor < keys.size()) {
                        Key nextKey = keys.get(posCursor);
                        if (nextKey == Key.kPlusMinus) {
                            keys.remove(posCursor);
                        }
                    }
                    if (prevKey == Key.kPlusMinus) {
                        keys.remove(posCursor--);
                    } else {
                        keys.add(posCursor++, k);
                    }
                } else {
                    keys.add(posCursor++, k);
                }
                break;
            case OpenBracket:
            case InfixOperator:
                keys.add(posCursor++, k);
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
        Stack<Key> bracketStack = matchBrackets(posCursor);
        if (bracketStack == null) {
            // TODO: mismatch brackets
        } else {
            if (bracketStack.empty()) {
                keys.add(posCursor++, Key.kBrOpen);
            } else {
                keys.add(posCursor++, Key.kBrClose);
            }
        }

    }

    private Stack<Key> matchBrackets(int index) {
        Stack<Key> parens = new Stack<Key>();
        for (Key k : keys) {
            if (k == Key.kBrOpen) {
                parens.push(k);

            }
            if (k == Key.kBrClose) {
                if (parens.empty()) {
                    // Mismatch parens at this point
                    return null;
                } else {
                    parens.pop();
                }
            }
        }
        return parens;
    }

    private void addKeyOperation(Key k) {
        switch (k) {
            case kAns:
                tokens = new Tokenizer();
                for (Key ky : keys) {
                    tokens.addToken(ky);
                }
                Expression postfix = ExpressionEvaluator.infixToPostfix(tokens.infix);
                ExpressionItem ans = ExpressionEvaluator.evaluateExpression(postfix);
                Log.d("Calc", ans.toString());
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

    private void addKeyMoveOperation(Key k) {
        switch (k) {
            case kMoveLeft:
                --posCursor;
                break;
            case kMoveRight:
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
