package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

//com/ysk/PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE/DoUpdate;
import java.io.File;

import jcx.db.talk;
import SomeUtils._hproc;
import SomeUtils.Bean.ProductDevProjectTableBean;
import SomeUtils.DAO.ProductDevProjectTableDAO;

/**
 * 新增資料在此設計
 * 
 * @author b0050
 *
 */
public class DoUpdate extends _hproc {

	@Override
	public String action(String value) throws Throwable {
		talk t = getTalk();
		String pno = getValue("PNO");
		ProductDevProjectTableDAO dao = new ProductDevProjectTableDAO(t);

		ProductDevProjectTableBean bean = dao
				.getProductDevProjectTableBean(pno);

		File F1 = getUploadFile("SALES_ATTACHED");
		File F2 = getUploadFile("LAW_ATTACHED");
		File F3 = getUploadFile("PURCH_ATTACHED");
		File F4 = getUploadFile("PROCESS_ATTACHED");
		File F5 = getUploadFile("RD_ATTACHED");
		System.out.println("" + F1 + "");

		//bean.setPROJECT_NO(pNo);
		
		
		bean.setP_NAME(getValue("P_NAME").trim());
		bean.setDESCRIPTION(getValue("DESCRIPTION").trim());
		bean.setEXP_DATE(getValue("EXP_DATE").trim());
		bean.setGENERIC_CNAME(getValue("GENERIC_CNAME").trim());
		bean.setGENERIC_ENAME(getValue("GENERIC_ENAME").trim());
		bean.setDOSAGE_FORM(getValue("DOSAGE_FORM").trim());
		bean.setDOSE(getValue("DOSE").trim());
		bean.setPACKING(getValue("PACKING").trim());
		bean.setDEV_TYPE(getValue("DEV_TYPE").trim());
		bean.setMEDICINE_TYPE(getValue("MEDICINE_TYPE").trim());
		
		bean.setSALES_ATTACHED(""+F1+"");
		bean.setLAW_ATTACHED(""+F2+"");
		bean.setPURCH_ATTACHED(""+F3+"");
		bean.setPROCESS_ATTACHED(""+F4+"");
		bean.setRD_ATTACHED(""+F5+"");
		/*bean.setEXP_MATERIAL_ATTENDANCE_DATE(getValue("EXP_MATERIAL_ATTENDANCE_DATE").trim());
		bean.setEXP_SMALL_TEST_DATE(getValue("EXP_SMALL_TEST_DATE").trim());
		bean.setEXP_SMALL_TEST_END_DATE(getValue("EXP_SMALL_TEST_END_DATE").trim());
		bean.setEXP_MIDDLE_TEST_DATE(getValue("EXP_MIDDLE_TEST_DATE").trim());
		bean.setEXP_METHODOLOGY_BEGIN_DATE(getValue("EXP_METHODOLOGY_BEGIN_DATE").trim());
		bean.setEXP_STABILITY_SAMPLES_PLACED_DATE(getValue("EXP_STABILITY_SAMPLES_PLACED_DATE").trim());
		bean.setEXP_REPORTING_DATE(getValue("EXP_REPORTING_DATE").trim());
		bean.setPROJECT_STATUS(getValue("PROJECT_STATUS").trim());
		bean.setCLOSING_DATE(getValue("CLOSING_DATE").trim());
		bean.setREFERENCE_FILE_1("" + F1 + "");
		bean.setREFERENCE_FILE_2("" + F2 + "");
		bean.setREFERENCE_FILE_3("" + F3 + "");*/
		dao.update(bean);
		t.execFromPool("update PRODUCT_DEV_PROJECT_MAINTAIN set PTABLE_MAINTAIN = '1' where PNO = '"
				+ getValue("MAINTAIN_PNO").trim() + "'");
		t.close();
		addScript("document.location.reload(true)");
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}

}
