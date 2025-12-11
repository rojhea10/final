package application;
	
import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		

		//Create labels	

		//label with no textfield
		Text text0 = new Text("Personal information");
		//create label full name
		Text text1 = new Text("Full Name");

		//create label current address
		Text text2 = new Text("Current Address");

		//create label for phone number
		Text text3 = new Text("Contact number");

		//creating label email
		Text text4 = new Text("Email");

		//create label for education level
		Text text5 = new Text("Highest Educational Attainment");

			//create label Gender
		Text text6 = new Text("Gender ");

		//label with no textfield
		Text text7 = new Text("Employment Elgibility");

		//create label  for date available
		Text text8 = new Text("Date Available");

		//creating label for position
		Text text9 = new Text("Desired position");

		//create label for salary requirement
		Text text10 = new Text("Desired Salary");

		//legally authorized
		Text text11 = new Text("Are you legally authorized to work in the country?");

		//any relatives
		Text text12 = new Text("Do you have any relatives working in our company?");

		//if yes explain
		Text text13 = new Text("If yes, please explain further ");

		//Creating Text Field for all labels
		TextField textField1 = new TextField();//full name
		TextField textField2 = new TextField();//current address
		TextField textField3 = new TextField();//contact number
		TextField textField4 = new TextField();//email
		TextField textField5 = new TextField();//education level
		TextField textField6 = new TextField();//date available
		TextField textField7 = new TextField();//desired position
		TextField textField8 = new TextField();//desired salary
		TextField textField9 = new TextField();//if yes explain further

				 
		//Create radio buttons for choice
		RadioButton rb1 = new RadioButton("Male");
		RadioButton rb2 = new RadioButton("Female");
		RadioButton rb3 = new RadioButton("Other");
		RadioButton rb4 = new RadioButton("Yes");
		RadioButton rb5 = new RadioButton("No");
		RadioButton rb6 = new RadioButton("Yes");
		RadioButton rb7 = new RadioButton("No");
		
		//Set toggle group for radio buttons
		ToggleGroup group = new ToggleGroup();
		rb1.setToggleGroup(group);
		rb2.setToggleGroup(group);
		rb3.setToggleGroup(group);
		ToggleGroup group2 = new ToggleGroup();
		rb4.setToggleGroup(group2);
		rb5.setToggleGroup(group2);
		ToggleGroup group3 = new ToggleGroup();
		rb6.setToggleGroup(group3);
		rb7.setToggleGroup(group3);

		//Create combo box for education level
		ComboBox<String> cb = new ComboBox<>();
		cb.setEditable(true);
		cb.getItems().addAll("Masters", "Bachelors", "College Diploma");
		cb.valueProperty().addListener((obs, oldVal, newVal) -> {});

		//Create datepicker for date available
		DatePicker dp = new DatePicker();
		dp.setEditable(false);
		dp.valueProperty().addListener((obs, oldVal, newVal) -> {});



		//Creating Button
		Button button1 = new Button("Submit");

		//Creating a grid pane
		GridPane gridPane = new GridPane();

		//setting the padding
		gridPane.setPadding(new Insets(10, 10, 10, 10)); 

		//setting the vertical and horizontal gaps between the columns
		gridPane.setVgap(5);
		gridPane.setHgap(1);

		//setting the Grid alignment
		gridPane.setAlignment(Pos.CENTER);
		
		//Arranging all the nodes in the grid
		gridPane.add(text0, 0, 0); 
		gridPane.add(text1, 0, 1);//full name
		gridPane.add(textField1, 1, 1); //full name
		gridPane.add(text2, 0, 2); //current address
		gridPane.add(textField2, 1, 2);
		gridPane.add(text3, 0, 3);//contact number
		gridPane.add(textField3, 1, 3);
		gridPane.add(text4, 2, 3);//email
		gridPane.add(textField4, 3, 3);
		gridPane.add(text5, 0, 4);//education level
		gridPane.add(cb, 1, 4); 
		gridPane.add(text6, 2, 4); //gender
		gridPane.add(text7, 0, 6); //employment eligibility
		gridPane.add(text8, 0, 8);//date available
		gridPane.add(dp, 1, 8);
		gridPane.add(text9, 2, 8);//desired position
		gridPane.add(textField7, 3, 8);//desired position
		gridPane.add(text10, 0, 9);//desired salary
		gridPane.add(textField8, 1, 9);//desired salary
		gridPane.add(text11, 0, 10);//legally authorized
		gridPane.add(text12, 0, 12);//any relatives
		gridPane.add(textField9, 0, 14);//if yes explain further
		gridPane.add(button1, 0, 15);

		
		//HBox for grouping radio buttons
		HBox hbox = new HBox(50); //spacing between buttons
	    hbox.getChildren().addAll(rb1, rb2, rb3);
	    gridPane.add(hbox, 2, 5); 

		//HBox for grouping radio buttons
		HBox hbox2 = new HBox(50); //spacing between buttons
	    hbox2.getChildren().addAll(rb4, rb5);
	    gridPane.add(hbox2, 0, 11);


		//HBox for grouping radio buttons
		HBox hbox3 = new HBox(50); //spacing between buttons
	    hbox3.getChildren().addAll(rb6, rb7);
	    gridPane.add(hbox3, 0, 13);
			//action event
		 //create handler object
	    button1.setOnAction(ACtionevent -> {
			String name = textField1.getText().trim();
			String address = textField2.getText().trim();
			String email = textField4.getText().trim();
			String education = cb.getValue();
			String position = textField7.getText().trim();
			double salaryStr =0;
			try {
				salaryStr = Double.parseDouble( textField8.getText().trim());
			} catch (NumberFormatException e) {
				System.out.println("Invalid salary input. Please enter a numeric value.");
			}

			LocalDate startDate = dp.getValue();

			int phoneStr = 0;
			try {
			phoneStr = Integer.parseInt( textField3.getText().trim());
			} catch (NumberFormatException e) {
				System.out.println("Invalid phone number input.");
			}

			String gender = "";
			try {
				gender = ((RadioButton) group.getSelectedToggle()).getText();
			} catch (NullPointerException e) {
				System.out.println("Please select a gender");
			}

						String authorized = "";
			try {
				authorized = ((RadioButton) group2.getSelectedToggle()).getText();
			} catch (NullPointerException e) {
				System.out.println("Please select an authorization option.");
			}

			String relatives = "";
			try {
				relatives = ((RadioButton) group3.getSelectedToggle()).getText();
			} catch (NullPointerException e) {
				System.out.println("Please select an option for relatives");
			}
			String comments = textField9.getText().trim();

			//create user object and set values
				User user = new User();
				user.setFullname(name);
				user.setAddress(address);
				user.setEmail(email);
				user.setEducation(education);
				user.setGender(gender);
				user.setPosition(position);
				user.setSalary(salaryStr);
				user.setStartDate(startDate);
				user.setPhone(phoneStr);
				user.setAuthorized(authorized);
				user.setRelatives(relatives);
				user.setComments(comments);


			//check for empty fields
			if (name.isEmpty() || address.isEmpty() || email.isEmpty() || education.isEmpty() || position.isEmpty() || textField8.getText().trim().isEmpty() || textField3.getText().trim().isEmpty() || authorized.isEmpty() || startDate == null) {
				System.out.println("Please fill in all fields");	
	}
	else{
		//check if relative is "yes" and comment is empty
		if (relatives.equals("Yes") && comments.isEmpty()) {
			System.out.println("Please explain further");
		}
		else {
		
	//check if phone exists in database
	if (Read.userExists(phoneStr)) {
		System.out.println("Phone number already exists in the database.");
	} else {
		System.out.println("Phone number is unique. Proceeding to insert.");
				 //call insert method
				 insert.in(user);
	    
	    }
		}
	}
	    }
		
	    );
	    
		//HBox for top image and text
		HBox hboxtop = new HBox();
		String top = "Employment Application";
		
		Image img = new Image("file:src/application/R.jpg"); //path to image
		ImageView imageView = new ImageView(img);//create image view
		imageView.setFitHeight(20);
		imageView.setFitWidth(20);

		//insert text and image into hbox
		hboxtop.getChildren().addAll(new Text(top), imageView);
		hboxtop.setAlignment(Pos.CENTER);

	
		//Hbox for bottom
		HBox hboxBot= new HBox();
		String bot = "By submitting this application, you agree to adhere to our company's policies";
		hboxBot.getChildren().add(new Text(bot));
		hboxBot.setAlignment(Pos.CENTER);

		
		// Border box
		//* 
		BorderPane pane = new BorderPane();
		//place nodes in the pane 
		pane.setTop(new CustomPane(hboxtop));
		pane.setBottom(new CustomPane(hboxBot));
		pane.setCenter(new CustomPane(gridPane));
		
			

		
		//Creating a scene object
		Scene scene = new Scene(pane, 400, 200);


		//Setting the title of the stage
		primaryStage.setTitle("Grid pane example in javafx");

		//Adding the scene to the stage
		primaryStage.setScene(scene);

		//Displaying the stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
