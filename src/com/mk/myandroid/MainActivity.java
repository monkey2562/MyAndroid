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

import com.mk.myandroid.backbutton.BackButtonActivity;
import com.mk.myandroid.component.ComponentActivity;
import com.mk.myandroid.customcontrol.CustomControlActivity;
import com.mk.myandroid.datastorage.DataStorageActivity;
import com.mk.myandroid.layout.LayoutActivity;
import com.mk.myandroid.listview.ListviewActivity;
import com.mk.myandroid.media.MediaActivity;
import com.mk.myandroid.project.ProjectActivity;
import com.mk.myandroid.resourceaccess.ResourceAccessActivity;
import com.mk.myandroid.ui.UiListActivity;


public class MainActivity extends Activity {
	ListView listView;
	SimpleAdapter adapter;
	private static final String[] NAMES = new String[] {"四大组件", "Intent","布局", "ListView", 
		"常用控件","后退事件","项目","定制控件","资源访问","数据存储","多媒体"};
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
				case 0://四大组件
					Intent componentIntent = new Intent(MainActivity.this, ComponentActivity.class);
					startActivity(componentIntent);
					break;
				case 1://Intent用组件启动 --显式intent
					Intent egIntent = new Intent();
					egIntent.setComponent(new ComponentName("com.mk.myandroid", "com.mk.myandroid.intent.IntentActivity"));
					startActivity(egIntent);
					break;
				case 2://布局
					Intent layoutIntent = new Intent(MainActivity.this, LayoutActivity.class);
					startActivity(layoutIntent);
					break;
				case 3://ListView
					Intent listViewIntent = new Intent(MainActivity.this, ListviewActivity.class);
					startActivity(listViewIntent);
					break;
				case 4://常用控件
					Intent uiIntent = new Intent(MainActivity.this, UiListActivity.class);
					startActivity(uiIntent);
					break;
				case 5://后退事件
					Intent backIntent = new Intent(MainActivity.this, BackButtonActivity.class);
					startActivity(backIntent);
					break;
				case 6://项目
					Intent projectIntent = new Intent(MainActivity.this, ProjectActivity.class);
					startActivity(projectIntent);
					break;
				case 7://定制控件
					Intent ccIntent = new Intent(MainActivity.this, CustomControlActivity.class);
					startActivity(ccIntent);
					break;
				case 8://资源访问
					Intent resIntent = new Intent(MainActivity.this, ResourceAccessActivity.class);
					startActivity(resIntent);
					break;
				case 9://数据存储
					Intent dataStorageIntent = new Intent(MainActivity.this, DataStorageActivity.class);
					startActivity(dataStorageIntent);
					break;
				case 10://多媒体
					Intent mediaIntent = new Intent(MainActivity.this, MediaActivity.class);
					startActivity(mediaIntent);
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
