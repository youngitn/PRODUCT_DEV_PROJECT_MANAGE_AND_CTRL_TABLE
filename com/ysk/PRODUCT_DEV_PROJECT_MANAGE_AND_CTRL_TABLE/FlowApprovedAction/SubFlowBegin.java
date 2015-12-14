package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/SubFlowBegin
import java.util.ArrayList;

import jcx.db.talk;
import jcx.jform.bProcFlow;
import SomeUtils.Bean.SubProductDevProjectTableBean;
import SomeUtils.DAO.SubProductDevProjectTableDAO;

/**
 * 程式起單. 新增5筆資料 in SUB_PRODUCT_DEV_PROJECT_TABLE. 並設定簽核狀態 in
 * SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC.
 * 
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
		// 取得主單單號
		talk t = getTalk();
		String MSATER_PNO = getValue("PNO").trim();
		SubProductDevProjectTableDAO sDao = new SubProductDevProjectTableDAO(t);
		ArrayList<SubProductDevProjectTableBean> blist = new ArrayList<SubProductDevProjectTableBean>();

		// 起5張子單,分別跑營業 質量 採購 作業 研發等部門 .
		for (int i = 1; i <= 5; i++) {
			blist.add(new SubProductDevProjectTableBean(Integer.toString(i), MSATER_PNO));
			t.execFromPool("");
		}	

		sDao.add(blist);
		return true;
	}
	
}
