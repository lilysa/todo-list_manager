package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Task {

	private int id_task = 0;
	//private int id_user = 0;
	private String name_task = null ;
	private String content_task = null;
	private int priority_task = 0 ;
	private String final_date_task = null;
	//public enum state {�_faire, en_cours, fini };
	//private state state_task;
	private String state_task = null;
	private int id_author = 0;
	private int id_actor = 0;
	
	
	//constructor
	public Task (int idt, String name, String content, int priority, String final_date, String state, int author, int actor) {
		
		id_task = idt;
		//id_user = idu;
		name_task = name;
		content_task = content;
		priority_task = priority;
		final_date_task = final_date;
		state_task = state;
		id_author = author;
		id_actor = actor;
		
	}
	
	//constructor
	public Task () {
		
	}
	

	public int getId_task() {
		return this.id_task;
	}
	
	public void setId_task(int id){
		this.id_task = id;
	}
	
	/**public int getId_user() {
		return this.id_user;
	}
	
	public void setId_user(int id){
		this.id_user = id;
	}
*/
	
	public String getName_task() {
		return this.name_task;
	}
	
	public void setName_task(String name){
		this.name_task = name;
	}
	
	public String getContent_task() {
		return this.content_task;
	}
	
	public void setContent_task(String content){
		this.content_task = content;
	}
	
	public int getPriority_task() {
		return this.priority_task;
	}
	
	public void setPriority_task(int priority){
		this.priority_task = priority;
	}
	
	public String getFinal_date_task() {
		return this.final_date_task;
	}
	
	public void setFinal_date_task(String date){
		this.final_date_task = date;
	}
	
	public String getState_task() {
		return this.state_task;
	}
	
	public void setState_task(String state){
		this.state_task = state;
	}
	
	public int getId_author() {
		return id_author;
	}
	
	public void setId_author(int author) {
		id_author = author;
	}
	
	public int getId_actor() {
		return id_actor;
	}
	
	public void setId_actor(int actor) {
		id_actor = actor;
	}
	
	
	static org.jdom2.Document document;
	static Element racine;
	
	
	//PETITE FONCTION POUR RECUPERER LE NOM DE L'ACTEUR
	public String getNameActor(int idActor) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheUsers.xml"));
	    racine = document.getRootElement();
		boolean search = true;

		List listUsers = racine.getChildren("User");
		Iterator i = listUsers.iterator();
		
		while((i.hasNext() == true) && (search == true)){
			
		    Element courant = (Element)i.next();
			if(courant.getChild("IDUser").getTextTrim().equals(Integer.toString(idActor)) ){
				search = false;
				return courant.getChild("NameUser").getTextTrim();
			}
		}	
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
       sortie.output(document, new FileOutputStream("AllTheUsers.xml"));
       return "erreur";	
	}
	
	
	
}
