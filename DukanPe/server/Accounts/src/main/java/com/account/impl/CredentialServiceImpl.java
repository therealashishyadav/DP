package com.account.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.model.Credential;
import com.account.repository.CredentialRepo;
import com.account.service.CredentialService;

@Service
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	private CredentialRepo credentialRepo;

	@Override
	public List<Credential> login(String username, String password) {

		 return credentialRepo.findAll().stream().filter(e -> (e.getUsername().equals(username)) && (e.getPassword().equals(password))).collect(Collectors.toList());

	}

    @Override
    public List<Credential> getAllCredentials() {
        return credentialRepo.findAll();
    }

    @Override
    public Credential getCredentialById(Long id) {
        return credentialRepo.findById(id).orElse(null);
    }

    @Override
    public Credential createCredential(Credential credential) {
        return credentialRepo.save(credential);
    }
    
    @Override
    public Credential updateCredential(Long id, Credential credential) {
        Credential existingCredential = credentialRepo.findById(id).orElse(null);
        if (existingCredential != null) {
            existingCredential.setUsername(credential.getUsername());
            existingCredential.setFullName(credential.getFullName());
            existingCredential.setMobileNumber(credential.getMobileNumber());
            existingCredential.setEmailId(credential.getEmailId());
            existingCredential.setPassword(credential.getPassword());
            return credentialRepo.save(existingCredential);
        } else {
            return null;
        }
    }
    
    @Override
    public boolean deleteCredential(Long id) {
        Credential existingCredential = credentialRepo.findById(id).orElse(null);
        if (existingCredential != null) {
            credentialRepo.delete(existingCredential);
            return true;
        } else {
            return false;
        }
    }	
		
}
