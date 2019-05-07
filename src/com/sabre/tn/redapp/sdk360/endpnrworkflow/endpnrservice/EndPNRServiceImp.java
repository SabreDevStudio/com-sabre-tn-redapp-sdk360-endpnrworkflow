package com.sabre.tn.redapp.sdk360.endpnrworkflow.endpnrservice;

import org.eclipse.jface.preference.IPreferenceStore;

import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointCommand;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointDataOperation;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointRequestWrapper;
import com.sabre.stl.pos.srw.nextgen.flow.ext.v2.FlowExtPointResponseWrapper;
import com.sabre.stl.pos.srw.nextgen.redapp.pnr.end.rq.v1.RedAppEndTransactionRq;
import com.sabre.stl.pos.srw.nextgen.redapp.travelitineraryread.rs.v1.RedAppTravelItinerary.RemarkInfo;
import com.sabre.stl.pos.srw.nextgen.redapp.travelitineraryread.rs.v1.RedAppTravelItinerary.RemarkInfo.Remark;
import com.sabre.stl.pos.srw.nextgen.redapp.travelitineraryread.rs.v1.RedAppTravelItineraryReadRs  ; 
import com.sabre.tn.redapp.sdk360.endpnrworkflow.Activator;
import com.sabre.tn.redapp.sdk360.endpnrworkflow.preferences.PreferenceInitializer;

import static com.sabre.stl.pos.srw.nextgen.flow.ext.utils.FlowExtPointCommandUtils.addError;
import static com.sabre.stl.pos.srw.nextgen.flow.ext.utils.FlowExtPointErrorFactory.createMajorError;


public class EndPNRServiceImp implements EndPNRService {
	IPreferenceStore store = Activator.getDefault().getPreferenceStore() ; 
	
	@Override
	public FlowExtPointCommand execute(FlowExtPointCommand extPointCommand) {
		
		

		
		// GET DATA model details 
		
				 
				
					RedAppTravelItineraryReadRs pnrResponse = getTIRResponse(extPointCommand); 
					
					if(pnrResponse!=null){
						
					if(pnrResponse.getTravelItinerary().getRemarkInfo()==null || ! isAlphaCodedRemarkPresent(pnrResponse.getTravelItinerary().getRemarkInfo())){
						
						
						
						// Optional <FlowExtPointRequestWrapper> rqWrapper = fetchRequestWrapper(extPointCommand, RedAppEndTransactionRq.class);
							
					     //extPointCommand.setFlowControlAction(FlowExtControlAction.CANCEL) ;
						 
					//	FlowExtPointRequestWrapper rqwraper = getEndTransactionRQ(extPointCommand); 
	
						
						addError(extPointCommand, createMajorError(store.getString(PreferenceInitializer.ERROR_TEXT)));
						 
					}
						
				
					}
	              
	  
		return extPointCommand;
	}
	
	
	private boolean isAlphaCodedRemarkPresent(RemarkInfo remarkInfo){
		
		if(remarkInfo==null){
			return false ; 
		}
		
		for(Remark remark : remarkInfo.getRemark()){
			
			if(remark.getType().equals("Alpha-Coded") && remark.getCode()!=null && remark.getCode().equals(store.getString(PreferenceInitializer.ALPHA_CODED_REMARK_LETTER))){
			
				return true ; 
			}
		}
		
		return false ; 
	}

 
    
    private RedAppTravelItineraryReadRs getTIRResponse(FlowExtPointCommand extPointCommand){
    	
    	for (FlowExtPointResponseWrapper rsp :extPointCommand.getResponses()) {
			
    		
          if(rsp.getResponse().getStructure() instanceof RedAppTravelItineraryReadRs ){
        	  RedAppTravelItineraryReadRs  response = (RedAppTravelItineraryReadRs) rsp.getResponse().getStructure(); 
    			
    			return response; 
    			
    		}
    		
		}
    		
    	
    	
    return null ; 
    }
    
    
    


}
