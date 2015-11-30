package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com/ysk/LAB_RECBOOK_USING_APPLY/QueryTableButton_Detail;
import SomeUtils._bproc;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.Bean.UserInfoViewBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

/**
 * 用來在表格中做為按鈕,顯示詳細資料.<br>
 * 用於emaker設計模式中,進入表格欄位,預設值.
 * @author b0050
 *
 */
public class QueryTableButton_Detail extends _bproc {

	@Override
	public String getDefaultValue(String arg0) throws Throwable {
		// 0:id 1:name
		String[] empIdName = getValue("QUERY_LIST.REQ_EMPID").split("-");
		ProductDevProjectTableDAO pTableDAO = new ProductDevProjectTableDAO(getTalk());
		ProductDevProjectTableBean pbean = pTableDAO.getProductDevProjectTableBean(getValue("QUERY_LIST.PNO").trim());
		// TODO Auto-generated method stub
		//message(user.getEmpid());
		setValue("PNO", getValue("QUERY_LIST.PNO").trim());
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
		setValue("MEDICINE_TYPE",pbean.getMEDICINE_TYPE().trim());
		setValue("SALES_ATTACHED", pbean.getSALES_ATTACHED().trim());
		setValue("LAW_ATTACHED", pbean.getLAW_ATTACHED().trim());
		setValue("PURCH_ATTACHED", pbean.getPURCH_ATTACHED().trim());
		setValue("PROCESS_ATTACHED", pbean.getPROCESS_ATTACHED().trim());
		setValue("RD_ATTACHED", pbean.getRD_ATTACHED().trim());
		setValue("IS_APPROVE", pbean.getIS_APPROVE().trim());
		setValue("PROJECT_NO", pbean.getPROJECT_NO().trim());
		setValue("REQ_EMPID", pbean.getREQ_EMPID().trim());
		UserInfoViewBean user = getUserInfo(pbean.getREQ_EMPID().trim());
		setValue("REQ_EMPID_NAME",user.getHecname().trim());
		setValue("REQ_DEPT_NAME",user.getDepName().trim());
		// QUERY SEND COMPUTE
		setVisible("DoAdd",false);
		return null;
	}

	
}
