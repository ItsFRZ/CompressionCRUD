package com.ItsFRZ.CompressRest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ItsFRZ.CompressRest.Entity.DataModel;
import com.ItsFRZ.CompressRest.Service.DataService;

@RestController
@RequestMapping("data")
public class CompressRestController {

	@Autowired
	DataService service;

	@GetMapping
	public List<DataModel> getAllObjects()
	{
	
		return service.getAllObjects();
	}
	
	
	
}
