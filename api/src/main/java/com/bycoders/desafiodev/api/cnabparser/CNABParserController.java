package com.bycoders.desafiodev.api.cnabparser;

import static com.bycoders.desafiodev.api.common.ConstantsConfig.PATH_API_V1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(PATH_API_V1 + "/parser")
public class CNABParserController {
	
	@Autowired
	ResourceLoader resourceLoader;

	private final CNABService service;
	
	public CNABParserController(CNABService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Map<String, List<CNAB>>> parserAndSave(@RequestParam("file") MultipartFile file) throws IOException {
		Set<String> fromInputStream = Util.fromInputStream(file.getInputStream());
		Set<CNAB> transactions = new HashSet<>();
		fromInputStream.stream().forEach(line -> transactions.add(CNAB.from(line)));
		Collection<CNAB> all = service.saveAll(transactions);
		Map<String, List<CNAB>> collect = all.stream().collect(Collectors.groupingBy(CNAB::getStore));
		return ResponseEntity.ok(collect);
	}
}
