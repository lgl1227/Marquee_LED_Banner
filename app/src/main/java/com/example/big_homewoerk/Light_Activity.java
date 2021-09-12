package com.example.big_homewoerk;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Light_Activity extends AppCompatActivity {
    private TextView txtshow;
    private String words;
    private float size_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        txtshow = (TextView)findViewById(R.id.txtOne);
        registerForContextMenu(txtshow);
        //获得Intent对象,并且用Bundle出去里面的数据
        Intent it = getIntent();
        Bundle bd = ((Intent) it).getExtras();

        //按键值的方式取出Bundle中的数据
        words = bd.getCharSequence("words").toString();
        txtshow.setText(words);
        int duration = 1200 * words.length() / 4;//速度

        txtshow.setSingleLine(true);//单行显示
        txtshow.setSelected(true);


    }


    //重写与ContextMenu相关方法
    @Override
    //重写上下文菜单的创建方法
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator = new MenuInflater(this);
        inflator.inflate(R.menu.menu_sub, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.blue:
                txtshow.setTextColor(Color.BLUE);
                break;
            case R.id.green:
                txtshow.setTextColor(Color.GREEN);
                break;
            case R.id.red:
                txtshow.setTextColor(Color.RED);
                break;
            case R.id.yellow:
                txtshow.setTextColor(Color.YELLOW);
                break;
            case R.id.gray:
                txtshow.setTextColor(Color.GRAY);
                break;
            case R.id.cyan:
                txtshow.setTextColor(Color.CYAN);
                break;
            case R.id.black:
                txtshow.setTextColor(Color.BLACK);
                break;
            case R.id.biger:
                size_now = txtshow.getTextSize();
                System.out.println(size_now);

                txtshow.setTextSize(TypedValue.COMPLEX_UNIT_PX,size_now+25);
                System.out.println(size_now);

                break;
            case R.id.smaller:
                size_now = txtshow.getTextSize();
                System.out.println(size_now);
                txtshow.setTextSize(TypedValue.COMPLEX_UNIT_PX,size_now-25);
                System.out.println(size_now);

                break;
            case R.id.quick:
                txtshow.setTextColor(Color.BLUE);
                break;
            case R.id.low:
                txtshow.setTextColor(Color.GREEN);
                break;

        }
        return true;
    }
}