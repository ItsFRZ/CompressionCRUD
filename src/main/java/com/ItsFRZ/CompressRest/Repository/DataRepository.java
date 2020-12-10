package com.ItsFRZ.CompressRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ItsFRZ.CompressRest.Entity.DataModel;

@Repository
public interface DataRepository extends JpaRepository<DataModel,Long> {

	
}
