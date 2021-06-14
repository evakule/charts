package controller;

import chart.test.entity.financial.BalanceEntity;
import chart.test.entity.financial.TransferEntity;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

public class Runner extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        LineChartProvider lineChartProvider = new LineChartProvider();
        LineChart<String, Number> lineChart = lineChartProvider.getSimpleChart();

        Scene scene = new Scene(lineChart, 1400, 800);

        lineChart.getData().add(getFilledSeries());

        File file = saveAsPng(lineChart, "chart.png");

//        file.deleteOnExit();


      }

    private XYChart.Series<String, Number> getFilledSeries() {
        XYChart.Series<String, Number> series = new XYChart.Series();
        series.setName("Series name");

        BalanceProvider balanceProvider = new BalanceProvider();
        TransferProvider transferProvider = new TransferProvider();

        List<TransferEntity> transfers = transferProvider.getTransfers();
        List<BalanceEntity> balances = balanceProvider.getBalances();

        for (int i = 1; i < balances.size(); i++) {
            BalanceEntity balanceEntity = balances.get(i);
            BigDecimal wd = getDepositsSum(transfers, balanceEntity.getUpdateTime());
            series.getData().add(
                    new XYChart.Data(
                            getParsedDate(balances.get(i).getUpdateTime()),
                            balances.get(i).getBalanceTotal().subtract(wd)
                    )
            );

            System.out.println(balances.get(i).getBalanceTotal().subtract(wd) + " -- Time: " + balances.get(i).getUpdateTime());
        }


        return series;
    }

    public File saveAsPng(LineChart lineChart, String path) {
        WritableImage image = lineChart.snapshot(new SnapshotParameters(), null);
        File file = new File(path);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private String getParsedDate(ZonedDateTime date) {
        return date.getYear() +
                "-" +
                date.getMonth().ordinal() +
                "-" +
                date.getDayOfMonth();
    }

    private BigDecimal getDepositsSum(List<TransferEntity> transfers, ZonedDateTime date) {
        BigDecimal wd = BigDecimal.ZERO;
        for (TransferEntity transfer : transfers) {
            if (!transfer.getTimestamp().isAfter(date)) {
                wd = wd.add(transfer.getAmount());
            }
        }
        return wd;

    }

    public static void main(String[] args) {
        launch(args);
    }
}
