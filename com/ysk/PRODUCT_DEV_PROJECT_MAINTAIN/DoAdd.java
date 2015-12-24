package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/DoAdd;
import java.io.File;

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

		String[][] field = { { "PROJECT_NO", "專案編號" },
				{ "MAINTAIN_TYPE", "異動類別" },

				{ "REQ_EMPID", "申請人" } };
		if (checkEmpty(field)) {
			//克服:使用DoInster處理檔案上傳
			//單純存字串會變成local位址C:XXXX...
			File F1 = getUploadFile("FF1");
			File F2 = getUploadFile("FF2");
			File F3 = getUploadFile("FF3");
			setValue("FF1", "" + F1 + "");
			setValue("FF2", "" + F2 + "");
			setValue("FF3", "" + F3 + "");

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
