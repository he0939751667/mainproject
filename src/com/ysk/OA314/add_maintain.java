package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_maintain extends _bProcFlow {
	String tablename = "FQ_INSTRUMENT_DETAIL";

	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"
		String get_table_data[][] = getTableData("table1");
		// �ˬdtable���O�_�����
		if (get_table_data.length != 0) {
			String[] field = { "PNO", "MPNO", "INS_NO", "MAINTAIN_TYPE",
					"MAINTAIN_PERSON", "MAINTAIN_ITEM", "MAINTAIN_CYCLE",
					"LASTTIME_MA_DATE", "NEXT_MA_DATE" };
			// �]�m�@�Ӯe�������ݭnPNO
			String[] tot_data = new String[field.length - 1];
			// �X����ƴN�s�W�X���[�Wtable�����
			for (int i = 0; i < get_table_data.length; i++) {
				for (int j = 0; j < tot_data.length; j++) {
					tot_data[j] = get_table_data[i][j];
				}
				INSERT_TABLE_DATA(tablename, field, tot_data);
			}
			return true;
		}else{
			message("�зs�W���@��Ƨ��b�e�X!!");
			return false;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}