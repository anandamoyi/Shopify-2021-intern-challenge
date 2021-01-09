import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ImageRepositoryMenu extends Application {

	private final Group groupTwo;
	
	public ImageRepositoryMenu() {
		groupTwo = new Group();
	}
	
	public Group getGroup() {
		return groupTwo;
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label imageUploadOption = new Label("Upload image by");
		Font f = new Font("verdana", 20);
		imageUploadOption.setLayoutX(20);
		imageUploadOption.setLayoutY(50);
		imageUploadOption.setFont(f);
		groupTwo.getChildren().add(imageUploadOption);
		
		Button imageUrl = new Button("Image url");
		Button windowsPath = new Button("Windows file path");
		Button macPath = new Button("Mac file path");
		
		imageUrl.setLayoutX(100);
		imageUrl.setLayoutY(500);
		windowsPath.setLayoutX(400);
		windowsPath.setLayoutY(500);
		macPath.setLayoutX(700);
		macPath.setLayoutY(500);
		
		groupTwo.getChildren().add(imageUrl);
		groupTwo.getChildren().add(windowsPath);
		groupTwo.getChildren().add(macPath);
		
		imageUrl.setOnAction(e -> {
			ImageUrlUpload imageUrlUpload = new ImageUrlUpload();
			primaryStage.getScene().setRoot(imageUrlUpload.getGroup());
			try {
				imageUrlUpload.start(primaryStage);
			} catch(Exception e1) {
				
				e1.printStackTrace();
				
			}
			
		});
		
		windowsPath.setOnAction(e -> {
			ImageWindowsUpload imageWindowsUpload = new ImageWindowsUpload();
			primaryStage.getScene().setRoot(imageWindowsUpload.getGroup());
			try {
				imageWindowsUpload.start(primaryStage);
			} catch(Exception e1) {
				
				e1.printStackTrace();
				
			}
			
		});
		
		macPath.setOnAction(e -> {
			ImageMacUpload imageMacUpload = new ImageMacUpload();
			primaryStage.getScene().setRoot(imageMacUpload.getGroup());
			try {
				imageMacUpload.start(primaryStage);
			} catch(Exception e1) {
				
				e1.printStackTrace();
				
			}
			
		});
		
		Scene scene = new Scene(groupTwo, 900, 1000, Color.BEIGE);
		primaryStage.setScene(scene);
		
        primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	
}
