package model;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserUserXML extends DefaultHandler{
	
	  private User user = null;
	  private int convert = 0;
	  private List<String> listUserName = new ArrayList<String>();

	  String balise = new String();
	  Boolean debutBalise = true;

	  public List<String> getListUserName() {
		  return listUserName;
	  }
	  
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
		  
		  if (balise == "IDUser"){
			  user = new User();
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
			  listUserName.add(user.getName_user());
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

		  if ((balise == "IDUser") && (debutBalise == true)) {
			  convert = Integer.parseInt(contenu);
			  user.setId_user(convert);
		  }
		  
		  if ((balise == "NameUser") && (debutBalise == true)) {
			  user.setName_user(contenu);
		  }
		  
		  if ((balise == "PswUser") && (debutBalise == true)) {
			  user.setPws_user(contenu);
		  }
		  

	  }
	  

}
