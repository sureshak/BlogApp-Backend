/**
 * 
 */
package org.suresh.blogapp.service;

import org.suresh.blogapp.entity.Task;

/**
 * @author cogjava3381
 *
 */
public interface MemberService {

	Task getTaskDetail(Integer memberId);
}
