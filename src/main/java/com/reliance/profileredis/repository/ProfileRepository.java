package com.reliance.profileredis.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.reliance.profileredis.model.Profile;

@Repository
public class ProfileRepository {
	/*
	 * HashOperations can store n number of key value pairs. A single key, such as
	 * the PROFILE can have multiple hashKey:value pairs
	 */
	/* HashOperations<"PROFILE", id, ProfileObject> */
	private HashOperations<String, Integer, Profile> hashOperations;

	public ProfileRepository(RedisTemplate<String, Profile> redisTemplate) {
		super();
		this.hashOperations = redisTemplate.opsForHash();
	}

	// CRUD operations
	public void createProfile(Profile profile) {
		hashOperations.put("PROFILE", profile.getId(), profile);
	}

	public List<Profile> getProfiles() {
		return hashOperations.values("PROFILE");
	}

	public Profile getProfile(Integer id) {
		return hashOperations.get("PROFILE", id);
	}

	public void updateProfile(Integer id, Profile profile) {
		Profile toBeUpdated = hashOperations.get("PROFILE", id);
		toBeUpdated.setName(profile.getName());
		toBeUpdated.setAddress(profile.getAddress());
		createProfile(toBeUpdated);
	}

	public void deleteProfile(Integer id) {
		hashOperations.delete("PROFILE", id);
	}
}
