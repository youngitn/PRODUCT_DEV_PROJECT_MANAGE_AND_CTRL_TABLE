package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com\ysk\PRODUCT_DEV_PROJECT_MAINTAIN\Init
import SomeUtils._hproc;

/**
 * 進入(基本上跟新增頁面同頁)簽核頁面變執行的程式。
 * 主要用於帶出資料庫欄位以外的資料,或是設定哪些欄位隱藏或顯視。
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
