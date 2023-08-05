package com.epicode.prenotazione;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.epicode.prenotazione.controller.PrenotationController;

class TestController {
	@Autowired PrenotationController pt;

	@BeforeAll
	static void beforeAllTest() {
		System.out.println("beforeAllTest");
	}
	
	@Test
	void testLanguage() {
		assertEquals("/api/book/italian",pt.english());
	}
}
