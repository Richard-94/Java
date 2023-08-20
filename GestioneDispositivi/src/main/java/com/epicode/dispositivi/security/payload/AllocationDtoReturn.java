package com.epicode.dispositivi.security.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllocationDtoReturn {
	private String workerUsername;
    private String gadgetIsbn;
    private LocalDate assignedDate;
    private LocalDate returnedDate;
	

}
