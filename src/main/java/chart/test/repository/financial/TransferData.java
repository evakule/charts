package chart.test.repository.financial;


import chart.test.entity.financial.TransferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import chart.test.repository.financial.first.FirstTransferRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TransferData {

  private final HashMap<Integer, TransferDataSource> transferDataSourceMap = new HashMap<>();

  private final FirstTransferRepository firstTransferRepository;

  @PostConstruct
  private void init() {
    transferDataSourceMap.put(1, firstTransferRepository);
  }

  public List<TransferEntity> getAllByAccountId(Long id) {
    List<TransferEntity> search = new ArrayList<>();
    for (int i = 1; i < transferDataSourceMap.size() + 1; i++) {
      search.addAll(
              transferDataSourceMap
                      .get(i)
                      .getAllByAccountId(id)
      );
    }
    return search;
  }
}
