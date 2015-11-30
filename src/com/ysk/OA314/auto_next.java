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
		// �i�۩wHTML�����U��쪺onChange ���ʧ@
		// �ǤJ�� value
		try {
			String MAINTAIN_CYCLE = getValue("MAINTAIN_CYCLE");
			String LASTTIME_MA_DATE = getValue("LASTTIME_MA_DATE");
			// �۰ʭp��U�����@�ɶ�
			if (MAINTAIN_CYCLE.length() != 0) {
				char[] str1 = MAINTAIN_CYCLE.toCharArray();
				for (int index = 0; index < MAINTAIN_CYCLE.length(); index++) {
					if (!Character.isDigit(str1[index])) {
						message("�g���п�J�Ʀr");
						return value; // �r�ꤤ�X�{�@�ӫD�ƭȪ��r���N���� loop, �]���o���O�ڭ̭n���r��
					}
				}
				int number = Integer.parseInt(MAINTAIN_CYCLE);
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
				Date pDate = new Date();
				pDate = df.parse(LASTTIME_MA_DATE);
				cal.setTime(pDate);
				cal.add(Calendar.DATE, 30 * number); // ����[30*�g����
				String NEXT_MA_DATE = df.format(cal.getTime()); // ����榡��String
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