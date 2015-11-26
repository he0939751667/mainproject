package com.ysk.OA314;
import jcx.jform.bNotify;

import java.io.*;
import java.util.*;

import com.ysk.OA314.OA314FlowService;
import com.ysk.field.Mail;

import setFuntion._bNotify;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class OA314sendmail extends _bNotify{
	OA314FlowService flowService;
	public void actionPerformed(String value)throws Throwable{
		// ����i�J�y�{���A�ҥD�ޮ�,�|���楻�q�{��
		//�i�ΥH�H�oEmail�q�������P��Ʈw�L�������~
		//�p�G�n���ʸ�Ʈw�A��ĳ��b�y�{�w�B�z�{�Ǥ��A�� addToTransaction(sql); �H�T�O��Ʈw���ʤ@�P.
		flowService = new OA314FlowService(this);
		String state = getState().trim();
		talk t = getTalk();
		// ���o�ثe�`�I�i�Hñ�֪��H
		Vector vid = getEngagedPeople();
		if (vid.size() == 0) return;
		// ���o�����
		String empid = getValue("EMPID").trim();
		String name = getName(empid);
		String PNO = getValue("MPNO");
		String DEPT_NAME = getValue("DEP_NAME").trim();
		String M_DATE = getValue("DATE").trim();
		String INSTRUMENT_NAME = getValue("INSTRUMENT_NAME");
		String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
		String TYPE = getValue("TYPE");
		Vector V2 = getmail(t, vid);
		// �C�Ӭy�{���d��email�q���榡
		if (state.trim().equals("�ݳB�z") || state.trim().equals("�ҥD��") || state.trim().equals("�~�O�޲z��")) {
			String title = flowService.getMailSubject(empid, name);
			String content = "" + "�жi�J�t��(" + Mail.getOaSystemUrl() + ") ñ��"
					+ "\r\n";
			content += "��        ���G" + PNO.trim() + "\r\n";
			content += "���u�s���G" + empid.trim() + "\r\n";
			content += "�m�@�@�W�G" + name.trim() + "\r\n";
			content += "���@�@���G" + DEPT_NAME.trim() + "\r\n";
			content += "�ӽФ���G" + M_DATE.trim() + "\r\n";
			content += "�]�ƦW�١G" + INSTRUMENT_NAME.trim() + "\r\n";
			content += "�����s���G" + INSTRUMENT_NO.trim() + "\r\n";
			content += "���A�O�G" + TYPE.trim() + "\r\n";
			content += "ñ�ַN���G" + getMemo() + "\r\n";
			sendmail(V2, flowService, title, content);
		} 
		return;
	}
	public String getInformation(){
		return "---------------\u8ab2\u4e3b\u7ba1.Notify()----------------";
	}
}