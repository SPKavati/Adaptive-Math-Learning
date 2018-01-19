package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Main1_Controller implements Initializable {
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement ps;
	
	@FXML
	private ComboBox list;
	@FXML
	private TextArea ex;
	@FXML
	private Button submit;
	@FXML
	private ComboBox stud;
	@FXML
	private Label lb;
	
	public Main1_Controller(ComboBox stud) {
		// TODO Auto-generated constructor stub
		this.stud=stud;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		lb.setText(stud.getSelectionModel().getSelectedItem().toString());
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/quiz","root","krish");  
			Statement stmt=con.createStatement();  
			  
			ResultSet rs=stmt.executeQuery("select*from info");  
			list.getItems().clear();
			while(rs.next())  {
			System.out.println(rs.getString(1));  
			list.getItems().add(rs.getString(1));
			}
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);}  
			  
		
	}

}
