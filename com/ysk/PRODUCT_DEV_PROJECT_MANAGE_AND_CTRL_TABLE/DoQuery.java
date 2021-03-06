package com.ysk.PRODUCT_DEV_PROJECT_MANAGE_AND_CTRL_TABLE;

import java.util.ArrayList;

import SomeUtils._hproc;
import SomeUtils.Bean.QueryItem;

/**
 * 執行查詢的動作在此設計
 * 
 * @author b0050
 *
 */
public class DoQuery extends _hproc {

	@Override
	public String action(String value) throws Throwable {
		// 建立table header,與設計模式的表格欄位順序一致.
		ArrayList<QueryItem> list = new ArrayList<QueryItem>();

		// PNO必須第一個
		list.add(new QueryItem("PNO", "申請單號", 1));// 0 不做為查詢條件來源
		list.add(new QueryItem("REQ_EMPID", "申請人員編", 1));
		list.add(new QueryItem("DATE", "申請日期", 2));
		list.add(new QueryItem("PROJECT_NO", "專案編號", 1));

		/**
		 * 以下開始為非主檔資料表資料. 查詢簽核狀態的SQL指令 直接用字串參數丟進去做為DB欄位名稱,"簽核狀態"為 table
		 * header,0表示在setQueryTable中不做為查詢條件.
		 */
		
		list.add(new QueryItem(
				"(select F_INP_STAT from LAB_RECBOOK_USING_APPLY_FLOWC where PNO=a.PNO)",
				"簽核狀態", 0));
		list.add(new QueryItem("'簽核紀錄'", "簽核紀錄", 0));
		list.add(new QueryItem("'詳細資訊'", "詳細資訊", 0));
		list.add(new QueryItem("'相關單位簽核紀錄'", "相關單位簽核紀錄", 0));
		list.add(new QueryItem("'建立'", "管控時間檔", 0));
		list.add(new QueryItem("P_NAME", "品項名稱", 1));
		list.add(new QueryItem("IS_APPROVE", "是否立項", 1));
		list.add(new QueryItem("MEDICINE_TYPE", "藥品分類", 1));
		list.add(new QueryItem("EXP_DATE", "預定完成日期", 2));
		list.add(new QueryItem("DEV_TYPE","開發類型", 1));
		/**
		 * 參數 1,4 代表
		 * LIST當中的元素位置,會使用到含"員工編號"&"簽核狀態"的元素,各位於list第1和第4的位置.(ArrayList從0開始算)
		 * 
		 * 參數 otherConditionString 額外的查詢條件 .
		 */
		setQueryTable(list, PRODUCT_DEV_PROJECT_TABLE_FINAL_CONFIG.USING_TABLE,
				"營銷-研發產品立項研發管控表", 1, 4, "");
		list.clear();
		return value;
	}

	public String getInformation() {
		return "---------------DO_QUERY(\u9001\u51fa\u67e5\u8a62).html_action()----------------";
	}
}