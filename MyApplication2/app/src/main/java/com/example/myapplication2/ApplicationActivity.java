package com.example.myapplication2;

/**
 * Created by 陌年 on 2017/12/14.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class ApplicationActivity extends ActionBarActivity implements View.OnClickListener{
    private Button customViewDiaog;
    private AlertDialog.Builder builder;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alter_dialog);
        customViewDiaog= (Button) findViewById(R.id.button);
        customViewDiaog.setOnClickListener(this);
    }
    public void onClick(View view){
        showCustomViewDialog(view);
    }

    private void showCustomViewDialog(View view){
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("自定义对话框");

        /**
         * 设置内容区域为自定义View
         */
        LinearLayout loginDialog= (LinearLayout) getLayoutInflater().inflate(R.layout.custom_view,null);
        builder.setView(loginDialog);
        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
}
