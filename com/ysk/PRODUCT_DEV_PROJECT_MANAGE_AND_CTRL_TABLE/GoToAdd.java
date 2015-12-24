package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;
import SomeUtils.Bean.UserInfoViewBean;

/**
 * 進入新增頁面時,需要一併帶出的資料在此設定. 主要用於帶出資料庫欄位以外的資料.
 * 
 * @author b0050
 *
 */
public class GoToAdd extends _hproc {
	@SuppressWarnings("deprecation")
	@Override
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		//
		UserInfoViewBean nowUser = getUserInfo(getUser());
		setValue("REQ_EMPID", getUser());
		setValue("REQ_EMPID_NAME", nowUser.getHecname());
		setValue("REQ_DEPT_NAME", nowUser.getDepName());
		setValue("DATE", getToday("YYYYmmdd"));
		/*
		 * test download File F1 = new
		 * File("p_DEV_FILE\\1449540754589_20151028meeting.doc");
		 * setOutput("application/octet-stream",F1.getName(), F1);
		 */
		setValue("SAMPLE_DOWNLOAD", "<button onclick=\"location.href='"
				+ getDownloadURL("p_DEV_FILE\\BPOA311-sample.doc")
				+ "'\";>夾檔文件下載</button>");
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}