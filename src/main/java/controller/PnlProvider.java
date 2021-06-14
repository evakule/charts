package controller;

import chart.test.entity.financial.BalanceEntity;
import chart.test.entity.financial.TransferEntity;

import java.util.ArrayList;
import java.util.List;

public class PnlProvider {
    private BalanceProvider balanceProvider = new BalanceProvider();
    private TransferProvider transferProvider = new TransferProvider();


    public List<PnlEntity> getPnls() {
        List<BalanceEntity> balances = balanceProvider.getBalances();
        List<TransferEntity> transfers = transferProvider.getTransfers();

        List<PnlEntity> pnls = new ArrayList<>();




        return pnls;
    }
}
