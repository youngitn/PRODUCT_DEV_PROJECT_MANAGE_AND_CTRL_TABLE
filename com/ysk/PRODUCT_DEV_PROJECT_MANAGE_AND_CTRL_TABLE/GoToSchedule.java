package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.GoToSchedule
//import com.ysk.bean.UserInfoViewBean;
import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;

/**
 * 進入時程編輯頁面時,需要一併帶出的資料在此設定. 主要用於帶出資料庫欄位以外的資料.
 * 
 * @author b0050
 *
 */
public class GoToSchedule extends _hproc {
	@SuppressWarnings("unused")
	@Override
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		//
		String pjno = getValue("QUERY_LIST.PROJECT_NO").trim();
		
		//已賦予專案編號即可編輯時程管控.
		if (!StringUtils.isEmpty(pjno)) {
			String ret[][] = getTalk().queryFromPool(
					"select * from PRODUCT_DEV_PROJECT_SCHEDULE where PROJECT_NO = '"
							+ pjno + "'");
			
			//如該專案編號已存在時程管控資料,則讀取計有資料並顯示,
			//但無法再此頁面做編輯,如需變更則需起單(OA328 研發產品管控表異動申請單).
			if (ret.length > 0) {
				String downloadString1, downloadString2, downloadString3;

				setValue("PNO", ret[0][0]);
				
				setValue("EXP_MATERIAL_ATTENDANCE_DATE", ret[0][2]);
				setValue("EXP_SMALL_TEST_DATE", ret[0][3]);
				setValue("EXP_SMALL_TEST_END_DATE", ret[0][4]);
				setValue("EXP_MIDDLE_TEST_DATE", ret[0][5]);
				setValue("EXP_METHODOLOGY_BEGIN_DATE", ret[0][6]);
				setValue("EXP_STABILITY_SAMPLES_PLACED_DATE", ret[0][7]);
				setValue("EXP_REPORTING_DATE", ret[0][8]);
				setValue("PROJECT_STATUS", ret[0][9]);
				setValue("CLOSING_DATE", ret[0][10]);
				

				if (ret[0][11].trim().length() != 0) {
					setValue("REFERENCE_FILE_1","<a href=\""
							+ getDownloadURL(ret[0][11].trim())
							+ "\">夾檔1 下載</a><br>");
					
					setEditable("REFERENCE_FILE_1", false);
				}
				
				setValue("REFERENCE_FILE_2", ret[0][12]);
				if (ret[0][12].trim().length() != 0) {
					setValue("REFERENCE_FILE_2","<a href=\""
							+ getDownloadURL(ret[0][12].trim())
							+ "\">夾檔2 下載</a><br>");
					setEditable("REFERENCE_FILE_2", false);
				}
				
				setValue("REFERENCE_FILE_3", ret[0][13]);
				if (ret[0][13].trim().length() != 0) {
					setValue("REFERENCE_FILE_3","<a href=\""
							+ getDownloadURL(ret[0][13].trim())
							+ "\">夾檔3 下載</a><br>");
					setEditable("REFERENCE_FILE_3", false);
				}
				
				
			}
			setValue("PROJECT_NO", pjno);
			setVisible("DoAdd", false);
		} else {

			addScript("window.close();");
			message("專案編號尚未建立!請待簽核流程完成再行編輯。");
		}
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}