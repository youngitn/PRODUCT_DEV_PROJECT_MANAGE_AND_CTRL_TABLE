package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;
//com\ysk\PRODUCT_DEV_PROJECT_MAINTAIN\Init
import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.Bean.UserInfoViewBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class Init extends _hproc {

	@SuppressWarnings("deprecation")
	@Override
	public String action(String paramString) throws Throwable {

		String PROJECT_NO = getValue("PROJECT_NO").trim();
		
		if (PROJECT_NO.length() == 0){
			addScript("window.close();");
			message("專案編號不可空白!");
		}
		ProductDevProjectTableDAO pTableDAO = new ProductDevProjectTableDAO(
				getTalk());
		ProductDevProjectTableBean pbean = pTableDAO
				.getProductDevProjectTableBeanByProjectNo(PROJECT_NO);

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
		
		if (POSITION == 5 && getState().trim().equals("經辦")){
		
			switch (Integer.parseInt(getValue("DEPT_FLAG"))) {
			case 1://行銷 
				setEditable("SALES_ATTACHED", true);
				break;
			case 2://法規 
				setEditable("LAW_ATTACHED", true);
				break;
			case 3://採購
				setEditable("PURCH_ATTACHED", true);
				break;
			case 4:// 製程發展
				setEditable("PROCESS_ATTACHED", true);
				break;
			case 5:// 研發
				setEditable("RD_ATTACHED", true);
				break;
			}
		}
		if (POSITION == 5 && getState().trim().equals("相關單位主管")){
			setVisible("BACK_TO_MAIN_FLOW", true);
			setEditable("BACK_TO_MAIN_FLOW", true);
		}
		
		
		return paramString;

	}
}
