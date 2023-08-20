package com.epicode.dispositivi.security.payload;

import java.time.LocalDate;

import com.epicode.dispositivi.security.model.Allocation;
import com.epicode.dispositivi.security.model.Gadget;
import com.epicode.dispositivi.security.model.Worker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AllocationDtoCreate {
	private String workerUsername;
    private String gadgetIsbn;
    private LocalDate assignedDate;
	

}
