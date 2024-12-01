package gh;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class gestorActivity {
	
	List<Activity> loadAct = new ArrayList<Activity>();
	
	public void loadActivity(String user) {
		final String BASE_URL = "https://api.github.com/users/" + user + "/events";
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(BASE_URL))  
				.GET()
				.build();
		
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> ans;
		
		//lista donde se guardan las actividades bajadas
		
		try {
			ans = client.send(request, HttpResponse.BodyHandlers.ofString());
	
			
			String actStr = String.valueOf(ans.body());
			String[] list = actStr.replace("]", "").replace("[", "").split("\\},\\{\"id");

			
			for(String s : list) {
				loadAct.add(Activity.loadJson(s));
				//System.out.println(s);
			}
			
	
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//recent Activity
	
	List<Activity> recent = new ArrayList<Activity>();
	
	//save the 5 recents activities
	public void recentActivity() {
		for(int n = 0;  n< 5; n++) {
			recent.add(loadAct.get(n));
		}
	}
	
	public void printActivity() {
		for(Activity a : recent) {
			System.out.println("Event " + a.getTypo() + " to " + a.getRepo());
		}
	}
	
}


