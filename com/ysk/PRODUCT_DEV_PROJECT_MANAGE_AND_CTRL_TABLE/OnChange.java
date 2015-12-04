package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

import org.apache.commons.lang.StringUtils;

import SomeUtils._hproc;
import SomeUtils.Bean.UserInfoViewBean;

/**
 * 當某個欄位變化時的事件處理.
 * 
 * @author b0050
 *
 */
public class OnChange extends _hproc {
	@SuppressWarnings("deprecation")
	@Override
	public String action(String value) throws Throwable {
		String queryEmpid = getValue(getName());
		if (!StringUtils.isEmpty(queryEmpid)) {
			UserInfoViewBean nowUser = getUserInfo(getValue(getName()));
			if (nowUser != null) {
				setValue("QUERY_REQ_EMPID_NAME", nowUser.getHecname());
				setValue("QUERY_REQ_DEPT_NAME", nowUser.getDepName());
			}

		} else {
			setValue("QUERY_REQ_EMPID_NAME", "");
			setValue("QUERY_REQ_DEPT_NAME", "");
		}

		return value;

	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}
