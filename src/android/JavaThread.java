package za.co.hellotech.JavaThread;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Tsungai on 2014/02/27.
 */
public class JavaThread extends CordovaPlugin
{
	private int counter = 0;

	@Override
	public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {		
		try {
		//	cordova.getActivity().runOnUiThread(new Runnable() {
		//		public void run() {
					new Thread() {
						@Override
						public void run() {
							while (true) {
								try {
									webView.sendJavascript("helloWorld('testing 1 2 3')");									
									Thread.sleep(1000);
								} catch (Exception e) {
									e.printStackTrace();
									break;
								}
							}
						}
					}.start();
					callbackContext.success();
		//		}
		//	});
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
}
