import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class InputBox
{
	public boolean flag = false;//false��ǰ�� true�ͺ���
    public void display(int i, Stage stage)
    {
    	if(i == 0)
    	{
    		stage.setTitle("��������");
    	    stage.show();
    	}
    	if(i == Num.num)
    	{
    		stage.close();
			Classic.display(Num.num, Num.names);
    		return;
    	}
    	HBox hb1 = new HBox();
    	HBox hb2 = new HBox(50);
    	Label lname = new Label("��������["+String.valueOf(i)+"]:");
    	TextField tname = new TextField();
	    Button button1 = new Button("��һ��");
	    Button button2 = new Button("��һ��");
	    hb1.getChildren().addAll(lname, tname);
	    hb1.setAlignment(Pos.CENTER);
	    hb2.getChildren().addAll(button1, button2);
	    hb2.setAlignment(Pos.CENTER);
	    button1.setOnAction(e -> 
	    {
	    	flag = true;
	    	display(i-1, stage);
	    });
	    button1.setOnKeyPressed(e -> 
	    {
	    	if(e.getCode() == KeyCode.ENTER)
	    	{
	    		flag = true;
	    		display(i-1, stage);
	    	}
	    });
	    button2.setOnAction(e -> 
	    {
	    	Num.names[i] = tname.getText();
	    	if(tname.getText().equals("")) AlertBox.display("Sorry", "���벻��Ϊ�գ�");
    		else display(i+1, stage);
	    });
	    button2.setOnKeyPressed(e -> 
	    {
	    	if(e.getCode() == KeyCode.ENTER)
	    	{
	    		Num.names[i] = tname.getText();
	    		if(tname.getText().equals("")) AlertBox.display("Sorry", "���벻��Ϊ�գ�");
	    		else display(i+1, stage);
	    	}
	    });
	    tname.setOnKeyPressed(e ->
	    {
	    	if(e.getCode() == KeyCode.ENTER)
	    	{
	    		Num.names[i] = tname.getText();
	    		if(tname.getText().equals("")) AlertBox.display("Sorry", "���벻��Ϊ�գ�");
	    		else display(i+1, stage);
	    	}
	    });
	    VBox vb = new VBox(10);
	    vb.getChildren().addAll(hb1, hb2);
	    vb.setAlignment(Pos.CENTER);
	    stage.setScene(new Scene(vb, 400, 200));
    }
}