package com.ItsFRZ.CompressRest.Service;

import java.util.List;
import java.util.Optional;

import com.ItsFRZ.CompressRest.Entity.DataModel;

public interface DataService {

	DataModel saveObjects(DataModel objects);
	DataModel updateObjects(DataModel objects);
	void deleteObjects(Long id);
	Optional<DataModel> getObjectById(Long id);
	List<DataModel> getAllObjects();
	
}
