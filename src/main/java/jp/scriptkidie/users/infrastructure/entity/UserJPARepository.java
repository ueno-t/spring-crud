package jp.scriptkidie.users.infrastructure.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, String> {

	public Optional<UserEntity> findById(String id);
}
