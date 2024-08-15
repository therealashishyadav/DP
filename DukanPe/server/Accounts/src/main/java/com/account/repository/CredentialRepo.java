package com.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Credential;

public interface CredentialRepo extends JpaRepository<Credential, Long> {

	Optional<Credential> findByUsername(String username);

    Optional<String> findShopNameByUsername(String username);

}
