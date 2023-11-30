package com.production.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class GrindingController {

	@Test
	@Disabled
	void testUpdateEquipmentStart() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testStopHeatGrinding() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetSingleEquipment() {
		fail("Not yet implemented");
	}

}
