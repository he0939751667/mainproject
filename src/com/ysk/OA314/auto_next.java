package com.ysk.OA314;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.jform.hproc;
import jcx.db.*;

public class auto_next extends hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的onChange 的動作
		// 傳入值 value
		try {
			String MAINTAIN_CYCLE = getValue("MAINTAIN_CYCLE");
			String LASTTIME_MA_DATE = getValue("LASTTIME_MA_DATE");
			// 自動計算下次維護時間
			if (MAINTAIN_CYCLE.length() != 0) {
				char[] str1 = MAINTAIN_CYCLE.toCharArray();
				for (int index = 0; index < MAINTAIN_CYCLE.length(); index++) {
					if (!Character.isDigit(str1[index])) {
						message("週期請輸入數字");
						return value; // 字串中出現一個非數值的字元就結束 loop, 因為這不是我們要的字串
					}
				}
				int number = Integer.parseInt(MAINTAIN_CYCLE);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
				Date pDate = new Date();
				pDate = df.parse(LASTTIME_MA_DATE);
				cal.setTime(pDate);
				cal.add(Calendar.DATE, 30 * number); // 日期加30*週期天
				String NEXT_MA_DATE = df.format(cal.getTime()); // 日期格式轉String
				setValue("NEXT_MA_DATE", NEXT_MA_DATE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getInformation() {
		return "---------------LASTTIME_MA_DATE(\u4e0a\u6b21\u7dad\u8b77\u65e5\u671f\uff1a).html_action()----------------";
	}
}