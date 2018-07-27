package com.revature.caliber.screening.services;

import java.util.List;

import com.revature.caliber.beans.ViolationType;

public interface ViolationTypeService {
	ViolationType getViolationType(int id);
	List<ViolationType> getAll();
}
