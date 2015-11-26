package com.ysk.STABLE_REMIND_MOVE;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

import com.ysk.STABLE_REMIND_MOVE.OA329FlowService;

public class update_data extends _bProcFlow {
	String tablename = "STABLEREMIND";
	String tablename2 = "STABLEDETAIL";
	OA329FlowService flowService;

	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"
		// ���o���ʤ��e�������
		String MPNO = getValue("MPNO");
		String MOVE_TYPE = getValue("MOVE_TYPE");
		String HURRY_PEOPLE = getValue("HURRY_PEOPLE");
		String[] HURRY_PEOPLE_field = { "HURRY_PEOPLE" };
		String[] HURRY_PEOPLE_data = { HURRY_PEOPLE };

		String VERIFICATION = getValue("VERIFICATION");
		String NO_CONFIRM = getValue("NO_CONFIRM");
		String[] VERIFICATION_field = { "VERIFICATION", "NO_CONFIRM" };
		String[] VERIFICATION_data = { VERIFICATION, NO_CONFIRM };

		String SAMPLE_POINT = getValue("SAMPLE_POINT");
		String[] SAMPLE_POINT_field = { "PNO", "SAMPLE_POINT" };
		String[] SAMPLE_POINT_data = { MPNO, SAMPLE_POINT };
		// �P�_��������������h�B�z����
		if (MOVE_TYPE.equals("A")) {
			UPDATE_MOVE_TYPE(tablename, HURRY_PEOPLE_field, HURRY_PEOPLE_data,
					MPNO);
		} else if (MOVE_TYPE.equals("B")) {
			UPDATE_MOVE_TYPE(tablename, VERIFICATION_field, VERIFICATION_data,
					MPNO);
		} else if (MOVE_TYPE.equals("C")) {
			INSERT_DATA(tablename2, SAMPLE_POINT_field, SAMPLE_POINT_data);
			// String sql =
			// "insert into STABLEDETAIL (PNO,SAMPLE_POINT) values ('"+MPNO+"','"+SAMPLE_POINT+"')";
			// addToTransaction(sql.toString());
			// message("�s�W����");
		}
		flowService = new OA329FlowService(this);
		talk t = getTalk();
		String PNO = getValue("PNO");
		String empid = getValue("EMPID");
		String M_DATE = getValue("DATE");
		String DEPT_NAME = getValue("DEP_NAME");
		String TYPE = getValue("TYPE");
		String name = getName(empid);
		/**
		 * �q���Ҧ�ñ�֤H��
		 **/
		String sql = "select DEP_CHIEF from HRUSER_DEPT_BAS where DEP_NO='17'";
		String DEP_CHIEF[][] = t.queryFromPool(sql);
		// �ѩ�Ҧ��y�{��ñ�֤H���èS���_��Hñ�֡A���q�����w�|�q����_��H�A�ҥH�b���]�p�Mapi��getFlowHistory()�@�ˡA�̧Ǭ��`�I�W�١B��֤H���B��֮ɶ��B��ַN���A�G���ݫe���[�Ӧr��
		String get_tot_user[][] = { { "test", DEP_CHIEF[0][0] },
				{ "test", empid } };
		String title = name + "(" + empid + ")���u�ӽ�í�w�ʨ��˴������ʳ�A���׳q��";
		String content = "í�w�ʨ��˴������ʳ��F�䴩�w�������סA�нT�{\r\n";
		content += "���u�s���G" + empid.trim() + "\r\n";
		content += "�m�@�@�W�G" + name.trim() + "\r\n";
		content += "���@�@���G" + DEPT_NAME.trim() + "\r\n";
		content += "�ӽФ���G" + M_DATE.trim() + "\r\n";
		content += "���������G" + TYPE + "\r\n";
		content += "ñ�ַN���G" + getMemo() + "\r\n";
		sendallmail(t, get_tot_user, title, content, flowService);
		return true;
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}