package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.Notify;
//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/Notify/EmailNotify
import java.util.Vector;

import SomeUtils._bNotify;

import com.ysk.service.BaseService;

public class EmailNotify extends _bNotify {
	BaseService service;

	@Override
	public void actionPerformed(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		service = new BaseService();
		// get sign people
		Vector<?> vid = getEngagedPeople();
		if (vid.size() == 0)
			return;

		
		Vector<String> V2 = new Vector<String>();
		for (int i = 0; i < vid.size(); i++) {
			V2.addElement(getEmail((String) vid.elementAt(i)));
			
		}
		if (V2.size() == 0)
			return;
		String content = getState();
		String title  = getState();
		

		String usr[] = ((String[]) V2.toArray(new String[0]));
		
		String sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
				"text/html");
		if (sendRS.trim().equals("")) {
			message("EMAIL�w�H�X�q��");
		} else {
			message("EMAIL�H�X����");
		}
	}
}
