package model;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ParserXML  extends DefaultHandler{
	

	  private List<Task>   listTaskSameUser = new ArrayList<Task>();
	  private Task task = null;
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

	  String balise = new String();
	  Boolean debutBalise = true;

	  
	  
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
		  
		  if (balise == "IDTask"){
			  task = new Task();
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
		  	  
		  if(balise == "IDTask") {
			  //exemple si on veut récupérer toutes les taches du user
			  if(task.getId_author() == idUser) {
				  listTaskSameUser.add(task);
			  }
		  }
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
		  
		  /**if ((balise == "StateTask") && (debutBalise == true)) {
			  task.setState_task(contenu);
		  }*/
		  
		  if ((balise == "AuthorTask") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  task.setId_author(convert);
		  }
		  
		  if ((balise == "ActorTask") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  task.setId_actor(convert);
		  }


	  }

}
