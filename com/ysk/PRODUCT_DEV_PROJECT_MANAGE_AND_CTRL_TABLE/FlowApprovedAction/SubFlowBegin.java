package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/SubFlowBegin
import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;
/**
 * �{���_��.
 * �s�W5����� in SUB_PRODUCT_DEV_PROJECT_TABLE.
 * �ó]�wñ�֪��A  in SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC.
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

		String pno = getValue("PNO");
		ProductDevProjectTableDAO dao = new ProductDevProjectTableDAO(getTalk());

		ProductDevProjectTableBean bean = dao
				.getProductDevProjectTableBean(pno);

		if (getValue("PROJECT_NO").trim().length() != 0) {

			bean.setPROJECT_NO(getValue("PROJECT_NO").trim());
			dao.update(bean);
			dao = null;
			return true;
		}
		message("�M�׽s����쥲����J!");
		return false;
	}
}
