package com.friedapps.scientycalc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.friedapps.scientycalc.calculator.Tokenizer;

public class CalcActivity extends Activity {

    private int total = 0;
    KeyPressHandler keyPressHandler;
    TextView exprTV, resultTV;
    String resultStr, exprStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calc);

        resultStr = "";
        exprStr = "";
        exprTV = (TextView) findViewById(R.id.txtCalcExpr);
        exprTV.setText(exprStr);
        resultTV = (TextView) findViewById(R.id.txtResult);
        resultTV.setText(resultStr);
        keyPressHandler = new KeyPressHandler(exprTV);
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
