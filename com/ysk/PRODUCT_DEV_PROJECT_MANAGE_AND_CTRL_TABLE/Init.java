package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.Init
import SomeUtils._hproc;

/**
 * �i�J(�򥻤W��s�W�����P��)ñ�֭����ܰ��檺�{���C �D�n�Ω�a�X��Ʈw���H�~�����,�άO�]�w����������é�����C
 * 
 * @author b0050
 *
 */
public class Init extends _hproc {

	@Override
	public String action(String paramString) throws Throwable {
		// TODO Auto-generated method stub
		if (POSITION == 5) {
			if (getState().equals("���_�y�L�T�{")) {
				setEditable("IS_APPROVE", true);
			}
			if (getState().equals("�|�p�g��")) {
				setEditable("PROJECT_NO", true);
			}
			checkAttch("SALES_ATTACHED");
			checkAttch("LAW_ATTACHED");
			checkAttch("PURCH_ATTACHED");
			checkAttch("RD_ATTACHED");
			checkAttch("PROCESS_ATTACHED");
		}
		return null;
	}

	public void checkAttch(String attName) {
		// TODO Auto-generated method stub

		if (getValue(attName) == null || getValue(attName).trim().length() == 0) {
			setValue(attName, "");
		}

	}

}
