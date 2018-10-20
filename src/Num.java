import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
public class Num extends Application {
	private static int MAXN = 50;
	public static int num;
	public static String[] names = new String[MAXN];
	public void start(Stage primaryStage)
	{
		Label lnum = new Label("请输入你的人数：");	
		TextField tnum = new TextField();
		FlowPane pane1 = new FlowPane();
		VBox pane2 = new VBox(50);
		Button submit = new Button("submit!");
		pane1.getChildren().addAll(lnum, tnum);
		pane1.setAlignment(Pos.CENTER);
		pane2.getChildren().addAll(pane1, submit);
		pane2.setAlignment(Pos.CENTER);
		Scene scene1 = new Scene(pane2, 400, 200);
		primaryStage.setTitle("Prompt");
		primaryStage.setScene(scene1);
		primaryStage.show();
		submit.setOnAction(e -> 
		{
			try
			{
				num = Integer.valueOf(tnum.getText()).intValue();
				primaryStage.close();
				InputBox input = new InputBox();
				input.display(0, new Stage());
			}
			catch(Exception event) 
			{
		        AlertBox.display("error!", "输入一个整数！");
			}
		});
		tnum.setOnKeyPressed(e ->
		{
				if(e.getCode() == KeyCode.ENTER)
				{
					try
					{
						num = Integer.valueOf(tnum.getText()).intValue();
						InputBox input = new InputBox();
						input.display(0, primaryStage);
					}
					catch(Exception event) 
					{
				        AlertBox.display("error!", "输入一个整数！");
					}
				}
		});
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
