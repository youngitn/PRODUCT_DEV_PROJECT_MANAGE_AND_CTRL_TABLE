package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com\ysk\PRODUCT_DEV_PROJECT_MAINTAIN\Init
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
		
		if (POSITION == 5){
			setEditable("SHOW_PTABLE",true);
			setEditable("SHOW_PTIME",true);
		}
		

		return null;
	}

}
