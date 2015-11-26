package com.ysk.STABLE_REMIND_MOVE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class back extends _hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		// 當返回查詢時初始化queryPage
		try {
			talk t = getTalk();
			String EMPID = getUser();
			user_info_view(EMPID);
			String DATE = getToday("YYYYmmdd");
			setValue("SDATE", DATE);
			setValue("EDATE", DATE);
			setValue("PNO", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u8fd4\u56de\u67e5\u8a62).html_action()----------------";
	}
}