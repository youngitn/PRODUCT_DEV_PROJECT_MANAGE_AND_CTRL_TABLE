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
		//�R�����椧�e�p�G���ݩ�P�D�渹���l��u��1����,
		//��ܦۤv�O�̫�@�i,����D��ñ�֪��A��s.
		if (ret[0][0].equals("1")) {

			

			SimpleDateFormat sdFormat = new SimpleDateFormat(
					"yyyyMMdd HH:mm:ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			t.execFromPool("UPDATE PRODUCT_DEV_PROJECT_TABLE_FLOWC "
					+ " SET F_INP_STAT = '���_�y�L'"
					+ ",F_INP_TIME = '" + strDate + "'"
					+ ",F_INP_INFO = '�U�������Ҥw�hñ'"
					+ " WHERE PNO = '" + PNO + "'");

			t.execFromPool("INSERT INTO PRODUCT_DEV_PROJECT_TABLE_FLOWC_HIS"
					+ " (PNO ,F_INP_STAT , F_INP_ID , F_INP_TIME , F_INP_INFO)"
					+ " VALUES ('" + PNO + "' ,'���_�y�L','" + getUser() + "','" + strDate
					+ "','�U�������Ҥw�hñ')");
			/*****
			 * email �g�b��..........
			 */
			BaseService service = new BaseService();
			// ���o���_�y�Lñ�֤H 
			String toPeople[][] = t.queryFromPool("SELECT ID FROM HRUSER_DEPT WHERE DEP_NO = '100144'");
			String content = getState();
			String title = getState();
			String usr[] = {getEmail(toPeople[0][0])};

			String sendRS = service.sendMailbccUTF8(usr, title, content, null, "",
					"text/html");
			if (sendRS.trim().equals("")) {
				message("EMAIL�w�H�X�q��");
			} else {
				message("EMAIL�H�X����");
			}
		}
		addScript("location.reload();");
		return value;
	}

}
