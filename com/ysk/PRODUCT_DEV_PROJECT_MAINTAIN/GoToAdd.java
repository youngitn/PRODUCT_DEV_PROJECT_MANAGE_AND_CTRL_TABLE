package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;
//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/GoToAdd;
//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;
import SomeUtils.Bean.UserInfoViewBean;

/**
 * �i�J�s�W������,�ݭn�@�ֱa�X����Ʀb���]�w. �D�n�Ω�a�X��Ʈw���H�~�����.
 * 
 * @author b0050
 *
 */
public class GoToAdd extends _hproc {
	@SuppressWarnings("deprecation")
	@Override
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		//
		UserInfoViewBean nowUser = getUserInfo(getUser());
		setValue("REQ_EMPID", getUser());
		setValue("REQ_EMPID_NAME", nowUser.getHecname());
		setValue("REQ_DEPT_NAME", nowUser.getDepName());
		setValue("MAINTAIN_DATE", getToday("YYYYmmdd"));
		/*
		 * test download File F1 = new
		 * File("p_DEV_FILE\\1449540754589_20151028meeting.doc");
		 * setOutput("application/octet-stream",F1.getName(), F1);
		 */
		
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}