package com.mk.myandroid.resourceaccess.xml;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mk.myandroid.R;

public class ResourceXMLActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resource_xml);
		XmlResourceParser parser = getResources().getXml(R.xml.users);
		try {
			//事件类型不等于XML读取完毕
			while (parser.getEventType()!=XmlResourceParser.END_DOCUMENT){
				if(parser.getEventType() == XmlResourceParser.START_TAG){
					if(parser.getName().equals("user")){
						String name = parser.getAttributeValue(null,"name");
						String age = parser.getAttributeValue(null,"age");
						System.out.println(String.format("姓名：%s,年龄：%s", name,age));
					}
				}
				parser.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resource_xml, menu);
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
