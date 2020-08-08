package web.initialize.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.initialize.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	Optional<UserEntity> findByUser(String username);
	List<UserEntity> findAllByUserIn(List<String> users);
}
