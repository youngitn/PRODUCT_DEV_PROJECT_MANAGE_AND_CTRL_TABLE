package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.Init
import SomeUtils._hproc;

/**
 * 進入(基本上跟新增頁面同頁)簽核頁面變執行的程式。 主要用於帶出資料庫欄位以外的資料,或是設定哪些欄位隱藏或顯視。
 * 
 * @author b0050
 *
 */
public class Init extends _hproc {

	@Override
	public String action(String paramString) throws Throwable {
		// TODO Auto-generated method stub
		if (POSITION == 5) {
			if (getState().equals("挖寶尖兵確認")) {
				setEditable("IS_APPROVE", true);
			}
			if (getState().equals("會計經辦")) {
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
