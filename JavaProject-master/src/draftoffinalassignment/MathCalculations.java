package draftoffinalassignment;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Artur
 */
public class MathCalculations extends Stage {

    MathCalculations() {

        ArrayList<Expenses> mathTest = new ArrayList<>();
        mathTest.add(new Expenses(93.12, "Food", "2019/05/2"));
        mathTest.add(new Expenses(12.00, "Food", "2019/05/4"));
        mathTest.add(new Expenses(189.03, "Food", "2019/05/12"));
        mathTest.add(new Expenses(124.52, "Food", "2019/05/22"));

        SortByExpenseAmount sortByAmount = new SortByExpenseAmount();
        Collections.sort(mathTest, sortByAmount);

        for (int i = 0; i < mathTest.size(); i++) {
            System.out.println(mathTest.get(i).getExpense());
        }

        createMonthlyLineChart(mathTest);

//        series.getData().add(new XYChart.Data(1,100.65));
//        series.getData().add(new XYChart.Data(2,23));
//        series.getData().add(new XYChart.Data(3,34));
//        series.getData().add(new XYChart.Data(4,45));
//        series.getData().add(new XYChart.Data(5,56));
        
    }

    private void createMonthlyLineChart(ArrayList<Expenses> list) {
        final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        final NumberAxis yAxis = new NumberAxis(0, list.get(list.size() - 1).getExpense(), 20);
        final LineChart lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series();

        xAxis.setLabel("Date of transaction");
        yAxis.setLabel("Amount spent");
        lineChart.setTitle("Spending graph");

        for (int i = 0; i < list.size(); i++) {
            //make instance of expense each loop to grab amount and date from arrayList
            Expenses expense = list.get(i);
            double amount = expense.getExpense();
            String date = expense.getTimeOfPurchase();
            int day = 0;
            //format date 
            if (date.contains("/")) {
                date = replaceDateElements(date);
            }
            //date is returned as a string but the chart uses ints/doubles
            day = Integer.parseInt(date);
            
            series.getData().add(new XYChart.Data(day, amount));
        }

        lineChart.getData().add(series);
        Scene scene = new Scene(lineChart, 500, 500);

        this.setScene(scene);
        this.setTitle("Expenses Chart");
        this.show();
    }

    private String replaceDateElements(String date) {

        String[] parts = date.split("/");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];

        String formattedDate = formatDate(day);

        return formattedDate;
    }

    private String formatDate(String date) {
        String tempDate = null;
        if (date.startsWith("0")) {
            tempDate = date.replace("0", "");
        } else {
            tempDate = date;
        }
        return tempDate;
    }

    private String formatMonth(String month) {
        return null;
    }
}
