package com.ysk.OA314;

import java.io.*;
import java.util.*;
import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_maintain extends _bProcFlow {
	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		talk t = getTalk();
		String PNO = getValue("PNO");
		String sql = "select * from FQ_INSTRUMENT_DETAIL where PNO='" + PNO
				+ "'";
		String ret[][] = t.queryFromPool(sql);
		if (ret.length == 0) {
			message("請存檔後在送出!");
			return false;
		} else {
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}