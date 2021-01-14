import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ImageRepository extends Application {
	
	private final Group group;
	private Properties prop = new Properties();
	private Properties prop2 = new Properties();
	private int index = 0;
	
	String name;
	String age;
	
	
	public ImageRepository() {
		group = new Group();
	}
	
	private static String imageUrl = null;
	private int X = 0;
	private int Y = 0;
	
	public Group getGroup() {
		return group;
	}
	
	public static String getImageUrl() {
		return imageUrl;
	}
	
	public static void setImageUrl(String url) {
		imageUrl = url;
	}
	
	@Override
	   public void start(Stage stage) {
		
		 try (InputStream input = new FileInputStream("imageRepo.properties")) {
			 
			 if(input != null) {
				 prop.load(input);
			 }
	        	
	        } catch(IOException io) {
	        	
	        	io.printStackTrace();
	        	
	        }
	        
	        try (InputStream input2 = new FileInputStream("coordinate.properties")) {
	        	
	        	if(input2 != null) {
	        		prop2.load(input2);
	        	}
	        	
	        } catch(IOException io) {
	        	
	        	io.printStackTrace();
	        	
	        }
	        
	        Object[] images = prop.keySet().toArray();
	        Object[] xCoordinates = prop2.keySet().toArray();
	        
	        if(!(prop.isEmpty())) {
	        	if(Integer.parseInt(prop.getProperty((String)images[images.length-1]))!= 900) {
	        		X = Integer.parseInt(prop.getProperty((String)images[images.length-1])) + 52;
	        	} else {
	        		X = 0;
	        	}
	        }
	        
	        if(!(prop2.isEmpty())) {
	        	if(Integer.parseInt(prop.getProperty((String)images[images.length-1]))== 900 || Integer.parseInt(prop2.getProperty((String) xCoordinates[xCoordinates.length-1])) != 1000 ) {
	        		Y = Integer.parseInt(prop2.getProperty((String) xCoordinates[xCoordinates.length-1])) + 52;
	        	} else if(Integer.parseInt(prop2.getProperty((String) xCoordinates[xCoordinates.length-1])) == 1000){
	        		
	        		Y = 0;
	        		
	        	}else {
	        	
	        		Y = Integer.parseInt(prop2.getProperty((String) xCoordinates[xCoordinates.length-1]));
	        	}
	        }
	        
	        prop.setProperty(imageUrl, String.valueOf(X));
	        prop2.setProperty(String.valueOf(X), String.valueOf(Y));
	        
	        Object[] addedImages = prop.keySet().toArray();
	        
	        //int index = 0;
	        prop2.forEach((k,v) -> {
	        	if(index < prop.size()) {
	        	
	        	Image image = new Image((String)addedImages[index]);
	        	
	        	ImageView imageView = new ImageView(image);
	        	imageView.setFitHeight(50);
	        	imageView.setFitWidth(50);
	        	imageView.setLayoutX(Integer.parseInt((String)k));
	        	imageView.setLayoutY(Integer.parseInt((String)v));
	        	group.getChildren().add(imageView);
	        	
	        	System.out.println((String)addedImages[index]);
	        	System.out.println(Integer.parseInt((String)k));
	        	System.out.println(Integer.parseInt((String)v));
	        	index++;
	        	} 
	        	
	        }
	        );
	        
	        System.out.println(index);
		
		try (OutputStream output = new FileOutputStream("imageRepo.properties")) {
			
			prop.store(output,null);
			
		} catch(IOException io) {
			io.printStackTrace();
		}
		
        try (OutputStream output2 = new FileOutputStream("coordinate.properties")) {
        	
        	prop2.store(output2, null);
			
		} catch(IOException io) {
			io.printStackTrace();
		}
        
        Button backToMenu = new Button("Back to menu");
        backToMenu.setLayoutX(600);
        backToMenu.setLayoutY(600);
        group.getChildren().add(backToMenu);
        
        backToMenu.setOnAction(e->{
        	ImageRepositoryMenu imageRepositoryMenu = new ImageRepositoryMenu();
        	stage.getScene().setRoot(imageRepositoryMenu.getGroup());
			try {
				imageRepositoryMenu.start(stage);
			} catch(Exception e1) {
				
				e1.printStackTrace();
				
			}
        });
        
        /**
        
		  String path = imageUrl;
		  	; 
		  String pathTwo = "https://static.wikia.nocookie.net/peanuts/images/1/1e/Joecooltrans.png/revision/latest?cb=20200228013110"
 
				  	; 
		  Image image = new Image(path);	
	      ImageView imgView = new ImageView(image);
	      Image image2 = new Image(pathTwo);	
	      ImageView imgView2 = new ImageView(image2);
	      imgView.setFitWidth(20);
	      imgView.setFitHeight(20);
	      imgView2.setFitWidth(20);
	      imgView2.setFitHeight(20);
	      imgView.setLayoutX(X);
	      Menu file = new Menu("Repository");
	      MenuItem item = new MenuItem("Save", imgView);
	      MenuItem item2 = new MenuItem("Save2",imgView2);
	      file.getItems().addAll(item);
	      file.getItems().addAll(item2);
	      //Creating a File chooser
	      FileChooser fileChooser = new FileChooser();
	      fileChooser.setTitle("Save");
	      fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
	      DirectoryChooser directoryChooser = new DirectoryChooser();
	      directoryChooser.setTitle("Save");
	      
	      //Adding action on the menu item
	      item.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent event) {
	              //Opening a dialog box
	              fileChooser.showSaveDialog(stage);
	           }
	        });
	      item2.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent event) {
	              //Opening a dialog box
	              directoryChooser.showDialog(stage);
	           }
	        });
	      //Creating a menu bar and adding menu to it.
	      MenuBar menuBar = new MenuBar(file);
	      group.getChildren().add(menuBar);
	      //Group root = new Group(menuBar);
	       * 
	       */
	      //Scene scene = new Scene(group, 900, 1000, Color.BEIGE);
	     // stage.setTitle("File Chooser Example");
	     // stage.setScene(scene);
            stage.getScene().setRoot(group);
	        stage.show();
	   }
	   public static void main(String args[]){
	      launch(args);
	   }
	}


