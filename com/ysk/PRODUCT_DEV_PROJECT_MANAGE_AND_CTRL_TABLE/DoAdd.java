package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//import com.ysk.bean.UserInfoViewBean;
import SomeUtils._hproc;

import com.ysk.field.Flow;

/**
 * ·s¼W¸ê®Æ¦b¦¹³]­p
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {
	String nowTable = "LAB_RECBOOK_USING_APPLY";

	@Override
	public String action(String value) throws Throwable {
		
		String[][] field = { 				
				{ "RECBOOK_NAME", "PNO", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "DATE", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "P_NAME", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "DESCRIPTION", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "EXP_DATE", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "GENERIC_CNAME", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "GENERIC_ENAME", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "DOSAGE_FORM", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "DOSE", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "PACKING", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "DEV_TYPE", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "MEDICINE_TYPE", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "SALES_ATTACHED", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "LAW_ATTACHED", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "PURCH_ATTACHED", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "PROCESS_ATTACHED", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "RD_ATTACHED", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "IS_APPROVE", "¬ö¿ýÃ¯¦WºÙ" },
				{ "RECBOOK_NAME", "PROJECT_NO", "¬ö¿ýÃ¯¦WºÙ" }
		
		};
		String condition =" REQ_EMPID = '"+getValue("REQ_EMPID").trim()+"' and REC_START_DATE >= '" + getValue("REC_START_DATE").trim()
				+ "'";
		String[][] ret = selectFromWhere("PNO", nowTable, condition);
		if (checkEmpty(field)) {
			if (ret.length == 0) {
				DoInster(nowTable, "½Ò¥DºÞ");
				sendEmailAfterAdd(getValue("REQ_EMPID").trim(),"SUB:½Ò¥DºÞ","¤º®e:½Ò¥DºÞ",null,"",Flow.FLOW_SING_LEVEL_11);
			}
		}
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
