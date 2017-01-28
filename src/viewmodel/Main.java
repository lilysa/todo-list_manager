package viewmodel;

import java.io.*;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Task;
import model.User;

public class Main {

	public static void main(String[] args) {


	//INITIALISATION DES VARIABLES UTILES POUR LA CREATION D'UN USER ET D'UNE TACHE
	int id = 1;
	int idu = 0;
	String name1 = "name1";
	String cont1 = "content1";
	int prop1 = 5;
	DateFormat format1 = new SimpleDateFormat("01/11/16");
	String date1 = (format1.format(new Date()));
	String st1 = "à_faire";
	
	String nameU1 = "Titi";
	String pswU1 = "toto";
	
	//CREATION D'UN USER
	User us1 = new User(idu, nameU1, pswU1);
	System.out.println("Id :" + us1.getId_user());
	
	// CREATION D'UNE TACHE --- mettre condition sur priorité
	Task test1 = new Task (id, name1, cont1, prop1, date1, st1, 0, 1);
	
	System.out.println("Id task :" + test1.getId_task() +" Name : " + test1.getName_task() +" Date : " + test1.getFinal_date_task() + " author : " + test1.getId_author());

	
	//ECRITURE DANS UN FICHIER
	//Path pathFileTask = Paths.get("AllTheTasks.xml");
    BufferedWriter XMLWriterAllTheTasks;
    OutputStreamWriter XMLOSWriter;
    String BeginFile = "toto"; //Files.newOutputStream(pathFileTask)
	try { 
		XMLOSWriter = new OutputStreamWriter(new FileOutputStream("AllTheTasks.xml",true), "UTF-8");
		XMLWriterAllTheTasks = new BufferedWriter(XMLOSWriter);
		XMLWriterAllTheTasks.write(BeginFile);
		XMLWriterAllTheTasks.flush();
		XMLWriterAllTheTasks.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	


	}

}
