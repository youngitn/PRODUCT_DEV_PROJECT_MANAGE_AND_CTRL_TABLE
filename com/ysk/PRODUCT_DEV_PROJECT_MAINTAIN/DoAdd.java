package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/DoAdd;
import SomeUtils._hproc;

import com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.PRODUCT_DEV_PROJECT_TABLE_FINAL_CONFIG;
import com.ysk.field.Flow;

/**
 * 新增資料在此設計
 * 
 * @author b0050
 *
 */
public class DoAdd extends _hproc {

	@Override
	public String action(String value) throws Throwable {

		String[][] field = { { "PROJECT_NO", "專案編號" },
				{ "MAINTAIN_TYPE","異動類別"},
			
				{ "REQ_EMPID", "申請人" }
				};
		if (checkEmpty(field)) {
			DoInster("PRODUCT_DEV_PROJECT_MAINTAIN", "課主管");
			sendEmailAfterAdd(getValue("REQ_EMPID").trim(), "SUB:課主管",
					"內容:課主管", null, "", Flow.FLOW_SING_LEVEL_11);
		}
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
