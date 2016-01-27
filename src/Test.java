import java.util.List;

// I AM USING THIS CLASS TO SIMPLY TEST THE API
public class Test {
	public static void main(String[] args) {
		API.login("", "", new PeachCallback() {

			@Override
			public void tokenDone(String token, boolean success) {
				// TODO Auto-generated method stub
				API.getConnections(token, new PeachCallback() {

					@Override
					public void connectionsDone(List<Connection> connections, boolean success) {
						// TODO Auto-generated method stub
						System.out.println(connections.get(0).getPosts()[0].getMessage()[0].getText());
					}

					
				});
			}

			
			
			
		});
	}

}
