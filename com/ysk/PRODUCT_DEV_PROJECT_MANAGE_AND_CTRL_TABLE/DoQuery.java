package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;
import SomeUtils.Bean.UserInfoViewBean;
import SomeUtils.DAO.UserInfoViewDAO;

/**
 * ����d�ߪ��ʧ@�b���]�p
 * @author b0050
 *
 */
public class DoQuery extends _hproc {
	
	@Override
	public String action(String value) throws Throwable {
		// �إ�table header,�P�]�p�Ҧ��������춶�Ǥ@�P.
		ArrayList<QueryItem> list = new ArrayList<QueryItem>();
		
		// PNO�����Ĥ@��
		list.add(new QueryItem("PNO", "�ӽг渹", 0));// 0 �������d�߱���ӷ�
		list.add(new QueryItem("RECBOOK_NO", "����ï�s��", 1));
		list.add(new QueryItem("RECBOOK_NAME", "����ï�W��", 1));
		list.add(new QueryItem("REC_START_DATE", "�����}�l���", 2));// 2 ��T�϶�
		list.add(new QueryItem("REC_END_DATE", "�����������", 2));// 2 ��T�϶�
		list.add(new QueryItem("REQ_EMPID", "�ӽФH���s", 1));

		/**
		 * �H�U�}�l���D�D�ɸ�ƪ���. �d��ñ�֪��A��SQL���O �����Φr��Ѽƥ�i�h����DB���W��,"ñ�֪��A"�� table
		 * header,0��ܦbsetQueryTable���������d�߱���.
		 */
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"ñ�֪��A", 0));
		list.add(new QueryItem("'ñ�֬���'", "ñ�֬���", 0));
		list.add(new QueryItem("'�ԲӸ�T'", "�ԲӸ�T", 0));
		UserInfoViewDAO ud = new UserInfoViewDAO(getTalk());
		UserInfoViewBean user = ud.getUserInfo(getUser());
		ud = null;
		String otherConditionString = "";

		// ��o"�B" �ҥH��ParentNo
		// ��o�@ �G�� ���H �W�@�h�O��o�B :13,���B�� getParentNo �[�\ �@ ,�G�� & ��o�B���H
		if (user.getParentNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.RD_DEPT_NO
				|| user.getDepNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.RD_DEPT_NO) {

			otherConditionString += "where (RECBOOK_NO like 'YF%' OR RECBOOK_NO like 'YJ%')";

		}// �~��"��": 18 �Ϋ~�޽ҩ��U���z�Ʋյ�...
		else if (user.getParentNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.QC_DEPT_NO
				|| user.getDepNo() == LAB_RECBOOK_USING_APPLY_FINAL_CONFIG.QC_DEPT_NO) {

			otherConditionString += "where (RECBOOK_NO like 'QC%' OR RECBOOK_NO like 'AR%')";

		} else if (user.getEmpid().equals("admin")) {
			otherConditionString = "";
		} else {
			message("�L�d���v��!");
			return value;
		}
		/**
		 * �Ѽ� 5,6 �N��
		 * LIST����������m,�|�ϥΨ�t"���u�s��"&"ñ�֪��A"������,�U���list��5�M��6����m.(ArrayList�q0�}�l��)
		 * 
		 * �Ѽ� otherConditionString �B�~���d�߱��� .
		 */
		setQueryTable(list, "LAB_RECBOOK_USING_APPLY", "����Ǭ���ï��γ�", 5, 6,
				otherConditionString);
		list.clear();
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}