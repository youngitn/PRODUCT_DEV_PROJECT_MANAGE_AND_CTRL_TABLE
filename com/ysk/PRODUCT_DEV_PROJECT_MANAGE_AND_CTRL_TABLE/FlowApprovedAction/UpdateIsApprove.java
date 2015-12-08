package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;
//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/UpdateIsApprove
import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class UpdateIsApprove  extends bProcFlow {

	/**
	 * ��y�{���d=���_�y�L�T�{��,
	 * �}��O�_�߶����,�ç�s���Ʈw�C
	 */
	@Override
	public boolean action(String paramString) throws Throwable {
		// TODO Auto-generated method stub
		String pno = getValue("PNO");
		ProductDevProjectTableDAO dao = new ProductDevProjectTableDAO(getTalk());
		
		ProductDevProjectTableBean bean = dao
				.getProductDevProjectTableBean(pno);
		
		if (getValue("IS_APPROVE").trim().length() != 0) {

			bean.setIS_APPROVE(getValue("IS_APPROVE").trim());
			dao.update(bean);
			dao = null;
			return true;
		}
		message("�O�_�߶���쥲���ֿ�!");
		return false;
	}

}
