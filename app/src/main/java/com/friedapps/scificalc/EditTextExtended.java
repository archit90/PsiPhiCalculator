package com.friedapps.scificalc;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextExtended extends EditText {
    int cursor;

    public EditTextExtended(Context context) {
        super(context);
        cursor = 0;
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
