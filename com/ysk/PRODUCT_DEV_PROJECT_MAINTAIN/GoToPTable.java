package com.ysk.PRODUCT_DEV_PROJECT_MAINTAIN;

//com\ysk\PRODUCT_DEV_PROJECT_MAINTAIN\GoToPTable
import jcx.db.talk;
import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.Bean.UserInfoViewBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

public class GoToPTable extends _hproc {

	@SuppressWarnings("deprecation")
	@Override
	public String action(String paramString) throws Throwable {

		String PROJECT_NO = getValue("PROJECT_NO").trim();
		//���omaintain��PNO
		String PNO = getValue("PNO").trim();
		String PTABLE_MAINTAIN = getValue("PTABLE_MAINTAIN").trim();
		System.out.println("PTABLE_MAINTAIN= "+PTABLE_MAINTAIN);
		if (PROJECT_NO.length() == 0) {
			addScript("window.close();");
			message("�M�׽s�����i�ť�!");
		}
		ProductDevProjectTableDAO pTableDAO = new ProductDevProjectTableDAO(
				getTalk());
		ProductDevProjectTableBean pbean = pTableDAO
				.getProductDevProjectTableBeanByProjectNo(PROJECT_NO);

		// TODO Auto-generated method stub
		// message(user.getEmpid());
		setValue("PNO", pbean.getPNO().trim());
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
		setValue("MAINTAIN_PNO", PNO);

		/*
		 * if (POSITION == 5 && getState().trim().equals("�g��")){
		 * 
		 * switch (Integer.parseInt(getValue("DEPT_FLAG"))) { case 1://��P
		 * setEditable("SALES_ATTACHED", true); break; case 2://�k�W
		 * setEditable("LAW_ATTACHED", true); break; case 3://����
		 * setEditable("PURCH_ATTACHED", true); break; case 4:// �s�{�o�i
		 * setEditable("PROCESS_ATTACHED", true); break; case 5:// ��o
		 * setEditable("RD_ATTACHED", true); break; } }
		 */

		/**
		 * �p�G���������O1 �i�ק�s,�B���bñ�֬y�{���A�� �Bñ�֪��A�O�w�k��.....
		 */
		talk t = getTalk();
		String ret[][] = t
				.queryFromPool("select F_INP_STAT from PRODUCT_DEV_PROJECT_MAINTAIN_FLOWC where PNO='"
						+ PNO + "'");
		
		if (getValue("MAINTAIN_TYPE").trim().equals("1") 
				&& POSITION != 5
				&& ret[0][0].trim().equals(PRODUCT_DEV_PROJECT_MAINTAIN_FINAL_CONFIG.MAINTAIN_OK_STAT)) {
			
			setEditable("SALES_ATTACHED", true);
			setEditable("LAW_ATTACHED", true);
			setEditable("PURCH_ATTACHED", true);
			setEditable("PROCESS_ATTACHED", true);
			setEditable("RD_ATTACHED", true);
			setVisible("DO_UPDATE", true);
		}
		if (!"".equals(PTABLE_MAINTAIN)) {
			setVisible("DO_UPDATE", false);
		}

		return paramString;

	}
}
