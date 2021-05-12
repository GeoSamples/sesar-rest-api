package org.earthchem.sesarrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.earthchem.sesarrestapi.dao.SampleTypeDAO;
import org.earthchem.sesarrestapi.model.SampleType;
import org.earthchem.sesarrestapi.service.SampleTypeService;
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
@Api(value="SampleType", description="Sample Types from SESAR",  tags = { "SampleType" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The operation is successfully."),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You try to access the forbidden resource."),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
}
)
public class SampleTypeController {

	@Autowired
	private SampleTypeService service;
	
	@ApiOperation(value = "Get sample type content by sample type id")
	@GetMapping(path="/sampletypes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<SampleTypeDAO> get(@PathVariable Integer id) {
		   SampleType obj = service.get(id);
		   if(obj == null)
		   {
		      SampleTypeDAO obj2 = new SampleTypeDAO();
		      return new ResponseEntity<SampleTypeDAO>(obj2, HttpStatus.BAD_REQUEST);
		   }
		      
		return new ResponseEntity<SampleTypeDAO>(obj.getDAO(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get sample type content by sample type name")
	@GetMapping(path="/sampletypes/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public SampleTypeDAO getByName(@PathVariable String name) {
		   SampleType obj = service.getByName(name);
		return obj.getDAO();
	}
	
	@ApiOperation(value = "Get a complete list of sample types")
	@GetMapping(path="/sampletypes/all", produces = MediaType.APPLICATION_JSON_VALUE)  
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
	
	
	@ApiOperation(value = "Get a complete list of top level sample type (object type) in SESAR system")
	@GetMapping(path="/objecttypes/all", produces = MediaType.APPLICATION_JSON_VALUE)  
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