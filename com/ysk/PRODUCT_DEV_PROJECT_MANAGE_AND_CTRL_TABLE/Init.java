package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.LAB_RECBOOK_USING_APPLY.Init
import SomeUtils._hproc;
import SomeUtils.Bean.UserInfoViewBean;

/**
 * 進入(基本上跟新增頁面同頁)簽核頁面變執行的程式. 主要用於帶出資料庫欄位以外的資料.
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
		if (POSITION == 5 && getState().equals("紀錄簿管理人")) {
			setEditable("RECBOOK_NO", true);
			// 去除空白
			if (getValue("RECBOOK_NO").trim().length() == 0) {
				setValue("RECBOOK_NO", "");
			}

		}

		return null;
	}

}
