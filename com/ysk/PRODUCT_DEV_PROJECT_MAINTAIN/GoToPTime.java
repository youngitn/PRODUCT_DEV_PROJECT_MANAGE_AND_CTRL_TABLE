package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/GoToPTime;
//import com.ysk.bean.UserInfoViewBean;
import jcx.db.talk;

import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

/**
 * 進入新增頁面時,需要一併帶出的資料在此設定. 主要用於帶出資料庫欄位以外的資料.
 * 
 * @author b0050
 *
 */
public class GoToPTime extends _hproc {
	@SuppressWarnings("deprecation")
	@Override
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		//
		String PNO = getValue("PNO").trim();
		String pjno = getValue("PROJECT_NO").trim();
		String mType = getValue("MAINTAIN_TYPE").trim();
		if (pjno.length() == 0){
			addScript("window.close();");
			message("專案編號不可空白!");
			
		}
		
		// 已賦予專案編號即可編輯時程管控.
		if (!StringUtils.isEmpty(pjno)) {
			ProductDevProjectScheduleDAO dao = new ProductDevProjectScheduleDAO(
					getTalk());
			ProductDevProjectScheduleBean bean = dao
					.getProductDevProjectScheduleBeanByProjectNo(pjno.trim());
			// String ret[][] = getTalk().queryFromPool(
			// "select * from PRODUCT_DEV_PROJECT_SCHEDULE where PROJECT_NO = '"
			// + pjno + "'");

		
			
			
			
			
			// 沒起過才進下面 if 主要是做讀取資料的動作:
			if (bean != null) {

				setValue("PNO", bean.getPNO());

				setValue("EXP_MATERIAL_ATTENDANCE_DATE",
						bean.getEXP_MATERIAL_ATTENDANCE_DATE());
				setValue("EXP_SMALL_TEST_DATE", bean.getEXP_SMALL_TEST_DATE());
				setValue("EXP_SMALL_TEST_END_DATE",
						bean.getEXP_SMALL_TEST_END_DATE());
				setValue("EXP_MIDDLE_TEST_DATE", bean.getEXP_MIDDLE_TEST_DATE());
				setValue("EXP_METHODOLOGY_BEGIN_DATE",
						bean.getEXP_METHODOLOGY_BEGIN_DATE());
				setValue("EXP_STABILITY_SAMPLES_PLACED_DATE",
						bean.getEXP_STABILITY_SAMPLES_PLACED_DATE());
				setValue("EXP_REPORTING_DATE", bean.getEXP_REPORTING_DATE());
				setValue("PROJECT_STATUS", mType);
				setValue("CLOSING_DATE", bean.getCLOSING_DATE());

				if (!StringUtils.isEmpty(bean.getREFERENCE_FILE_1().trim())) {
					setValue("REFERENCE_FILE_1", bean.getREFERENCE_FILE_1()
							.trim());

				} else {
					setVisible("REFERENCE_FILE_1", false);
				}

				if (!StringUtils.isEmpty(bean.getREFERENCE_FILE_2().trim())) {
					setValue("REFERENCE_FILE_2", bean.getREFERENCE_FILE_2()
							.trim());

				}

				if (!StringUtils.isEmpty(bean.getREFERENCE_FILE_3())) {
					setValue("REFERENCE_FILE_3", bean.getREFERENCE_FILE_3()
							.trim());

				}
				if (bean.getREFERENCE_FILE_1().length()< 4 || bean.getREFERENCE_FILE_1().trim().equals("null")) {

					setVisible("REFERENCE_FILE_1", false);
				}
				if (bean.getREFERENCE_FILE_2().length() < 4 || bean.getREFERENCE_FILE_2().trim().equals("null")) {

					setVisible("REFERENCE_FILE_2", false);
				}
				if (bean.getREFERENCE_FILE_3().length() < 4 || bean.getREFERENCE_FILE_3().trim().equals("null")) {

					setVisible("REFERENCE_FILE_3", false);
				}
			}

		}
		
		/**
		 * 判斷異動類別是否等於1 進度更新等條件..
		 */
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO = '"
						+ PNO + "'");
		System.out.println("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO = '"
				+ getValue("PNO").trim() + "'");
		if (getValue("MAINTAIN_TYPE").trim().equals("1") 
				&& POSITION != 5
				&& ret[0][0].trim().equals("課主管")) {
			
			setVisible("REFERENCE_FILE_1", true);
			setVisible("REFERENCE_FILE_2", true);
			setVisible("REFERENCE_FILE_3", true);
			setVisible("DO_UPDATE", true);
		}

		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}