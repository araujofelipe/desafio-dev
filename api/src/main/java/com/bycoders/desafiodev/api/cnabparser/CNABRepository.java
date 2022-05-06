package com.bycoders.desafiodev.api.cnabparser;

import java.util.Collection;

import org.springframework.stereotype.Repository;

@Repository
public interface CNABRepository {
	
	Collection<CNAB> save(Collection<CNAB> transactions);
} 
