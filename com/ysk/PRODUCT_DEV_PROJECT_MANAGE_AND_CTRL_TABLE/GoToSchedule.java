package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.GoToSchedule
//import com.ysk.bean.UserInfoViewBean;
import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectScheduleBean;
import SomeUtils.DAO.ProductDevProjectScheduleDAO;

/**
 * �i�J�ɵ{�s�譶����,�ݭn�@�ֱa�X����Ʀb���]�w. �D�n�Ω�a�X��Ʈw���H�~�����.
 * 
 * @author b0050
 *
 */
public class GoToSchedule extends _hproc {
	@SuppressWarnings("unused")
	@Override
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		//
		
		addScript("document.getElementById(\"flow_panel\").style.visibility = \"hidden\";");
		String pjno = getValue("QUERY_LIST.PROJECT_NO").trim();
		String isApprove = getValue("QUERY_LIST.IS_APPROVE").trim();
		// �w�ᤩ�M�׽s���Y�i�s��ɵ{�ޱ�.
		if (!StringUtils.isEmpty(pjno)) {
			ProductDevProjectScheduleDAO dao = new ProductDevProjectScheduleDAO(
					getTalk());
			ProductDevProjectScheduleBean bean = dao
					.getProductDevProjectScheduleBeanByProjectNo(pjno.trim());
			// String ret[][] = getTalk().queryFromPool(
			// "select * from PRODUCT_DEV_PROJECT_SCHEDULE where PROJECT_NO = '"
			// + pjno + "'");

			// �p�ӱM�׽s���w�s�b�ɵ{�ޱ����,�h�u��Ū���J����ƨ����,
			// �L�k�A���������s��,�p���ܧ�h�ݰ_��(OA328 ��o���~�ޱ����ʥӽг�).
			// �N�O��:�o�i�D�檺�M�׽s���p�G�q�S�S�عL�ɵ{�ޱ���,
			// �~�i�H�q�o�̶i�ӷs�W,����q�o�̶i�ӴN�u���,�����.
			// �n�沈�����_OA328.
			
			//�����DOADD �g�L�U���P�_��ܻP�_
			setVisible("DoAdd", true);
			// �S�_�L�~�i�U�� if �D�n�O��Ū����ƪ��ʧ@:
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
				
				//�����ܧ���s �����_���ʳ�~���.
				setVisible("DoAdd", false);
				
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			// �S���_�L��_�L���װ���H�U�{��,�D�n�]�OŪ����Ƨ@�e�{.
			System.out.println("OA3XX-----" + isApprove);
			setValue("PROJECT_NO", pjno);
			setValue("PROJECT_STATUS", isApprove);
			setEditable("PROJECT_STATUS", false);
			setEditable("PROJECT_NO", false);
			
		} else {

			addScript("window.close();");
			message("�M�׽s���|���إ�!�Ы�ñ�֬y�{�����A��s��C");
		}
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}