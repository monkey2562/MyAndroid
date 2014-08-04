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
import android.widget.TextView;

import com.mk.myandroid.backbutton.BackButtonActivity;
import com.mk.myandroid.broadcastreceiver.BroadcastreceiverActivity;
import com.mk.myandroid.contentprovider.ContentproviderActivity;
import com.mk.myandroid.customcontrol.CustomControlActivity;
import com.mk.myandroid.layout.LayoutActivity;
import com.mk.myandroid.lifetime.LifetimeActivity;
import com.mk.myandroid.listview.ListviewActivity;
import com.mk.myandroid.project.ProjectActivity;
import com.mk.myandroid.service.ServiceActivity;
import com.mk.myandroid.ui.UiListActivity;


public class MainActivity extends Activity {
	ListView listView;
	SimpleAdapter adapter;
	private static final String[] NAMES = new String[] {"�Ĵ����֮activity", "�Ĵ����֮service",
		"�Ĵ����֮Broadcast Receiver","�Ĵ����֮ContentProvider","Intent","����", "ListView", 
		"���ÿؼ�","�����¼�","��Ŀ","���ƿؼ�"};
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
				case 0://�Ĵ����֮activity
					Intent lifetimeIntent = new Intent(MainActivity.this, LifetimeActivity.class);
					startActivity(lifetimeIntent);
					
					break;
				case 1://�Ĵ����֮service
					Intent serviceIntent = new Intent(MainActivity.this, ServiceActivity.class);
					startActivity(serviceIntent);
					break;
				case 2://�Ĵ����֮Broadcast Receiver
					Intent broadcastReceiverIntent = new Intent(MainActivity.this, BroadcastreceiverActivity.class);
					startActivity(broadcastReceiverIntent);
					break;
				case 3://�Ĵ����֮ContentProvider
					Intent contentIntent = new Intent(MainActivity.this, ContentproviderActivity.class);
					startActivity(contentIntent);
					break;
				case 4://Intent��������� --��ʽintent
					Intent egIntent = new Intent();
					egIntent.setComponent(new ComponentName("com.mk.myandroid", "com.mk.myandroid.intent.IntentActivity"));
					startActivity(egIntent);
					break;
				case 5://����
					Intent layoutIntent = new Intent(MainActivity.this, LayoutActivity.class);
					startActivity(layoutIntent);
					break;
				case 6://ListView
					Intent listViewIntent = new Intent(MainActivity.this, ListviewActivity.class);
					startActivity(listViewIntent);
					break;
				case 7://���ÿؼ�
					Intent uiIntent = new Intent(MainActivity.this, UiListActivity.class);
					startActivity(uiIntent);
					break;
				case 8://�����¼�
					Intent backIntent = new Intent(MainActivity.this, BackButtonActivity.class);
					startActivity(backIntent);
					break;
				case 9://��Ŀ
					Intent projectIntent = new Intent(MainActivity.this, ProjectActivity.class);
					startActivity(projectIntent);
					break;
				case 10://���ƿؼ�
					Intent ccIntent = new Intent(MainActivity.this, CustomControlActivity.class);
					startActivity(ccIntent);
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
