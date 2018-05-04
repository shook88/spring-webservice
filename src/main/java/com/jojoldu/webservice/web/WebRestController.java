package com.jojoldu.webservice.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jojoldu.webservice.domain.posts.PostsRepository;
import com.jojoldu.webservice.dto.posts.PostsSaveRequestDto;
import com.jojoldu.webservice.service.PostsService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
public class WebRestController {

	private PostsRepository postsRepository;

	private PostsService postsService;

	private Environment env;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}

	@GetMapping("/profile")
	public String getProfile() {
		return Arrays.stream(env.getActiveProfiles()).findFirst().orElse("");
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}

}
