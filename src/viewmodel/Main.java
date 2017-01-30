package viewmodel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Authentification;
import model.JDOMLectureTasks;
import model.Task;
import model.User;

public class Main {

	static org.jdom2.Document document;
	   static org.jdom2.Element racine;
	
	public static void main(String[] args) {

/*

	//INITIALISATION DES VARIABLES UTILES POUR LA CREATION D'UN USER ET D'UNE TACHE
	int id = 2;
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

	try {
		//us1.begin_task("test.xml",test1);
		//us1.finish_task("test.xml", test1);
		//us1.obtain_task("test.xml", test1);
		//us1.supress_task("test.xml", test1);
		//us1.change_task("test.xml", test1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try {
		us1.create_task(test1);
		us1.create_task(test1);
		us1.supress_task(test1);
		
	} catch (JDOMException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

*/
	
		try {
			List<Task> Test = JDOMLectureTasks.recupToDoTasks();
			System.out.println(Test.get(0).getName_task());
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	
	

	
	
}	
