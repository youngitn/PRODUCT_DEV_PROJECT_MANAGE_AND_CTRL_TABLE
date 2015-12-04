package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE.Notify;
// com/ysk/LAB_RECBOOK_USING_APPLY/Notify/SendMailAll
import java.util.Arrays;
import java.util.HashSet;

import jcx.jform.bProcFlow;

import com.ysk.service.BaseService;

public class SendMailAll extends bProcFlow {

	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"

		BaseService service = new BaseService();

		String sendRS = "";
		String email;
		String[] AllApprovePeople = getAllApprovePeople();
		String title = getState();
		String content = getState();
		int isEmailAllSend = 0;

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
			message("EMAIL�H�X����");
			return false;

		}

		message("EMAIL�w�H�X�q��");

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
