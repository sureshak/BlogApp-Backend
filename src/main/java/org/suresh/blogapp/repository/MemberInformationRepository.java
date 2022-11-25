package org.suresh.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.suresh.blogapp.entity.MemberInformation;

@Repository
public interface MemberInformationRepository extends JpaRepository<MemberInformation, Integer> {

}
