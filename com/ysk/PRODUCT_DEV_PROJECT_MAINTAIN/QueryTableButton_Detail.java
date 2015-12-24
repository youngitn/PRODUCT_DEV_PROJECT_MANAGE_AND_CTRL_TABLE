package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/QueryTableButton_Detail;
import jcx.db.talk;
import SomeUtils._bproc;
import SomeUtils.Bean.UserInfoViewBean;

/**
 * 用來在表格中做為按鈕,顯示詳細資料.<br>
 * 用於emaker設計模式中,進入表格欄位,預設值.
 * 
 * @author b0050
 *
 */
public class QueryTableButton_Detail extends _bproc {

	@SuppressWarnings({ "unused", "deprecation" })
	@Override
	public String getDefaultValue(String arg0) throws Throwable {
		// 0:id 1:name
		String[] empIdName = getValue("QUERY_LIST.REQ_EMPID").split("-");
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select * from PRODUCT_DEV_PROJECT_MAINTAIN where PNO = '"
						+ getValue("QUERY_LIST.PNO").trim() + "'");
		// TODO Auto-generated method stub
		// message(user.getEmpid());
		setValue("PNO", getValue("QUERY_LIST.PNO").trim());
		setValue("PROJECT_NO", ret[0][1].trim());
		setValue("MAINTAIN_DATE", ret[0][3].trim());
		setValue("MAINTAIN_TYPE", ret[0][4].trim());
		setValue("REQ_EMPID", ret[0][2].trim());
		UserInfoViewBean user = getUserInfo(ret[0][2].trim());
		setValue("REQ_EMPID_NAME", user.getHecname().trim());
		setValue("REQ_DEPT_NAME", user.getDepName().trim());
		setValue("FF1", ret[0][5].trim());
		setValue("FF2", ret[0][6].trim());
		setValue("FF3", ret[0][7].trim());
		setValue("PTABLE_MAINTAIN", ret[0][8].trim());
		setValue("PTIME_MAINTAIN", ret[0][9].trim());
		// QUERY SEND COMPUTE
		setVisible("DoAdd", false);
		ret = t.queryFromPool("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO = '"
				+ getValue("QUERY_LIST.PNO").trim() + "'");
		System.out
				.println("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO = '"
						+ getValue("PNO").trim() + "'");
		if (getValue("MAINTAIN_TYPE").trim().equals("1") && POSITION != 5
				&& ret[0][0].trim().equals(PRODUCT_DEV_PROJECT_MAINTAIN_FINAL_CONFIG.MAINTAIN_OK_STAT)) {

			setVisible("MAINTAIN_FINISH", true);

		}
		setEditable("MAINTAIN_TYPE", false);
		return null;
	}

}
