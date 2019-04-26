
import java.io.*;
import java.util.Vector;


public class FileAccess {
	
	private File fileOut;
	
	public FileAccess(String link, String path) {
		
		// Creazione del file e download in caso non esista
		this.fileOut = new File(path);
		if(!fileOut.exists())
		{
			Download download = new Download(link, fileOut);
			download.run();
		}
	}

	// Metodo che consente di leggere una riga del file e generare un oggetto 
	// GreenArea a partire da questa tramite parsing e conversioni stringa numero
	public GreenArea generateGreenArea() {
		
		GreenArea ga = new GreenArea();
		String line;
		String[] parsedLine = new String[GreenArea.N_PARAMETER];
		
		// Lettura e parsing del file .csv e istanziazione di un oggetto GreenArea
		try {
			
			BufferedReader buff = new BufferedReader(new FileReader(fileOut));
			line = buff.readLine();
			parsedLine = line.split(";");
			
			if(!isInt(parsedLine[0])) {
				line = buff.readLine();
				parsedLine = line.split(";");
			}
			
			buff.close();
			
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found Exception");
		} catch (IOException e) {
			System.err.println("IO Exception");
		} catch (Exception e) {
			System.err.println("General Exception");
		}
		

		// set di ga
		ga.setZona((int)Integer.parseInt(parsedLine[0]));
		ga.setArea((int)Integer.parseInt(parsedLine[1]));
		ga.setLocID((int)Integer.parseInt(parsedLine[2]));
		ga.setLocName(parsedLine[3]);
		ga.setDescription(parsedLine[4]);
		ga.setType(parsedLine[5]);
		ga.setClassification(parsedLine[6]);
		ga.setClassificationISTAT(parsedLine[7]);
		ga.setOwner(parsedLine[8]);
		ga.setSurface((double)Double.parseDouble(parsedLine[9].replace(",", ".")));

		return ga;
	}
	
	// Metodo che genera una lista di oggetti GreenArea scansionando l'intero file in 
	// questione riga per riga
	public Vector<GreenArea> generateGACollection() {
		
		Vector<GreenArea> gaCollection = new Vector<GreenArea>();
		
		GreenArea ga;
		String line;
		String[] parsedLine = new String[GreenArea.N_PARAMETER];
		boolean flag = true;
		
		// Lettura iterata e parsing del file .csv e istanziazione di un oggetto GreenArea
		try {
			BufferedReader buff = new BufferedReader(new FileReader(fileOut));
			
			do {
				line = buff.readLine();
				parsedLine = line.split(";");
			
				if(!isInt(parsedLine[0])) {
					line = buff.readLine();
					parsedLine = line.split(";");
				}
				
				// Se la riga letta non è vuota si crea un nuovo elemento GreenArea
				if(!line.equals(null)) {
					ga = new GreenArea();
					ga.setZona((int)Integer.parseInt(parsedLine[0]));
					ga.setArea((int)Integer.parseInt(parsedLine[1]));
					ga.setLocID((int)Integer.parseInt(parsedLine[2]));
					ga.setLocName(parsedLine[3]);
					ga.setDescription(parsedLine[4]);
					ga.setType(parsedLine[5]);
					ga.setClassification(parsedLine[6]);
					ga.setClassificationISTAT(parsedLine[7]);
					ga.setOwner(parsedLine[8]);
					ga.setSurface((double)Double.parseDouble(parsedLine[9].replace(",", ".")));
				
					gaCollection.add(ga);
				}
				else {
					flag = false;
				}		
			} while(flag);
			buff.close();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found Exception");
		} catch (IOException e) {
			System.err.println("IO Exception");
		} catch (Exception e) {
			System.err.println("General Exception");
		}
		// Il vettore ha lunghezza limitata torvare modo di risolvere la questione.
		return gaCollection;
		
	}
	
	public boolean isInt(String test) {
		
		try {
			@SuppressWarnings("unused")
			int number = (int) Integer.parseInt(test);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
