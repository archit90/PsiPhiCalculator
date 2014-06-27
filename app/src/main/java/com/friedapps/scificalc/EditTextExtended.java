package com.friedapps.scificalc;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextExtended extends EditText {
    int cursor;

    public EditTextExtended(Context context) {
        super(context);
        cursor = 0;
        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                cursor = getSelectionStart();
                setSelection(cursor);
            }
        });
    }

    public EditTextExtended(Context context, AttributeSet attrs) {
        super(context, attrs);
        cursor = 0;
    }

    public EditTextExtended(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        cursor = 0;
    }

    public int getCursorPosition() {
        return cursor;
    }

    @Override
    public void onSelectionChanged(int start, int end) {
        cursor = start;
        setSelection(cursor);
    }


}
