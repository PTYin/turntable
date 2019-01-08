import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
public class Classic
{
	public static void display(int n, String[] names)
	{
		Stage classic = new Stage();
		MyPane pane = new MyPane();
		Turntable classicTable = new Turntable(n, names, pane);
		classicTable.setPointer(2, Turntable.R/25, Turntable.R, Turntable.R*1/10, Color.RED);
		setAction(pane, classicTable);
		pane.setCenter(new Group(classicTable, classicTable.pointer));
		Scene scene = new Scene(pane, 1000, 860);
		classic.setTitle("turntable");
		classic.setScene(scene);
		classic.show();
	}
	private static void setAction(MyPane pane, Turntable classicTable)
	{
		RotateTransition rt1 = new RotateTransition(Duration.minutes(10), classicTable);
	    rt1.setByAngle(10000000);
	    RotateTransition rt2 = new RotateTransition();
	    rt2.setNode(classicTable);
		pane.begin.setOnAction((ActionEvent e) -> 
		{
		    classicTable.rotate1(rt1);
		});
		pane.finish.setOnAction((ActionEvent e) -> 
		{
			classicTable.stop(rt1, rt2);
		});
		pane.start.setOnAction((ActionEvent e) -> 
		{
			classicTable.rotate2(rt2, pane);
		});
		pane.minutes.setOnKeyPressed((KeyEvent ke) ->
		{
			if(ke.getCode() == KeyCode.ENTER)
			{
				classicTable.rotate2(rt2, pane);
			}
		});
		pane.seconds.setOnKeyPressed((KeyEvent ke) ->
		{
			if(ke.getCode() == KeyCode.ENTER)
			{
				classicTable.rotate2(rt2, pane);
			}
		});
	}
}
