package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/DoAdd;
import SomeUtils._hproc;

import com.ysk.field.Flow;

/**
 * �s�W��Ʀb���]�p
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {


	@Override
	public String action(String value) throws Throwable {
		
		String[][] field = { 				
				{"P_NAME", "�~���W��" },
				{"DESCRIPTION", "����" },
				{"EXP_DATE", "�w�w�������" },
				{"GENERIC_CNAME", "�ī~�q�ΦW��" },
				{"GENERIC_ENAME", "�ī~�^��W��" },
				{"DOSAGE_FORM", "����" },
				{"DOSE", "���q" },
				{"PACKING", "�]�˳W��" },
				{"DEV_TYPE", "�}�o����" },
				{"MEDICINE_TYPE", "�ī~����" },

		};
		if (checkEmpty(field)) {		
			DoInster(PRODUCT_DEV_PROJECT_TABLE_FINAL_CONFIG.USING_TABLE, "�ҥD��");
			sendEmailAfterAdd(getValue("REQ_EMPID").trim(),"SUB:�ҥD��","���e:�ҥD��",null,"",Flow.FLOW_SING_LEVEL_11);		
		}
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
