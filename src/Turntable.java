import java.util.ArrayList;
import java.util.Random;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.control.*;
import javafx.animation.RotateTransition;
public class Turntable extends Group
{
	protected Random random = new Random();
	protected final int MAXN = 50;
	public static final double R = 300D;
	protected int mins = 0, secs = 0;
	public ArrayList<Group> partitions = new ArrayList<Group>();
	public int[][] color = new int[MAXN][3];
	public Group pointer;
	public Turntable(int n, String[] names, MyPane pane)
	{
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
			Text index = new Text(x-10, y+7, names[i]);
			index.setRotate(90-((360D/(double)n)*((double)i+0.5)));
			index.setFont(Font.font(20));
			index.setFill(Color.WHITE);
			Group partition = new Group(arc, index);
			partitions.add(partition);
			this.getChildren().add(partitions.get(i));
			passName(i, names[i], pane);
		}
	}
	public void setPointer(double width, double radius, double length, double distance, Color color)
	{
		Line line = new Line(0, length, 0, 0);
		line.setStroke(color);
		line.setStrokeWidth(width);
		Circle circle = new Circle(0,distance,radius);
		circle.setFill(color);
		pointer = new Group(line, circle);
	}
	protected void rotate1(RotateTransition rt1)
	{
		rt1.play();
	}
	protected void rotate2(RotateTransition rt2, MyPane pane)
	{
		int averageSpeed = random.nextInt(30)+100;
		try
		{
			mins = Integer.valueOf(pane.minutes.getText()).intValue();
			secs = Integer.valueOf(pane.seconds.getText()).intValue();
			System.out.println(pane.minutes.getText());
			rt2.setByAngle(averageSpeed*(60*mins+secs));
			rt2.setDuration(Duration.seconds(60*mins+secs));
			rt2.play();
			new Countdown().countdown(60*mins+secs);
			mins = 0;
			secs = 0;
			pane.minutes.setText("0");
		    pane.seconds.setText("0");
		}
		catch(Exception event)
		{
			AlertBox.display("error", "请输入整数…");
		}
	}
	protected void stop(RotateTransition rt1, RotateTransition rt2)
	{
		rt1.stop();
		rt2.stop();
	}
	protected void passName(int i, String name, MyPane pane)
	{
		Label label = new Label(name);
		label.setFont(new Font("华文琥珀", 20));
		label.setTextFill(Color.rgb(color[i][0], color[i][1], color[i][2]));
		pane.vbox1.getChildren().add(label);
	}
}