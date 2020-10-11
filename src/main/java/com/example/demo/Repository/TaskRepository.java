package com.example.demo.Repository;

import com.example.demo.Model.Task.State;
import com.example.demo.Model.Task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from fix_list where fix_list.login = :login", nativeQuery = true)
    List<Task> findAllByLogin(@Param("login") String login);

    Task findByTask(String task);

    @Modifying
    @Query(value = "delete from fix_list where fix_list.id = :number_id", nativeQuery = true)
    void deleteById(@Param("number_id") Long id);

    @Transactional
    @Modifying
    @Query(value = "update  set  fix_f state = :state where task = :task", nativeQuery = true)
    void updateStateTask(@Param("task") String task, @Param("state") String state);
}