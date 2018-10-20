import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox
{
    public static void display(String title , String message)
    {
	    Stage window = new Stage();
	    window.setTitle(title);
	    window.setMinWidth(300);
	    window.setMinHeight(150);
	    Button button = new Button("关闭");
	    button.setOnAction(e -> window.close());
	    button.setOnKeyPressed(e -> window.close());
	    Label label = new Label(message+"(按任意键继续…)");
	    VBox layout = new VBox(10);
	    label.setTextFill(Color.RED);
	    layout.getChildren().addAll(label , button);
	    layout.setAlignment(Pos.CENTER);
	    Scene scene = new Scene(layout);
	    window.setScene(scene);
	    window.showAndWait();
    }
}