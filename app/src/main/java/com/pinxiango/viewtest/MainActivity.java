package com.pinxiango.viewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressBarView1 progress = (ProgressBarView1) findViewById(R.id.progress);
        progress.setMax(100);
        progress.setProgress(60);
        Button btn_canvas = (Button) findViewById(R.id.btn_canvas);
        btn_canvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CanvasTest1Activity.class));
            }
        });


        final EditText edt_main = (EditText) findViewById(R.id.edt_main);
        edt_main.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("TAG", "之前的文本为:"+s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("TAG", "改变后未:"+s);
            }
        });
        edt_main.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    Toast.makeText(MainActivity.this, "完成", Toast.LENGTH_SHORT).show();
                    edt_main.clearFocus();
                    return true;
                }
                return false;
            }
        });
        edt_main.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    Log.e("TAG", "获取焦点");
                }else{
                    Log.e("TAG", "失去焦点");
                }
            }
        });
    }
}
