package com.techbow.datadashboard.model.dao.repository;

import com.techbow.datadashboard.model.dvo.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataJpaRepository extends JpaRepository<Data, Long> {
}
