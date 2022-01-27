package com.reliance.profileredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reliance.profileredis.model.Profile;
import com.reliance.profileredis.repository.ProfileRepository;

@RestController
@RequestMapping("/api")
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;

	// GET all profiles
	@GetMapping("/profiles")
	public List<Profile> getProfiles() {
		List<Profile> profiles = profileRepository.getProfiles();
		return profiles;
	}

	// GET profile by id
	@GetMapping("/profiles/{id}")
	public Profile getProfileDetail(@PathVariable("id") Integer id) {
		Profile profile = profileRepository.getProfile(id);
		return profile;
	}

	// POST profile
	@PostMapping("/profiles")
	public void createProfile(@RequestBody Profile profile) {
		profileRepository.createProfile(profile);
	}

	// PUT (Update profile)
	@PutMapping("/profiles/{id}")
	public void updateProfile(@PathVariable("id") Integer id, @RequestBody Profile profile) {
		profileRepository.updateProfile(id, profile);
	}

	// DELETE
	@DeleteMapping("/profiles/{id}")
	public void deleteProfile(@PathVariable("id") Integer id) {
		profileRepository.deleteProfile(id);
	}
}
