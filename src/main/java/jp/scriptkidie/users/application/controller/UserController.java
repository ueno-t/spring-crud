package jp.scriptkidie.users.application.controller;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jp.scriptkidie.users.domain.user.User;
import jp.scriptkidie.users.domain.user.UserService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@Transactional
@RequiredArgsConstructor
public class UserController {

	@NonNull
	private final UserService service;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAll() {
		return service.findAll();
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findById(@PathVariable("id") String id) {
		return service.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public User save(@RequestBody UserBody user) {
		return service.save(user.toDomain());
	}

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") String id) {
		service.deleteById(id);
	}

}
