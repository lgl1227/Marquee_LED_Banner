package com.example.big_homewoerk;

/*
* 添加菜单
* 速度的改变
* 下一步--增加历史记录
* 下一步--完善和发布
* */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.big_homewoerk.Light_Activity;
import com.example.big_homewoerk.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "input_words";
    final private int good= 114;
    final private int belong= 115;
    final private int me= 116;


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: 我要开始了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: 现在暂停了");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "onPostResume: 现在开始了");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: 现在停止了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: 现在杀死了");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button ok_button,canel_button;
        EditText edie_View2= (EditText) findViewById(R.id.editTextTextMultiLine);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok_button=(Button)findViewById((R.id.button4));
        MyListener test= new MyListener();
        ok_button.setOnClickListener(test);

        canel_button=(Button)findViewById((R.id.button3));
        canel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textView2= (EditText) findViewById(R.id.editTextTextMultiLine);
                String words = textView2.getText().toString();
                if(!words.isEmpty()){
                    textView2.setText("");
                }
            }
        });


        Log.d(TAG, "onCreate: 现在创建了");
    }


    class MyListener implements
            View.OnClickListener{
        @Override
        public void onClick(View v ){
            EditText textView2= (EditText) findViewById(R.id.editTextTextMultiLine);
            String words = textView2.getText().toString();
            if(words.isEmpty()){
                Toast.makeText(MainActivity.this,"请输入有效的文字",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(MainActivity.this, Light_Activity.class);
                Bundle bd = new Bundle();
                bd.putCharSequence("words",words);
                intent.putExtras(bd);
                startActivity(intent);
                finish();
            }
            Toast.makeText(MainActivity.this,textView2.getText(),Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(1,good,5,"打赏作者");
        menu.add(1,belong,6,"版权说明");
        menu.add(1,me,7,"关于作者");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case good:
                Intent intent = new Intent(MainActivity.this,Good.class);
                startActivity(intent);
                break;
            case belong:
                Intent intent2 = new Intent(MainActivity.this,Activity_belong.class);
                startActivity(intent2);
                break;
            case me:
                Intent intent3 = new Intent(MainActivity.this,Activity_me.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}