package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.LAB_RECBOOK_USING_APPLY.Init
import SomeUtils._hproc;
import SomeUtils.Bean.UserInfoViewBean;

/**
 * �i�J(�򥻤W��s�W�����P��)ñ�֭����ܰ��檺�{��. �D�n�Ω�a�X��Ʈw���H�~�����.
 * 
 * @author b0050
 *
 */
public class Init extends _hproc {

	@Override
	public String action(String paramString) throws Throwable {
		// TODO Auto-generated method stub

		UserInfoViewBean nowUser = getUserInfo(getUser());
		setValue("REQ_EMPID", getUser());
		setValue("REQ_EMPID_NAME", nowUser.getHecname());
		setValue("REQ_DEPT_NAME", nowUser.getDepName());
		if (POSITION == 5 && getState().equals("����ï�޲z�H")) {
			setEditable("RECBOOK_NO", true);
			// �h���ť�
			if (getValue("RECBOOK_NO").trim().length() == 0) {
				setValue("RECBOOK_NO", "");
			}

		}

		return null;
	}

}
