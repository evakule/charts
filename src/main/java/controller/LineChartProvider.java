package controller;


import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class LineChartProvider {

    public LineChart<String, Number> getSimpleChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart =
                new LineChart<String, Number>(xAxis, yAxis);

        lineChart.setCreateSymbols(false);

        xAxis.setLabel("Month");

        lineChart.setTitle("Account name");

        return lineChart;
    }
}
