package com.account.service;

import java.util.List;
import java.util.Optional;

import com.account.model.Credential;

public interface CredentialService {

    List<Credential> getAllCredentials();

    Credential getCredentialById(Long id);

    Credential createCredential(Credential credential);

    Credential updateCredential(Long id, Credential credential);

    boolean deleteCredential(Long id);

	public List<Credential> login(String username, String password);
	
}
