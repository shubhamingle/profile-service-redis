package com.reliance.profileredis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.reliance.profileredis.model.Profile;

@Configuration
public class Config {
	/*
	 * Lettuce is a fully non-blocking Redis client built with netty providing
	 * Reactive, Asynchronous and Synchronous Data Access, whereas Jedis provides
	 * synchronous data access
	 */
	/*
	 * LettuceConnectionFactory is a class used for creating lettuce-based
	 * connection to Redis
	 */
	/* A Bean is an object managed by the Spring container */
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	/* RedisTemplate is a class used to interact with the Redis database */
	@Bean
	RedisTemplate<String, Profile> redisTemplate() {
		RedisTemplate<String, Profile> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory());
		return redisTemplate;
	}
}
