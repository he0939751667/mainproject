package com.ysk.OA314;

import java.io.*;
import java.util.*;

import setFuntion._bRule;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class rule_for_FQ extends _bRule{
	public Vector getIDs(String value)throws Throwable{
		// �^�ǭȬ� Vector contails �ŦX�o���W�檺�b��
		// value �� "QA4Q���ҤΩw���O�i"
		Vector id=new Vector();
		String state = getState().trim();
		String MUSER = getData("EMPID");
		talk t = getTalk();
		String chief[][] = getchief(t,MUSER);
		if(state.equals("�ݳB�z") || state.equals("�~�O�޲z��")){
			if(MUSER.length()!=0){
				id.addElement(MUSER);
			}else{
				id.addElement("admin");
			}
			return id;
		}else if(state.equals("�ҥD��") || state.equals("�~�O�ҥD��")){
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
		return "---------------QA4Q\u9a57\u8b49\u53ca\u5b9a\u671f\u4fdd\u990a.Rule()----------------";
	}
}