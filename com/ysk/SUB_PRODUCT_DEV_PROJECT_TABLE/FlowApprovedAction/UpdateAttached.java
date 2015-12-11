package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.FlowApprovedAction;

//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/FlowApprovedAction/UpdateAttached
import java.io.File;

import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class UpdateAttached extends bProcFlow {
	/**
	 * 當流程關卡=研發經辦時,
	 * 開放研發專用夾檔欄位,並更新到資料庫中。
	 */
	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		String pno = getValue("PNO");
		ProductDevProjectTableDAO dao = new ProductDevProjectTableDAO(getTalk());

		ProductDevProjectTableBean bean = dao
				.getProductDevProjectTableBean(pno);

		if (getValue("RD_ATTACHED").trim().length() != 0) {

			File F1 = getUploadFile("RD_ATTACHED");
			bean.setRD_ATTACHED("" + F1 + "");
			dao.update(bean);
			dao = null;
			return true;
		}
		return false;
	}

}
