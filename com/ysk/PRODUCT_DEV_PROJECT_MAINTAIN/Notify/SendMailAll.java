package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN.Notify;

// com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/Notify/SendMailAll
import java.util.Arrays;
import java.util.HashSet;

import jcx.db.talk;
import jcx.jform.bProcFlow;

import com.ysk.service.BaseService;

public class SendMailAll extends bProcFlow {

	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		if (getValue("MAINTAIN_TYPE").trim().equals("1")
				|| getValue("MAINTAIN_TYPE").trim().equals("2")) {
			BaseService service = new BaseService();

			String sendRS = "";
			String email;
			String[] AllApprovePeople = getAllApprovePeople();
			
			String title = "研發產品管控表異動申請單,簽核完成";
						
			String content = "申請單號:"+getValue("PNO")+"<br>";
			content += "申請日期:" + getValue("MAINTAIN_DATE")+"<br>";
			content += "申請人:" + getValue("REQ_EMPID")+"  "+getValue("REQ_EMPID_NAME")+"<br>";
			
			int isEmailAllSend = 0;
			System.out.println(AllApprovePeople.toString());
			for (String peopleString : AllApprovePeople) {
				// System.out.println("value=" + it.next().toString());

				email = getEmail(peopleString);
				// email = service.getUserInfoBean(peopleString).getEmail();
				String usr[] = { email };

				sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
						"text/html");
				// if send mail Sending Failed,isEmailAllSend will +1 for check.
				if (!sendRS.trim().equals("")) {
					isEmailAllSend++;
				}

			}

			if (isEmailAllSend != 0) {
				message("EMAIL寄出失敗");
				return false;

			}

			message("EMAIL已寄出通知");
		}
		return true;

	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}

	public String[] getAllApprovePeople() {
		String vid[][] = getFlowHistory();
		String ausr[] = new String[vid.length];
		for (int i = 0; i < vid.length; i++) {
			ausr[i] = vid[i][1].trim();
		}
		HashSet<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(ausr));
		String usr[] = (String[]) set.toArray(new String[0]);
		return usr;

	}
}
