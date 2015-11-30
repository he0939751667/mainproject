package com.ysk.OA314;

import javax.swing.*;

import setFuntion._bTransaction;

import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class table_addbefore_check extends _bTransaction {
	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的作業
		// 回傳值為 false 表示接下來不執行任何指令
		String[] field = { "INS_NO", "MAINTAIN_TYPE", "MAINTAIN_PERSON",
				"MAINTAIN_ITEM", "MAINTAIN_CYCLE", "LASTTIME_MA_DATE",
				"NEXT_MA_DATE" };
		String[] field_name = { "儀器編號", "維護類別", "維護人員", "維護項目", "維護週期",
				"上次維護時間", "下次維護時間" };
		boolean check = check_field(field, field_name);
		if (check == false) {
			return check;
		}else{
			String MAINTAIN_CYCLE = getValue("MAINTAIN_CYCLE");
			char[] str1 = MAINTAIN_CYCLE.toCharArray();
			for (int index = 0; index < MAINTAIN_CYCLE.length(); index++) {
				if (!Character.isDigit(str1[index])) {
					message("週期請輸入數字");
					return false; // 字串中出現一個非數值的字元就結束 loop, 因為這不是我們要的字串
				}
			}
			return true;
		}
	}

	public String getInformation() {
		return "---------------table1()appendProgram()----------------";
	}
}