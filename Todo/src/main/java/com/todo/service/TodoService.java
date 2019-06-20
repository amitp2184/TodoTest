package com.todo.service;

import java.util.List;
import java.util.Map;

/*
 * service interface for todo
 */

public interface TodoService {
	//this method is to create a todo.
	public Map<String,Object> create(Map<String,Object> context);
	//this method is to get a single todo by its todoSeqId.
	public Map<String,Object> getById(String id);
	//this method is to get all todos.
	public List<Map<String,Object>> getAll();
	//this method is to update a todo
	public Map<String,Object> update(Map<String,Object> context);
	//this method is to delete a todo by its todoSeqId
	public boolean removeById(String id);
	//this method is to remove all that todos which are checked at front end.
	public boolean removeByIds(Map<String,Object> context);
}
