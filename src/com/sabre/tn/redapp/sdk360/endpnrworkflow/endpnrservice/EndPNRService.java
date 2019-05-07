package com.sabre.tn.redapp.sdk360.endpnrworkflow.endpnrservice;

import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointCommand;

public interface EndPNRService {
	
	
	public FlowExtPointCommand  execute(FlowExtPointCommand extPointCommand);
	
	

}
