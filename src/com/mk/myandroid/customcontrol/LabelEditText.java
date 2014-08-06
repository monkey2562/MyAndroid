package com.mk.myandroid.customcontrol;


import java.net.ContentHandler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mk.myandroid.R;
/**
 * ���ƴ�������ı��򣨲��������ؼ���
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
		// ��ȡlabelText���Ե���ԴID
		int resourceId = attrs.getAttributeResourceValue(null, "labelText", 0);
		// δ�����ԴID,������ȡ����ֵ
		if (resourceId == 0) {
			labelText = attrs.getAttributeValue(null, "labelText");
		} else {
			// ����Դ�ļ��л�ȡlabelText������ֵ
			labelText = getResources().getString(resourceId);
		}
		if (labelText == null) {
			throw new RuntimeException("��������labelText����");
		}

		// ��ȡlabelFontSize���Ե���ԴID
		resourceId = attrs.getAttributeResourceValue(null, "labelFontSize", 0);
		// ������ȡlabelFontSize���Ե�ֵ�����δ���ø����ԣ�������ֵ��Ϊ14
		if (resourceId == 0) {
			labelFontSize = attrs.getAttributeIntValue(null, "labelFontSize", 14);
		} else {
			// ����Դ�ļ��л�ȡlabelFontSize������ֵ
			labelFontSize = getResources().getInteger(resourceId);
		}

		// ��ȡlabelPosition���Ե���ԴID
		resourceId = attrs.getAttributeResourceValue(null, "labelPosition", 0);
		// ������ȡlabelPosition���Ե�ֵ
		if (resourceId == 0) {
			labelPosition = attrs.getAttributeValue(null, "labelPosition");
		} else {
			// ����Դ�ļ��л�ȡlabelFontSize������ֵ
			labelPosition = getResources().getString(resourceId);
		}
		if (labelPosition == null) {
			labelPosition = "left";
		}
		String infService = Context.LAYOUT_INFLATER_SERVICE;
		LayoutInflater li = null;
		// ���LAYOUT_INFLATER_SERVICE����
		li = (LayoutInflater) context.getSystemService(infService);
		LinearLayout ll = null;
		// ����labelPosition������ֵװ�ز�ͬ�������ļ�
		if (labelPosition.equals("left")) {
			ll = (LinearLayout) li.inflate(R.layout.labeledittext_horizontal, this);
			textView = (TextView) findViewById(R.id.textview);
			textView.setTextSize(labelFontSize);
			textView.setText(labelText);
		} else if (labelPosition.equals("top")) {
			ll = new LinearLayout(context);
			ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			TextView tv = new TextView(context);
			tv.setTextSize(labelFontSize);
			tv.setText(labelText);
			ll.addView(tv);
			EditText et = new EditText(context);
			ll.addView(et);
		} else {
			throw new RuntimeException("labelPosition������ֵֻ����left����top");
		}
		
		
	}

}
