package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.Init
import SomeUtils._hproc;

/**
 * �i�J(�򥻤W��s�W�����P��)ñ�֭����ܰ��檺�{���C
 * �D�n�Ω�a�X��Ʈw���H�~�����,�άO�]�w����������é�����C
 * @author b0050
 *
 */
public class Init extends _hproc {

	@Override
	public String action(String paramString) throws Throwable {
		// TODO Auto-generated method stub
		if (POSITION == 5) {

			if (getState().equals("��o�g��")) {
				setEditable("RD_ATTACHED", true);
			}
			if (getState().equals("��P�g��")) {
				setEditable("SALES_ATTACHED", true);
			}
			if (getState().equals("�k�W�g��")) {
				setEditable("LAW_ATTACHED", true);
			}
			if (getState().equals("���ʽҸg��")) {
				setEditable("PURCH_ATTACHED", true);
			}
			if (getState().equals("�s�{�o�i�g��")) {
				setEditable("PROCESS_ATTACHED", true);
			}

			if (getState().equals("���_�y�L�T�{")) {
				setEditable("IS_APPROVE", true);
			}
		}

		return null;
	}

}
