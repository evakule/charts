package chart.test.repository.merchants;

import chart.test.entity.merchants.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

  Optional<UserEntity> findByUserId(Integer userId);

  @Query(value = "select activation_token from telegram_users WHERE activation_token = ?1", nativeQuery = true)
  Optional<String> findActivationToken(String token);

  UserEntity findByActivationToken(String token);

  @Query(value = "select description from bots where id = ?1", nativeQuery = true)
  String getDescriptionByBotId(Integer botId);
}
