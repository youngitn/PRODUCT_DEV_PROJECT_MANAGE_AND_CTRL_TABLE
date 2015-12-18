package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE/DoAdd;
import java.io.File;

import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

/**
 * 新增資料在此設計
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {

	@Override
	public String action(String value) throws Throwable {

		String[][] field = { { "PROJECT_NO", "專案編號" },
				{ "EXP_MATERIAL_ATTENDANCE_DATE", "預計材料到齊日" },
				{ "EXP_SMALL_TEST_DATE", "預計小試開始日期" },
				{ "EXP_SMALL_TEST_END_DATE", "預計小試結束日期" },
				{ "EXP_MIDDLE_TEST_DATE", "預計中試開始日期" },
				{ "EXP_METHODOLOGY_BEGIN_DATE", "預計方法學開始日期" },
				{ "EXP_STABILITY_SAMPLES_PLACED_DATE", "預計放置穩定性樣品日期" },
				{ "EXP_REPORTING_DATE", "預計申報日期" },
				{ "PROJECT_STATUS", "專案狀態" }, { "CLOSING_DATE", "結案日期" }

		};
		if (checkEmpty(field)) {
			
			File F1 = getUploadFile("REFERENCE_FILE_1");
			File F2 = getUploadFile("REFERENCE_FILE_2");
			File F3 = getUploadFile("REFERENCE_FILE_3");
			System.out.println(""+F1+"");
			ProductDevProjectScheduleBean bean = new ProductDevProjectScheduleBean(
					createPNO("PNO", getToday("YYYYmmdd"), "PRODUCT_DEV_PROJECT_SCHEDULE"), 
					getValue("PROJECT_NO"), 
					getValue("EXP_MATERIAL_ATTENDANCE_DATE"), 
					getValue("EXP_SMALL_TEST_DATE"), 
					getValue("EXP_SMALL_TEST_END_DATE"), 
					getValue("EXP_MIDDLE_TEST_DATE"), 
					getValue("EXP_METHODOLOGY_BEGIN_DATE"), 
					getValue("EXP_STABILITY_SAMPLES_PLACED_DATE"),
					getValue("EXP_REPORTING_DATE"), 
					getValue("PROJECT_STATUS"), 
					getValue("CLOSING_DATE"), 
					""+F1+"", 
					""+F2+"", 
					""+F3+"");
			
			ProductDevProjectScheduleDAO pScheduleDAO = new ProductDevProjectScheduleDAO(
					getTalk());
			pScheduleDAO.insert(bean);
		}
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
