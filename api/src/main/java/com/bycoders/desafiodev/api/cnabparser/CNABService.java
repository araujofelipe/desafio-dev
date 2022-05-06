package com.bycoders.desafiodev.api.cnabparser;

import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class CNABService {
	
	private final CNABRepository repository;
	
	public CNABService(CNABRepository repository) {
		this.repository = repository;
	}
	
	public Collection<CNAB> save(Collection<CNAB> transactions) {
		return repository.save(transactions);
	}
}
