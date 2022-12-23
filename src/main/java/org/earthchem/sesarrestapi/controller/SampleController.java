package org.earthchem.sesarrestapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.earthchem.sesarrestapi.dao.SampleIGSNJSONLDDAO;
import org.earthchem.sesarrestapi.dao.SampleJSONLDDAO;
import org.earthchem.sesarrestapi.dao.SampleProfileDAO;
import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1")
@Api(value="Sample", description="Sample Metadata from SESAR",  tags = { "Sample" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The operation is successfully."),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You try to access the forbidden resource."),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
}
)
public class SampleController {

	@Autowired
	private SampleService service;
	
	@ApiOperation(value = "Get sample profile by id")
	@GetMapping(path="/sample/id/{id}",
	            headers ={"Accept=application/json,application/xml"},
			    produces={"application/json", "application/xml"})  
	@ResponseBody
	public ResponseEntity<SampleProfileDAO> get(@PathVariable Integer id) {
		Sample s = service.get(id);
		if(s == null )
		{
			return new ResponseEntity<SampleProfileDAO>(new SampleProfileDAO(), HttpStatus.NOT_FOUND);		
		}
	     
		SampleProfileDAO sp = s.getDAO();
		
		return new ResponseEntity<SampleProfileDAO>(sp, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get sample profile by igsn")
	@GetMapping(path={"/sample/igsn/{igsn}", "/sample/igsn/{prefix}/{igsn}"}, 
                headers ={"Accept=application/json,application/xml"},
		        produces={"application/json", "application/xml"})  
	@ResponseBody
	public ResponseEntity<SampleProfileDAO> getByIGSN(@PathVariable (required = false) String prefix, @PathVariable String igsn) {
		String fullIgsn = null;
		if (prefix != null) {
			fullIgsn = prefix + "/" + igsn;
		} else {
			fullIgsn = igsn;
		}
		Sample s = service.getByIGSN(fullIgsn);
		if(s == null )
		{
			return new ResponseEntity<SampleProfileDAO>(new SampleProfileDAO(), HttpStatus.NOT_FOUND);		
		}
		SampleProfileDAO sp = s.getDAO();
		return new ResponseEntity<SampleProfileDAO>(sp, HttpStatus.OK);
	}

	@ApiOperation(value = "Get sample profile by sample name")
	@GetMapping(path="/samples",
                headers ={"Accept=application/json,application/xml"},
		        produces={"application/json", "application/xml"})
	@ResponseBody
	public ResponseEntity<List<SampleProfileDAO>> getByName(@RequestParam (required = true) String name) {
		List<Sample> s = service.getByName(name);
		List<SampleProfileDAO> sl = new ArrayList<SampleProfileDAO>();
		if(s == null )
		{
			return new ResponseEntity<List<SampleProfileDAO>>(sl, HttpStatus.NOT_FOUND);
		}
		for (Sample item: s)
		{
		    SampleProfileDAO sp = item.getDAO();
		    sl.add(sp);
	    }
		return new ResponseEntity<List<SampleProfileDAO>>(sl, HttpStatus.OK);
	}


	@ApiOperation(value = "Get Sample JSON-LD content by igsn.")
	@GetMapping(path={"/sample/json-ld/igsn/{igsn}", "/sample/json-ld/igsn/{prefix}/{igsn}"}, produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<SampleJSONLDDAO> getJSONLDByIGSN(@PathVariable (required = false) String prefix, @PathVariable String igsn) {
			String fullIgsn = null;
			if (prefix != null) {
				fullIgsn = prefix + "/" + igsn;
			} else {
				fullIgsn = igsn;
			}   
			Sample sobj = service.getByIGSN(fullIgsn);
			if(sobj==null)
			{
				return new ResponseEntity<SampleJSONLDDAO>(new SampleJSONLDDAO(), HttpStatus.NOT_FOUND);
			}
			else
			{
				SampleJSONLDDAO obj = sobj.getJSONLDDAO();		   
				return new ResponseEntity<SampleJSONLDDAO>(obj, HttpStatus.OK);
			}
	}
		
	@ApiOperation(value = "Get Sample IGSN-ev JSON-LD content by igsn. See <a href='https://github.com/IGSN/igsn-json'> here </a> for more details.")
	@GetMapping(path={"/sample/igsn-ev-json-ld/igsn/{igsn}", "/sample/igsn-ev-json-ld/igsn/{prefix}/{igsn}"}, produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<SampleIGSNJSONLDDAO> getIGSNEVJSONLDByIGSN(@PathVariable (required = false) String prefix, @PathVariable String igsn) {
			String fullIgsn = null;
			if (prefix != null) {
				fullIgsn = prefix + "/" + igsn;
			} else {
				fullIgsn = igsn;
			}
			Sample sobj = service.getByIGSN(fullIgsn);
			if(sobj==null)
			{
				return new ResponseEntity<SampleIGSNJSONLDDAO>(new SampleIGSNJSONLDDAO(), HttpStatus.NOT_FOUND);
			}
			else
			{
				SampleIGSNJSONLDDAO obj = sobj.getIGSNJSONLDDAO();
				
				return new ResponseEntity<SampleIGSNJSONLDDAO>(obj, HttpStatus.OK);
			}
	}
}
