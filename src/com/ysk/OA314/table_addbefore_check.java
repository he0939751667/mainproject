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
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��@�~
		// �^�ǭȬ� false ��ܱ��U�Ӥ����������O
		String[] field = { "INS_NO", "MAINTAIN_TYPE", "MAINTAIN_PERSON",
				"MAINTAIN_ITEM", "MAINTAIN_CYCLE", "LASTTIME_MA_DATE",
				"NEXT_MA_DATE" };
		String[] field_name = { "�����s��", "���@���O", "���@�H��", "���@����", "���@�g��",
				"�W�����@�ɶ�", "�U�����@�ɶ�" };
		boolean check = check_field(field, field_name);
		if (check == false) {
			return check;
		}else{
			String MAINTAIN_CYCLE = getValue("MAINTAIN_CYCLE");
			char[] str1 = MAINTAIN_CYCLE.toCharArray();
			for (int index = 0; index < MAINTAIN_CYCLE.length(); index++) {
				if (!Character.isDigit(str1[index])) {
					message("�g���п�J�Ʀr");
					return false; // �r�ꤤ�X�{�@�ӫD�ƭȪ��r���N���� loop, �]���o���O�ڭ̭n���r��
				}
			}
			return true;
		}
	}

	public String getInformation() {
		return "---------------table1()appendProgram()----------------";
	}
}