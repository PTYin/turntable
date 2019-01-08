import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.shape.*;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public class Turntable2 extends Application
{
	private final int MAXN = 50;
	private final double R = 300D;
	private int averageSpeed = 1;//平均每秒转多少圈
	private int mins = 0, secs = 0;
	public ArrayList<Group> partitions = new ArrayList<Group>();
	public int[][] color = new int[MAXN][3];
	public String[] names = new String[MAXN];
	public void start(Stage primaryStage)
	{
		Image img = new Image("/timgg.jpg");
		BackgroundImage bgimg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(bgimg);
		Random random = new Random();
		Label logo = new Label("POWERED\nBY   PTYin");
		VBox vbox1 = new VBox(0.1);
		VBox vbox2 = new VBox(20);
		FlowPane fp = new FlowPane();
		Button begin = new Button("QuickStart");
		Button finish = new Button("Stop");
		Group table = new Group();
		Label lminutes = new Label("MIN:");
		TextField minutes = new TextField();
		Label lseconds = new Label("SEC:");
		TextField seconds = new TextField();
		Button start = new Button("Start!");
		int n = 32;
		for(int i = 0; i<n; ++i)
		{
			Arc arc = new Arc(0,R,R,R,(double)i*360/(double)n,360/(double)n);
			color[i][0] = random.nextInt(255);
			color[i][1] = random.nextInt(255);
			color[i][2] = random.nextInt(255);
			arc.setType(ArcType.ROUND);
			arc.setStroke(Color.BLACK);
			arc.setFill(Color.rgb(color[i][0], color[i][1], color[i][2]));
			double angle = ((360D/(double)n)*((double)i+0.5))/180D*Math.PI;
			double x = Math.cos(angle)*4*R/5;
			double y = R*(1-Math.sin(angle)*4/5);
			Text index = new Text(x-10, y+7, String.valueOf(i+1));
			index.setRotate(90-((360D/(double)n)*((double)i+0.5)));
			index.setFont(Font.font(18));
			index.setFill(Color.WHITE);
			Group partition = new Group(arc, index);
			partitions.add(partition);
			table.getChildren().add(partitions.get(i));
			Label label = new Label("编号:"+String.valueOf(i+1));
			label.setFont(new Font("华文琥珀", 18));
			label.setTextFill(Color.rgb(color[i][0], color[i][1], color[i][2]));
			vbox1.getChildren().add(label);
		}
		logo.setFont(Font.font("Arial Black", 10));
		logo.setTextFill(Color.WHITE);
		logo.setAlignment(Pos.TOP_LEFT);
		logo.setPadding(new Insets(0,0,30,0));
		BorderPane pane = new BorderPane();
		pane.setBackground(background);
		Line line = new Line(0, R, 0, 0);
		line.setStroke(Color.RED);
		line.setStrokeWidth(2);
		Circle circle = new Circle(0,20,10);
		circle.setFill(Color.RED);
		Group pointer = new Group(line, circle);
		pane.setTop(logo);
		Group arch = new Group(table, pointer);
		vbox1.setPadding(new Insets(0, 28, 0, 0));
		pane.setLeft(vbox1);
		vbox2.getChildren().addAll(begin, finish);
		pane.setRight(vbox2);
		pane.setCenter(arch);
		fp.getChildren().addAll(lminutes, minutes, lseconds, seconds, start);
		fp.setAlignment(Pos.BOTTOM_CENTER);
		pane.setBottom(fp);
		pane.setBottom(fp);
		RotateTransition rt1 = new RotateTransition(Duration.minutes(10), table);
	    rt1.setByAngle(10000000);
	    RotateTransition rt2 = new RotateTransition();
	    rt2.setNode(table);
	    minutes.setText("0");
	    seconds.setText("0");
		begin.setOnAction((ActionEvent e) -> 
		{
		    rt1.play();
		});
		finish.setOnAction((ActionEvent e) -> 
		{
			rt1.stop();
			rt2.stop();
		});
		lminutes.setFont(Font.font("Gill Sans Ultra Bold",25));
		lminutes.setTextFill(Color.SNOW);
		lseconds.setFont(Font.font("Gill Sans Ultra Bold",25));
		lseconds.setTextFill(Color.SNOW);
		start.setOnAction((ActionEvent e) -> 
		{
			averageSpeed = random.nextInt(30)+100;
			mins = Integer.valueOf(minutes.getText()).intValue();
			secs = Integer.valueOf(seconds.getText()).intValue();
			rt2.setByAngle(averageSpeed*(60*mins+secs));
			rt2.setDuration(Duration.seconds(60*mins+secs));
			rt2.play();
			new Countdown().countdown(60*mins+secs);
			mins = 0;
			secs = 0;
			minutes.setText("0");
		    seconds.setText("0");
		});
		minutes.setOnKeyPressed((KeyEvent ke) ->
		{
			if(ke.getCode() == KeyCode.ENTER)
			{
				averageSpeed = random.nextInt(30)+100;
				try
				{
					mins = Integer.valueOf(minutes.getText()).intValue();
					secs = Integer.valueOf(seconds.getText()).intValue();
					rt2.setByAngle(averageSpeed*(60*mins+secs));
					rt2.setDuration(Duration.seconds(60*mins+secs));
					rt2.play();
					new Countdown().countdown(60*mins+secs);
					mins = 0;
					secs = 0;
					minutes.setText("0");
				    seconds.setText("0");
				}
				catch(Exception event)
				{
					AlertBox.display("error", "请输入整数…");
				}
			}
		});
		seconds.setOnKeyPressed((KeyEvent ke) ->
		{
			if(ke.getCode() == KeyCode.ENTER)
			{
				averageSpeed = random.nextInt(30)+100;
				try
				{
					mins = Integer.valueOf(minutes.getText()).intValue();
					secs = Integer.valueOf(seconds.getText()).intValue();
					rt2.setByAngle(averageSpeed*(60*mins+secs));
					rt2.setDuration(Duration.seconds(60*mins+secs));
					rt2.play();
					new Countdown().countdown(60*mins+secs);
					mins = 0;
					secs = 0;
					minutes.setText("0");
				    seconds.setText("0");
				}
				catch(Exception event)
				{
					AlertBox.display("error", "请输入整数…");
				}
			}
		});
		Scene scene = new Scene(pane, 1000, 860);
		primaryStage.setTitle("turntable");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}