package com.psabharw.calculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {


    private android.support.v7.widget.Toolbar toolbar;
    private EditText textbox;
    private ButtonClickListener btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     textbox=(EditText)findViewById(R.id.editText);

        int idList [] ={R.id.button0,R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,
                R.id.button8,R.id.button9,R.id.add,R.id.sub,R.id.mul,R.id.div,R.id.exp,R.id.fact};

        for (int id :idList)
        {
            View v = (View)findViewById(id);
            v.setOnClickListener(btnClick);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"hey",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ButtonClickListener implements View.OnClickListener {
        public void onClick (View v)
        {
            switch(v.getId())
            {
                case R.id.add : mMath("+");
                        break;
                case R.id.sub : mMath("-");
                    break;
                case R.id.mul : mMath("*");
                    break;
                case R.id.div : mMath("/");
                    break;
                default:
                    String numb= ((Button)v).getText().toString();
                    getKeyboard(numb);
                    break;
            }

        }

    }
}
