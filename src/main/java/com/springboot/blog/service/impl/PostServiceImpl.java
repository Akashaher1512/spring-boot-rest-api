package com.springboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNOtFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;

	public PostServiceImpl(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	@Override
	public PostDto createPost(PostDto postDto) {

		// 1. create Post class object

		Post post = mapToEntity(postDto);

		/*
		 * // 2. convert PostDto to Post post.setTitle(postDto.getTitle());
		 * post.setDescription(postDto.getDescription());
		 * post.setContent(postDto.getContent());
		 */
		// 3. save Post to db
		Post newPost = postRepository.save(post);

		// 4. create PostDto class object

		PostDto postResponse = mapToDTO(newPost);

		/*
		 * // 5. convert Post to PostDto postResponse.setId(newPost.getId());
		 * postResponse.setTitle(newPost.getTitle());
		 * postResponse.setDescription(newPost.getDescription());
		 * postResponse.setContent(newPost.getContent());
		 */

		// 6. return the PostDto object
		return postResponse;
	}
	
	
	

	@Override
	public PostResponse getAllPosts(int pageNumber, int pageSize , String sortBy , String sortDir) {
	
		Sort sort = null;
		
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = sort.by(sortBy).ascending();
		}
		else if (sortDir.equalsIgnoreCase("desc")) {
			sort = sort.by(sortBy).descending();
		}
		else {
			sort = sort.by(sortBy).ascending();
		}
		
		
		// 1. create Pageable object
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		
		
		//2. pass pageable object in findAll()
		
		Page<Post> page =  postRepository.findAll(pageable);
		
		//3. transfer data from Page<Post> to List<post> 
		
		List<Post> listOfPosts = page.getContent();
		
		
		List<PostDto> content =  listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContent(content);
		postResponse.setPageNo(page.getNumber());
		postResponse.setPageSize(page.getSize());
		postResponse.setTotalElements(page.getTotalElements());
		postResponse.setTotalPages(page.getTotalPages());
		postResponse.setLast(page.isLast());
		
		return postResponse;
	}

	@Override
	public PostDto getPostById(long id) {
		
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNOtFoundException("Post", "id", id));
	
		return mapToDTO(post);
	}
	
	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		
		// 1. find the post by using id 
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNOtFoundException("Post", "id", id));
		
		// 2. update values of variable using getter and setter methods
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		
		// 3. save updated post to database
		Post updatedPot = postRepository.save(post);
		
		
		return mapToDTO(updatedPot);
	}

	

	@Override
	public void deletePost(long id) { 	//id =1
		
		// 1. find the post by using id
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNOtFoundException("Post", "id", id)); //id =1
		
		// 2. delete Post from database
		postRepository.delete(post);
	}

	
	
	// converting entity to Dto
	private PostDto mapToDTO(Post post) {

		// 1. create postDto object
		PostDto postDto = new PostDto();

		// 2.convert fields
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());

		// 3. return Object of PostDto

		return postDto;
	}

	// converting Dto to entity
	private Post mapToEntity(PostDto postDto) {
		
		//1. create Post object
		Post post = new Post();

		// 2. convert PostDto to Post
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		return post;
	}

	




}
