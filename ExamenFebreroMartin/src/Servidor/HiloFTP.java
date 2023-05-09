package Servidor;

import java.awt.TextArea;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.SocketException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JTextArea;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class HiloFTP extends Thread implements Runnable{
	
	private ObjectInputStream dataOS;
	JTextArea tr;
	BufferedReader br;
	public HiloFTP(JTextArea textArea) throws SocketException, IOException, NoSuchAlgorithmException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		tr = textArea;
		FTPClient cliente = new FTPClient();
		String servFTP = "localhost";
		String usuario = "Martin";
		String clave = "";
		String directorio = "Examen Procesos";
		String archivo_origen = "B:\\XAMPP2\\htdocs\\htdocs\\Procesos\\Examen Procesos\\anuncios.dgt";
		String archivo_destino = "C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\ProcesosyServicios2trim\\ExamenFebreroMartin\\anuncios.txt";
		
		cliente.connect(servFTP);
		cliente.enterLocalPassiveMode();
		
		boolean login = cliente.login(usuario, clave);
		if(login)
			System.out.println("Login correcto...");
		else {
			System.out.println("Login incorrecto");
			cliente.disconnect();
			System.exit(1);
		}
		System.out.println("Directorio actual: " + cliente.printWorkingDirectory());
		if(cliente.changeWorkingDirectory(directorio))
			System.out.println("Dir actual:" + cliente.printWorkingDirectory());
		else
			System.out.println("No existe el directorio " + directorio);
		
		System.out.println("Descargando archivo : " + archivo_origen);
		cliente.setFileType(FTP.BINARY_FILE_TYPE);
		InputStream fileout = new FileInputStream(archivo_origen);
		dataOS = new ObjectInputStream(fileout);
		Object o = dataOS.readObject();
		String datos = (String)o; 
		System.out.println("Datos : " + datos);
		o = dataOS.readObject();
		byte resumenOriginal[] = (byte[]) o ;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(datos.getBytes());
		byte resumenActual[] = md.digest();
		if(MessageDigest.isEqual(resumenActual, resumenOriginal)) {
			System.out.println("Datos");
			BufferedWriter br = new BufferedWriter(new FileWriter(archivo_destino));
			br.write(datos);
			br.close();
		}else {
			System.out.println("No se ha podido descargar");
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			while(true) {
				br = new BufferedReader(new FileReader("anuncios.txt"));
				String linea = br.readLine();
			while(linea != null) {
					
							tr.setText(linea);
							Thread.sleep(2000);	
							linea = br.readLine();
			} 
			
			}
		}catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
