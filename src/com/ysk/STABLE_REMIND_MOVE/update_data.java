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
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		// 取得異動內容相關資料
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
		// 判斷異動類型為什麼則處理什麼
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
			// message("新增完成");
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
		 * 通知所有簽核人員
		 **/
		String sql = "select DEP_CHIEF from HRUSER_DEPT_BAS where DEP_NO='17'";
		String DEP_CHIEF[][] = t.queryFromPool(sql);
		// 由於所有流程的簽核人中並沒有起單人簽核，但通知必定會通知到起單人，所以在此設計和api的getFlowHistory()一樣，依序為節點名稱、批核人員、批核時間、批核意見，故必需前面加個字串
		String get_tot_user[][] = { { "test", DEP_CHIEF[0][0] },
				{ "test", empid } };
		String title = name + "(" + empid + ")員工申請穩定性取樣提醒異動單，結案通知";
		String content = "穩定性取樣提醒異動單行政支援已完成結案，請確認\r\n";
		content += "員工編號：" + empid.trim() + "\r\n";
		content += "姓　　名：" + name.trim() + "\r\n";
		content += "部　　門：" + DEPT_NAME.trim() + "\r\n";
		content += "申請日期：" + M_DATE.trim() + "\r\n";
		content += "異動類型：" + TYPE + "\r\n";
		content += "簽核意見：" + getMemo() + "\r\n";
		sendallmail(t, get_tot_user, title, content, flowService);
		return true;
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}