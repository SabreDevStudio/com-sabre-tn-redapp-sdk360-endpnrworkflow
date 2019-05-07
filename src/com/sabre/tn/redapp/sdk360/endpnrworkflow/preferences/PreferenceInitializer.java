package com.sabre.tn.redapp.sdk360.endpnrworkflow.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.sabre.tn.redapp.sdk360.endpnrworkflow.Activator;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public static final String ALPHA_CODED_REMARK_LETTER = "REMARK LETTER"; 
	public static final String ERROR_TEXT = "ERROR_TEXT"; 
	
	
	
	@Override
	public void initializeDefaultPreferences() {
		// TODO Auto-generated method stub
		
		IPreferenceStore store = Activator.getDefault().getPreferenceStore() ; 
		
		store.setDefault(ALPHA_CODED_REMARK_LETTER, "V");
		store.setDefault(ERROR_TEXT,"ALPHA CODED REMARK IS MISSING PNR WILL NOT END ");

	}

}
