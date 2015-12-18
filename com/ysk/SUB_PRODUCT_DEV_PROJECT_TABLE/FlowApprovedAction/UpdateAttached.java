package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.FlowApprovedAction;

//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/FlowApprovedAction/UpdateAttached
import java.io.File;

import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class UpdateAttached extends bProcFlow {
	/**
	 * 當流程關卡=研發經辦時, 開放研發專用夾檔欄位,並更新到資料庫中。
	 */
	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
			String pno = getValue("MSATER_PNO");
			ProductDevProjectTableDAO dao = new ProductDevProjectTableDAO(getTalk());

			ProductDevProjectTableBean bean = dao
					.getProductDevProjectTableBean(pno);
			String attNameString = null;
			File F1 = null;
			switch (Integer.parseInt(getValue("DEPT_FLAG").trim())) {
			case 1:
				attNameString = "SALES_ATTACHED";
				F1 = getUploadFile(attNameString);
				bean.setSALES_ATTACHED("" + F1 + "");
				break;
			case 2:
				attNameString = "LAW_ATTACHED";
				F1 = getUploadFile(attNameString);
				bean.setLAW_ATTACHED("" + F1 + "");
				break;
			case 3:
				attNameString = "PURCH_ATTACHED";
				F1 = getUploadFile(attNameString);
				bean.setPURCH_ATTACHED("" + F1 + "");
				break;
			case 4:
				attNameString = "PROCESS_ATTACHED";
				F1 = getUploadFile(attNameString);
				bean.setPROCESS_ATTACHED("" + F1 + "");
				break;
			case 5:
				attNameString = "RD_ATTACHED";
				F1 = getUploadFile(attNameString);
				bean.setRD_ATTACHED("" + F1 + "");
				break;
			}		
				dao.update(bean);
				dao = null;

		
		return true;
	}

}
