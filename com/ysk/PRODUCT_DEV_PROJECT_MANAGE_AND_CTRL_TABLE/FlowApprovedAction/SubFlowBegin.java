package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/SubFlowBegin
import java.util.ArrayList;

import jcx.db.talk;
import jcx.jform.bProcFlow;
import SomeUtils.Bean.SubProductDevProjectTableBean;
import SomeUtils.DAO.SubProductDevProjectTableDAO;

import com.ysk.service.BaseService;

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
			blist.add(new SubProductDevProjectTableBean(Integer.toString(i),
					MSATER_PNO));
			t.execFromPool("");
		}

		sDao.add(blist);

		// ���o�l�y�{�Ĥ@����ñ�֤H 
		String toPeople[][] = t
				.queryFromPool("select DEP_CHIEF from HRUSER_DEPT_BAS "
						+ " where " + " DEP_NO = '15' or "
						+ " DEP_NO = '11' or " + " DEP_NO = '33' or "
						+ " DEP_NO = '12' or " + " DEP_NO = '13'");

		BaseService service = new BaseService();

		String content = getState();
		String title = getState();
		System.out.println("OA311----------"+toPeople[0][0]+toPeople[1][0]+toPeople[2][0]+toPeople[3][0]+toPeople[4][0]);
		String usr[] = { 
				getEmail(toPeople[0][0]), 
				getEmail(toPeople[1][0]),
				getEmail(toPeople[2][0]), 
				getEmail(toPeople[3][0]),
				getEmail(toPeople[4][0]) };

		String sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
				"text/html");
		if (sendRS.trim().equals("")) {
			message("EMAIL�w�H�X�q��");
		} else {
			message("EMAIL�H�X����");
		}
		return true;
	}

}
