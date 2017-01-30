package model;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ParserTaskXML  extends DefaultHandler{
	

	  private List<Task> listTaskSameUser = new ArrayList<Task>();
	  private List<Task> listTaskToDo = new ArrayList<Task>();
	  private List<Task> listTaskInProgress = new ArrayList<Task>();
	  private List<Task> listTaskDone = new ArrayList<Task>();
	  private List<Task> listTaskWithoutActor = new ArrayList<Task>();
	  private List<Task> listTaskHighPriority = new ArrayList<Task>();
	  private List<Task> listAllTasks = new ArrayList<Task>();
	  
	  private Task task = null;
	  private int nbTaskPrio = -1;
	  private int convert = 0;
	  private int idUser = 0;

	  /**
	   * Restitue la liste des taches.
	   * 
	   * @return la liste des taches.
	   */
	  public List<Task> getListTaskSameUser() {
	    return listTaskSameUser;
	  }
	  
	  public List<Task> getListTaskToDo() {
		  return listTaskToDo;
	  }
	  
	  public List<Task> getListTaskInProgress() {
		  return listTaskInProgress;
	  }
	  
	  public List<Task> getListTaskDone() {
		  return listTaskDone;
	  }
	  
	  public List<Task> getListTaskWithoutActor(){
		  return listTaskWithoutActor;
	  }
	  
	  public List<Task> getListTaskHighPriority () {
		  return listTaskHighPriority;
	  }

	  public List<Task> getListAllTasks() {
		  return listAllTasks;
	  }
	  String balise = new String();
	  Boolean debutBalise = true;
	  int numTask = -1;
	  
	  
	  /*
	   * (non-Javadoc)
	   * 
	   * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	   * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	   */
	  @Override
	  public void startElement(String uri,
	                           String localName,
	                           String qName,
	                           Attributes attributes) throws SAXException {
		  balise = localName ;
		  debutBalise = true;
		  
		  if (balise == "Task"){
			  if (numTask != -1) {
				  //exemple si on veut récupérer toutes les taches du user
				  if(task.getId_author() == idUser) {
					  listTaskSameUser.add(task);
				  }
				  if(task.getState_task().equals("en_cours")){
					  listTaskInProgress.add(task);
				  }
				  if(task.getState_task().equals("à_faire")){
					  listTaskToDo.add(task);
				  }
				  if(task.getState_task().equals("fini")){
					  listTaskDone.add(task);
				  }
				  if (task.getId_actor() == 0){
					  listTaskWithoutActor.add(task);
				  }
				  if (task.getPriority_task() == 5){
					  listTaskHighPriority.add(task);
				  }
			  }
			  task = new Task();
			  numTask++;
		  }
		   
	  }

	  /*
	   * (non-Javadoc) BufferedReader
	   * 
	   * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	   * java.lang.String, java.lang.String)
	   */
	  @Override
	  public void endElement(String uri, String localName, String qName) throws SAXException {
		  debutBalise = false;
	  }

	  /*
	   * (non-Javadoc)
	   * 
	   * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	   */
	  @Override
	  public void characters(char[] ch, int start, int length) throws SAXException {
		  String contenu = new String (ch, start, length);
		  if ((balise == "IDTask") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  task.setId_task(convert);
		  }
		  
		  if ((balise == "NameTask") && (debutBalise == true)) {
			  task.setName_task(contenu);
		  }
		  
		  if ((balise == "ContentTask") && (debutBalise == true)) {
			  task.setContent_task(contenu);
		  }
		  
		  if ((balise == "PriorityTask") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  task.setPriority_task(convert);
		  }
		  
		  if ((balise == "StateTask") && (debutBalise == true)) {
			  task.setState_task(contenu);
		  }
		  
		  if ((balise == "AuthorTask") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  task.setId_author(convert);
		  }
		  
		  if ((balise == "ActorTask") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  task.setId_actor(convert);
		  }

		  if ((balise == "DateTask") && (debutBalise == true)){
			  task.setFinal_date_task(contenu);
		  }

	  }

}
