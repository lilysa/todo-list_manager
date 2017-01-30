package model;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Task;


public class User {

	static org.jdom2.Document document;
	static Element racine;
	
	private int id_user = 0;
	private String name_user = null;
	private String psw_user = null;

	//constructeur
	public User (int id, String name, String psw){
		id_user = id;
		name_user = name;
		psw_user = psw;
		
	}
	//autre constructeur
	public User() {
		
	}
	
	
	//TOUS LES GET ET LES SET
	public int getId_user() {
		return this.id_user;
	}
	
	public void setId_user(int id){
		this.id_user = id;
	}
	
	public String getName_user(){
		return this.name_user;
	}
	
	public void setName_user(String name){
		this.name_user = name;
	}
	
	public String getPsw_user() {
		return this.psw_user;
	}
	
	public void setPws_user(String psw){
		this.psw_user = psw;
	}
	
	//VERIFIE EXISTENCE ACTOR
	//L'utilisateur ne doit pas pouvoir créer une tâche ayant un acteur fictif
	public boolean existActor (String actor) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheUsers.xml"));
	    racine = document.getRootElement();
	    
	    boolean search = true;
	    int j = 0;
	    
	    List<Element> listTask = racine.getChildren("User");
	    Iterator<Element>i = listTask.iterator();
	    int nbNode = listTask.size();
		while((i.hasNext() == true) && (search == true)){
			Element courant = (Element)i.next();
			j++;
			if (j<nbNode) {
				if(courant.getChild("NameUser").getTextTrim().equals(actor)){
					return true;
				}
			}
		}
		
		return false;
	}
	
	//AJOUTER UNE TACHE
	public void create_task (Task task) throws JDOMException, IOException {
		
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheTasks.xml"));
	    racine = document.getRootElement();
	    List<Element> listTask = racine.getChildren("Task");
		int nbNode = listTask.size();
		Element newTask = (Element) listTask.get(nbNode-1); //on se place au bon endroit
		
		Element iDTask = new Element("IDTask");	//création des noeuds
		Element nameTask = new Element("NameTask");
		Element contentTask = new Element("ContentTask");
		Element priorityTask = new Element("PriorityTask");
		Element stateTask = new Element("StateTask");
		Element authorTask = new Element("AuthorTask");
		Element actorTask = new Element("ActorTask");
		Element dateTask = new Element("DateTask");
		
		newTask.addContent(iDTask);//ajout des balises au fichier
		newTask.addContent(nameTask);
		newTask.addContent(contentTask);
		newTask.addContent(priorityTask);
		newTask.addContent(stateTask);
		newTask.addContent(authorTask);
		newTask.addContent(actorTask);
		newTask.addContent(dateTask);
		
		newTask.getChild("IDTask").addContent(Integer.toString(nbNode)); //ajout du contenu des balises
		newTask.getChild("NameTask").addContent(task.getName_task());
		newTask.getChild("ContentTask").addContent(task.getContent_task());
		newTask.getChild("PriorityTask").addContent(Integer.toString(task.getPriority_task()));
		newTask.getChild("StateTask").addContent(task.getState_task());
		newTask.getChild("AuthorTask").addContent(Integer.toString(task.getId_author()));
		newTask.getChild("ActorTask").addContent(Integer.toString(task.getId_actor()));
		newTask.getChild("DateTask").addContent(task.getFinal_date_task());
		
		//nouveau noeud task vide
		Element t = new Element("Task");
		racine.addContent(t);
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheTasks.xml"));
		
	}
		
	//SUPPRIMER UNE TACHE
	public void supress_task (Task task) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File("AllTheTasks.xml"));
	     racine = document.getRootElement();
		boolean search = true;
		int id = (int)task.getId_task();
		String idS = Integer.toString(id);
		List<Element> listTask = racine.getChildren("Task");
		Iterator<Element> i = listTask.iterator();
		while((i.hasNext() == true) && (search == true)){
			   Element courant = (Element)i.next();
			   
			   if(courant.getChild("IDTask").getTextTrim().equals(idS)){
				   courant.removeContent();
				   courant.setName("TaskSuppr");
				   search = false;
			   }
		 }

		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheTasks.xml"));
	}
	
	//MODIFIER UNE TACHE
	public void change_task(Task task) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File("AllTheTasks.xml"));
	     racine = document.getRootElement();
		boolean search = true;
		
		int id = (int)task.getId_task();
		String idS = Integer.toString(id);
		List<Element> listTask = racine.getChildren("Task");
		Iterator<Element> i = listTask.iterator();
		while((i.hasNext() == true) && (search == true)){
			
		    Element courant = (Element)i.next();
			if(courant.getChild("IDTask").getTextTrim().equals(idS) ){
				courant.getChild("NameTask").setText(task.getName_task());
				courant.getChild("ContentTask").setText(task.getContent_task());
				courant.getChild("PriorityTask").setText(Integer.toString(task.getPriority_task()));
				courant.getChild("StateTask").setText(task.getState_task());
				courant.getChild("ActorTask").setText(Integer.toString(task.getId_actor()));
				courant.getChild("DateTask").setText(task.getFinal_date_task());
				search = false;
			}
		}	
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheTasks.xml"));
		
		
	}
	
}