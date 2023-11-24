package com.tesifacile.project.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tesifacile.project.checking.TesiControl;
import com.tesifacile.project.model.Thesis;
import com.tesifacile.project.repository.ThesisRepository;

@Service
public class ThesisService {
	@Autowired ThesisRepository thesisRepo;
	@Autowired @Qualifier("theis") private ObjectProvider<Thesis> thesisProvider;
	@Autowired TesiControl tesiControl;
	

}
