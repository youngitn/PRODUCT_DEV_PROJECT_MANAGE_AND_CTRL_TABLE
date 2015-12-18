package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.GoToSchedule
//import com.ysk.bean.UserInfoViewBean;
import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

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
		
		addScript("document.getElementById(\"flow_panel\").style.visibility = \"hidden\";");
		String pjno = getValue("QUERY_LIST.PROJECT_NO").trim();
		String isApprove = getValue("QUERY_LIST.IS_APPROVE").trim();
		// 已賦予專案編號即可編輯時程管控.
		if (!StringUtils.isEmpty(pjno)) {
			ProductDevProjectScheduleDAO dao = new ProductDevProjectScheduleDAO(
					getTalk());
			ProductDevProjectScheduleBean bean = dao
					.getProductDevProjectScheduleBeanByProjectNo(pjno.trim());
			// String ret[][] = getTalk().queryFromPool(
			// "select * from PRODUCT_DEV_PROJECT_SCHEDULE where PROJECT_NO = '"
			// + pjno + "'");

			// 如該專案編號已存在時程管控資料,則只能讀取既有資料並顯示,
			// 無法再此頁面做編輯,如需變更則需起單(OA328 研發產品管控表異動申請單).
			// 就是說:這張主單的專案編號如果從沒沒建過時程管控表,
			// 才可以從這裡進來新增,之後從這裡進來就只能看,不能改.
			// 要改必須先起OA328.
			
			//先顯示DOADD 經過下面判斷顯示與否
			setVisible("DoAdd", true);
			// 沒起過才進下面 if 主要是做讀取資料的動作:
			if (bean != null) {
				String downloadString1, downloadString2, downloadString3;

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
				setValue("PROJECT_STATUS", bean.getPROJECT_STATUS());
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
				
				//隱藏變更按鈕 必須起異動單才能改.
				setVisible("DoAdd", false);
				
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			// 沒有起過跟起過都匯執行以下程式,主要也是讀取資料作呈現.
			System.out.println("OA3XX-----" + isApprove);
			setValue("PROJECT_NO", pjno);
			setValue("PROJECT_STATUS", isApprove);
			setEditable("PROJECT_STATUS", false);
			setEditable("PROJECT_NO", false);
			
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