package com.ysk.STABLE_REMIND_MOVE;


import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class Setquery extends _hproc{
	public String action(String value)throws Throwable{
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@ 
		// �ǤJ�� value 
		//��i�J�e���A�����y�{�ɫh��l��queryPage
				if(POSITION!=5){
				talk t = getTalk();
				setNewView("queryPage");
				String EMPID = getUser();
				//���oEMPID�m�W�A������setValue�m�W�A����
				user_info_view(EMPID);
				String DATE = getToday("YYYYmmdd");
				setValue("SDATE",DATE);
				setValue("EDATE",DATE);
				}
		 return value;
	}
	public String getInformation(){
		return "---------------text3(text3).html_action()----------------";
	}
}
