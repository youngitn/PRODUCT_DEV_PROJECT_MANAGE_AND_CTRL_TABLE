package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE.FlowApprovedAction;

import java.text.SimpleDateFormat;
import java.util.Date;

import jcx.db.talk;
//com/ysk/SUB_PRODUCT_DEV_PROJECT_TABLE/FlowApprovedAction/SubFlowIsDone
import jcx.jform.bProcFlow;

public class SubFlowIsDone extends bProcFlow {

	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		String PNO = getValue("MSATER_PNO").trim();
		int check = 0;
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select F_INP_STAT from SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC "
						+ "where MSATER_PNO = '" + PNO + "'");

		for (String[] strings : ret) {
			if (!strings[0].equals("END")) {
				check++;
			}
		}
		System.out.println("------------------------" + check);
		if (check == 1) {
			SimpleDateFormat sdFormat = new SimpleDateFormat(
					"yyyyMMdd hh:mm:ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			t.execFromPool("UPDATE PRODUCT_DEV_PROJECT_TABLE_FLOWC "
					+ " SET F_INP_STAT = '挖寶尖兵確認' ,F_INP_TIME = '" + strDate
					+ "'" + " WHERE PNO = '" + PNO + "'");

			t.execFromPool("INSERT INTO PRODUCT_DEV_PROJECT_TABLE_FLOWC_HIS"
					+ " (PNO ,F_INP_STAT , F_INP_ID , F_INP_TIME , F_INP_INFO)"
					+ " VALUES ('" + PNO + "' ,'挖寶尖兵確認','各單位相關人員','" + strDate
					+ "','並行簽核流程')");
		}
		/*****
		 * email 寫在此..........
		 */
		return true;
	}

}
