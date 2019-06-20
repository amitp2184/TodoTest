package com.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.todo.constants.UriConstants;
import com.todo.service.TodoService;


/*
 * Controller for uri
 */

@CrossOrigin
@RestController
@RequestMapping(value = UriConstants.API + UriConstants.TODO)
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@PostMapping(UriConstants.CREATE)
	public ResponseEntity<Map<String,Object>> create(@RequestBody Map<String,Object> context){
		return new ResponseEntity<>(todoService.create(context), HttpStatus.CREATED);
	}
	
	@GetMapping(UriConstants.GET + UriConstants.BY + UriConstants.ID)
	public ResponseEntity<Map<String,Object>> getById(@PathVariable("id")String todoSeqId){
		return new ResponseEntity<>(todoService.getById(todoSeqId),HttpStatus.OK);
	}

	@GetMapping(UriConstants.GET + UriConstants.ALL)
	public ResponseEntity<List<Map<String,Object>>> getAll(){
		return new ResponseEntity<>(todoService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping(UriConstants.UPDATE)
	public ResponseEntity<Map<String,Object>> update(@RequestBody Map<String,Object> context){
		return new ResponseEntity<>(todoService.update(context),HttpStatus.OK);
	}
	
	@DeleteMapping(UriConstants.DELETE + UriConstants.BY + UriConstants.ID)
	public ResponseEntity<Boolean> removeById(@PathVariable("id")String todoSeqId){
		return new ResponseEntity<>(todoService.removeById(todoSeqId),HttpStatus.OK);
	}
	
	@PostMapping(UriConstants.DELETE + UriConstants.ALL)
	public ResponseEntity<Boolean> removeByIds(@RequestBody Map<String,Object> context){
		return new ResponseEntity<>(todoService.removeByIds(context),HttpStatus.OK);
	}
}
