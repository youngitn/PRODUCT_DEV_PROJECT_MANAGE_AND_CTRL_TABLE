package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

import com.ysk.field.Flow;

/**
 * �s�W��Ʀb���]�p
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {
	String nowTable = "LAB_RECBOOK_USING_APPLY";

	@Override
	public String action(String value) throws Throwable {
		
		String[][] field = { 				
				{ "RECBOOK_NAME", "PNO", "����ï�W��" },
				{ "RECBOOK_NAME", "DATE", "����ï�W��" },
				{ "RECBOOK_NAME", "P_NAME", "����ï�W��" },
				{ "RECBOOK_NAME", "DESCRIPTION", "����ï�W��" },
				{ "RECBOOK_NAME", "EXP_DATE", "����ï�W��" },
				{ "RECBOOK_NAME", "GENERIC_CNAME", "����ï�W��" },
				{ "RECBOOK_NAME", "GENERIC_ENAME", "����ï�W��" },
				{ "RECBOOK_NAME", "DOSAGE_FORM", "����ï�W��" },
				{ "RECBOOK_NAME", "DOSE", "����ï�W��" },
				{ "RECBOOK_NAME", "PACKING", "����ï�W��" },
				{ "RECBOOK_NAME", "DEV_TYPE", "����ï�W��" },
				{ "RECBOOK_NAME", "MEDICINE_TYPE", "����ï�W��" },
				{ "RECBOOK_NAME", "SALES_ATTACHED", "����ï�W��" },
				{ "RECBOOK_NAME", "LAW_ATTACHED", "����ï�W��" },
				{ "RECBOOK_NAME", "PURCH_ATTACHED", "����ï�W��" },
				{ "RECBOOK_NAME", "PROCESS_ATTACHED", "����ï�W��" },
				{ "RECBOOK_NAME", "RD_ATTACHED", "����ï�W��" },
				{ "RECBOOK_NAME", "IS_APPROVE", "����ï�W��" },
				{ "RECBOOK_NAME", "PROJECT_NO", "����ï�W��" }
		
		};
		String condition =" REQ_EMPID = '"+getValue("REQ_EMPID").trim()+"' and REC_START_DATE >= '" + getValue("REC_START_DATE").trim()
				+ "'";
		String[][] ret = selectFromWhere("PNO", nowTable, condition);
		if (checkEmpty(field)) {
			if (ret.length == 0) {
				DoInster(nowTable, "�ҥD��");
				sendEmailAfterAdd(getValue("REQ_EMPID").trim(),"SUB:�ҥD��","���e:�ҥD��",null,"",Flow.FLOW_SING_LEVEL_11);
			}
		}
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
