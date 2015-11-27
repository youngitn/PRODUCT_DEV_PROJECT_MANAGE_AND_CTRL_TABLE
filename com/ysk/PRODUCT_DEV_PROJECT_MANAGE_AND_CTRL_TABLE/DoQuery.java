package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;

/**
 * ����d�ߪ��ʧ@�b���]�p
 * 
 * @author b0050
 *
 */
public class DoQuery extends _hproc {

	@Override
	public String action(String value) throws Throwable {
		// �إ�table header,�P�]�p�Ҧ��������춶�Ǥ@�P.
		ArrayList<QueryItem> list = new ArrayList<QueryItem>();

		// PNO�����Ĥ@��
		list.add(new QueryItem("PNO", "�ӽг渹", 1));// 0 �������d�߱���ӷ�
		list.add(new QueryItem("REQ_EMPID", "�ӽФH���s", 1));
		list.add(new QueryItem("DATE", "�ӽФ��", 2));
		list.add(new QueryItem("PROJECT_NO", "�M�׽s��", 1));
		/**
		 * �H�U�}�l���D�D�ɸ�ƪ���. �d��ñ�֪��A��SQL���O �����Φr��Ѽƥ�i�h����DB���W��,"ñ�֪��A"�� table
		 * header,0��ܦbsetQueryTable���������d�߱���.
		 */
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"ñ�֪��A", 0));
		list.add(new QueryItem("'ñ�֬���'", "ñ�֬���", 0));
		list.add(new QueryItem("'�ԲӸ�T'", "�ԲӸ�T", 0));

		/**
		 * �Ѽ� 1,4 �N��
		 * LIST����������m,�|�ϥΨ�t"���u�s��"&"ñ�֪��A"������,�U���list��1�M��4����m.(ArrayList�q0�}�l��)
		 * 
		 * �Ѽ� otherConditionString �B�~���d�߱��� .
		 */
		setQueryTable(list, PRODUCT_DEV_PROJECT_TABLE_FINAL_CONFIG.USING_TABLE,
				"��P-��o���~�߶���o�ޱ���", 1, 4, "");
		list.clear();
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}