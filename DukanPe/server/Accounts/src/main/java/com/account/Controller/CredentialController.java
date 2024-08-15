package com.account.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.account.model.Credential;
import com.account.repository.CredentialRepo;
import com.account.service.CredentialService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CredentialController {

	@Autowired
	private CredentialService credentialService;

	@GetMapping("/signin/{username}/{password}")
	public List<Credential> login(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		List<Credential> signedIn = credentialService.login(username, password);
		return signedIn;
	}

	@GetMapping("/credential")
	public ResponseEntity<List<Credential>> getAllCredentials() {
		List<Credential> credentials = credentialService.getAllCredentials();
		return new ResponseEntity<>(credentials, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Credential> getCredentialById(@PathVariable Long id) {
		Credential credential = credentialService.getCredentialById(id);
		if (credential != null) {
			return new ResponseEntity<>(credential, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/credential")
	public ResponseEntity<Credential> createCredential(@RequestBody Credential credential) {
		Credential createdCredential = credentialService.createCredential(credential);
		return new ResponseEntity<>(createdCredential, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Credential> updateCredential(@PathVariable Long id, @RequestBody Credential credential) {
		Credential updatedCredential = credentialService.updateCredential(id, credential);
		if (updatedCredential != null) {
			return new ResponseEntity<>(updatedCredential, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCredential(@PathVariable Long id) {
		boolean deleted = credentialService.deleteCredential(id);
		if (deleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}