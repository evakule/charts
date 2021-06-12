package chart.test.service;

import chart.test.entity.financial.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import chart.test.repository.financial.AccountData;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountData accountData;

  public AccountEntity getById(Long id) {
    return accountData.findById(id);
  }

  public List<AccountEntity> getAccountsByGroupId(Integer groupId) {
    return accountData.getAccountsByGroupId(groupId);
  }
}
