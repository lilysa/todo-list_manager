package viewmodel;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.jdom2.JDOMException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.VBox;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;

import javafx.scene.text.Text;
import model.ControlledScreen;
import model.JDOMLectureTasks;
import model.ScreensController;
import model.Task;


public class ConnectController implements Initializable, ControlledScreen {
	ScreensController myController; 
	
	@FXML	Accordion accordionEnCours;
	@FXML	Accordion accordionUrgentes;
	@FXML	Accordion accordionFinies;
	@FXML	Accordion accordionNonAttribuees;
	@FXML	Accordion accordionVosTaches;
	@FXML	Accordion accordionPretes;
	@FXML	Accordion accordionDernieresTaches;
	@FXML	Button createTask;
	@FXML	Button editTask;

	@FXML	Text todaysDate;
	
	Button modifyTask = new Button("Modifier");
	List<Task> listeTache;
	Task current;
	TitledPane[] tps;
	String contentTitled;
	TextArea taskContent;
	

	
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
		 todaysDate.setText(LocalDate.now().toString());
		 listeTache = new ArrayList<Task>();
		
		 /* --- INITIALISATION TACHES PRETES --- */
		 try {
			listeTache= JDOMLectureTasks.recupToDoTasks();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 try {
					taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			
			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						try{
							String clickedTaskName = ((Text)arg0.getTarget()).getText();
							AppToDoListManager.setCurrentTask(AppToDoListManager.getTaskFromId(clickedTaskName));
							editTask.setDisable(false);
							AppToDoListManager.setCurrentTaskInitialized(true);
							System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
						}catch(ClassCastException e){
							e.printStackTrace();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
		 }
		 accordionPretes.getPanes().addAll(tps);
		 
		 /* --- INITIALISATION TACHES NONATTRIBUEES --- */
		 try {
			listeTache= JDOMLectureTasks.recupTasksWithoutActor();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 try {
					taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			
			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						try{
							String clickedTaskName = ((Text)arg0.getTarget()).getText();
							AppToDoListManager.setCurrentTask(AppToDoListManager.getTaskFromId(clickedTaskName));
							editTask.setDisable(false);
							AppToDoListManager.setCurrentTaskInitialized(true);
							System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
						}catch(ClassCastException e){
							e.printStackTrace();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
		 }
		 accordionNonAttribuees.getPanes().addAll(tps);
		 
		 
		 /* --- INITIALISATION TACHES VOSTACHES --- */
		 try {
			listeTache= JDOMLectureTasks.recupYourTasks(Integer.toString(AppToDoListManager.getCurrentUser().getId_user()));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 try {
					taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
				} catch (JDOMException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			 
			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						try{
							String clickedTaskName = ((Text)arg0.getTarget()).getText();
							AppToDoListManager.setCurrentTask(AppToDoListManager.getTaskFromId(clickedTaskName));
							editTask.setDisable(false);
							AppToDoListManager.setCurrentTaskInitialized(true);
							System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
						}catch(ClassCastException e){
							e.printStackTrace();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
		 }
		 accordionVosTaches.getPanes().addAll(tps);
		 
		 
		 /* --- INITIALISATION TACHES FINIES --- */
		 try {
			listeTache= JDOMLectureTasks.recupTasksDone();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 try {
					taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			
			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						try{
							String clickedTaskName = ((Text)arg0.getTarget()).getText();
							AppToDoListManager.setCurrentTask(AppToDoListManager.getTaskFromId(clickedTaskName));
							editTask.setDisable(false);
							AppToDoListManager.setCurrentTaskInitialized(true);
							System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
						}catch(ClassCastException e){
							e.printStackTrace();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
		 }
		 accordionFinies.getPanes().addAll(tps);
		 
		 
		 /* --- INITIALISATION TACHES URGENTES --- */
		 try {
			listeTache= JDOMLectureTasks.recupHighPriorityTasks();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 try {
					taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
					
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						try{
							String clickedTaskName = ((Text)arg0.getTarget()).getText();
							AppToDoListManager.setCurrentTask(AppToDoListManager.getTaskFromId(clickedTaskName));
							editTask.setDisable(false);
							AppToDoListManager.setCurrentTaskInitialized(true);
							System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
						}catch(ClassCastException e){
							e.printStackTrace();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
		 }
		 accordionUrgentes.getPanes().addAll(tps);
		 
		 /* --- INITIALISATION TACHES ENCOURS --- */
		 try {
			listeTache= JDOMLectureTasks.recupInProgressTasks();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 try {
					taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
				} catch (JDOMException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			
			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent arg0) {
						try{
							String clickedTaskName = ((Text)arg0.getTarget()).getText();
							AppToDoListManager.setCurrentTask(AppToDoListManager.getTaskFromId(clickedTaskName));
							editTask.setDisable(false);
							AppToDoListManager.setCurrentTaskInitialized(true);
							System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
						}catch(ClassCastException e){
							e.printStackTrace();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				});
		 }
		 accordionEnCours.getPanes().addAll(tps);
		 
		 /* --- INITIALISATION TACHES DERNIERESTACHES --- */
		 try { // /!\ listeTache = à changer !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			listeTache= JDOMLectureTasks.recupInProgressTasks();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tps = new TitledPane[listeTache.size()];
		 
		 for(int i = 0; i < listeTache.size(); i++){
			 taskContent = new TextArea();
			 taskContent.clear();
			 
			 try {
				taskContent.setText(JDOMLectureTasks.displayTask(listeTache.get(i)));
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 taskContent.setEditable(false);
			 String contenu= listeTache.get(i).getName_task() + "_" + Integer.toString(listeTache.get(i).getId_task());
			 contentTitled = contenu;
			 tps[i] = new TitledPane(contentTitled, taskContent);
			
//			 tps[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
//					@Override
//					public void handle(MouseEvent arg0) {
//						AppToDoListManager.setCurrentTask(current);
//						editTask.setDisable(false);
//						AppToDoListManager.setCurrentTaskInitialized(true);
//						System.out.println("currentTaskApp : " + AppToDoListManager.getCurrentTask().toString());
//					}
//				});
		 }
		 accordionDernieresTaches.getPanes().addAll(tps);
		 
		 
		 
		 createTask.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	//Task t = new Task(0, "connectcon", "roller", 2, "2017-02-23", "en_cours", new User(1, "Jon Snow", "secret"), new User(2, "Peter Pan", "clochette"));
	                //if(!(AppToDoListManager.getCurrentTask() !=null))
	                		//AppToDoListManager.setCurrentTask(t);
	            	
	            	myController.loadScreen(AppToDoListManager.createTaskID, AppToDoListManager.CreateTaskFile);
	                myController.setScreen(AppToDoListManager.createTaskID);
	            }
	        });
		 
		 editTask.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	//Task t = new Task(0, "connectcon", "roller", 2, "2017-02-23", "en_cours", new User(1, "Jon Snow", "secret"), new User(2, "Peter Pan", "clochette"));
	                //if(!(AppToDoListManager.getCurrentTask() !=null))
	                		//AppToDoListManager.setCurrentTask(t);
	            	
	            	myController.loadScreen(AppToDoListManager.taskManagementID, AppToDoListManager.TaskManagementFile);
	                myController.setScreen(AppToDoListManager.taskManagementID);
	            }
	        });
		 
		 
	    }
	 
	 public void setScreenParent(ScreensController screenParent){
	        myController = screenParent;
	     } 
}
