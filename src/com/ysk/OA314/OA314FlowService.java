package com.ysk.OA314;

import java.util.Vector;

import com.ysk.service.BaseFlowService;

import jcx.jform.bNotify;
import jcx.jform.bProcFlow;
import jcx.jform.bRule;
import jcx.jform.hproc;

public class OA314FlowService extends BaseFlowService {

	public OA314FlowService() {
		
	}

	public OA314FlowService(bRule br) {
		super(br);
		
	}

	public OA314FlowService(hproc hp) {
		super(hp);
		
	}

	public OA314FlowService(bProcFlow bpf) {
		super(bpf);
		
	}

	public OA314FlowService(bNotify bn) {
		super(bn);
		
	}

	@Override
	public boolean checkBussinessRuleBeforeAddApprover(String ruleTableApprover) {
		
		return false;
	}

	@Override
	public boolean doApproveUpdateData(String approveActionName) {
		
		return false;
	}

	@Override
	public void doInformApprover(String sourceState, String destState) {
		

	}

	@Override
	public Vector<String> getSignFlowApprover(String ruleTableApprover) {
		
		return null;
	}

}
