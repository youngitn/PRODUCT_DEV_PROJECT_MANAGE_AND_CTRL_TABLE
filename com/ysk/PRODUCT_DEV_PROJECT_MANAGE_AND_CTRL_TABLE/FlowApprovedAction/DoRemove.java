package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE.FlowApprovedAction;

import SomeUtils._bProcFlow;

public class DoRemove extends _bProcFlow {

	@Override
	public boolean action(String arg0) throws Throwable {
		// TODO Auto-generated method stub
		del("PRODUCT_DEV_PROJECT_TABLE", getValue("PNO").trim());
		
		return false;
	}

}
