import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class MyPane extends BorderPane
{
	public VBox vbox1 = new VBox(0.1);
	public TextField minutes = new TextField();
	public TextField seconds = new TextField();
	public Button begin = new Button("QuickStart");
	public Button finish = new Button("Stop");
	public Button start = new Button("Start!");
	public MyPane()
	{
		try
		{
			Image img = new Image("/timgg.jpg");
			BackgroundImage bgimg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background background = new Background(bgimg);
			this.setBackground(background);
		}
		catch(Exception e)
		{
			this.setStyle("-fx-background-color: cornsilk");
		}
		Label logo = new Label("\n\n\nPOWERED\nBY   PTYin");
		VBox vbox2 = new VBox(20);
		FlowPane fp = new FlowPane();
		Label lminutes = new Label("MIN:");
		Label lseconds = new Label("SEC:");
/*-----------------------------------------------------------------------------*/
		logo.setFont(Font.font("Arial Black", 10));
		logo.setTextFill(Color.WHITE);
		logo.setAlignment(Pos.TOP_LEFT);
		logo.setPadding(new Insets(0,0,30,0));
		lminutes.setFont(Font.font("Gill Sans Ultra Bold",25));
		lminutes.setTextFill(Color.SNOW);
		lseconds.setFont(Font.font("Gill Sans Ultra Bold",25));
		lseconds.setTextFill(Color.SNOW);
/*-----------------------------------------------------------------------------*/
		vbox1.setPadding(new Insets(0, 28, 0, 0));
		vbox2.getChildren().addAll(begin, finish);
		fp.getChildren().addAll(lminutes, minutes, lseconds, seconds, start);
		fp.setAlignment(Pos.BOTTOM_CENTER);
		minutes.setText("0");
		seconds.setText("0");
		this.setTop(logo);
		this.setBottom(fp);
		this.setLeft(vbox1);
		this.setRight(vbox2);
		
	}
}
