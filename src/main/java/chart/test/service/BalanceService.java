package chart.test.service;

import chart.test.entity.financial.BalanceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import chart.test.repository.financial.BalanceData;

@Service
@RequiredArgsConstructor
public class BalanceService {

  private final BalanceData balanceData;

  public BalanceEntity getTopByAccountId(Long id) {
    return balanceData.findTopByAccountIdOrderByUpdateTimeDesc(id);
  }

  public BalanceEntity getBalanceByLabel(String label) {
    return balanceData.getBalanceByLabel(label);
  }
}
