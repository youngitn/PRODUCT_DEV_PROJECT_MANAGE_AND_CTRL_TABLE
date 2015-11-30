package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.GoToSchedule
//import com.ysk.bean.UserInfoViewBean;
import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;

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
		String pjno = getValue("QUERY_LIST.PROJECT_NO").trim();
		
		//�w�ᤩ�M�׽s���Y�i�s��ɵ{�ޱ�.
		if (!StringUtils.isEmpty(pjno)) {
			String ret[][] = getTalk().queryFromPool(
					"select * from PRODUCT_DEV_PROJECT_SCHEDULE where PROJECT_NO = '"
							+ pjno + "'");
			
			//�p�ӱM�׽s���w�s�b�ɵ{�ޱ����,�hŪ���p����ƨ����,
			//���L�k�A���������s��,�p���ܧ�h�ݰ_��(OA328 ��o���~�ޱ����ʥӽг�).
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
							+ "\">����1 �U��</a><br>");
					
					setEditable("REFERENCE_FILE_1", false);
				}
				
				setValue("REFERENCE_FILE_2", ret[0][12]);
				if (ret[0][12].trim().length() != 0) {
					setValue("REFERENCE_FILE_2","<a href=\""
							+ getDownloadURL(ret[0][12].trim())
							+ "\">����2 �U��</a><br>");
					setEditable("REFERENCE_FILE_2", false);
				}
				
				setValue("REFERENCE_FILE_3", ret[0][13]);
				if (ret[0][13].trim().length() != 0) {
					setValue("REFERENCE_FILE_3","<a href=\""
							+ getDownloadURL(ret[0][13].trim())
							+ "\">����3 �U��</a><br>");
					setEditable("REFERENCE_FILE_3", false);
				}
				
				
			}
			setValue("PROJECT_NO", pjno);
			setVisible("DoAdd", false);
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