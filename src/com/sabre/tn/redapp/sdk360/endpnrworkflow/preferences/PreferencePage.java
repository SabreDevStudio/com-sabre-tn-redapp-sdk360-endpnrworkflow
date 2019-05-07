package com.sabre.tn.redapp.sdk360.endpnrworkflow.preferences;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sabre.tn.redapp.sdk360.endpnrworkflow.Activator;




public class PreferencePage  extends FieldEditorPreferencePage
implements IWorkbenchPreferencePage {

	public PreferencePage() {
		// TODO Auto-generated constructor stub
		super(GRID); 
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Choose the END PNR Settings");
		
	}

	@Override
	public void init(IWorkbench arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		
		addField(new StringFieldEditor(PreferenceInitializer.ALPHA_CODED_REMARK_LETTER,"Choose The Remark to be read  ", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceInitializer.ERROR_TEXT,"Choose the ERROR Text to show on screen", getFieldEditorParent()));
		
	}
	
	
	
	
	

}
