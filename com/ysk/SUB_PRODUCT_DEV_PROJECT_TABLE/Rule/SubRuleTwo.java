package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.Rule;

//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/Rule/SubRuleTwo
import java.util.Vector;

import jcx.db.talk;
import SomeUtils._bRule;

import com.ysk.util.Log;
import com.ysk.util.LogUtil;

/**
 * 立項管控表子流程-相關單位主管2&相關單位主管2確認
 * 
 * @author YangTing
 *
 */
public class SubRuleTwo extends _bRule {
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
		case 1://行銷主管 DEP_NO=43 K00888
			DEP_NO = "43";
			break;
		case 2:// 產品法規 DEP_NO=16 K10636
			DEP_NO = "16";
			break;
		case 3:// 空白 跳簽
			return idVector;
		case 4:// 製程發展主管 DEP_NO=50 K10635
			DEP_NO = "50";
			break;
		case 5:// 研發課主管 DEP_NO=30 K08300
			DEP_NO = "30";
			break;
		}
		signers = t.queryFromPool("select DEP_CHIEF from HRUSER_DEPT_BAS where DEP_NO = '"+DEP_NO+"'");
		idVector.add("admin");
		idVector.add(signers[0][0]);
		
		return idVector;
	}
}
