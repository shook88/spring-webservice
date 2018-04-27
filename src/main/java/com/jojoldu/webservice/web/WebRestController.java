package com.jojoldu.webservice.web;

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

	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}

	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}

}
