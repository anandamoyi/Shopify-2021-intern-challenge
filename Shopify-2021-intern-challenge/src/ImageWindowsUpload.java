import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 

//User can upload images using Windows image directory
public class ImageWindowsUpload extends Application {
	// 16d5c7e514c37b62e7d24b724551bf1ed0930e4b
private final Group groupFour;
	
	public ImageWindowsUpload() {
		groupFour = new Group();
	}
	
	public Group getGroup() {
		return groupFour;
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	/**
	 *  nx xnsjsbddbdbcdbcbdcdbccc
	 *  xsndsbchdschdsbchdsbchdsbchsd
	 *  xdsncjdsbchdschdsvchgsdv
	 */
	
	//@Override
	//creates UI
	/**
		upload.setOnAction(e -> {
			ImageRepository.setImageUrl("file:///C:"+imageUrlField.getText());
			ImageRepository repository = new ImageRepository();
			primaryStage.getScene().setRoot(repository.getGroup());
			try {
				repository.start(primaryStage);
			} catch(Exception e1) {
				e1.printStackTrace();
				
			}
			
		});
		
		/**
		
       imageRepository.setOnAction(e -> {
			
			ImageRepository repository = new ImageRepository();
			primaryStage.getScene().setRoot(repository.getGroup());
			try {
				repository.start(primaryStage);
			} catch(Exception e1) {
				e1.printStackTrace();
				
			}
			
		});
		**/
		
		
		
		//primaryStage.getScene().setRoot(groupFour);
       // primaryStage.setResizable(false);
		//primaryStage.show();
		**/ 
	//}

}
