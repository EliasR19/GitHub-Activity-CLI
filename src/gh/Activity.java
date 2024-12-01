package gh;

public class Activity {
	String typo;
	String repo;
	long id;
	
	public static Activity loadJson(String act) {
			act = act.replaceFirst("id", "");
			String[] act1 = act.replace("{", "").replace("\"", "").split("},");
	
			String[] info = act1[0].split(",");
			String[] repo = act1[1].split(",");
			
			
			String idStr = info[0].replace(":", "");
			String typoStr = info[1].replace("type:", "");
			String repoStr = repo[1].replace("name:", "");


			Activity newAct = new Activity();
			newAct.id = Long.parseLong(idStr);
			newAct.typo = typoStr;
			newAct.repo = repoStr;
			
			return newAct;
	}
	
	public long getId() {
		return id;
	}
	
	public String getTypo() {
		return typo;
	}
	
	public String getRepo() {
		return repo;
	
	}
}
