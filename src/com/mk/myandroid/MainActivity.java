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
import com.mk.myandroid.project.ProjectActivity;
import com.mk.myandroid.resourceaccess.ResourceAccessActivity;
import com.mk.myandroid.ui.UiListActivity;


public class MainActivity extends Activity {
	ListView listView;
	SimpleAdapter adapter;
	private static final String[] NAMES = new String[] {"�Ĵ����", "Intent","����", "ListView", 
		"���ÿؼ�","�����¼�","��Ŀ","���ƿؼ�","��Դ����","���ݴ洢"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        listView = (ListView) findViewById(R.id.lv001);
        //���ɶ�̬���飬��������  
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();  
        for(int i = 0 ;i < NAMES.length;i++){
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	map.put("ItemName", NAMES[i]);
        	map.put("Image", R.drawable.app_icon);
        	listItem.add(map);
        	
        }
        
        //������������Item�Ͷ�̬�����Ӧ��Ԫ��
        adapter = new SimpleAdapter(this, listItem, //����Դ
        		R.layout.main_item, //listItem��XMLʵ��
        		new String[] {"ItemName","Image"},//��̬������item��Ӧ������ 
        		new int[] {R.id.tv001,R.id.iv001}  );//Item��XML�ļ������Ӧ��ID
        //��Ӳ���ʾ
        listView.setAdapter(adapter);
        //��ӵ��
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
//				setTitle("�����"+arg2+"����Ŀ");
				switch (arg2) {
				case 0://�Ĵ����
					Intent componentIntent = new Intent(MainActivity.this, ComponentActivity.class);
					startActivity(componentIntent);
					break;
				case 1://Intent��������� --��ʽintent
					Intent egIntent = new Intent();
					egIntent.setComponent(new ComponentName("com.mk.myandroid", "com.mk.myandroid.intent.IntentActivity"));
					startActivity(egIntent);
					break;
				case 2://����
					Intent layoutIntent = new Intent(MainActivity.this, LayoutActivity.class);
					startActivity(layoutIntent);
					break;
				case 3://ListView
					Intent listViewIntent = new Intent(MainActivity.this, ListviewActivity.class);
					startActivity(listViewIntent);
					break;
				case 4://���ÿؼ�
					Intent uiIntent = new Intent(MainActivity.this, UiListActivity.class);
					startActivity(uiIntent);
					break;
				case 5://�����¼�
					Intent backIntent = new Intent(MainActivity.this, BackButtonActivity.class);
					startActivity(backIntent);
					break;
				case 6://��Ŀ
					Intent projectIntent = new Intent(MainActivity.this, ProjectActivity.class);
					startActivity(projectIntent);
					break;
				case 7://���ƿؼ�
					Intent ccIntent = new Intent(MainActivity.this, CustomControlActivity.class);
					startActivity(ccIntent);
					break;
				case 8://��Դ����
					Intent resIntent = new Intent(MainActivity.this, ResourceAccessActivity.class);
					startActivity(resIntent);
					break;
				case 9://���ݴ洢
					Intent dataStorageIntent = new Intent(MainActivity.this, DataStorageActivity.class);
					startActivity(dataStorageIntent);
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
