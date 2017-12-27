package com.application3.myapplication3;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends  Activity  {
    private Button browse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_view);
        Browse();
    }
    void Browse(){
        browse = (Button)findViewById(R.id.browse) ;
        browse.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText text = (EditText) findViewById(R.id.address);
                String address = text.getText().toString();
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(address);
                intent.setData(content_url);
                startActivity(intent);
            }
        });

    }

}
