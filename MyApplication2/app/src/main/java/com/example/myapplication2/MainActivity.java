package com.example.myapplication2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
public class MainActivity extends Activity {
    private String[] name ={"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageids ={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private ListView lv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),
                R.layout.simple_adapter, new String[] { "name", "img"},
                new int[] { R.id.name,R.id.img});
        //setListAdapter(adapter);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
//                Toast.makeText(MainActivity.this,
//                        ((TextView) view).getText(), Toast.LENGTH_LONG)
//                        .show()
                TextView text = (TextView) view.findViewById(R.id.name);
                String name = text.getText().toString();
                Toast.makeText(MainActivity.this, name,Toast.LENGTH_LONG).show();
            }
        });
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
 //       Map<String, Object> map = new HashMap<String, Object>();
//        map.put("name", "Lion");
//        map.put("img", R.drawable.lion);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("name", "Tiger");
//        map.put("img", R.drawable.tiger);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("name", "Monkey");
//        map.put("img", R.drawable.monkey);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("name", "Dog");
//        map.put("img", R.drawable.dog);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("name", "Cat");
//        map.put("img", R.drawable.cat);
//        list.add(map);
//
//        map = new HashMap<String, Object>();
//        map.put("name", "Elephant");
//        map.put("img", R.drawable.elephant);
//        list.add(map);
        for (int i = 0; i < name.length; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name",name[i]);
            map.put("img",imageids[i]);
            list.add(map);
        }


        return list;
    }
}
