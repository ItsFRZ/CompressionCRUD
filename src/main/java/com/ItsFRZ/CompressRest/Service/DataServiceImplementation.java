package com.ItsFRZ.CompressRest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ItsFRZ.CompressRest.Entity.DataModel;
import com.ItsFRZ.CompressRest.Repository.DataRepository;

@Service
public class DataServiceImplementation implements DataService {

	@Autowired
	private DataRepository repository;
	
	
	
	public DataRepository getRepository() {
		return repository;
	}

	public void setRepository(DataRepository repository) {
		this.repository = repository;
	}

	@Override
	public DataModel saveObjects(DataModel objects) {
		// TODO Auto-generated method stub
		return repository.save(objects);
	}

	@Override
	public DataModel updateObjects(DataModel objects) {
		// TODO Auto-generated method stub
		return repository.save(objects);
	}

	@Override
	public void deleteObjects(Long id) {
		// TODO Auto-generated method stub

		repository.deleteById(id);
	}

	@Override
	public Optional<DataModel> getObjectById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<DataModel> getAllObjects() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
