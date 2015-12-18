package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/FlowApprovedAction/SubFlowBegin
import java.util.ArrayList;

import jcx.db.talk;
import jcx.jform.bProcFlow;
import SomeUtils.Bean.SubProductDevProjectTableBean;
import SomeUtils.DAO.SubProductDevProjectTableDAO;

import com.ysk.service.BaseService;

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
			blist.add(new SubProductDevProjectTableBean(Integer.toString(i),
					MSATER_PNO));
			t.execFromPool("");
		}

		sDao.add(blist);

		// 取得子流程第一關的簽核人 
		String toPeople[][] = t
				.queryFromPool("select DEP_CHIEF from HRUSER_DEPT_BAS "
						+ " where " + " DEP_NO = '15' or "
						+ " DEP_NO = '11' or " + " DEP_NO = '33' or "
						+ " DEP_NO = '12' or " + " DEP_NO = '13'");

		BaseService service = new BaseService();

		String content = getState();
		String title = getState();
		System.out.println("OA311----------"+toPeople[0][0]+toPeople[1][0]+toPeople[2][0]+toPeople[3][0]+toPeople[4][0]);
		String usr[] = { 
				getEmail(toPeople[0][0]), 
				getEmail(toPeople[1][0]),
				getEmail(toPeople[2][0]), 
				getEmail(toPeople[3][0]),
				getEmail(toPeople[4][0]) };

		String sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
				"text/html");
		if (sendRS.trim().equals("")) {
			message("EMAIL已寄出通知");
		} else {
			message("EMAIL寄出失敗");
		}
		return true;
	}

}
