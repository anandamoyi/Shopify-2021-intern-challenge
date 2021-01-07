import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageMacUpload extends Application {
	
private final Group group;
	
	public ImageMacUpload() {
		group = new Group();
	}
	
	public Group getGroup() {
		return group;
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextField imageUrlField = new TextField();
		Label imageUrl = new Label("Enter the image file path: ");
		Label ex = new Label("ex: /Users/username/Pictures/camera/test/1.JPG");
		HBox h = new HBox(imageUrl,imageUrlField,ex);
		h.setSpacing(10);
		h.setLayoutX(100);
		h.setLayoutY(100);
		group.getChildren().add(h);
		
		Button previousMenu = new Button("Back to menu");
		previousMenu.setLayoutX(0);
		previousMenu.setLayoutY(0);
		Button upload = new Button("Upload");
		upload.setLayoutX(100);
		upload.setLayoutY(200);
		Button imageRepository = new Button("Image Repository");
		imageRepository.setLayoutX(700);
		imageRepository.setLayoutY(700);
		group.getChildren().add(imageRepository);
		group.getChildren().add(previousMenu);
		group.getChildren().add(upload);
		
		
		
		previousMenu.setOnAction(e -> {
			ImageRepositoryMenu imageRepositoryMenu = new ImageRepositoryMenu();
			primaryStage.getScene().setRoot(imageRepositoryMenu.getGroup());
			try {
				imageRepositoryMenu.start(primaryStage);
			} catch(Exception e1) {
				
				e1.printStackTrace();
				
			}
			
		});
		
		upload.setOnAction(e -> {
			ImageRepository.setImageUrl("file:"+imageUrlField.getText());
			
		});
		
       imageRepository.setOnAction(e -> {
			
			ImageRepository repository = new ImageRepository();
			primaryStage.getScene().setRoot(repository.getGroup());
			try {
				repository.start(primaryStage);
			} catch(Exception e1) {
				e1.printStackTrace();
				
			}
			
		});
		
		
		Scene scene = new Scene(group, 900, 1000, Color.BEIGE);
		primaryStage.setScene(scene);
		primaryStage.getScene().setRoot(group);
        primaryStage.setResizable(false);
		primaryStage.show();
	}


}
