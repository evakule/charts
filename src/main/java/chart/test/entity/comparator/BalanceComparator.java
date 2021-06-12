package chart.test.entity.comparator;

import chart.test.entity.financial.BalanceEntity;

import java.util.Comparator;

public class BalanceComparator implements Comparator<BalanceEntity> {

  @Override
  public int compare(BalanceEntity a, BalanceEntity b) {
    long diff = a.getUpdateTime().compareTo(b.getUpdateTime());
    if(diff > 0)
      return 1;
    else if(diff < 0)
      return -1;
    else
      return 0;
  }
}
