package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/SubFlowBegin
import jcx.jform.bProcFlow;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;
/**
 * 程式起單.
 * 新增5筆資料 in SUB_PRODUCT_DEV_PROJECT_TABLE.
 * 並設定簽核狀態  in SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC.
 * @author YangTing
 *
 */
public class SubFlowBegin extends bProcFlow {
	/**
	 * 當流程關卡=會計主管時, 開放專案編號欄位,並更新到資料庫中。
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
		message("專案編號欄位必須輸入!");
		return false;
	}
}
