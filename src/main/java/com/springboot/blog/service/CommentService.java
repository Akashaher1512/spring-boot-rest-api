package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.payload.CommentDto;

public interface CommentService {

	// 1. create comment
	CommentDto createCimment( Long postId,  CommentDto commentDto);
	
	// 2. get Comments By Post Id
	List<CommentDto> getCommentsByPostId(long postId);
	
	
	// 3. get comment by id
	CommentDto getCommentById(long postId, long commentId);
	
	// 4. update comment
	CommentDto updateComment(Long postId, Long commentId , CommentDto commentDto);
	
	// 5. delete comment
	void deleteComment(long postId, long commentId);
	
}
