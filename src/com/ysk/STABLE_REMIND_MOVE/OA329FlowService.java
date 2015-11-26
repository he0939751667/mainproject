package com.ysk.STABLE_REMIND_MOVE;

import java.util.Vector;

import com.ysk.service.BaseFlowService;

import jcx.jform.bNotify;
import jcx.jform.bProcFlow;
import jcx.jform.bRule;
import jcx.jform.hproc;

public class OA329FlowService extends BaseFlowService {

	public OA329FlowService() {
		
	}

	public OA329FlowService(bRule br) {
		super(br);
		
	}

	public OA329FlowService(hproc hp) {
		super(hp);
		
	}

	public OA329FlowService(bProcFlow bpf) {
		super(bpf);
		
	}

	public OA329FlowService(bNotify bn) {
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
