import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HelperClass {
	
	public static String request(String baseUrl, String endPoint, Map<String, String> headers, JSONObject fields, boolean post) {
		try {
			HttpURLConnection httpsUrlConnection = (HttpURLConnection) new URL(baseUrl+endPoint).openConnection();
			
			if (headers != null) {
				for (Entry<String, String> entry : headers.entrySet()) {
					httpsUrlConnection.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}
			
			if (post) {
				httpsUrlConnection.setRequestMethod("POST");
				httpsUrlConnection.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(httpsUrlConnection.getOutputStream());
				wr.writeBytes(fields.toString());
				wr.flush();
				wr.close();
			}
			httpsUrlConnection.connect();
			int resultCode = httpsUrlConnection.getResponseCode();
			System.out.println("RESULT CODE= " + resultCode);
			for (Entry<String, List<String>> header : httpsUrlConnection.getHeaderFields().entrySet()) {
			    System.out.println(header.getKey() + "=" + header.getValue());
			}
			if (resultCode != 200) {
				return null;
			}
			
			InputStream is = httpsUrlConnection.getInputStream();
						
			byte[] responseBytes = IOUtils.toByteArray(is);
			String response = new String(responseBytes, "UTF8");
			return response;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Gson gson() {
		return (new GsonBuilder()).create();
	}
}
