package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/GoToPTime;
//import com.ysk.bean.UserInfoViewBean;
import jcx.db.talk;

import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

/**
 * �i�J�s�W������,�ݭn�@�ֱa�X����Ʀb���]�w. �D�n�Ω�a�X��Ʈw���H�~�����.
 * 
 * @author b0050
 *
 */
public class GoToPTime extends _hproc {
	@SuppressWarnings("deprecation")
	@Override
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		//
		String PNO = getValue("PNO").trim();
		String pjno = getValue("PROJECT_NO").trim();
		String mType = getValue("MAINTAIN_TYPE").trim();
		if (pjno.length() == 0){
			addScript("window.close();");
			message("�M�׽s�����i�ť�!");
			
		}
		
		// �w�ᤩ�M�׽s���Y�i�s��ɵ{�ޱ�.
		if (!StringUtils.isEmpty(pjno)) {
			ProductDevProjectScheduleDAO dao = new ProductDevProjectScheduleDAO(
					getTalk());
			ProductDevProjectScheduleBean bean = dao
					.getProductDevProjectScheduleBeanByProjectNo(pjno.trim());
			// String ret[][] = getTalk().queryFromPool(
			// "select * from PRODUCT_DEV_PROJECT_SCHEDULE where PROJECT_NO = '"
			// + pjno + "'");

		
			
			
			
			
			// �S�_�L�~�i�U�� if �D�n�O��Ū����ƪ��ʧ@:
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
		 * �P�_�������O�O�_����1 �i�ק�s������..
		 */
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO = '"
						+ PNO + "'");
		System.out.println("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO = '"
				+ getValue("PNO").trim() + "'");
		if (getValue("MAINTAIN_TYPE").trim().equals("1") 
				&& POSITION != 5
				&& ret[0][0].trim().equals("�ҥD��")) {
			
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