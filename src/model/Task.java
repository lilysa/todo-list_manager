package model;

public class Task {

	private int id_task = 0;
	//private int id_user = 0;
	private String name_task = null ;
	private String content_task = null;
	private int priority_task = 0 ;
	private String final_date_task = null;
	private String state_task;
	private User author_task = null;
	private User actor_task = null;
	
	
	//constructor
	public Task (int idt, String name, String content, int priority, String final_date, String state, User author, User actor) {
		
		id_task = idt;
		//id_user = idu;
		name_task = name;
		content_task = content;
		priority_task = priority;
		final_date_task = final_date;
		state_task = state;
		author_task = author;
		actor_task = actor;
		
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
		return name_task;
	}
	
	public void setName_task(String name){
		name_task = name;
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
	
	public User getAuthor_task() {
		return author_task;
	}
	
	public void setAuthor_task(User author) {
		author_task = author;
	}
	
	public User getActor_task() {
		return actor_task;
	}
	
	public void setActor_task(User actor) {
		actor_task = actor;
	}
	public String getState_task() {
		return state_task;
	}
	public void setState_task(String st) {
		//if(st.equals("prete")||st.equals("en_cours")||st.equals("finie"))
			this.state_task = st;
	}
}
