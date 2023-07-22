package com.todo.todolist.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = " INSERT INTO public.tasks (user_id) VALUES (:id)", nativeQuery = true)
    public default void insertTaskUser(Long id) {
    }
}
