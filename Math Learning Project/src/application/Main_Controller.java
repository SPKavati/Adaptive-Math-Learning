package application;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.sql.*;
public class Main_Controller implements Initializable {
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;

	@FXML
	private Button btn;
	@FXML
	private ComboBox teach;
	@FXML
	private ComboBox stud;
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		// TODO Auto-generated method stub
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/quiz","root","krish");  
			Statement stmt=con.createStatement();  
			  
			ResultSet rs=stmt.executeQuery("select*from info");  
			teach.getItems().clear();
			stud.getItems().clear();
			while(rs.next())  {
			System.out.println(rs.getString(1));  
			teach.getItems().add(rs.getString(1));
			stud.getItems().add(rs.getString(2));
			}
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			  
		
		btn.setOnAction(e->{
			System.out.println("sathya");
			 try {
	             Parent root = FXMLLoader.load(getClass().getResource("/application/design1.fxml"));
	             Stage stage=new Stage();
	             Scene scene= new Scene(root);
	             stage.setScene(scene);
	             stage.setTitle("Team Screen ");
	             stage.show();

	         } catch (IOException e1) {
	             e1.printStackTrace();
	         }
		});
	}

	Main1_Controller mc=new Main1_Controller(stud);
}
