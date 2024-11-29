package gh;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GHActivityCLI {

	public static void main(String[] args){
		// TODO Auto-generated method stub
			
		final String BASE_URL = "https://api.github.com/users/EliasR19/events";
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(BASE_URL))  
				.GET()
				.build();
		
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpResponse<String> ans;
		List<Activity> loadAct = new ArrayList<Activity>();
		
		try {
			ans = client.send(request, HttpResponse.BodyHandlers.ofString());

			
			
			String actStr = String.valueOf(ans.body());
			String[] list = actStr.replace("]", "").replace("[", "").split("\\},\\{\"id");
			
			//Activity.loadJson(list[0]);
			for(String s : list) {
				//loadAct.add(Activity.loadJson(s));
				System.out.println(s);
			}
			
			//Activity.loadJson(list[1]);
			//System.out.println(list);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
