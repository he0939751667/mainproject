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
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		talk t = getTalk();
		// ���o�~�O��g�������ɸ��
		String[] field = { "MPNO", "INS_NO", "MAINTAIN_TYPE",
				"MAINTAIN_PERSON", "MAINTAIN_ITEM", "MAINTAIN_CYCLE",
				"LASTTIME_MA_DATE", "NEXT_MA_DATE" };
		String[] field_data = new String[field.length];
		for (int i = 0; i < field.length; i++) {
			field_data[i] = getValue(field[i]);
		}
		//����g����J�r��
		String MAINTAIN_CYCLE = getValue("MAINTAIN_CYCLE");
		char[] str1 = MAINTAIN_CYCLE.toCharArray();
		for (int index = 0; index < MAINTAIN_CYCLE.length(); index++) {
			if (!Character.isDigit(str1[index])) {
				message("�g���п�J�Ʀr");
				return value; // �r�ꤤ�X�{�@�ӫD�ƭȪ��r���N���� loop, �]���o���O�ڭ̭n���r��
			}
		}
		String[] field_name = { "�渹", "�����s��", "���@���O", "���@�H��", "���@����",
				"���@�g��", "�W�����@���", "�U�����@���" };
		// ����H���|�g
		boolean forget = forget_field(field_data, field_name);
		// �p�G�S���|�g�b�s��
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