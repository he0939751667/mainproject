package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class select_instrument extends _hproc {
	String tablename = "FQ_INSTRUMENT_DETAIL";

	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的onChange 的動作
		// 傳入值 value
		try {
			talk t = getTalk();
			String PNO = getValue("MPNO");
			String[] field = { "INS_NO", "MAINTAIN_TYPE", "MAINTAIN_ITEM",
					"MAINTAIN_CYCLE", "LASTTIME_MA_DATE", "NEXT_MA_DATE",
					"MAINTAIN_PERSON" };
			selectfield(tablename, field, PNO);
			String MAINTAIN_PERSON = getValue("MAINTAIN_PERSON");
			String ret[][] = user_info_view2(MAINTAIN_PERSON);
			setValue("MAINTAIN_NAME", ret[0][0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getInformation() {
		return "---------------MPNO(\u55ae\u865f\uff1a).html_action()----------------";
	}
}
