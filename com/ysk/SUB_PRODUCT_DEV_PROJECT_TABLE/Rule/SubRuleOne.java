package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.Rule;

//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/Rule/SubRuleOne
import java.util.Vector;

import jcx.db.talk;
import SomeUtils._bRule;

import com.ysk.util.Log;
import com.ysk.util.LogUtil;

/**
 * 立項管控表子流程-相關單位主管&相關單位主管確認
 * 
 * @author YangTing
 *
 */
public class SubRuleOne extends _bRule {
	Log log = LogUtil.getLog(this.getClass());

	@Override
	public Vector<String> getIDs(String arg0) throws Throwable {

		Vector<String> idVector = new Vector<String>();
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select DEPT_FLAG from SUB_PRODUCT_DEV_PROJECT_TABLE where MSATER_PNO = '"
						+ getData("MSATER_PNO").trim()
						+ "' and  SUB_PNO = '"
						+ getData("SUB_PNO").trim() + "'");

		String DEP_NO = null;
		String signers[][] = null;
		switch (Integer.parseInt(ret[0][0])) {
		case 1:// 營業主管 DEP_NO=15 K00888
			DEP_NO = "15";
			break;
		case 2:// 質量主管 DEP_NO=11 K10321
			DEP_NO = "11";
			break;
		case 3:// 採購課主管 DEP_NO=33 K05544
			DEP_NO = "33";
			break;
		case 4:// 作業處主管 DEP_NO=12 K10530
			DEP_NO = "12";
			break;
		case 5:// 研發處主管 DEP_NO=13 K10615
			DEP_NO = "13";
			break;
		}
		signers = t.queryFromPool("select DEP_CHIEF from HRUSER_DEPT_BAS where DEP_NO = '"+DEP_NO+"'");
		idVector.add(signers[0][0]);
		idVector.add("admin");
		return idVector;
	}
}
