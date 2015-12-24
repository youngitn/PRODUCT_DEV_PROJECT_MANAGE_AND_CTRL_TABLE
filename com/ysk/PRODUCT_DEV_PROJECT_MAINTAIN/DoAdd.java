package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com/ysk/PRODUCT_DEV_PROJECT_MAINTAIN/DoAdd;
import java.io.File;

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

		String[][] field = { { "PROJECT_NO", "�M�׽s��" },
				{ "MAINTAIN_TYPE", "�������O" },

				{ "REQ_EMPID", "�ӽФH" } };
		if (checkEmpty(field)) {
			//�J�A:�ϥ�DoInster�B�z�ɮפW��
			//��¦s�r��|�ܦ�local��}C:XXXX...
			File F1 = getUploadFile("FF1");
			File F2 = getUploadFile("FF2");
			File F3 = getUploadFile("FF3");
			setValue("FF1", "" + F1 + "");
			setValue("FF2", "" + F2 + "");
			setValue("FF3", "" + F3 + "");

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
