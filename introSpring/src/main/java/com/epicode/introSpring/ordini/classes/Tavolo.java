package com.epicode.introSpring.ordini.classes;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component 
public class Tavolo {
	private int tableNumber;
	private int numberSeats;
	private Status status;
	
	
	
}
