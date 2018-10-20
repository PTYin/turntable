import javafx.application.Application;
import javafx.geometry.Pos;

import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Countdown
{
	static String S = "";
	static Timeline animation;
	int tmp;
    public void countdown(int tmp) 
    {
        Label label = new Label();
    	Stage stage = new Stage();
    	Scene scene = new Scene(label,400,200);
    	this.tmp = tmp;
        label.setFont(Font.font("Arial Black",70));
        label.setTextFill(Color.VIOLET);
        label.setAlignment(Pos.CENTER);
        animation = new Timeline(new KeyFrame(Duration.seconds(1), e -> 
        {
        	S = String.valueOf(--this.tmp);
            label.setText(S);
        	if(this.tmp < 0)
        	{
        		animation.stop();
        		S = String.valueOf(this.tmp);
                label.setText(S);
        		stage.close();
        	}
        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        stage.setTitle("Countdown!");
    	stage.setScene(scene);
    	stage.show();
    }
}