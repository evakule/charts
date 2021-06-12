package chart.test.repository.financial;

import chart.test.entity.comparator.BalanceComparator;
import chart.test.entity.financial.BalanceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import chart.test.repository.financial.first.FirstBalanceRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.TreeSet;

@Component
@RequiredArgsConstructor
public class BalanceData {

  private final HashMap<Integer, BalanceDataSource> balanceDataSourceMap = new HashMap<>();

  private final FirstBalanceRepository firstBalanceRepository;

  @PostConstruct
  private void init() {
    balanceDataSourceMap.put(1, firstBalanceRepository);
  }

  public BalanceEntity findTopByAccountIdOrderByUpdateTimeDesc(Long id) {
    TreeSet<BalanceEntity> set = new TreeSet<>(new BalanceComparator());
    for (int i = 1; i < balanceDataSourceMap.size() + 1; i++) {
      set.add(
              balanceDataSourceMap
                      .get(i)
                      .findTopByAccountIdOrderByUpdateTimeDesc(id)
                      .orElseGet(BalanceEntity::new)
      );
    }
    return set.first();
  }

  public BalanceEntity getBalanceByLabel(String label) {
    for (int i = 1; i < balanceDataSourceMap.size() + 1; i++) {
      BalanceEntity search =
              balanceDataSourceMap
                      .get(i).getBalanceByLabel(label).orElseGet(BalanceEntity::new);
      if (search.getId() != null) {
        return search;
      }
    }
    return new BalanceEntity();
  }
}
