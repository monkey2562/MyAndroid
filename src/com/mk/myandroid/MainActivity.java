package com.mk.myandroid;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mk.myandroid.broadcastreceiver.BroadcastreceiverActivity;
import com.mk.myandroid.contentprovider.ContentproviderActivity;
import com.mk.myandroid.layout.LayoutActivity;
import com.mk.myandroid.lifetime.LifetimeActivity;
import com.mk.myandroid.listview.ListviewActivity;
import com.mk.myandroid.service.ServiceActivity;
import com.mk.myandroid.ui.UiListActivity;


public class MainActivity extends Activity {
	ListView listView;
	SimpleAdapter adapter;
	private static final String[] NAMES = new String[] {"四大组件之activity", "四大组件之service",
		"四大组件之Broadcast Receiver","四大组件之ContentProvider","Intent","布局", "ListView", "常用控件","事件"};
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
        	map.put("Image", R.drawable.app_icon);
        	listItem.add(map);
        	
        }
        
        //生成适配器的Item和动态数组对应的元素
        adapter = new SimpleAdapter(this, listItem, //数据源
        		R.layout.main_item, //listItem的XML实现
        		new String[] {"ItemName","Image"},//动态数组与item对应的子项 
        		new int[] {R.id.tv001,R.id.iv001}  );//Item的XML文件里面对应的ID
        //添加并显示
        listView.setAdapter(adapter);
        //添加点击
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
//				setTitle("点击第"+arg2+"个项目");
				switch (arg2) {
				case 0://四大组件之activity
					Intent lifetimeIntent = new Intent(MainActivity.this, LifetimeActivity.class);
					startActivity(lifetimeIntent);
					
					break;
				case 1://四大组件之service
					Intent serviceIntent = new Intent(MainActivity.this, ServiceActivity.class);
					startActivity(serviceIntent);
					break;
				case 2://四大组件之Broadcast Receiver
					Intent broadcastReceiverIntent = new Intent(MainActivity.this, BroadcastreceiverActivity.class);
					startActivity(broadcastReceiverIntent);
					break;
				case 3://四大组件之ContentProvider
					Intent contentIntent = new Intent(MainActivity.this, ContentproviderActivity.class);
					startActivity(contentIntent);
					break;
				case 4://Intent用组件启动 --显式intent
					Intent egIntent = new Intent();
					egIntent.setComponent(new ComponentName("com.mk.myandroid", "com.mk.myandroid.intent.IntentActivity"));
					startActivity(egIntent);
					break;
				case 5://布局
					Intent layoutIntent = new Intent(MainActivity.this, LayoutActivity.class);
					startActivity(layoutIntent);
					break;
				case 6://ListView
					Intent listViewIntent = new Intent(MainActivity.this, ListviewActivity.class);
					startActivity(listViewIntent);
					break;
				case 7://常用控件
					Intent uiIntent = new Intent(MainActivity.this, UiListActivity.class);
					startActivity(uiIntent);
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
