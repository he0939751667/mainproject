package com.ysk.STABLE_REMIND_MOVE;

import javax.swing.*;

import setFuntion._bTransaction;

import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class detail_add_before extends _bTransaction {
	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��@�~
		// �^�ǭȬ� false ��ܱ��U�Ӥ����������O
		String MOVE_TYPE = getValue("MOVE_TYPE");
		boolean check_null = false;
		if (MOVE_TYPE.equals("1.��ʤH������")) {
			String[] field = { "HURRY_PEOPLE" };
			String[] field_name = { "��ʤH��" };
			check_null = check_field(field, field_name);
		} else if (MOVE_TYPE.equals("2.�L�����T�{")) {
			String[] field = { "VERIFICATION" };
			String[] field_name = { "�����`��" };
			check_null = check_field(field, field_name);
		} else if (MOVE_TYPE.equals("3.�������ˤ��")) {
			String[] field = { "SAMPLE_POINT" };
			String[] field_name = { "����I" };
			check_null = check_field(field, field_name);
		}
		if(check_null==false) return false;
		return true;
	}

	public String getInformation() {
		return "---------------table1()appendProgram()----------------";
	}
}