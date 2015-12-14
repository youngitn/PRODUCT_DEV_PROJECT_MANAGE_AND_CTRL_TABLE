package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.FlowApprovedAction;

//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/FlowApprovedAction/UpdateAttached
import java.io.File;

import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class UpdateAttached extends bProcFlow {
	/**
	 * ��y�{���d=��o�g���, �}���o�M�Χ������,�ç�s���Ʈw���C
	 */
	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		String pno = getValue("MSATER_PNO");
		ProductDevProjectTableDAO dao = new ProductDevProjectTableDAO(getTalk());

		ProductDevProjectTableBean bean = dao
				.getProductDevProjectTableBean(pno);
		String attNameString = null;
		
		switch (Integer.parseInt(getValue("DEPT_FLAG").trim())) {
		case 1:
			attNameString = "SALES_ATTACHED";
			break;
		case 2:
			attNameString = "LAW_ATTACHED";
			break;
		case 3:
			attNameString = "PURCH_ATTACHED";
			break;
		case 4:
			attNameString = "PROCESS_ATTACHED";
			break;
		case 5:
			attNameString = "RD_ATTACHED";
			break;
		}
		if (getValue(attNameString).trim().length() != 0) {

			File F1 = getUploadFile(attNameString);
			bean.setRD_ATTACHED("" + F1 + "");
			dao.update(bean);
			dao = null;
		}
		return true;
	}

}
