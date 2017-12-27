package com.application3.myapplication3;

/**
 * Created by 陌年 on 2017/12/24.
 */
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;

public class WebViewLoad extends Activity {
    private Button browse;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_view);
        Browse();
    }

    void Browse() {
        browse = (Button) findViewById(R.id.browse);
        browse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.address);
                String address = text.getText().toString();
                Uri content_url = Uri.parse(address);
                intent = new Intent(Intent.ACTION_VIEW, content_url);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra("url", address);
                PackageManager pm = getPackageManager();
                List<ResolveInfo> resolveList = pm.queryIntentActivities(intent, PackageManager.MATCH_ALL);
                Log.i("WebViewLoad", "resolveList size:" + resolveList.size());
                if (resolveList.size() > 0) {
                    String title = "choose application";
                    Intent intentChooser = Intent.createChooser(intent, title);
                    startActivity(intentChooser);
                } else {
                    Toast.makeText(WebViewLoad.this, "no match activity to start!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
