package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


public class JDOMLectureTasks {

	static org.jdom2.Document document;
	static Element racine;
	
	
	//POUR RECUPERER LES TACHES A FAIRE
	public static List<Task> recupToDoTasks() throws JDOMException, IOException {
		
		List<Task> listTaskToDo = new ArrayList<Task>();
		
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheTasks.xml"));
	    racine = document.getRootElement();
	    List<Element> listTask = racine.getChildren("Task");
	    Iterator<Element> i = listTask.iterator();
		int nbNode = listTask.size();
		int j = 0;
		while(i.hasNext() == true){
			   Element courant = (Element)i.next();
			   j++;
			   if (j < nbNode){
			   if(courant.getChild("StateTask").getTextTrim().equals("a faire")){
				   listTaskToDo.add(new Task(courant.getChild("IDTask").getTextTrim()+"_"
						   			+courant.getChild("NameTask").getTextTrim()+"_"+courant.getChild("ContentTask").getTextTrim()
						   			+"_"+courant.getChild("PriorityTask").getTextTrim()+"_"+courant.getChild("DateTask").getTextTrim()
						   			+"_"+courant.getChild("StateTask").getTextTrim()+"_"+courant.getChild("AuthorTask").getTextTrim()
						   			+"_"+courant.getChild("ActorTask").getTextTrim()));
			   }
			   }
		 }

		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheTasks.xml"));
	
	return listTaskToDo;
	}
	
	
	//POUR RECUPERER LES TACHES EN COURS
	public static List<Task> recupInProgressTasks() throws JDOMException, IOException {
		
		List<Task> listTaskInProgress = new ArrayList<Task>();
		
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheTasks.xml"));
	    racine = document.getRootElement();
	    List<Element> listTask = racine.getChildren("Task");
	    Iterator<Element> i = listTask.iterator();
		int nbNode = listTask.size();
		int j = 0;
		while(i.hasNext() == true){
			   Element courant = (Element)i.next();
			   j++;
			   if (j < nbNode){
			   if(courant.getChild("StateTask").getTextTrim().equals("en cours")){
				   listTaskInProgress.add(new Task(courant.getChild("IDTask").getTextTrim()+"_"
						   			+courant.getChild("NameTask").getTextTrim()+"_"+courant.getChild("ContentTask").getTextTrim()
						   			+"_"+courant.getChild("PriorityTask").getTextTrim()+"_"+courant.getChild("DateTask").getTextTrim()
						   			+"_"+courant.getChild("StateTask").getTextTrim()+"_"+courant.getChild("AuthorTask").getTextTrim()
						   			+"_"+courant.getChild("ActorTask").getTextTrim()));
			   }
			   }
		 }

		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheTasks.xml"));
	
	return listTaskInProgress;
	}


	//POUR RECUPERER LES TACHES FAITES
public static List<Task> recupTasksDone() throws JDOMException, IOException {
		
		List<Task> listTaskDone = new ArrayList<Task>();
		
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheTasks.xml"));
	    racine = document.getRootElement();
	    List<Element> listTask = racine.getChildren("Task");
	    Iterator<Element> i = listTask.iterator();
		int nbNode = listTask.size();
		int j = 0;
		while(i.hasNext() == true){
			   Element courant = (Element)i.next();
			   j++;
			   if (j < nbNode){
			   if(courant.getChild("StateTask").getTextTrim().equals("fini")){
				   listTaskDone.add(new Task(courant.getChild("IDTask").getTextTrim()+"_"
						   			+courant.getChild("NameTask").getTextTrim()+"_"+courant.getChild("ContentTask").getTextTrim()
						   			+"_"+courant.getChild("PriorityTask").getTextTrim()+"_"+courant.getChild("DateTask").getTextTrim()
						   			+"_"+courant.getChild("StateTask").getTextTrim()+"_"+courant.getChild("AuthorTask").getTextTrim()
						   			+"_"+courant.getChild("ActorTask").getTextTrim()));
			   }
			   }
		 }

		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheTasks.xml"));
	
	return listTaskDone;
	}
		
