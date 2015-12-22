package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE/DoUpdate;
import java.io.File;

import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

/**
 * �s�W��Ʀb���]�p
 * 
 * @author b0050
 *
 */
public class DoUpdate extends _hproc {

	@Override
	public String action(String value) throws Throwable {

		/*
		 * String[][] field = { { "PROJECT_NO", "�M�׽s��" }, {
		 * "EXP_MATERIAL_ATTENDANCE_DATE", "�w�p���ƨ����" }, { "EXP_SMALL_TEST_DATE",
		 * "�w�p�p�ն}�l���" }, { "EXP_SMALL_TEST_END_DATE", "�w�p�p�յ������" }, {
		 * "EXP_MIDDLE_TEST_DATE", "�w�p���ն}�l���" }, { "EXP_METHODOLOGY_BEGIN_DATE",
		 * "�w�p��k�Ƕ}�l���" }, { "EXP_STABILITY_SAMPLES_PLACED_DATE", "�w�p��mí�w�ʼ˫~���"
		 * }, { "EXP_REPORTING_DATE", "�w�p�ӳ����" }, { "PROJECT_STATUS", "�M�ת��A" },
		 * { "CLOSING_DATE", "���פ��" }
		 * 
		 * };
		 */
		// if (checkEmpty(field)) {

		String pNo = getValue("PROJECT_NO").trim();
		ProductDevProjectScheduleDAO pScheduleDAO = new ProductDevProjectScheduleDAO(
				getTalk());
		ProductDevProjectScheduleBean bean = pScheduleDAO
				.getProductDevProjectScheduleBeanByProjectNo(pNo);

		File F1 = getUploadFile("REFERENCE_FILE_1");
		File F2 = getUploadFile("REFERENCE_FILE_2");
		File F3 = getUploadFile("REFERENCE_FILE_3");
		System.out.println("" + F1 + "");

		bean.setPROJECT_NO(pNo);
		bean.setEXP_MATERIAL_ATTENDANCE_DATE(getValue("EXP_MATERIAL_ATTENDANCE_DATE").trim());
		bean.setEXP_SMALL_TEST_DATE(getValue("EXP_SMALL_TEST_DATE").trim());
		bean.setEXP_SMALL_TEST_END_DATE(getValue("EXP_SMALL_TEST_END_DATE").trim());
		bean.setEXP_MIDDLE_TEST_DATE(getValue("EXP_MIDDLE_TEST_DATE").trim());
		bean.setEXP_METHODOLOGY_BEGIN_DATE(getValue("EXP_METHODOLOGY_BEGIN_DATE").trim());
		bean.setEXP_STABILITY_SAMPLES_PLACED_DATE(getValue("EXP_STABILITY_SAMPLES_PLACED_DATE").trim());
		bean.setEXP_REPORTING_DATE(getValue("EXP_REPORTING_DATE").trim());
		bean.setPROJECT_STATUS(getValue("PROJECT_STATUS").trim());
		bean.setCLOSING_DATE(getValue("CLOSING_DATE").trim());
		bean.setREFERENCE_FILE_1("" + F1 + "");
		bean.setREFERENCE_FILE_2("" + F2 + "");
		bean.setREFERENCE_FILE_3("" + F3 + "");
		
		pScheduleDAO.update(bean);
		addScript("document.location.reload(true)");
		// }
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
