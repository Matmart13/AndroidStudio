package Servidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.security.DrbgParameters.NextBytes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Servidor  extends JFrame implements KeyListener,Runnable{
	JLabel tiempo;
	Thread hilo;
	JPanel panel;
	JScrollPane scrollpanel;
	static JTextArea textArea;
	JScrollPane scrollPane2;
	static JTextArea textArea2;
	BufferedReader br;
	static final int MAXIMO=15;//MAXIMO DE CONEXIONES PERMITIDAS

	public Servidor() {
		// TODO Auto-generated constructor stub
		//Panel
			addKeyListener(this);
			setLayout(null);
			panel  = new JPanel();
			getContentPane();
			setFocusable(true);
			panel.setLayout(null);
			getContentPane().setBackground(Color.white);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Servidor");
			tiempo = new JLabel("00:00:000");
			add(tiempo);
			tiempo.setFont(new Font("Serif",Font.BOLD,30));
			tiempo.setBounds(200,0,tiempo.getPreferredSize().width,tiempo.getPreferredSize().height);
			JLabel texto = new JLabel("Este es el Servidor");
			add(texto);
			texto.setFont(new Font("SansSerrif",Font.PLAIN,15));
			texto.setBounds(10,10,texto.getPreferredSize().width,texto.getPreferredSize().height);
			
			textArea = new JTextArea();
			scrollpanel = new JScrollPane(textArea);
			scrollpanel.setBounds(30,70,400,200);
			add(scrollpanel);
			
			textArea2 = new JTextArea();
			scrollPane2 = new JScrollPane(textArea2);
			scrollPane2.setBounds(30,300,200,200);
			add(scrollPane2);

			hilo = new Thread(this);
			hilo.start();
			setSize(500,600);
			setVisible(true);
			//Meter aqui las iniciali que dependen de que panel este visible
			Reloj r = new Reloj();
			r.start();
	}
	class Reloj extends Thread implements Runnable{
		public void run() {
			// TODO Auto-generated method stub
		try {
			while(true) {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String horaActual = sdf.format(cal.getTime());
				tiempo.setText(horaActual);
				Thread.sleep(200);
			}
		}catch(Exception e) {
			tiempo.setText("00:00:00");
		}
	}
  
	}
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
		// TODO Auto-generated method stub
		new Servidor();
		HiloFTP n = new HiloFTP(textArea);
		n.start();
			//Conexion con el cliente
			int numeroConexiones = 0;
			int PUERTO = 6000;
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado...");
			Socket tabla[] = new Socket[MAXIMO];// para controlar las conexiones
			while (numeroConexiones <10) {
				Socket socket = new Socket();
				socket = servidor.accept();
				HiloServidor hilo = new HiloServidor(socket,textArea2);
				hilo.start();
			}
			servidor.close();
			//Conexion con el PHP
			
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		}
	
	

}

