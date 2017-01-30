package model;

import java.net.*;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;

public class Authentification implements Runnable {

	private Socket socket;
	private PrintWriter out = null;
	private BufferedReader in = null;
	private String reception = null
			, login = null
			, pass =  null
			, action = null
			, send = null;
	public boolean authentifier = false;
	public Thread t2;
	
	public Authentification(Socket s){
		 socket = s;
		}
	public void run() {
	
		try {
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			
		while(!authentifier){
			
			reception = in.readLine(); //On récupère une ligne de forme : "action*login*pass"
			System.out.println(reception);
			String[] part = reception.split("_");
			action = part[0];
			login = part[1];
			pass = part[2];
			
			//POUR LA CONNEXION
			if (action.equals("connection")){
				try {
				if(isValid(login, pass)){
					send = getNameAndIDUser(login);
					send = "true_"+send;
					out.println(send);
					out.flush();
					authentifier = true;	
				}
				else {
					out.println("erreur"); 
					out.flush();
				}
				} 
				catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
			}
			
			//POUR L'INSCRIPTION
			if (action.equals("signUp")){
				try {
				if(isANewUser(login, pass)){
					send = getNameAndIDUser(login);
					send = "true_"+send;
					out.println(send);
					out.flush();
					authentifier = true;	
				}
				else {
					out.println("erreur"); 
					out.flush();
				}
				} 
				catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
				
			}
			
		
		} 
		}
		catch (IOException e) {
			System.err.println(login+" ne répond pas !");
		}
			
			
	}
	
	
	static org.jdom2.Document document;
	static Element racine;
	
	//FONCTION QUI VERIFIE SI LE NOM D'UTILISATEUR ET LE MOT DE PASSE SONT CORRECTS 
	//RENVOIE TRUE SI L'UTILISATEUR PEUT SE CONNECTER
	private static boolean isValid(String login, String pass) throws JDOMException, IOException {
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheUsers.xml"));
	    racine = document.getRootElement();
	    List<Element> listUser = racine.getChildren("User");
		Iterator<Element> i = listUser.iterator();
		
		while(i.hasNext() == true){
			   Element courant = (Element)i.next();
			   
			   if (courant.getChild("NameUser").getTextTrim().equals(login)){
				   if(courant.getChild("PswUser").getTextTrim().equals(pass)){
					   return true;
				   }
			   }
		}
		return false;
		
	}

	//FONCTION QUI PERMET A L'UTILISATEUR DE S'INSCRIRE
	private static boolean isANewUser(String login, String pass) throws JDOMException, IOException {
		
		//Pour la lecture du fichier
		SAXBuilder sxb = new SAXBuilder();
	    document = sxb.build(new File("AllTheUsers.xml"));
	    racine = document.getRootElement();
	    List listUsers = racine.getChildren("User");
	    Iterator i = listUsers.iterator();
	    int nbNode = listUsers.size();
	    int j = 0;
	    boolean nameAlreadyUsed = false;
	    String name = new String();
	    
	    while((i.hasNext() == true) && (nameAlreadyUsed == false)){
			   Element courant = (Element)i.next();
			   j++;
			   if(j < nbNode){
				   System.out.println(courant.getChild("NameUser").getTextTrim());
				   if(courant.getChild("NameUser").getTextTrim().equals(login)){
					   nameAlreadyUsed = true;
					   return false;
				   }
			   }
		 }
	    
	    //Si le nom d'utilisateur n'est pas déjà pris, on peut s'inscrire !!
	    if (nameAlreadyUsed == false) {
	    	Element newUser = (Element) listUsers.get(nbNode-1); //on se place au bon endroit
		
	    	Element iDUser = new Element("IDUser");	//création des noeuds
	    	Element nameUser = new Element("NameUser");
	    	Element pswUser = new Element("PswUser");
		
	    	newUser.addContent(iDUser);//ajout des balises au fichier
	    	newUser.addContent(nameUser);
	    	newUser.addContent(pswUser);
		
	    	newUser.getChild("IDUser").addContent(Integer.toString(nbNode)); //ajout du contenu
	    	newUser.getChild("NameUser").addContent(login);
			newUser.getChild("PswUser").addContent(pass);
		
		
			//nouveau noeud user vide
			Element u = new Element("User");
			racine.addContent(u);
	    }
		
	    XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheUsers.xml"));
        return true;
	}
	
	
	//PETITE FONCTION POUR RECUPERER LE NOM DU USER ET L'ID
	private static String getNameAndIDUser(String login) throws JDOMException, IOException{
		String idANDname = null;
		boolean search = true;
		//Pour la lecture du fichier
		SAXBuilder sxb = new SAXBuilder();
		document = sxb.build(new File("AllTheUsers.xml"));
		racine = document.getRootElement();
		List listUsers = racine.getChildren("User");
		Iterator i = listUsers.iterator();
		
		while((i.hasNext() == true) && (search == true)){
			
		    Element courant = (Element)i.next();
			if(courant.getChild("NameUser").getTextTrim().equals(login) ){
				idANDname = login+"_"+courant.getChild("IDUser").getTextTrim();
				search = false;
			}
		}	
		
		XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        sortie.output(document, new FileOutputStream("AllTheUsers.xml"));
		
		return idANDname;
	}
	
}

