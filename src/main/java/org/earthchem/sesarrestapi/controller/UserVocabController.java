package org.earthchem.sesarrestapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.earthchem.sesarrestapi.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1")
@Api(value="UserVocab", description="Collected Vocaburaries from User in SESAR",  tags = { "UserVocab" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The operation is successfully."),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You try to access the forbidden resource."),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
}
)
public class UserVocabController {
	@Autowired
	private SampleService service;

	@ApiOperation(value = "Get existing list of platform type from SESAR")
	@GetMapping(path="/vocabularies/platformtypes", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getPlatformTypes() {  
		List<String> l = service.getPlatformTypes();
		List<String> nl = new ArrayList<String>();
		try {
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/platform_type_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
			System.out.println(pl);
			

		    for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s)) 
		  	    {
		  	    	if(pl.get(s).length()==0) continue;
		  	    	s2 = pl.get(s);
		  	    }
		  	    else s2 = s;
			    if(nl.contains(s2)) continue;
			    nl.add(s2);
		    }
        } catch (IOException e) {
           return new ResponseEntity<List<String> >(new ArrayList<String>(), HttpStatus.NOT_FOUND);
        }    
		return new ResponseEntity<List<String> >(nl, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the existing list of collection  methods from SESAR")
	@GetMapping(path="/vocabularies/collectionmethods", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getCollectionMethods() { 
		
		List<String> l = service.getCollectionMethods();
		List<String> nl = new ArrayList<String>();
		try {
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/collection_method_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
		    for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s)) 
		  	    {
		  	    	if(pl.get(s).length()==0) continue;
		  	    	s2 = pl.get(s);
		  	    }
		  	    else s2 = s;
			    if(nl.contains(s2)) continue;
			    nl.add(s2);
		    }
        } catch (IOException e) {
           return new ResponseEntity<List<String> >(new ArrayList<String>(), HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<String> >(nl, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the existing list of collector from SESAR")
	@GetMapping(path="/vocabularies/collectors", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getCollectors() { 
		
		List<String> l = service.getCollectors();
		List<String> nl = new ArrayList<String>();
		try {
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/collector_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
		    for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s)) 
		  	    {
		  	    	if(pl.get(s).length()==0) continue;
		  	    	s2 = pl.get(s);
		  	    }
		  	    else s2 = s;
			    if(nl.contains(s2)) continue;
			    nl.add(s2);
		    }
        } catch (IOException e) {
           return new ResponseEntity<List<String> >(new ArrayList<String>(), HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<String> >(nl, HttpStatus.OK);
	}	

	@ApiOperation(value = "Get existing list of platform name from SESAR")
	@GetMapping(path="/vocabularies/platformnames", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getPlatformNames() {  
		List<String> l = service.getPlatformNames();
		List<String> nl = new ArrayList<String>();
		try {
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/platform_name_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
		    for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s))
		  	    {
		  	    	if(pl.get(s).length()==0) continue;
		  	    	s2 = pl.get(s);
		  	    }
		  	    else s2 = s;
			    if(nl.contains(s2)) continue;
			    nl.add(s2);
		    }
        } catch (IOException e) {
           return new ResponseEntity<List<String> >(new ArrayList<String>(), HttpStatus.NOT_FOUND);
        }  
		return new ResponseEntity<List<String> >(nl, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get existing list of field name from SESAR")
	@GetMapping(path="/vocabularies/cruisefieldprograms", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getFieldNames() {  
		List<String> l = service.getCruiseFieldPrgrm();
		List<String> nl = new ArrayList<String>();
		try {
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/cruise_field_program_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
			for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s)) 
		  	    {
		  	    	if(pl.get(s).length()==0) continue; 
		  	    	s2 = pl.get(s);
		  	    }
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
	@GetMapping(path="/vocabularies/physiogeographicfeatures", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<List<String> > getPhysiographicFeatures() { 
		List<String> l = service.getPrimaryLocationTypes();
		List<String> nl = new ArrayList<String>();
		try {
            InputStream in = new ClassPathResource(
            	      "volcabulary_mapping/physiographic_feature_mapping.json").getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            TypeReference< HashMap<String, String> > typeReference = new TypeReference< HashMap<String,String> >(){};
			HashMap<String,String> pl = mapper.readValue(in,typeReference);
		    for( String s: l)
		    {
		    	String s2;
		  	    if(pl.containsKey(s)) 
		  	    {
		  	    	if(pl.get(s).length()==0) continue;
		  	    	s2 = pl.get(s);
		  	    }
		  	    else s2 = s;
			    if(nl.contains(s2)) continue;
			    nl.add(s2);
		    }
        } catch (IOException e) {
           return new ResponseEntity<List<String> >(new ArrayList<String>(), HttpStatus.NOT_FOUND);
        }	
		return new ResponseEntity<List<String> >(nl, HttpStatus.OK);
	}
}
