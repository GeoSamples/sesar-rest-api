package org.earthchem.sesarrestapi.controller;

import java.util.HashMap;

import org.earthchem.sesarrestapi.dao.LaunchTypeDAO;
import org.earthchem.sesarrestapi.model.LaunchType;
import org.earthchem.sesarrestapi.service.LaunchTypeService;
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
@Api(value="LaunchType", description="Launch types from SESAR",  tags = { "LaunchType" })
public class LaunchTypeController {

	@Autowired
	private LaunchTypeService service;
	
	@ApiOperation(value = "Get launch type by id")
	@GetMapping(path="/launchtypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<LaunchTypeDAO> get(@PathVariable Integer id) {
		   LaunchType obj = service.get(id);
		   if(obj == null)
		   {
		      LaunchTypeDAO obj2 = new LaunchTypeDAO();
		      return new ResponseEntity<LaunchTypeDAO>(obj2, HttpStatus.BAD_REQUEST);
		   }
		      
		return new ResponseEntity<LaunchTypeDAO>(obj.getDAO(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get launch type by name")
	@GetMapping(path="/launchtypes/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public LaunchTypeDAO getByName(@PathVariable String name) {
		   LaunchType obj = service.getByName(name);
		return obj.getDAO();
	}
	
	@ApiOperation(value = "Get a complete list of launch type from SESAR")
	@GetMapping(path="/launchtypes/all", produces = MediaType.APPLICATION_JSON_VALUE)  
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