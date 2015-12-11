package com.ysk.SUB_PRODUCT_DEV_PROJECT_TABLE;
//com\ysk\SUB_PRODUCT_DEV_PROJECT_TABLE\Init
import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.Bean.UserInfoViewBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class Init extends _hproc {

	@Override
	public String action(String paramString) throws Throwable {

		String PNO = getValue("MSATER_PNO").trim();
		ProductDevProjectTableDAO pTableDAO = new ProductDevProjectTableDAO(
				getTalk());
		ProductDevProjectTableBean pbean = pTableDAO
				.getProductDevProjectTableBean(PNO);

		// TODO Auto-generated method stub
		// message(user.getEmpid());
		setValue("DATE", pbean.getDATE().trim());
		setValue("P_NAME", pbean.getP_NAME().trim());
		setValue("DESCRIPTION", pbean.getDESCRIPTION().trim());
		setValue("EXP_DATE", pbean.getEXP_DATE().trim());
		setValue("GENERIC_CNAME", pbean.getGENERIC_CNAME().trim());
		setValue("GENERIC_ENAME", pbean.getGENERIC_ENAME().trim());
		setValue("DOSAGE_FORM", pbean.getDOSAGE_FORM().trim());
		setValue("DOSE", pbean.getDOSE().trim());
		setValue("PACKING", pbean.getPACKING().trim());
		setValue("DEV_TYPE", pbean.getDEV_TYPE().trim());
		setValue("MEDICINE_TYPE", pbean.getMEDICINE_TYPE().trim());
		setValue("SALES_ATTACHED", pbean.getSALES_ATTACHED().trim());
		setValue("LAW_ATTACHED", pbean.getLAW_ATTACHED().trim());
		setValue("PURCH_ATTACHED", pbean.getPURCH_ATTACHED().trim());
		setValue("PROCESS_ATTACHED", pbean.getPROCESS_ATTACHED().trim());
		setValue("RD_ATTACHED", pbean.getRD_ATTACHED().trim());
		setValue("IS_APPROVE", pbean.getIS_APPROVE().trim());
		setValue("PROJECT_NO", pbean.getPROJECT_NO().trim());
		setValue("REQ_EMPID", pbean.getREQ_EMPID().trim());
		UserInfoViewBean user = getUserInfo(pbean.getREQ_EMPID().trim());
		setValue("REQ_EMPID_NAME", user.getHecname().trim());
		setValue("REQ_DEPT_NAME", user.getDepName().trim());

		return paramString;

	}
}
