package com.epicode.dispositivi.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GadgetWrapper {
	 private Tablet tablet;
	 private Laptop laptop;
	 private Smartphone smartphone;

}
