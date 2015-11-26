package com.ysk.STABLE_REMIND_MOVE;

import java.util.Vector;

import jcx.db.talk;
import jcx.jform.bNotify;
import jcx.util.convert;

import com.ysk.field.Mail;
import com.ysk.util.Log;
import com.ysk.util.LogUtil;
import com.ysk.STABLE_REMIND_MOVE.OA329FlowService;

public class sendmail extends bNotify {
	private Log log = LogUtil.getLog(this.getClass());

	private OA329FlowService flowService;

	public void actionPerformed(String value) throws Throwable {
		// ����i�J�y�{���A�~�O�޲z����,�|���楻�q�{��
		// �i�ΥH�H�oEmail�q�������P��Ʈw�L�������~
		// �p�G�n���ʸ�Ʈw�A��ĳ��b�y�{�w�B�z�{�Ǥ��A�� addToTransaction(sql); �H�T�O��Ʈw���ʤ@�P.
		// ���o�ثe�y�{�`�I
		flowService = new OA329FlowService(this);
		String state = getState().trim();
		talk t = getTalk();
		// ���o�ثe�`�I�i�Hñ�֪��H
		Vector vid = getEngagedPeople();
		if (vid.size() == 0)
			return;
		// ���o�����
		String empid = getValue("EMPID").trim();
		String name = getName(empid);
		String PNO = getValue("MPNO");
		String PRODUCT_NAME = getValue("PRODUCT_NAME");
		String DEPT_NAME = getValue("DEP_NAME").trim();
		String M_DATE = getValue("DATE").trim();
		String MOVE_TYPE = getValue("TYPE");
		Vector V2 = new Vector();
		// �d��ñ�֪̪�email
		for (int i = 0; i < vid.size(); i++) {
			String sql = "select EMAIL from HRUSER where EMPID = '"
					+ convert.ToSql(vid.elementAt(i).toString()) + "' ";
			String r1[][] = t.queryFromPool(sql);
			if (r1.length == 0)
				continue;
			V2.addElement(r1[0][0].trim());
		}
		if (V2.size() == 0)
			return;
		// �C�Ӭy�{���d��email�q���榡
		if (state.trim().equals("�ݳB�z") || state.trim().equals("�ҥD��")) {
			String title = flowService.getMailSubject(empid, name);
			String content = "" + "�жi�J�t��(" + Mail.getOaSystemUrl() + ") ñ��"
					+ "\r\n";
			content += "��        ���G" + PNO.trim() + "\r\n";
			content += "�~�@�@�W�G" + PRODUCT_NAME.trim() + "\r\n";
			content += "���u�s���G" + empid.trim() + "\r\n";
			content += "�m�@�@�W�G" + name.trim() + "\r\n";
			content += "���@�@���G" + DEPT_NAME.trim() + "\r\n";
			content += "�ӽФ���G" + M_DATE.trim() + "\r\n";
			content += "���������G" + MOVE_TYPE.trim() + "\r\n";
			content += "ñ�ַN���G" + getMemo() + "\r\n";

			String usr[] = (String[]) V2.toArray(new String[0]);
			String sendRS = flowService.sendMailbccUTF8(usr, title, content,
					null, "", "text/plain");
			if (sendRS.trim().equals("")) {
				message("EMAIL�w�H�X�q��");
			} else {
				message("EMAIL�H�X����");
			}
		} 
		return;
	}

	public String getInformation() {
		return "---------------\u54c1\u4fdd\u7ba1\u7406\u54e1.Notify()----------------";
	}
}
