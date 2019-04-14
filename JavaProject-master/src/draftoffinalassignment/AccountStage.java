package draftoffinalassignment;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 *
 * @author shann
 */
public class AccountStage extends Stage {

    GridPane accountGrid = new GridPane();

    Text accountOutput = new Text();

    Button addExpenses = new Button("Add expenses");

    Button viewMathGraphs = new Button("View as graph");

    Button importCSV = new Button("import CSV file");

    Button viewAccountInfo = new Button("View account information");

    AccountStage() {

        accountGrid.setPadding(new Insets(10));
//
//      accountGrid.add(accountOutput, 1, 0);

        accountGrid.add(addExpenses, 0, 0);

        accountGrid.add(viewMathGraphs, 1, 0);

        accountGrid.add(importCSV, 0, 1);

        accountGrid.add(viewAccountInfo, 1, 1);
        
        importCSV.setOnAction(event -> showCSVParserStage());
        
        addExpenses.setOnAction(event -> showExpensesStage());
        
        viewMathGraphs.setOnAction(event -> showMathCalculationsStage());

//     viewChart.setOnAction(event -> showMathStage());
        viewAccountInfo.setOnAction(event -> showAccountInformation());

        Scene scene = new Scene(accountGrid, 300, 300);

        this.setScene(scene);
        this.setTitle("Account");
        this.show();

    }

    public void showExpensesStage() {
        ExpensesStage expensesStage = new ExpensesStage();
    }
    
    public void showMathCalculationsStage(){
        MathCalculations mathStage = new MathCalculations();
    }
    
    public void showCSVParserStage(){
        CSVParser parser = new CSVParser();
    }
//
//   public void showMathStage() {
//      MathStage mathStage = new  MathStage();
//   }
    public String showAccountInformation() {
        //this class has to take this user's accoutn 
        //infromation and put it to string on a labels?

        String userInformation = "";

        return userInformation;

    }

}
