package controller;

import chart.test.entity.financial.TransferEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransferProvider {
    private static final String BALANCES = "/Users/evakule/Downloads/transfers_202106141322.csv";


    public List<TransferEntity> getTransfers() {
        int counter = 0;
        String row;
        List<TransferEntity> transfers = new ArrayList<>();
        try (
                BufferedReader csvReader = new BufferedReader(new FileReader(BALANCES));
        ) {
            while ((row = csvReader.readLine()) != null) {
                if (counter > 0) {
                    String[] rowColumns = row.split(",");
                    TransferEntity transferEntity = buildTransferEntity(rowColumns);
                    transfers.add(transferEntity);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transfers;
    }

    private static TransferEntity buildTransferEntity(String[] rowColumns) {
        TransferEntity transferEntity = new TransferEntity();
        transferEntity.setTxId(Long.valueOf(rowColumns[0]));
        transferEntity.setAccountId(Long.valueOf(rowColumns[1]));
        transferEntity.setAmount(new BigDecimal(rowColumns[2]));
        transferEntity.setAsset(rowColumns[3]);
        transferEntity.setStatus(rowColumns[4]);
        transferEntity.setTimestamp(getTimeFromString(rowColumns[5]));
        transferEntity.setTransferCounterparty(rowColumns[6]);
        transferEntity.setType(rowColumns[7]);
        return transferEntity;
    }

    private static ZonedDateTime getTimeFromString(String timeStr) {
        return LocalDateTime.parse(
                timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        ).atZone(ZoneId.of("GMT"));
    }
}
