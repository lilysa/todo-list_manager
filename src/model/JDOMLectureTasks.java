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
		   if(courant.getChild("ActorTask").getTextTrim().equals("-2")){
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

//POUR RECUPERER LES DEUX DERNIERES TACHES
public static List<Task> recupTwoLastTasks(String IDcourantUser) throws JDOMException, IOException {
	
	List<Task> TwoLastTasks = new ArrayList<Task>();
	
	SAXBuilder sxb = new SAXBuilder();
    document = sxb.build(new File("AllTheTasks.xml"));
    racine = document.getRootElement();
    
    List<Element> listTask = racine.getChildren("Task");
    
    int nbNode = listTask.size();
	if (nbNode>1){
    Element last1 = listTask.get(nbNode-1);
    TwoLastTasks.add(new Task(last1.getChild("IDTask").getTextTrim()+"_"
   			+last1.getChild("NameTask").getTextTrim()+"_"+last1.getChild("ContentTask").getTextTrim()
   			+"_"+last1.getChild("PriorityTask").getTextTrim()+"_"+last1.getChild("DateTask").getTextTrim()
   			+"_"+last1.getChild("StateTask").getTextTrim()+"_"+last1.getChild("AuthorTask").getTextTrim()
   			+"_"+last1.getChild("ActorTask").getTextTrim()));
   
    if(nbNode>2){
    Element last2 = listTask.get(nbNode-2);
    TwoLastTasks.add(new Task(last2.getChild("IDTask").getTextTrim()+"_"
   			+last2.getChild("NameTask").getTextTrim()+"_"+last1.getChild("ContentTask").getTextTrim()
   			+"_"+last2.getChild("PriorityTask").getTextTrim()+"_"+last2.getChild("DateTask").getTextTrim()
   			+"_"+last2.getChild("StateTask").getTextTrim()+"_"+last2.getChild("AuthorTask").getTextTrim()
   			+"_"+last2.getChild("ActorTask").getTextTrim()));
    }
	}
	XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
    sortie.output(document, new FileOutputStream("AllTheTasks.xml"));

return TwoLastTasks;
}


//POUR RECUPERER UNE TACHE AVEC UN JOLI AFFICHAGE
public static String displayTask(Task t) throws JDOMException, IOException {
	String display = new String ();
	String idAuthor = new String();
	String idActor = new String();
	
	SAXBuilder sxb = new SAXBuilder();
    document = sxb.build(new File("AllTheTasks.xml"));
    racine = document.getRootElement();
    
    List<Element> listTask = racine.getChildren("Task");
    Iterator<Element>i = listTask.iterator();
    
    boolean search = true;
    int nbNode = listTask.size();
    int j = 0;
    
    int id = (int)t.getId_task();
	String idS = Integer.toString(id);
	
	while((i.hasNext() == true) && (search == true)){
		   Element courant = (Element)i.next();
		   
		   if(courant.getChild("IDTask").getTextTrim().equals(idS)){
			   display = "\nDate de fin : "+courant.getChild("DateTask").getTextTrim()+
					   "\nDescription : "+courant.getChild("ContentTask").getTextTrim()+					   
					   "\nPriorité : "+courant.getChild("PriorityTask").getTextTrim()+
					   "\nÉtat : "+courant.getChild("StateTask").getTextTrim();
			   idActor = courant.getChild("ActorTask").getTextTrim();
			   idAuthor = courant.getChild("AuthorTask").getTextTrim();
			   search = false;
		   } //à ce stade on a tout sauf l'auteur et le réalisateur	   
	}
	
	//pour récupérer l'acteur
	String actor = t.getNameActor(Integer.parseInt(idActor));
    String author = t.getNameAuthor(Integer.parseInt(idAuthor));
    display = "Réalisateur : "+actor+"\nCréateur de la tâche :"+author+display;
    
	return display;
}



}


