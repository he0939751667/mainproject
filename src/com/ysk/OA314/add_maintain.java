package com.ysk.OA314;

import java.io.*;
import java.util.*;
import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_maintain extends _bProcFlow {
	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"
		talk t = getTalk();
		String PNO = getValue("PNO");
		String sql = "select * from FQ_INSTRUMENT_DETAIL where PNO='" + PNO
				+ "'";
		String ret[][] = t.queryFromPool(sql);
		if (ret.length == 0) {
			message("�Цs�ɫ�b�e�X!");
			return false;
		} else {
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}