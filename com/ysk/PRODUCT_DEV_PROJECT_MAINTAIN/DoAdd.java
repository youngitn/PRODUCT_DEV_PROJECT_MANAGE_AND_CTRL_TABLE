package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/DoAdd;
import SomeUtils._hproc;

import com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.PRODUCT_DEV_PROJECT_TABLE_FINAL_CONFIG;
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

		String[][] field = { { "PROJECT_NO", "�M�׽s��" },
				{ "MAINTAIN_TYPE","�������O"},
			
				{ "REQ_EMPID", "�ӽФH" }
				};
		if (checkEmpty(field)) {
			DoInster("PRODUCT_DEV_PROJECT_MAINTAIN", "�ҥD��");
			sendEmailAfterAdd(getValue("REQ_EMPID").trim(), "SUB:�ҥD��",
					"���e:�ҥD��", null, "", Flow.FLOW_SING_LEVEL_11);
		}
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
