package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_maintain extends _bProcFlow {
	String tablename = "FQ_INSTRUMENT_DETAIL";

	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		String get_table_data[][] = getTableData("table1");
		// 檢查table內是否有資料
		if (get_table_data.length != 0) {
			String[] field = { "PNO", "MPNO", "INS_NO", "MAINTAIN_TYPE",
					"MAINTAIN_PERSON", "MAINTAIN_ITEM", "MAINTAIN_CYCLE",
					"LASTTIME_MA_DATE", "NEXT_MA_DATE" };
			// 設置一個容器但不需要PNO
			String[] tot_data = new String[field.length - 1];
			// 幾筆資料就新增幾次加上table的資料
			for (int i = 0; i < get_table_data.length; i++) {
				for (int j = 0; j < tot_data.length; j++) {
					tot_data[j] = get_table_data[i][j];
				}
				INSERT_TABLE_DATA(tablename, field, tot_data);
			}
			return true;
		}else{
			message("請新增維護資料完在送出!!");
			return false;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}