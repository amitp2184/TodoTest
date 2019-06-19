package com.todo.service;

import java.util.List;
import java.util.Map;

public interface TodoService {
	public Map<String,Object> create(Map<String,Object> context);
	public Map<String,Object> getById(String id);
	public List<Map<String,Object>> getAll();
	public Map<String,Object> update(Map<String,Object> context);
	public boolean removeById(String id);
	public boolean removeByIds(Map<String,Object> context);
}
