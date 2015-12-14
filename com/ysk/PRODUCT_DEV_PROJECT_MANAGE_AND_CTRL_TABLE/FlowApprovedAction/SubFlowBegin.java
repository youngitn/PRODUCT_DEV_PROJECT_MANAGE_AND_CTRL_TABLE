package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/SubFlowBegin
import java.util.ArrayList;

import jcx.db.talk;
import jcx.jform.bProcFlow;
import SomeUtils.Bean.SubProductDevProjectTableBean;
import SomeUtils.DAO.SubProductDevProjectTableDAO;

/**
 * �{���_��. �s�W5����� in SUB_PRODUCT_DEV_PROJECT_TABLE. �ó]�wñ�֪��A in
 * SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC.
 * 
 * @author YangTing
 *
 */
public class SubFlowBegin extends bProcFlow {
	/**
	 * ��y�{���d=�|�p�D�ޮ�, �}��M�׽s�����,�ç�s���Ʈw���C
	 */
	@Override
	public boolean action(String paramString) throws Throwable {
		// TODO Auto-generated method stub
		// ���o�D��渹
		talk t = getTalk();
		String MSATER_PNO = getValue("PNO").trim();
		SubProductDevProjectTableDAO sDao = new SubProductDevProjectTableDAO(t);
		ArrayList<SubProductDevProjectTableBean> blist = new ArrayList<SubProductDevProjectTableBean>();

		// �_5�i�l��,���O�]��~ ��q ���� �@�~ ��o������ .
		for (int i = 1; i <= 5; i++) {
			blist.add(new SubProductDevProjectTableBean(Integer.toString(i), MSATER_PNO));
			t.execFromPool("");
		}	

		sDao.add(blist);
		return true;
	}
	
}
