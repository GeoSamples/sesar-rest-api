package org.earthchem.sesarrestapi.controller;

import org.earthchem.sesarrestapi.dao.ClassificationDAO;
import org.earthchem.sesarrestapi.model.Classification;
import org.earthchem.sesarrestapi.service.ClassificationService;
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
@RequestMapping("/v1/classifications")
@Api(value="Classification", description="Operations pertaining to Classification for SESAR repository",  tags = { "Classification" })
public class ClassificationController {

	@Autowired
	private ClassificationService service;
	
	@ApiOperation(value = "Get Classification content by classification id")
	@GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ResponseEntity<ClassificationDAO> get(@PathVariable Integer id) {
		   Classification obj = service.get(id);
		   if(obj == null)
		   {
		      ClassificationDAO obj2 = new ClassificationDAO();
		      return new ResponseEntity<ClassificationDAO>(obj2, HttpStatus.BAD_REQUEST);
		   }
		      
		return new ResponseEntity<ClassificationDAO>(obj.getDAO(), HttpStatus.OK);
	}
	@ApiOperation(value = "Get Classification content by Classification name")
	@GetMapping(path="/name/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ClassificationDAO getByName(@PathVariable String name) {
		   Classification obj = service.getByName(name);
		return obj.getDAO();
	}
}