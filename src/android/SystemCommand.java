package kelvin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.Exception;

import java.lang.StringBuffer;
import java.lang.Process;
import java.lang.Runtime;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import android.util.Log;
/**
 * @author kelvin
 */
public class SystemCommand extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("execute")) {
            try {
                String command = args.getString(0);
                StringBuffer output = new StringBuffer();
                Process p;
                try {
                    p = Runtime.getRuntime().exec(command);
                    p.waitFor();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = "";
                    while ((line = reader.readLine())!= null) {
                        output.append(line + "n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String response = output.toString();

                callbackContext.success(response);
                return true;
            } catch (Exception e) {
				String stackTrace = Log.getStackTraceString(e); 
                callbackContext.error("Error: " + e.getMessage() + stackTrace);
                return false;
            }
        }
        return false;
    }
}