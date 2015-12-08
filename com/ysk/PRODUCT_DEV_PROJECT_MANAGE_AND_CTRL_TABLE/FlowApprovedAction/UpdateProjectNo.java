package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;
//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/UpdateProjectNo
import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class UpdateProjectNo extends bProcFlow {
	/**
	 * ��y�{���d=�|�p�D�ޮ�,
	 * �}��M�׽s�����,�ç�s���Ʈw���C
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
