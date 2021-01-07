import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
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

public class ImageRepository extends Application {
	
	private final Group group;
	
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
	//zasqsqws
	@Override
	   public void start(Stage stage) {
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
	      Scene scene = new Scene(group, 595, 355, Color.BEIGE);
	      stage.setTitle("File Chooser Example");
	      stage.setScene(scene);
	      stage.show();
	   }
	   public static void main(String args[]){
	      launch(args);
	   }
	}


