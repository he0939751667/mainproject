package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class set_flowc extends _hproc {
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		try {
			String EMPID = getValue("EMPID");
			user_info_view(EMPID);

			String STATUS = getValue("STATUS");
			if (STATUS.equals("1")) {
				setValue("TYPE", "1.���`�ϥ�");
			} else {
				setValue("TYPE", "2.���o");
			}

			String state = getState().trim();
			if (state.equals("�~�O�޲z��")) {
				String field[] = { "INS_NO", "MAINTAIN_TYPE", "MAINTAIN_ITEM",
						"MAINTAIN_CYCLE", "LASTTIME_MA_DATE", "NEXT_MA_DATE",
						"MAINTAIN_PERSON" };
				for (int i = 0; i < field.length; i++) {
					setEditable(field[i], true);
				}
				setVisible("button1", true);
				setVisible("text6", true);
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