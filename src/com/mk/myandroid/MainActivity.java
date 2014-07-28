package com.mk.myandroid;

import java.util.ArrayList;
import java.util.HashMap;

import com.mk.myandroid.layout.LayoutActivity;
import com.mk.myandroid.lifetime.LifetimeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class MainActivity extends Activity {
	ListView listView;
	SimpleAdapter adapter;
	private static final String[] NAMES = new String[] {"生命周期", "布局", "文本框", "输入框","事件"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = (ListView) findViewById(R.id.lv001);
        //生成动态数组，加入数据  
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();  
        for(int i = 0 ;i < NAMES.length;i++){
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	map.put("ItemName", NAMES[i]);
        	listItem.add(map);
        	
        }
        
        //生成适配器的Item和动态数组对应的元素
        adapter = new SimpleAdapter(this, listItem, //数据源
        		R.layout.main_item, //listItem的XML实现
        		new String[] {"ItemName"},//动态数组与item对应的子项 
        		new int[] {R.id.tv001}  );//Item的XML文件里面对应的ID
        //添加并显示
        listView.setAdapter(adapter);
        //添加点击
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
//				setTitle("点击第"+arg2+"个项目");
				switch (arg2) {
				case 0:
					Intent lifetimeIntent = new Intent(MainActivity.this, LifetimeActivity.class);
					startActivity(lifetimeIntent);
					
					break;
				case 1:
					Intent layoutIntent = new Intent(MainActivity.this, LayoutActivity.class);
					startActivity(layoutIntent);
					break;
				default:
					break;
				}
				
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
}
