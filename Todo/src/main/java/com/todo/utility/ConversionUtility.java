package com.todo.utility;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.todo.constants.MapKeyConstants;
import com.todo.entity.Todo;

/*
 * this is utility is used for converting an object to map or vice versa 
 */

public class ConversionUtility {

	// to convert Todo object to a Map
	public static Map<String, Object> convertEntityToMap(Todo todo) {
		Map<String, Object> context = new HashMap<>();
		if (todo != null) {
			context.put(MapKeyConstants.TODO_SEQ_ID, todo.getTodoSeqId());
			context.put(MapKeyConstants.TITLE, todo.getTitle());
			context.put(MapKeyConstants.DESCRIPTION, todo.getDescription());
			context.put(MapKeyConstants.TIME_OF_EVENT, todo.getTimeOfEvent());
		}
		return context;
	}

	// to convert Map to a Todo object
	public static Todo convertMapToEntity(Map<String, Object> context) {
		Todo todo = new Todo();
		if (context != null && !context.isEmpty()) {
			todo.setTitle((String) context.get(MapKeyConstants.TITLE));
			todo.setDescription((String) context.get(MapKeyConstants.DESCRIPTION));
			todo.setTimeOfEvent(Timestamp.valueOf(context.get(MapKeyConstants.TIME_OF_EVENT).toString()));				
		}
		return todo;
	}

	// to convert List of Todo objects to List of Map
	public static List<Map<String, Object>> convertListEntityToListMap(List<Todo> todos) {
		List<Map<String, Object>> resultList = new ArrayList<>();
		if (todos != null && !todos.isEmpty()) {
			resultList = todos.stream().map(mapper -> {
				Map<String, Object> map = new HashMap<>();
				map.put(MapKeyConstants.TODO_SEQ_ID, mapper.getTodoSeqId());
				map.put(MapKeyConstants.TITLE, mapper.getTitle());
				map.put(MapKeyConstants.DESCRIPTION, mapper.getDescription());
				map.put(MapKeyConstants.TIME_OF_EVENT, mapper.getTimeOfEvent());
				return map;
			}).collect(Collectors.toList());
		}
		return resultList;
	}

}
