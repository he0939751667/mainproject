package com.ysk.STABLE_REMIND_MOVE;
import jcx.jform.bRule;
import java.io.*;
import java.util.*;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class flow_point extends bRule{
	public Vector getIDs(String value)throws Throwable{
		// �^�ǭȬ� Vector contails �ŦX�o���W�檺�b��
		// value �� "QAí�w���˴������ʳ�"
		Vector id=new Vector();
		String state = getState().trim();
		String MUSER = getData("EMPID");
		talk t = getTalk();
		String sql = "select b.dep_chief from hruser a,hruser_dept_bas b where a.dept_no=b.dep_no and a.empid='"+MUSER+"'";
		String chief[][] = t.queryFromPool(sql);
		if(state.equals("�ݳB�z")){
			if(MUSER.length()!=0){
				id.addElement(MUSER);
			}else{
				id.addElement("admin");
			}
			return id;
		}else if(state.equals("�ҥD��")){
			for(int i=0;i<chief.length;i++){
				if(chief[i][0].length()!=0){
					String dep_chief = chief[i][0].trim();
					id.addElement(dep_chief);
				}else{
					id.addElement("admin");
				}
			}
			return id;
		}
		return id;
	}
	public String getInformation(){
		return "---------------QA\u7a69\u5b9a\u53d6\u6a23\u63d0\u9192\u7570\u52d5\u55ae.Rule()----------------";
	}
}
