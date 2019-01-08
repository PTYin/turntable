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
public class Prompt extends Application {
	private int MAXN = 50;
	public int num;
	public String[] names = new String[MAXN];
	public void start(Stage primaryStage)
	{
		RadioButton classic = new RadioButton("经典");
		RadioButton specific = new RadioButton("特制");
		VBox pane = new VBox(20);
		Button submit = new Button("submit!");
		pane.getChildren().addAll(classic, specific);
		pane.getChildren().add(submit);
		pane.setAlignment(Pos.CENTER);
		classic.setOnKeyPressed(e ->
		{
			if(e.getCode() == KeyCode.ENTER)
			{
				try
				{
					new Num().start(new Stage());
					primaryStage.close();
				}
				catch(Exception event)
				{
					AlertBox.display("error!", "输入一个整数！");
				}
			}
		});
		specific.setOnKeyPressed(e ->
		{
			if(e.getCode() == KeyCode.ENTER)
			{
				try
				{
					new Turntable2().start(new Stage());
					primaryStage.close();
				}
				catch(Exception event)
				{
					AlertBox.display("error!", "输入一个整数！");
				}
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
			try
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
			}
			catch(Exception event) 
			{
		        AlertBox.display("error!", "输入一个整数！");
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
