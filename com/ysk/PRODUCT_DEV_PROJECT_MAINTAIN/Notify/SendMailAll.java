package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN.Notify;

// com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/Notify/SendMailAll
import java.util.Arrays;
import java.util.HashSet;

import jcx.db.talk;
import jcx.jform.bProcFlow;

import com.ysk.service.BaseService;

public class SendMailAll extends bProcFlow {

	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"
		if (getValue("MAINTAIN_TYPE").trim().equals("1")
				|| getValue("MAINTAIN_TYPE").trim().equals("2")) {
			BaseService service = new BaseService();

			String sendRS = "";
			String email;
			String[] AllApprovePeople = getAllApprovePeople();
			
			String title = "��o���~�ޱ����ʥӽг�,ñ�֧���";
						
			String content = "�ӽг渹:"+getValue("PNO")+"<br>";
			content += "�ӽФ��:" + getValue("MAINTAIN_DATE")+"<br>";
			content += "�ӽФH:" + getValue("REQ_EMPID")+"  "+getValue("REQ_EMPID_NAME")+"<br>";
			
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
				message("EMAIL�H�X����");
				return false;

			}

			message("EMAIL�w�H�X�q��");
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
