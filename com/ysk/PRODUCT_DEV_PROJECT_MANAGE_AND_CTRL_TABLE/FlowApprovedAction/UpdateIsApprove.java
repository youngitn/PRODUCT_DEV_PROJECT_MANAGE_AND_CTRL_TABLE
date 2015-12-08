package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;
//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/UpdateIsApprove
import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class UpdateIsApprove  extends bProcFlow {

	/**
	 * 當流程關卡=挖寶尖兵確認時,
	 * 開放是否立項欄位,並更新到資料庫。
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
		message("是否立項欄位必須核選!");
		return false;
	}

}
