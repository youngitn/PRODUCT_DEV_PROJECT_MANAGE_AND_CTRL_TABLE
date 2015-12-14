package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.Rule;

//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/Rule/SubRuleThree
import java.util.Vector;

import jcx.db.talk;
import SomeUtils._bRule;

import com.ysk.util.Log;
import com.ysk.util.LogUtil;

/**
 * �߶��ޱ���l�y�{-�g��
 * 
 * @author YangTing
 *
 */
public class SubRuleThree extends _bRule {
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
		case 1:// ��P�g�� DEP_NO=100138 
			DEP_NO = "100138";
			break;
		case 2:// �k�W�g�� DEP_NO=100139 
			DEP_NO = "100139";
			break;
		case 3:// ���ʽҸg�� DEP_NO=100140 
			DEP_NO = "100140";
			break;
		case 4:// �s�{�o�i�g�� DEP_NO=100141 
			DEP_NO = "100141";
			break;
		case 5:// ��o�g�� DEP_NO=100142 
			DEP_NO = "100142";
			break;
		}
		signers = t.queryFromPool("select ID from HRUSER_DEPT where DEP_NO = '"+DEP_NO+"'");
		idVector.add(signers[0][0]);
		idVector.add("admin");
		return idVector;
	}
}
