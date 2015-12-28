package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/QueryTableButton_SubSignHis;
import java.util.Vector;

import com.ysp.action.GetDepNameByEmpId;
import com.ysp.service.BaseService;

import jcx.db.talk;
import SomeUtils._bproc;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.Bean.UserInfoViewBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

/**
 * 用來在表格中做為按鈕,顯示詳細資料.<br>
 * 用於emaker設計模式中,進入表格欄位,預設值.
 * 
 * @author b0050
 *
 */
public class QueryTableButton_SubSignHis extends _bproc {

	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	public String getDefaultValue(String arg0) throws Throwable {
		talk t = getTalk();
		String msPno = getValue("QUERY_LIST.PNO").trim();
		// 0:id 1:name
		String[] empIdName = getValue("QUERY_LIST.REQ_EMPID").split("-");
		ProductDevProjectTableDAO pTableDAO = new ProductDevProjectTableDAO(
				getTalk());
		ProductDevProjectTableBean pbean = pTableDAO
				.getProductDevProjectTableBean(msPno);
		// TODO Auto-generated method stub
		// message(user.getEmpid());
		String ret[][] = t
				.queryFromPool("select MSATER_PNO,SUB_PNO,F_INP_STAT,MSATER_PNO from SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC WHERE MSATER_PNO = '"
						+ msPno + "'");
		for (String[] row : ret) {
			Vector<String> people = getApprovablePeople("產品立項研發管控表-相關單位簽核",
					"a.MSATER_PNO = '" + row[0] + "' and a.SUB_PNO = '"
							+ row[1] + "'");

			if (people.isEmpty()) {
				row[3] = "簽核完成";
			} else {
				String id = people.get(0).toString();
				UserInfoViewBean bean = getUserInfo(id);

				row[3] = id + "-" + getName(id) + "-" + bean.getDepName();
			}

		}

		if (ret.length == 0) {
			addScript("window.close();");
			message("尚無資料!");

		} else {
			setTableHeader("SUB_FLOW_STATE", new String[] { "主單單號", "子單單號",
					"目前關卡", "簽核人員" });
			setTableData("SUB_FLOW_STATE", ret);
		}

		return null;
	}

}
