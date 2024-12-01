package gh;

public class GHActivityCLI {

	public static void main(String[] args){

			gestorActivity gestor = new gestorActivity();
			
			gestor.loadActivity(args[0]);
			gestor.recentActivity();
			gestor.printActivity();

		
	}

}
