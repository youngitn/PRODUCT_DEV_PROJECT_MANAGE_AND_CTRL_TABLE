package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

import SomeUtils.Bean.LabRecbookUsingApplyBean;
import SomeUtils.DAO.LabRecbookUsingApplyDAO;
//com/ysk/LAB_RECBOOK_USING_APPLY/FlowApprovedAction/LabBookManagerFlowApprovedAction;
import jcx.jform.bProcFlow;

/**
 * �b����ï�޲z�H���@��,�N�|���޲z�Hupdate RECBOOK_NO���.
 * 
 * @author YangTing
 *
 */
public class UpdateAttached extends bProcFlow {

	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		/*
		�P�_�O�_����
		SALES_ATTACHED
		LAW_ATTACHED
		PURCH_ATTACHED
		PROCESS_ATTACHED
		RD_ATTACHED
		*
		*/
		if (getValue("RECBOOK_NO").trim().length() == 0) {
			message("����ï�s����줣�i����.");
			return false;
		}
		LabRecbookUsingApplyDAO lDao = new LabRecbookUsingApplyDAO(
				getTalk());
		LabRecbookUsingApplyBean bean = lDao
				.getLabRecbookUsingApplyBeanByPno(getValue("PNO"));
		bean.setRECBOOK_NO(getValue("RECBOOK_NO"));
		lDao.update(bean);
		return true;
	}

}
