package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class insert_detail extends _hproc {
	String tablename = "FQ_INSTRUMENT_DETAIL";

	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		talk t = getTalk();
		// 取得品保填寫的明細檔資料
		String[] field = { "MPNO", "INS_NO", "MAINTAIN_TYPE",
				"MAINTAIN_PERSON", "MAINTAIN_ITEM", "MAINTAIN_CYCLE",
				"LASTTIME_MA_DATE", "NEXT_MA_DATE" };
		String[] field_data = new String[field.length];
		for (int i = 0; i < field.length; i++) {
			field_data[i] = getValue(field[i]);
		}
		//防止週期輸入字串
		String MAINTAIN_CYCLE = getValue("MAINTAIN_CYCLE");
		char[] str1 = MAINTAIN_CYCLE.toCharArray();
		for (int index = 0; index < MAINTAIN_CYCLE.length(); index++) {
			if (!Character.isDigit(str1[index])) {
				message("週期請輸入數字");
				return value; // 字串中出現一個非數值的字元就結束 loop, 因為這不是我們要的字串
			}
		}
		String[] field_name = { "單號", "儀器編號", "維護類別", "維護人員", "維護項目",
				"維護週期", "上次維護日期", "下次維護日期" };
		// 防止人員漏寫
		boolean forget = forget_field(field_data, field_name);
		// 如果沒有漏寫在存檔
		if (forget != false) {
			INSERT_DATA(tablename, field, field_data);
			String[] field2 = { "MAINTAIN_TYPE", "MAINTAIN_PERSON",
					"MAINTAIN_ITEM", "MAINTAIN_CYCLE", "LASTTIME_MA_DATE",
					"NEXT_MA_DATE", "MAINTAIN_NAME" };
			Clear_field(t, field2);
		}
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u5b58\u6a94).html_action()----------------";
	}
}