package com.mk.myandroid.customcontrol;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mk.myandroid.R;
/**
 * 定制带标题的文本框（不带命名控件）
 * 
 * @author Administrator
 * 
 */
public class LabelEditText extends LinearLayout {
	private TextView textView;
	private String labelText;
	private int labelFontSize;
	private String labelPosition;

	public LabelEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// 读取labelText属性的资源ID
		int resourceId = attrs.getAttributeResourceValue(null, "labelText", 0);
		// 未获得资源ID,继续读取属性值
		if (resourceId == 0) {
			labelText = attrs.getAttributeValue(null, "labelText");
		} else {
			// 从资源文件中获取labelText的属性值
			labelText = getResources().getString(resourceId);
		}
		if (labelText == null) {
			throw new RuntimeException("必须设置labelText属性");
		}

		// 读取labelFontSize属性的资源ID
		resourceId = attrs.getAttributeResourceValue(null, "labelFontSize", 0);
		// 继续读取labelFontSize属性的值，如果未设置该属性，将属性值设为14
		if (resourceId == 0) {
			labelFontSize = attrs.getAttributeIntValue(null, "labelFontSize", 14);
		} else {
			// 从资源文件中获取labelFontSize的属性值
			labelFontSize = getResources().getInteger(resourceId);
		}

		// 读取labelPosition属性的资源ID
		resourceId = attrs.getAttributeResourceValue(null, "labelPosition", 0);
		// 继续读取labelPosition属性的值
		if (resourceId == 0) {
			labelPosition = attrs.getAttributeValue(null, "labelPosition");
		} else {
			// 从资源文件中获取labelFontSize的属性值
			labelPosition = getResources().getString(resourceId);
		}
		if (labelPosition == null) {
			labelPosition = "left";
		}
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li = null;
		// 获得LAYOUT_INFLATER_SERVICE服务
		li = (LayoutInflater) context.getSystemService(infService);
		LinearLayout ll = null;
		// 根据labelPosition的属性值装载不同的配置文件
		if (labelPosition.equals("left")) {
			ll = (LinearLayout) li.inflate(R.layout.labeledittext_horizontal, this);
			textView = (TextView) findViewById(R.id.textview);
			textView.setTextSize(labelFontSize);
			textView.setText(labelText);
		} else if (labelPosition.equals("top")) {
			ll = new LinearLayout(context);
			TextView tv = new TextView(context);
			tv.setTextSize(labelFontSize);
			tv.setText(labelText);
			ll.addView(tv);
			EditText et = new EditText(context);
			ll.addView(et);
		} else {
			throw new RuntimeException("labelPosition的属性值只能是left或者top");
		}
		
		
	}

}
