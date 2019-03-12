import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class GUI extends Application  {
	Insets i = new Insets(90, 90, 90, 90);
	Insets j = new Insets(70, 70, 70, 100);
	Insets k = new Insets(80, 55, 60, 90);
	int s=0;
	int historyCount = 0;
	String[] ht = new String[5]; //history type
	int[] hv = new int[5]; //history value
	String temp="";
	int depyes=0,wityes=0;
	Stage window;
	Scene scene0,scene1,scene2;
	Button button0;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	Button buttonN0;
	Button buttonN1;
	Button buttonN2;
	Button buttonN3;
	Button buttonN4;
	Button buttonN5;
	Button buttonN6;
	Button buttonN7;
	Button buttonN8;
	Button buttonN9;
	Button confirm;
	Button back;
	Label label0,label1,label2,labelm;
	TextField field;
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		for(s=0; s<5; s++)
		{
			hv[s]=0;
		}
		historyCount=0;
		ATM atm = new ATM();
		window = primaryStage;
		GridPane layout0 = new GridPane();
		layout0.setPadding(k);
		layout0.setVgap(20);
		layout0.setHgap(20);
		GridPane layout1 = new GridPane();
		layout1.setPadding(i);
		layout1.setVgap(35);
		layout1.setHgap(150);
		GridPane layout2 = new GridPane();
		layout2.setPadding(j);
		layout2.setVgap(20);
		layout2.setHgap(20);
		Scene scene0 = new Scene(layout0, 500 ,200);
		Scene scene1 = new Scene(layout1, 640, 360);
		Scene scene2 = new Scene(layout2, 360 ,360);
		Label labelu = new Label("Card Number:");
		Label label0 = new Label();
		Label label2 = new Label();
		Label labelm = new Label("Welcome to your ATM Machine.");
		TextField field = new TextField();
		button0 = new Button("Confirm");
		button0.setOnAction(e -> {
			historyCount = 0;
			if(field.getText().equals(ATM.cardNum))
				window.setScene(scene1);
			else label0.setText("Error");
		});
		button1 = new Button("Withdraw");
		button1.setOnAction(e -> {
			label2.setText("Enter withdraw amount");
			wityes=1;
			historyCount=0;
			window.setScene(scene2);
			
		});
		button2 = new Button("Deposit");
		button2.setOnAction(e -> {
			label2.setText("Enter deposit amount");
			depyes=1;
			historyCount=0;
			window.setScene(scene2);
			
		});
		button3 = new Button("Balance Inquiry");
		button3.setOnAction(e -> {labelm.setText("Your balance is "+Integer.toString(atm.bal));
			historyCount=0;
		});
		confirm = new Button("Confirm");
		confirm.setOnAction(e -> {
			if(depyes==1)
			{
				atm.deposit(temp);
				labelm.setText("Successfully Deposited "+temp);
				if(hv[0]==0)
				{
					hv[0]= Integer.parseInt(temp);
					ht[0]="Deposited ";
				}
				else
				{
					hv[4]=hv[3];hv[3]=hv[2];hv[2]=hv[1];hv[1]=hv[0];
					ht[4]=ht[3];ht[3]=ht[2];ht[2]=ht[1];ht[1]=ht[0];
					hv[0]= Integer.parseInt(temp);
					ht[0]="Deposited ";
				}
			}
			else if(wityes==1)
			{
				if(Integer.parseInt(temp)<atm.bal)
				{
					atm.withdraw(temp);
					labelm.setText("Successfully Withdrew "+temp);
					if(hv[0]==0)
					{
						hv[0]= Integer.parseInt(temp);
						ht[0]="Withdrew ";
					}
					else
					{
						hv[4]=hv[3];hv[3]=hv[2];hv[2]=hv[1];hv[1]=hv[0];
						ht[4]=ht[3];ht[3]=ht[2];ht[2]=ht[1];ht[1]=ht[0];
						hv[0]= Integer.parseInt(temp);
						ht[0]="Withdrew ";
					}
				}
				else labelm.setText("Not enough funds!");
			}
			depyes=0;wityes=0;
			temp = "";
			historyCount=0;
			window.setScene(scene1);
		});
		button4 = new Button("Previous");
		button4.setOnAction(e ->{
			if(historyCount==5)
			{
				labelm.setText("Error: no more history");
			}
			else 
			{
				if(hv[historyCount]==0)
				labelm.setText("Error: no more history");
				else
				{
					labelm.setText(ht[historyCount]+Integer.toString(hv[historyCount]));
					historyCount+=1;
				}
			}
		});
		button5 = new Button("Next");
		button5.setOnAction(e ->{
			if(historyCount==0)
				labelm.setText("Error: that was the last transaction");
			else 
			{
				labelm.setText(ht[historyCount-1]+Integer.toString(hv[historyCount-1]));
				historyCount-=1;
			}
				});
		buttonN0 = new Button("0");
		buttonN0.setOnAction(e ->{ temp=temp+"0";
				label2.setText(temp);
		});
		buttonN1 = new Button("1");
		buttonN1.setOnAction(e ->{ temp=temp+"1";
				label2.setText(temp);
		});
		buttonN2 = new Button("2");
		buttonN2.setOnAction(e ->{ temp=temp+"2";
				label2.setText(temp);
		});
		buttonN3 = new Button("3");
		buttonN3.setOnAction(e ->{ temp=temp+"3";
				label2.setText(temp);
		});
		buttonN4 = new Button("4");
		buttonN4.setOnAction(e ->{ temp=temp+"4";
				label2.setText(temp);
		});
		buttonN5 = new Button("5");
		buttonN5.setOnAction(e ->{ temp=temp+"5";
				label2.setText(temp);
		});
		buttonN6 = new Button("6");
		buttonN6.setOnAction(e ->{ temp=temp+"6";
				label2.setText(temp);
		});
		buttonN7 = new Button("7");
		buttonN7.setOnAction(e ->{ temp=temp+"7";
				label2.setText(temp);
		});
		buttonN8 = new Button("8");
		buttonN8.setOnAction(e ->{ temp=temp+"8";
				label2.setText(temp);
		});
		buttonN9 = new Button("9");
		buttonN9.setOnAction(e ->{ temp=temp+"9";
				label2.setText(temp);
		});
		back = new Button("Back");
		back.setOnAction(e -> { temp="";
		label2.setText("");
		window.setScene(scene1);});
		GridPane.setConstraints(label2, 0, 0, 4, 1);
		GridPane.setConstraints(button1, 0, 1);
		GridPane.setConstraints(button2, 0, 2);
		GridPane.setConstraints(button3, 0, 3);
		GridPane.setConstraints(button4, 2, 2);
		GridPane.setConstraints(button5, 2, 3);
		GridPane.setConstraints(labelm, 1, 1, 2, 1);
		GridPane.setConstraints(labelu, 0, 0);
		GridPane.setConstraints(field, 1, 0);
		GridPane.setConstraints(button0, 2, 0);
		GridPane.setConstraints(label0, 2, 1);
		GridPane.setConstraints(buttonN0, 0, 4);
		GridPane.setConstraints(buttonN1, 0, 3);
		GridPane.setConstraints(buttonN2, 1, 3);
		GridPane.setConstraints(buttonN3, 2, 3);
		GridPane.setConstraints(buttonN4, 0, 2);
		GridPane.setConstraints(buttonN5, 1, 2);
		GridPane.setConstraints(buttonN6, 2, 2);
		GridPane.setConstraints(buttonN7, 0, 1);
		GridPane.setConstraints(buttonN8, 1, 1);
		GridPane.setConstraints(buttonN9, 2, 1);
		GridPane.setConstraints(confirm,  3, 0, 2, 1);
		GridPane.setConstraints(back,     3, 4);
		layout2.getChildren().add(label2);
		layout2.getChildren().add(confirm);
		layout2.getChildren().add(buttonN0);
		layout2.getChildren().add(buttonN1);
		layout2.getChildren().add(buttonN2);
		layout2.getChildren().add(buttonN3);
		layout2.getChildren().add(buttonN4);
		layout2.getChildren().add(buttonN5);
		layout2.getChildren().add(buttonN6);
		layout2.getChildren().add(buttonN7);
		layout2.getChildren().add(buttonN8);
		layout2.getChildren().add(buttonN9);
		layout2.getChildren().add(back);
		layout1.getChildren().add(labelm);
		layout1.getChildren().add(button1);
		layout1.getChildren().add(button2);
		layout1.getChildren().add(button3);
		layout1.getChildren().add(button4);
		layout1.getChildren().add(button5);
		layout0.getChildren().add(label0);
		layout0.getChildren().add(labelu);
		layout0.getChildren().add(field);
		layout0.getChildren().add(button0);
		window.setScene(scene0);
		window.setTitle("Your ATM Machine");
		window.show();
	}

}
