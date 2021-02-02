package com.examplee.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examplee.model.emp;

@Repository
public interface emp_repos extends JpaRepository<emp, Long> {

}
