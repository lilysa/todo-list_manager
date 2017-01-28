package model;

import model.Task;

public class User {

	private int id_user = 0;
	private String name_user = null;
	private String psw_user = null;

	//constructeur
	public User (int id, String name, String psw){
		id_user = id;
		name_user = name;
		psw_user = psw;
		
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
		//on �crit dans le fichier
	}
		
	//SUPPRIMER UNE TACHE
	public void supress_task (Task task) {
		//suppression dans le fichier xml
	}
	
	//PRENDRE UNE TACHE
	public void obtain_task (Task task) {
		task.setId_author(this.getId_user());
		//modifier l'auteur dans le fichier
	}
	
	//COMMENCER UNE TACHE
	public void begin_task (Task task) {
		if (!task.getState_task().equals("en_cours")) {
			task.setState_task("en_cours");
			//modifier l'�tat dans le fichier
		}	
	}
	
	//FINIR UNE TACHE
	public void finish_task(Task task) {
		if (!task.getState_task().equals("fini")) {
			task.setState_task("fini");
			//modifier l'�tat dans le fichier
		}
	}
	
}