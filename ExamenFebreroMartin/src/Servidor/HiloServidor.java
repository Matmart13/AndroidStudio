package Servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JTextArea;

public class HiloServidor extends Thread{

	DataInputStream fentrada;
	DataOutputStream fsalida;
	Socket socket = null;
	JTextArea j;
	
	public HiloServidor(Socket s, JTextArea j) {
		this.socket = s;
		this.j = j;
		try {
			// CREO FLUJO DE ENTRADA PARA LEER LOS MENSAJES
			fentrada = new DataInputStream(socket.getInputStream());
			String cadena = "";
			cadena = fentrada.readUTF();
		    URL miUrl = new URL("http://localhost/htdocs/Procesos/claves_bbdd.php?nombre=pablo");
            //URL miUrl = new URL("https://gs.litterator.info/php/prueba_conexion_com_servidor.php");
            j.setText("" + miUrl.toString());

            HttpURLConnection miHtp = (HttpURLConnection) miUrl.openConnection();
            miHtp.setRequestMethod("GET");
            InputStream miEntrada = miHtp.getInputStream();
            InputStreamReader miLector = new InputStreamReader(miEntrada);
            BufferedReader miBufferLector = new BufferedReader(miLector);
            String Linea = miBufferLector.readLine().toString();
            if(cadena.equals(Linea)) {
            	j.setText("Es correcto");   	
            }else {
            	j.setText("No es Correcto");
            }
            
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		j.append("\nEstoy en el run");
		while (true) {
			String cadena = "";
			try {
				cadena = fentrada.readUTF();
				if (cadena.trim().equals("*")){
					break;
				}else {
					j.setText(desencriptar(cadena));
					fsalida.writeUTF(j.getText()+"\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

		// se cierra el socket del cliente
	
	}

	public String desencriptar(String msg) throws IOException, ReflectiveOperationException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		fentrada = new DataInputStream(socket.getInputStream());
		String mensajeEntrada = msg;
		//System.out.println(mensajeEntrada);
	    String nuevo;
		String archivoClave = "clave_secreta.key";
		// Recumperamos clave secreta del fichero
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream(archivoClave));
		Key clavesecreta = (Key) oin.readObject();
		oin.close();
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.DECRYPT_MODE, clavesecreta);
		byte[]desEncr = c.doFinal(Base64.getEncoder().encode(mensajeEntrada.getBytes()));
		nuevo = new String(desEncr);
		return nuevo;
	}

}
