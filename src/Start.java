import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.RadioButton;
public class Start extends Application {
	private int MAXN = 50;
	public int num;
	public String[] names = new String[MAXN];
	public void start(Stage primaryStage)
	{
		RadioButton classic = new RadioButton("经典");
		RadioButton specific = new RadioButton("PS特制");
		VBox pane = new VBox(20);
		Button submit = new Button("submit!");
		pane.getChildren().addAll(classic, specific);
		pane.getChildren().add(submit);
		pane.setAlignment(Pos.CENTER);
		classic.setOnKeyPressed(e ->
		{
			if(e.getCode() == KeyCode.ENTER)
			{
				classic.setSelected(true);
				new Num().start(new Stage());
				primaryStage.close();
			}
		});
		specific.setOnKeyPressed(e ->
		{
			if(e.getCode() == KeyCode.ENTER)
			{
				specific.setSelected(true);
				new Turntable2().start(new Stage());
				primaryStage.close();
			}
		});
		classic.setOnAction(e -> 
		{
			specific.setSelected(false);
		});
		specific.setOnAction(e -> 
		{
			classic.setSelected(false);
		});
		submit.setOnAction(e -> 
		{
			if(classic.isSelected())
			{
				new Num().start(new Stage());
				primaryStage.close();
			}
			if(specific.isSelected())
			{
				new Turntable2().start(new Stage());
				primaryStage.close();
			}
		});
		Scene scene = new Scene(pane, 300, 150);
		primaryStage.setTitle("Prompt");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
