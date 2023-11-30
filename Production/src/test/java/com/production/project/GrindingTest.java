package com.production.project;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.production.project.costants.TypeOfProcessSpring;
import com.production.project.model.Grinding;
import com.production.project.repository.GrindingRepository;
import com.production.project.service.GrindingService;

import jakarta.persistence.EntityNotFoundException;
@SpringBootTest
class GrindingTest {
	@Autowired @Qualifier("grinding") private ObjectProvider<Grinding> grindProvider;
	@Autowired
    GrindingRepository grindRepo;
	
	@Autowired GrindingService grindServ;
    
	
		 @Test	    void testGrindFind() {		 	        // Given	        Long idToFind = 1L;	        // When	        Optional<Grinding> optionalGrind = grindRepo.findById(idToFind);	        //Grinding actualGrind = optionalGrind.orElse(null);	        // Then	        assertTrue(optionalGrind.isPresent());	        //assertNull(actualGrind);	    }

//	@Test
//	void testCreateGrinding() {
//		Grinding grind = new Grinding();
//		grind.setMachine("XC;
//		grind.setProduced(0L);
//		grind.setToProduce(100L);
//		grind.setStatus(false);
//		grind.setTypeOfProcessSpring(TypeOfProcessSpring.Molatura);
//		assertEquals(100, grind.getToProduce());
//	}

	

	 @Test
	 public void testGrindFind_WithNonExistingId() {
	     // Arrange
	     Long nonExistingId = 140L;

	     // Act
	     try {
	         Optional<Grinding> optionalGrinding = grindServ.grindFind(nonExistingId);
	         // Use assertTrue for a clearer assertion about the absence of a value
	         assertTrue(!optionalGrinding.isPresent());
	     } catch (EntityNotFoundException e) {
	         // Handle the exception if needed
	     }
	 }


	
	
	

}
