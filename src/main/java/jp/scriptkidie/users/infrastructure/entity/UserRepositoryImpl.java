package jp.scriptkidie.users.infrastructure.entity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import jp.scriptkidie.users.domain.user.User;
import jp.scriptkidie.users.domain.user.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	@NonNull
	private final UserJPARepository repository;

	@Override
	public Optional<User> findById(String id) {
		return repository.findById(id).map(UserEntity::toDomain);
	}

	@Override
	public User save(User user) {
		return repository.save(UserEntity.of(user)).toDomain();
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll().stream().map(UserEntity::toDomain).collect(Collectors.toList());
	}

}
