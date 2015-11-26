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
		// 當表單進入流程狀態課主管時,會執行本段程式
		//可用以寄發Email通知等等與資料庫無關的做業
		//如果要異動資料庫，建議放在流程預處理程序中，用 addToTransaction(sql); 以確保資料庫異動一致.
		flowService = new OA314FlowService(this);
		String state = getState().trim();
		talk t = getTalk();
		// 取得目前節點可以簽核的人
		Vector vid = getEngagedPeople();
		if (vid.size() == 0) return;
		// 取得欄位資料
		String empid = getValue("EMPID").trim();
		String name = getName(empid);
		String PNO = getValue("MPNO");
		String DEPT_NAME = getValue("DEP_NAME").trim();
		String M_DATE = getValue("DATE").trim();
		String INSTRUMENT_NAME = getValue("INSTRUMENT_NAME");
		String INSTRUMENT_NO = getValue("INSTRUMENT_NO");
		String TYPE = getValue("TYPE");
		Vector V2 = getmail(t, vid);
		// 每個流程關卡的email通知格式
		if (state.trim().equals("待處理") || state.trim().equals("課主管") || state.trim().equals("品保管理員")) {
			String title = flowService.getMailSubject(empid, name);
			String content = "" + "請進入系統(" + Mail.getOaSystemUrl() + ") 簽核"
					+ "\r\n";
			content += "單        號：" + PNO.trim() + "\r\n";
			content += "員工編號：" + empid.trim() + "\r\n";
			content += "姓　　名：" + name.trim() + "\r\n";
			content += "部　　門：" + DEPT_NAME.trim() + "\r\n";
			content += "申請日期：" + M_DATE.trim() + "\r\n";
			content += "設備名稱：" + INSTRUMENT_NAME.trim() + "\r\n";
			content += "儀器編號：" + INSTRUMENT_NO.trim() + "\r\n";
			content += "狀態別：" + TYPE.trim() + "\r\n";
			content += "簽核意見：" + getMemo() + "\r\n";
			sendmail(V2, flowService, title, content);
		} 
		return;
	}
	public String getInformation(){
		return "---------------\u8ab2\u4e3b\u7ba1.Notify()----------------";
	}
}