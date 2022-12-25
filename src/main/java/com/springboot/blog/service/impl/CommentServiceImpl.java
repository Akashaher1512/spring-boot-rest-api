package com.springboot.blog.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Override
	public CommentDto createCimment(Long postId, CommentDto commentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentDto> getCommentsByPostId(long postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDto getCommentById(long postId, long commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(long postId, long commentId) {
		// TODO Auto-generated method stub
		
	}
	
	
	// Comment to CommentDto
	private CommentDto mapToDto(Comment comment) {
		
		CommentDto commentDto = new CommentDto();
		commentDto.setId(comment.getId());
		commentDto.setName(comment.getName());
		commentDto.setEmail(comment.getEmail());
		commentDto.setBody(comment.getBody());
		
		return commentDto;
	}
	
	
	// CommentDto to Comment
	private Comment mapToEntity(CommentDto commentDto) {
		
		Comment comment = new Comment();
		
	//	comment.setId(commentDto.getId());
		comment.setName(commentDto.getName());
		comment.setEmail(commentDto.getEmail());
		comment.setBody(commentDto.getBody());
		
		return comment;
	}
	
	

}







