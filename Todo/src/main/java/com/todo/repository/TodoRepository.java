package com.todo.repository;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Serializable> {

	@Query("SELECT todo.todoSeqId as todoSeqId, todo.title as title, todo.description as description, todo.timeOfEvent as timeOfEvent FROM Todo todo WHERE todo.todoSeqId =:id")
	public Map<String, Object> findTodoMapById(@Param("id") long id);
	
	@Query("SELECT todo FROM Todo todo WHERE todo.todoSeqId =:id")
	public Todo findTodoById(@Param("id") long id);

	@Query("SELECT todo FROM Todo todo WHERE todo.todoSeqId IN(:ids)")
	public Set<Todo> findAllByIds(@Param("ids") Set<Long> ids);
	
}
