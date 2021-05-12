package org.earthchem.sesarrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;

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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1/vocabularies")
@Api(value="Classification", description="Classifications from SESAR",  tags = { "Classification" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The operation is successfully."),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You try to access the forbidden resource."),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
}
)
public class ClassificationController {

	@Autowired
	private ClassificationService service;
	
	@ApiOperation(value = "Get classification content by classification id")
	@GetMapping(path="/classifications/{id}", produces = MediaType.APPLICATION_JSON_VALUE)  
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
	@GetMapping(path="/classifications/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ClassificationDAO getByName(@PathVariable String name) {
		   Classification obj = service.getByName(name);
		return obj.getDAO();
	}
	
	@ApiOperation(value = "Get a complete list of classifications")
	@GetMapping(path="/classifications/all", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<HashMap<String, ArrayList<String> > > getAll() {
		   HashMap<String, ArrayList<String> > obj = service.getAll();
		   if(obj == null || obj.isEmpty())
		   {
			   HashMap<String, ArrayList<String> > list= new HashMap<String, ArrayList<String> >();
		      return new ResponseEntity<HashMap<String, ArrayList<String> >>(list, HttpStatus.NOT_FOUND);
		   }
		      
		return new ResponseEntity<HashMap<String, ArrayList<String> >>(obj, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get a complete list of materials in SESAR system")
	@GetMapping(path="/materials/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ResponseEntity<HashMap<String, ArrayList<String> > > getAllMaterials() {
		   HashMap<String, ArrayList<String> > obj = service.getAllMaterials();
		   if(obj == null || obj.isEmpty())
		   {
			   HashMap<String, ArrayList<String> > list= new HashMap<String, ArrayList<String> >();
		      return new ResponseEntity<HashMap<String, ArrayList<String> >>(list, HttpStatus.NOT_FOUND);
		   }
		      
		return new ResponseEntity<HashMap<String, ArrayList<String> >>(obj, HttpStatus.OK);
	}
	
}