package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com/ysk/LAB_RECBOOK_USING_APPLY/QueryTableButton_SignHis;
import SomeUtils._bproc;

import com.ysk.service.SignFlowHistoryService;

/**
 * ���ñ�֬y�{���v.���@��椺���s.<br>
 * �Ω�emaker�]�p�Ҧ���,�i�J������,�w�]��.
 * @author b0050
 *
 */
public class QueryTableButton_SignHis extends _bproc {

	@Override
	public String getDefaultValue(String arg0) throws Throwable {

		String functionName = this.getFunctionName();
		SignFlowHistoryService service = new SignFlowHistoryService(this);
		String key = "a.PNO='" + getValue("QUERY_LIST.PNO") + "'";
		service.doDisplaySignFlowHistory(functionName, key);
		return null;

	}
}
