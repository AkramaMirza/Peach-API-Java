import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class API {
	public static final String BASE_URL = "https://v1.peachapi.com";
	public static final String ENDPOINT_REGISTER = "/register";
	public static final String ENDPOINT_LOGIN = "/login";
	public static final String ENDPOINT_CONNECTIONS = "/connections";
	public static final String ENDPOINT_EXPLORE = "/connections/explore";
	
	public static void login(String email, String password, PeachCallback callback) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				JSONObject fields = new JSONObject();
				try {
					fields.put("email", email);
					fields.put("password", password);
					HashMap<String, String> headers = new HashMap<String, String>();
					headers.put("Accept", "application/json");
					JSONObject result = new JSONObject(HelperClass.request(BASE_URL, ENDPOINT_LOGIN, headers, fields, true));
					JSONObject data = result.getJSONObject("data");
					Integer successInt = result.getInt("success");
					Boolean success = successInt == 1 ? true : false;
					JSONArray streamsJson = data.getJSONArray("streams");
					String token = streamsJson.getJSONObject(0).getString("token");
					callback.tokenDone(token, success);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		thread.start();		
	}
	
	public static void register(String email, String username, String password, PeachCallback callback) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				JSONObject fields = new JSONObject();
				try {
					fields.put("email", email);
					fields.put("name", username);
					fields.put("password", password);
					HashMap<String, String> headers = new HashMap<String, String>();
					headers.put("Accept", "application/json");
					JSONObject result = new JSONObject(HelperClass.request(BASE_URL, ENDPOINT_REGISTER, headers, fields, true));
					JSONObject data = result.getJSONObject("data");
					Integer successInt = result.getInt("success");
					Boolean success = successInt == 1 ? true : false;
					//String token = data.getString("token");
					JSONArray streamsJson = data.getJSONArray("streams");
					String token = streamsJson.getJSONObject(0).getString("token");
					String id = streamsJson.getJSONObject(0).getString("id");
					callback.tokenDone(token, success);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		thread.start();		
	}
	
	public static void getConnections(String token, PeachCallback callback) {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
					HashMap<String, String> headers = new HashMap<String, String>();
					headers.put("Accept", "application/json");
					headers.put("Authorization", "Bearer "+ token);
					try {
						JSONObject result = new JSONObject(HelperClass.request(BASE_URL, ENDPOINT_CONNECTIONS, headers, null, false));
						JSONObject data = result.getJSONObject("data");
						Integer successInt = result.getInt("success");
						Boolean success = successInt == 1 ? true : false;
						List<Connection> connections = new ArrayList<>();
						JSONArray connectionsJson = data.getJSONArray("connections");
						for (int i = 0; i < connectionsJson.length(); i++) {
							Connection connection = HelperClass.gson().fromJson(connectionsJson.getJSONObject(i).toString(), Connection.class);
							connections.add(connection);
						}
						List<FriendRequest> inboundFriendRequests = new ArrayList<>();
						JSONArray inboundFriendRequestsJson = data.getJSONArray("inboundFriendRequests");
						for (int i = 0; i < inboundFriendRequestsJson.length(); i++) {
							FriendRequest fr = HelperClass.gson().fromJson(inboundFriendRequestsJson.getJSONObject(i).toString(), FriendRequest.class);
							inboundFriendRequests.add(fr);
						}
						List<FriendRequest> outboundFriendRequests = new ArrayList<>();
						JSONArray outboundFriendRequestsJson = data.getJSONArray("outboundFriendRequests");
						for (int i = 0; i < outboundFriendRequestsJson.length(); i++) {
							FriendRequest fr = HelperClass.gson().fromJson(outboundFriendRequestsJson.getJSONObject(i).toString(), FriendRequest.class);
							outboundFriendRequests.add(fr);
						}
						Stream requesterStream = HelperClass.gson().fromJson(data.getJSONObject("requesterStream").toString(), Stream.class);
						callback.connectionsDone(connections, success);
						callback.inboundFriendRequestsDone(inboundFriendRequests, success);
						callback.outboundFriendRequestsDone(outboundFriendRequests, success);
						callback.requesterStreamDone(requesterStream, success);						
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
		});
		thread.start();		
	}

}
