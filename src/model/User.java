package model;

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
	
	//AJOUTER UNE TACHE
	public void create_task (Task task) {
		//on écrit dans le fichier
	    BufferedWriter XMLWriterAllTheTasks;
	    OutputStreamWriter XMLOSWriter;
		try { 
			XMLOSWriter = new OutputStreamWriter(new FileOutputStream("AllTheTasks.xml",true), "UTF-8");
			XMLWriterAllTheTasks = new BufferedWriter(XMLOSWriter);
			XMLWriterAllTheTasks.write("\n<Task>\n\t<IDTask>" +task.getId_task()+"</IDTask>\n\t<NameTask>"+task.getName_task()+"</NameTask>\n\t<ContentTask>"+task.getContent_task()+"</ContentTask>\n\t<PriorityTask>"+task.getPriority_task()+"</PriorityTask>\n\t<StateTask>"+task.getState_task()+"</StateTask>\n\t<AuthorTask>"+task.getId_author()+"</AuthorTask>\n\t<ActorTask>"+task.getId_actor()+"</ActorTask>\n</Task>");
			XMLWriterAllTheTasks.flush();
			XMLWriterAllTheTasks.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	//SUPPRIMER UNE TACHE
	public void supress_task (String file, Task task) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File(file));
	     racine = document.getRootElement();
		boolean search = true;
		int id = (int)task.getId_task();
		String idS = Integer.toString(id);
		List listTask = racine.getChildren("Task");
		Iterator i = listTask.iterator();
		while((i.hasNext() == true) && (search == true)){
			   Element courant = (Element)i.next();
			   
			   if(courant.getChild("IDTask").getTextTrim().equals(idS)){
				   courant.removeContent();
				   courant.setName("TaskSuppr");
				   search = false;
			   }
		 }

		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(file));
	}
	
	//PRENDRE UNE TACHE
	public void obtain_task (String file, Task task) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File(file));
	     racine = document.getRootElement();
		boolean search = true;
		int id = (int)task.getId_task();
		String idS = Integer.toString(id);
		
		List listTask = racine.getChildren("Task");
		Iterator i = listTask.iterator();
		while((i.hasNext() == true) && (search == true)){
			   Element courant = (Element)i.next();
			   
			   if(courant.getChild("IDTask").getTextTrim().equals(idS)){
				   int at = (int)task.getId_author();
				   String atS = Integer.toString(at);
				   courant.getChild("ActorTask").setText(atS);
				   search = false;
			   }
		 }
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(file));
		
		
		
	}
	
	//COMMENCER UNE TACHE
	public void begin_task (String file, Task task) throws JDOMException, IOException {
		
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File(file));
	     racine = document.getRootElement();
		boolean search = true;
		
		if (task.getState_task().equals("à_faire")) {
			
			//modifier l'état dans le fichier
			List listTask = racine.getChildren("Task");
			Iterator i = listTask.iterator();
			int id = (int)task.getId_task();
			String idS = Integer.toString(id);
			while((i.hasNext() == true) && (search == true)){
				   Element courant = (Element)i.next();
				   
				   if(courant.getChild("IDTask").getTextTrim().equals(idS)){
					   courant.getChild("StateTask").setText("en_cours");
					   search = false;
				   }
			 }	
		}
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(file));
	}
	
	//FINIR UNE TACHE
	public void finish_task(String file, Task task) throws JDOMException, IOException {
			//modifier l'état dans le fichier
			SAXBuilder sxb = new SAXBuilder();
		     document = sxb.build(new File(file));
		     racine = document.getRootElement();
			boolean search = true;
			
			int id = (int)task.getId_task();
			String idS = Integer.toString(id);
			
			if (!task.getState_task().equals("fini")) {
				
				List listTask = racine.getChildren("Task");
				Iterator i = listTask.iterator();
				
				while((i.hasNext() == true) && (search == true)){
					   Element courant = (Element)i.next();
					   if(courant.getChild("IDTask").getTextTrim().equals(idS) ){
						  courant.getChild("StateTask").setText("fini");
						   search = false;
					   }
				 }	
			}
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	        sortie.output(document, new FileOutputStream(file));
			
			
		}
	
	//REMETTRE LA TACHE DANS UN ETAT A FAIRE
	public void change_state_task(String file, Task task) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File(file));
	     racine = document.getRootElement();
		boolean search = true;
		
		int id = (int)task.getId_task();
		String idS = Integer.toString(id);
		List listTask = racine.getChildren("Task");
		Iterator i = listTask.iterator();
		while((i.hasNext() == true) && (search == true)){
			
		    Element courant = (Element)i.next();
			if(courant.getChild("IDTask").getTextTrim().equals(idS) ){
			courant.getChild("StateTask").setText(task.getState_task());
			search = false;
			}
		}	
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(file));
		
		
	}
	
	//MODIFIER UNE TACHE
	public void change_task(String file, Task task) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	     document = sxb.build(new File(file));
	     racine = document.getRootElement();
		boolean search = true;
		
		int id = (int)task.getId_task();
		String idS = Integer.toString(id);
		List listTask = racine.getChildren("Task");
		Iterator i = listTask.iterator();
		while((i.hasNext() == true) && (search == true)){
			
		    Element courant = (Element)i.next();
			if(courant.getChild("IDTask").getTextTrim().equals(idS) ){
				courant.getChild("NameTask").setText(task.getName_task());
				courant.getChild("ContentTask").setText(task.getContent_task());
				courant.getChild("PriorityTask").setText(Integer.toString(task.getPriority_task()));
				courant.getChild("StateTask").setText(task.getState_task());
				courant.getChild("ActorTask").setText(Integer.toString(task.getId_actor()));
				
				search = false;
			}
		}	
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream(file));
		
		
	}
	
}