package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/DoAdd;
import SomeUtils._hproc;

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
		
		String[][] field = { 				
				{"P_NAME", "品項名稱" },
				{"DESCRIPTION", "說明" },
				{"EXP_DATE", "預定完成日期" },
				{"GENERIC_CNAME", "藥品通用名稱" },
				{"GENERIC_ENAME", "藥品英文名稱" },
				{"DOSAGE_FORM", "劑型" },
				{"DOSE", "劑量" },
				{"PACKING", "包裝規格" },
				{"DEV_TYPE", "開發類型" },
				{"MEDICINE_TYPE", "藥品分類" },

		};
		if (checkEmpty(field)) {		
			DoInster(PRODUCT_DEV_PROJECT_TABLE_FINAL_CONFIG.USING_TABLE, "課主管");
			sendEmailAfterAdd(getValue("REQ_EMPID").trim(),"SUB:課主管","內容:課主管",null,"",Flow.FLOW_SING_LEVEL_11);		
		}
		return value;
	}

	

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
