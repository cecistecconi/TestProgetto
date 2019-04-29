
import java.io.*;
import java.net.*;

public class Download implements Runnable{
	
	private String link;
	private File out;
	
	// Costruttore
	public Download(String link, File out) {
		this.link = link;
		this.out = out;
	}

	// Metodo d'interfaccia Runnable
	@Override
	public void run() {
		
		try {
			
			// Genera la connessione all'URL desiderato e crea uno sytream in 
			// ingresso a quell'URL con uno buffer
			URL url = new URL(link);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			BufferedInputStream in = new BufferedInputStream(http.getInputStream());
			
			// Ritorna la lunghezza in Byte del file da scaricare
			double fileSize = (double)http.getContentLengthLong();
			
			// Si crea o stream in uscita in modo da salvare il file su disco
			// con un buffer di 1024 Byte
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(this.out), 1024);
			byte[] buffer = new byte[1024];
			
			// Lettura del file e successiva scrittura su disco
			int read = 0;
			while((read = in.read(buffer, 0, 1024)) >= 0) {
				bout.write(buffer, 0, read);
			}
			System.out.println("Download complete! " + fileSize + " Byte scaricati");
			
			// chiusura stream
			in.close();
			bout.close();
			
		}
		catch(IOException e) {
			System.err.println("Download IO Exception");
		}
	}
	
	//
	
}
