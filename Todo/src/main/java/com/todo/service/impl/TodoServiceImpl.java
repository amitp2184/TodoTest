package com.todo.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.constants.MapKeyConstants;
import com.todo.entity.Todo;
import com.todo.repository.TodoRepository;
import com.todo.service.TodoService;
import com.todo.utility.ConversionUtility;
/*
 * implementation for service interface of todo
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Map<String, Object> create(Map<String, Object> context) {
		Todo todo = null;
		if (context != null && !context.isEmpty()) {
			todo = ConversionUtility.convertMapToEntity(context);
			if (todo != null) {
				todo = todoRepository.save(todo);
			}
		}
		return ConversionUtility.convertEntityToMap(todo);
	}

	@Override
	public Map<String, Object> getById(String id) {
		if (id == null || id.isEmpty()) {
			throw new RuntimeException("Todo Id can not be empty.");
		}
		Map<String,Object> todo = todoRepository.findTodoMapById(Long.parseLong(id));
		if(todo == null || todo.isEmpty()) {
			throw new RuntimeException("Todo not found");
		}
		return todo;
	}

	@Override
	public List<Map<String, Object>> getAll() {
		return ConversionUtility.convertListEntityToListMap(todoRepository.findAll());
	}

	@Override
	public Map<String, Object> update(Map<String, Object> context) {
		Todo todo = null;
		if (context != null && !context.isEmpty() && context.containsKey(MapKeyConstants.TODO_SEQ_ID)) {
			todo = todoRepository.findTodoById(Long.parseLong(context.get(MapKeyConstants.TODO_SEQ_ID).toString()));
			if (todo == null) {
				throw new RuntimeException("Todo not found.");
			}
			todo.setTitle((String) context.get(MapKeyConstants.TITLE));
			todo.setDescription((String) context.get(MapKeyConstants.DESCRIPTION));
			todo.setTimeOfEvent(Timestamp.valueOf(context.get(MapKeyConstants.TIME_OF_EVENT).toString()));		
			todo = todoRepository.save(todo);
		}
		return ConversionUtility.convertEntityToMap(todo);
	}

	@Override
	public boolean removeById(String id) {
		Todo todo = todoRepository.findTodoById(Long.parseLong(id));
		if (todo == null) {
			throw new RuntimeException("Todo not found.");
		}
		todoRepository.delete(todo);
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean removeByIds(Map<String, Object> context) {
		if (context != null && !context.isEmpty()) {
			List<Integer> list = (List<Integer>)context.get(MapKeyConstants.IDS);
			Set<Long> ids = list.parallelStream().map(mapper->{
				return Long.parseLong(mapper.toString());
			}).collect(Collectors.toSet());
			if(ids != null && !ids.isEmpty()) {
				Set<Todo> todos = todoRepository.findAllByIds(ids);
				if (todos != null && !todos.isEmpty()) {
					todoRepository.deleteAll(todos);
					return true;
				}
			}
		}
		return false;
	}

}
