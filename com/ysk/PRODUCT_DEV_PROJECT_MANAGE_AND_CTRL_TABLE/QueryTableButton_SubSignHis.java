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
 * �ΨӦb��椤�������s,��ܸԲӸ��.<br>
 * �Ω�emaker�]�p�Ҧ���,�i�J������,�w�]��.
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
			Vector<String> people = getApprovablePeople("���~�߶���o�ޱ���-�������ñ��",
					"a.MSATER_PNO = '" + row[0] + "' and a.SUB_PNO = '"
							+ row[1] + "'");

			if (people.isEmpty()) {
				row[3] = "ñ�֧���";
			} else {
				String id = people.get(0).toString();
				UserInfoViewBean bean = getUserInfo(id);

				row[3] = id + "-" + getName(id) + "-" + bean.getDepName();
			}

		}

		if (ret.length == 0) {
			addScript("window.close();");
			message("�|�L���!");

		} else {
			setTableHeader("SUB_FLOW_STATE", new String[] { "�D��渹", "�l��渹",
					"�ثe���d", "ñ�֤H��" });
			setTableData("SUB_FLOW_STATE", ret);
		}

		return null;
	}

}
