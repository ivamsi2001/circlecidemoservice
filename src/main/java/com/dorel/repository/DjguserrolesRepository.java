package com.dorel.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorel.model.Djguserroles;

@Repository
public interface DjguserrolesRepository  extends JpaRepository<Djguserroles, Long> {

	Djguserroles findByDjguserid(UUID djguserid);
}
