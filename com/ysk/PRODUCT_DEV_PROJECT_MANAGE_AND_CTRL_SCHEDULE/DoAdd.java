package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_SCHEDULE/DoAdd;
import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

/**
 * �s�W��Ʀb���]�p
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {

	@Override
	public String action(String value) throws Throwable {

		String[][] field = { { "PROJECT_NO", "�M�׽s��" },
				{ "EXP_MATERIAL_ATTENDANCE_DATE", "�w�p���ƨ����" },
				{ "EXP_SMALL_TEST_DATE", "�w�p�p�ն}�l���" },
				{ "EXP_SMALL_TEST_END_DATE", "�w�p�p�յ������" },
				{ "EXP_MIDDLE_TEST_DATE", "�w�p���ն}�l���" },
				{ "EXP_METHODOLOGY_BEGIN_DATE", "�w�p��k�Ƕ}�l���" },
				{ "EXP_STABILITY_SAMPLES_PLACED_DATE", "�w�p��mí�w�ʼ˫~���" },
				{ "EXP_REPORTING_DATE", "�w�p�ӳ����" },
				{ "PROJECT_STATUS", "�M�ת��A" }, { "CLOSING_DATE", "���פ��" }

		};
		if (checkEmpty(field)) {
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
					getValue("REFERENCE_FILE_1"), 
					getValue("REFERENCE_FILE_2"), 
					getValue("REFERENCE_FILE_3"));
			
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
