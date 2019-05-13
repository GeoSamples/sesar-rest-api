package org.earthchem.sesarrestapi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1")
@Api(value="Sample", description="Navigation types from SESAR",  tags = { "Sample" })
public class SampleController {

	@Autowired
	private SampleService service;
	
	@ApiOperation(value = "Get navigation type content by id")
	@GetMapping(path="/sample/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ResponseEntity<Sample> get(@PathVariable Integer id) {      
		return new ResponseEntity<Sample>(service.get(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get navigation type content by igsn")
	@GetMapping(path="/sample/igsn/{igsn}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public Sample getByName(@PathVariable String name) {
		return service.getByIGSN(name);
	}
	
	@ApiOperation(value = "Get existing list of platform type from SESAR")
	@GetMapping(path="/samples/platformtypes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getPlatformTypes() {  
		List<String> l = service.getPlatformTypes();
		List<String> nl = new ArrayList<String>();
		try {
          //  File file = ResourceUtils.getFile("volcabury_mapping/platform_type_mapping.json");
            //InputStream in = new FileInputStream(file);
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/platform_type_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
			System.out.println(pl);
			

		    for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s)) s2 = pl.get(s);
		  	    else s2 = s;
			    if(nl.contains(s2)) continue;
			    nl.add(s2);
		    }
        } catch (IOException e) {
           return new ResponseEntity<List<String> >(new ArrayList<String>(), HttpStatus.NOT_FOUND);
        }
        
		return new ResponseEntity<List<String> >(nl, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the existing list of physionic features from SESAR")
	@GetMapping(path="/samples/physiogeographicfeatures", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getPhysionicFeatures() {  
		return new ResponseEntity<List<String> >(service.getPrimaryLocationTypes(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the existing list of collection  methods from SESAR")
	@GetMapping(path="/samples/collectionmethods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getCollectionMethods() {  
		return new ResponseEntity<List<String> >(service.getCollectionMethods(), HttpStatus.OK);
	}
	
}