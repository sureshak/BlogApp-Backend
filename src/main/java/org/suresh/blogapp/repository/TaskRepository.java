/**
 * 
 */
package org.suresh.blogapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.suresh.blogapp.entity.Task;

/**
 * @author cogjava3381
 *
 */
@Repository
public interface TaskRepository  extends JpaRepository<Task, Integer> {
	
	@Query(value = "select * from task where member_id = ?",nativeQuery = true)
	public Optional<Task> findByMemberId(Integer memberId);

}
