package chart.test.service;

import chart.test.entity.merchants.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import chart.test.repository.merchants.UserRepository;


import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public UserEntity getUserByChatId(Integer userId) {
    return repository.findByUserId(userId)
            .orElseGet(UserEntity::new);
  }

  public boolean isRegistered(Integer userId) {
    UserEntity user =
            repository.findByUserId(userId).orElseGet(UserEntity::new);
    return nonNull(user.getIsTokenActivated()) && user.getIsTokenActivated();
  }

  public boolean isTokenValid(String token) {
    String tokenFromDb =
            repository.findActivationToken(token).orElseGet(String::new);
    return nonNull(tokenFromDb);
  }

  public void activateUserByToken(Update update, String token) {
    UserEntity newUser = repository.findByActivationToken(token);
    newUser.setIsTokenActivated(true);
    newUser.setUserId(update.getMessage().getFrom().getId().intValue());
    repository.save(newUser);
  }

  public String getDescriptionByBotId(Integer botId) {
    return repository.getDescriptionByBotId(botId);
  }
}
