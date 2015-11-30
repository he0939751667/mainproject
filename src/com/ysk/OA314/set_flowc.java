package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class set_flowc extends _hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		try {
			String EMPID = getValue("EMPID");
			user_info_view(EMPID);

			String PNO = getValue("PNO");
			setValue("MPNO",PNO);
			String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
			setValue("INS_NO",INSTRUMENT_NO);
			String STATUS = getValue("STATUS");
			if (STATUS.equals("1")) {
				setValue("TYPE", "1.正常使用");
			} else {
				setValue("TYPE", "2.報廢");
			}

			String state = getState().trim();
			if (state.equals("品保管理員")) {
				String field[] = { "text5", "DETAIL_CONTENT", "INS_NO",
						"MAINTAIN_TYPE", "MAINTAIN_ITEM", "MAINTAIN_CYCLE",
						"LASTTIME_MA_DATE", "NEXT_MA_DATE", "MAINTAIN_PERSON",
						"MAINTAIN_NAME", "table1" };
				for (int i = 0; i < field.length; i++) {
					setVisible(field[i], true);
				}
			}else if (state.equals("品保課主管")){
				String field[] = { "text6", "text4", "SCRAP_DATE"};
				for (int i = 0; i < field.length; i++) {
					setVisible(field[i], true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public String getInformation() {
		return "---------------text1(FORM_STATE).html_action()----------------";
	}
}