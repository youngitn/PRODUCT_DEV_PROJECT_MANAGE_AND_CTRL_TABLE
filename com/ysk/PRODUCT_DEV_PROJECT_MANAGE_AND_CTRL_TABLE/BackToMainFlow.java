package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;
//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/BackToMainFlow
import java.text.SimpleDateFormat;
import java.util.Date;

import jcx.db.talk;
import SomeUtils._hproc;

import com.ysk.service.BaseService;

public class BackToMainFlow extends  _hproc {
	@Override
	public String action(String value) throws Throwable {
		// TODO Auto-generated method stub
		String PNO = getValue("MSATER_PNO").trim();
		String SUB_PNO = getValue("SUB_PNO");
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select count(*) from SUB_PRODUCT_DEV_PROJECT_TABLE "
						+ "where MSATER_PNO = '" + PNO + "'");
		
		t.execFromPool("DELETE FROM SUB_PRODUCT_DEV_PROJECT_TABLE WHERE MSATER_PNO = '"
				+ PNO + "' and SUB_PNO = '" + SUB_PNO + "';");
		t.execFromPool("DELETE FROM SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC WHERE MSATER_PNO = '"
				+ PNO + "' and SUB_PNO = '" + SUB_PNO + "';");
		t.execFromPool("DELETE FROM SUB_PRODUCT_DEV_PROJECT_TABLE_FLOWC_HIS WHERE MSATER_PNO = '"
				+ PNO + "' and SUB_PNO = '" + SUB_PNO + "';");
		//刪除本單之前如果隸屬於同主單號的子單只剩1的話,
		//表示自己是最後一張,執行主單簽核狀態更新.
		if (ret[0][0].equals("1")) {

			

			SimpleDateFormat sdFormat = new SimpleDateFormat(
					"yyyyMMdd HH:mm:ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			t.execFromPool("UPDATE PRODUCT_DEV_PROJECT_TABLE_FLOWC "
					+ " SET F_INP_STAT = '挖寶尖兵'"
					+ ",F_INP_TIME = '" + strDate + "'"
					+ ",F_INP_INFO = '各相關單位皆已退簽'"
					+ " WHERE PNO = '" + PNO + "'");

			t.execFromPool("INSERT INTO PRODUCT_DEV_PROJECT_TABLE_FLOWC_HIS"
					+ " (PNO ,F_INP_STAT , F_INP_ID , F_INP_TIME , F_INP_INFO)"
					+ " VALUES ('" + PNO + "' ,'挖寶尖兵','" + getUser() + "','" + strDate
					+ "','各相關單位皆已退簽')");
			/*****
			 * email 寫在此..........
			 */
			BaseService service = new BaseService();
			// 取得挖寶尖兵簽核人 
			String toPeople[][] = t.queryFromPool("SELECT ID FROM HRUSER_DEPT WHERE DEP_NO = '100144'");
			String content = getState();
			String title = getState();
			String usr[] = {getEmail(toPeople[0][0])};

			String sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
					"text/html");
			if (sendRS.trim().equals("")) {
				message("EMAIL已寄出通知");
			} else {
				message("EMAIL寄出失敗");
			}
		}
		addScript("location.reload();");
		return value;
	}

}
