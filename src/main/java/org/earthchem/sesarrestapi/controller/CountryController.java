package org.earthchem.sesarrestapi.controller;

import java.util.HashMap;

import org.earthchem.sesarrestapi.dao.CountryDAO;
import org.earthchem.sesarrestapi.model.Country;
import org.earthchem.sesarrestapi.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1/vocabularies")
@Api(value="Country", description="Countries from SESAR",  tags = { "Country" })
public class CountryController {

	@Autowired
	private CountryService service;
	
	@ApiOperation(value = "Get country content by country id")
	@GetMapping(path="/countries/{id}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<CountryDAO> get(@PathVariable Integer id) {
		   Country obj = service.get(id);
		   if(obj == null)
		   {
		      CountryDAO obj2 = new CountryDAO();
		      return new ResponseEntity<CountryDAO>(obj2, HttpStatus.BAD_REQUEST);
		   }
		      
		return new ResponseEntity<CountryDAO>(obj.getDAO(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get country content by country name")
	@GetMapping(path="/countries/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public CountryDAO getByName(@PathVariable String name) {
		   Country obj = service.getByName(name);
		return obj.getDAO();
	}
	
	@ApiOperation(value = "Get a complete list of Countries from SESAR")
	@GetMapping(path="/countries/all", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<HashMap<String, String> > getAll() {
		   HashMap<String, String> obj = service.getAll();
		   if(obj == null || obj.isEmpty())
		   {
			   HashMap<String, String> list= new HashMap<String, String>();
		      return new ResponseEntity< HashMap<String, String> >(list, HttpStatus.NOT_FOUND);
		   }
		      
		return new ResponseEntity<HashMap<String, String> >(obj, HttpStatus.OK);
	}
	
}