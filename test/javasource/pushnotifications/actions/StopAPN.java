// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pushnotifications.actions;

import pushnotifications.implementation.apn.APNConnection;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import communitycommons.Misc;

public class StopAPN extends CustomJavaAction<Boolean>
{
	private IMendixObject __settings;
	private pushnotifications.proxies.APNSettings settings;

	public StopAPN(IContext context, IMendixObject settings)
	{
		super(context);
		this.__settings = settings;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		this.settings = __settings == null ? null : pushnotifications.proxies.APNSettings.initialize(getContext(), __settings);

		// BEGIN USER CODE
		APNConnection connection = APNConnection.getConnection();
		
		if(connection!= null){
			try{
				connection.stop();
			}
			catch(Exception e){
				Misc.throwException(e.getMessage());
				return false;
			}
		}
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "StopAPN";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
