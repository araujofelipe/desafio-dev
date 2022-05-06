package com.bycoders.desafiodev.api.cnabparser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CNABRepository extends JpaRepository<CNAB, Long> {
	
} 
