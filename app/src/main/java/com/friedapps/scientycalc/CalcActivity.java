package com.friedapps.scientycalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends Activity {

    private int total = 0;
    KeyPressHandler keyPressHandler;
    EditText resultET, exprET;
    String resultStr, exprStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calc);

        resultStr = "";
        exprStr = "";
        exprET = (EditText) findViewById(R.id.edtxtCalcExpr);
        exprET.setText(exprStr);
        resultET = (EditText) findViewById(R.id.edtxtResult);
        resultET.setText(resultStr);
        keyPressHandler = new KeyPressHandler(exprET, resultET);
        Button resetBtn = (Button) findViewById(R.id.btnReset);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyPressHandler.reset();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calc, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View view) {

        int btnId = view.getId();
        ButtonKeys.Key key = ButtonKeys.getKey(btnId);
        keyPressHandler.addKey(key);
//        Toast.makeText(this, "Success " + key.toString(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Fail " + key.toString(), Toast.LENGTH_SHORT).show();

    }
}
