package com.ysk.STABLE_REMIND_MOVE;
import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add_before extends _hproc{
	public String action(String value)throws Throwable{
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@ 
		// �ǤJ�� value
		talk t = getTalk();
		String EMPID = getValue("EMPID");
		user_info_view(EMPID);
		setValue("MOVE_TYPE","1.��ʤH������");
		setEditable("HURRY_PEOPLE",true);
		return value;
	}
	public String getInformation(){
		return "---------------button1(\u65b0\u589e).html_action()----------------";
	}
}
