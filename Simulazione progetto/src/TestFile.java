import java.util.Vector;

public class TestFile {

	public static void main(String[] args) {
		
		String link = new String("http://dati.comune.milano.it/dataset/"
				+ "da6bc86d-c27f-4256-84eb-86c35dad7d0e/resource/"
				+ "bd55cd57-4dd7-4d72-b182-de4f4b7de8c6/download/"
				+ "ds339_territorioambiente_aree-verdi-zona-superficie_2014.csv");
		
		String path = new String(".\\Aree_verdi.csv");
		
		FileAccess file_1 = new FileAccess(link, path);
		
		Vector<GreenArea> area_1 = file_1.generateGACollection();
		
		System.out.println(area_1.capacity());

	}

}
