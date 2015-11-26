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
		// 當表單進入流程狀態品保管理員時,會執行本段程式
		// 可用以寄發Email通知等等與資料庫無關的做業
		// 如果要異動資料庫，建議放在流程預處理程序中，用 addToTransaction(sql); 以確保資料庫異動一致.
		// 取得目前流程節點
		flowService = new OA329FlowService(this);
		String state = getState().trim();
		talk t = getTalk();
		// 取得目前節點可以簽核的人
		Vector vid = getEngagedPeople();
		if (vid.size() == 0)
			return;
		// 取得欄位資料
		String empid = getValue("EMPID").trim();
		String name = getName(empid);
		String PNO = getValue("MPNO");
		String PRODUCT_NAME = getValue("PRODUCT_NAME");
		String DEPT_NAME = getValue("DEP_NAME").trim();
		String M_DATE = getValue("DATE").trim();
		String MOVE_TYPE = getValue("TYPE");
		Vector V2 = new Vector();
		// 查詢簽核者的email
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
		// 每個流程關卡的email通知格式
		if (state.trim().equals("待處理") || state.trim().equals("課主管")) {
			String title = flowService.getMailSubject(empid, name);
			String content = "" + "請進入系統(" + Mail.getOaSystemUrl() + ") 簽核"
					+ "\r\n";
			content += "單        號：" + PNO.trim() + "\r\n";
			content += "品　　名：" + PRODUCT_NAME.trim() + "\r\n";
			content += "員工編號：" + empid.trim() + "\r\n";
			content += "姓　　名：" + name.trim() + "\r\n";
			content += "部　　門：" + DEPT_NAME.trim() + "\r\n";
			content += "申請日期：" + M_DATE.trim() + "\r\n";
			content += "異動類型：" + MOVE_TYPE.trim() + "\r\n";
			content += "簽核意見：" + getMemo() + "\r\n";

			String usr[] = (String[]) V2.toArray(new String[0]);
			String sendRS = flowService.sendMailbccUTF8(usr, title, content,
					null, "", "text/plain");
			if (sendRS.trim().equals("")) {
				message("EMAIL已寄出通知");
			} else {
				message("EMAIL寄出失敗");
			}
		} 
		return;
	}

	public String getInformation() {
		return "---------------\u54c1\u4fdd\u7ba1\u7406\u54e1.Notify()----------------";
	}
}
