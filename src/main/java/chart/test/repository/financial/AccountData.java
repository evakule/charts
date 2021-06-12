package chart.test.repository.financial;

import chart.test.entity.financial.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import chart.test.repository.financial.first.FirstAccountRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountData {
  private final HashMap<Integer, AccountDataSource> accountDataSourceMap = new HashMap<>();

  private final FirstAccountRepository firstAccountRepository;

  @PostConstruct
  private void init() {
    accountDataSourceMap.put(1, firstAccountRepository);
  }

  public AccountEntity findById(Long id) {
    for (int i = 1; i < accountDataSourceMap.size() + 1; i++) {
      AccountEntity search =
              accountDataSourceMap
                      .get(i).findById(id).orElseGet(AccountEntity::new);
      if (search.getId() != null) {
        return search;
      }
    }
    return new AccountEntity();
  }

  public List<AccountEntity> getAccountsByGroupId(Integer groupId) {
    List<AccountEntity> search = new ArrayList<>();
    for (int i = 1; i < accountDataSourceMap.size() + 1; i++) {
      search.addAll(
              accountDataSourceMap
                      .get(i)
                      .getAccountsByGroup(groupId)
                      .orElseGet(ArrayList::new)
      );
    }
    return search;
  }
}