	//POUR RECUPERER LES PRIORITES 5
public static List<Task> recupHighPriorityTasks() throws JDOMException, IOException {
	
	List<Task> listHighPriorityTask = new ArrayList<Task>();
	
	SAXBuilder sxb = new SAXBuilder();
    document = sxb.build(new File("AllTheTasks.xml"));
    racine = document.getRootElement();
    List<Element> listTask = racine.getChildren("Task");
    Iterator<Element> i = listTask.iterator();
	int nbNode = listTask.size();
	int j = 0;
	while(i.hasNext() == true){
		   Element courant = (Element)i.next();
		   j++;
		   if (j < nbNode){
		   if(courant.getChild("PriorityTask").getTextTrim().equals("5")){
			   listHighPriorityTask.add(new Task(courant.getChild("IDTask").getTextTrim()+"_"
					   			+courant.getChild("NameTask").getTextTrim()+"_"+courant.getChild("ContentTask").getTextTrim()
					   			+"_"+courant.getChild("PriorityTask").getTextTrim()+"_"+courant.getChild("DateTask").getTextTrim()
					   			+"_"+courant.getChild("StateTask").getTextTrim()+"_"+courant.getChild("AuthorTask").getTextTrim()
					   			+"_"+courant.getChild("ActorTask").getTextTrim()));
		   }
		   }
	 }

	XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
    sortie.output(document, new FileOutputStream("AllTheTasks.xml"));

return listHighPriorityTask;
}
	

//POUR RECUPERER LES TACHES NON ATTRIBUEES
public static List<Task> recupTasksWithoutActor() throws JDOMException, IOException {
	
	List<Task> listTaskWithoutActor = new ArrayList<Task>();
	
	SAXBuilder sxb = new SAXBuilder();
    document = sxb.build(new File("AllTheTasks.xml"));
    racine = document.getRootElement();
    List<Element> listTask = racine.getChildren("Task");
    Iterator<Element> i = listTask.iterator();
	int nbNode = listTask.size();
	int j = 0;
	while(i.hasNext() == true){
		   Element courant = (Element)i.next();
		   j++;
		   if (j < nbNode){
		   if(courant.getChild("ActorTask").getTextTrim().equals("0")){
			   listTaskWithoutActor.add(new Task(courant.getChild("IDTask").getTextTrim()+"_"
					   			+courant.getChild("NameTask").getTextTrim()+"_"+courant.getChild("ContentTask").getTextTrim()
					   			+"_"+courant.getChild("PriorityTask").getTextTrim()+"_"+courant.getChild("DateTask").getTextTrim()
					   			+"_"+courant.getChild("StateTask").getTextTrim()+"_"+courant.getChild("AuthorTask").getTextTrim()
					   			+"_"+courant.getChild("ActorTask").getTextTrim()));
		   }
		   }
	 }

	XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
    sortie.output(document, new FileOutputStream("AllTheTasks.xml"));

return listTaskWithoutActor;
}

//POUR LES TACHES DE L'UTILISATEUR
public static List<Task> recupYourTasks(String IDcourantUser) throws JDOMException, IOException {
	
	List<Task> listYourTask = new ArrayList<Task>();
	
	SAXBuilder sxb = new SAXBuilder();
    document = sxb.build(new File("AllTheTasks.xml"));
    racine = document.getRootElement();
    List<Element> listTask = racine.getChildren("Task");
    Iterator<Element> i = listTask.iterator();
	int nbNode = listTask.size();
	int j = 0;
	while(i.hasNext() == true){
		   Element courant = (Element)i.next();
		   j++;
		   if (j < nbNode){
		   if(courant.getChild("ActorTask").getTextTrim().equals(IDcourantUser)){
			   listYourTask.add(new Task(courant.getChild("IDTask").getTextTrim()+"_"
					   			+courant.getChild("NameTask").getTextTrim()+"_"+courant.getChild("ContentTask").getTextTrim()
					   			+"_"+courant.getChild("PriorityTask").getTextTrim()+"_"+courant.getChild("DateTask").getTextTrim()
					   			+"_"+courant.getChild("StateTask").getTextTrim()+"_"+courant.getChild("AuthorTask").getTextTrim()
					   			+"_"+courant.getChild("ActorTask").getTextTrim()));
		   }
		   }
	 }

	XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
    sortie.output(document, new FileOutputStream("AllTheTasks.xml"));

return listYourTask;
}


}


