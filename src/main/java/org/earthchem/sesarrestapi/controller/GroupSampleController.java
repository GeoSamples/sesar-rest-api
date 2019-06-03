package org.earthchem.sesarrestapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.earthchem.sesarrestapi.dao.SampleProfileDAO;
import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.service.GroupSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1")
@Api(value="GroupSample", description="Samples from a group in SESAR",  tags = { "GroupSample" })
public class GroupSampleController {
	
	@Autowired
	private GroupSampleService service;
	
	@ApiOperation(value = "Get a list of sample profile by group id")
	@GetMapping(path="/samples/group/id/{id}",
	            headers ={"Accept=application/json,application/xml"},
			    produces={"application/json", "application/xml"}
			    )  
	@ResponseBody
	public ResponseEntity<List<SampleProfileDAO>> get(@PathVariable Integer id) {      
		List<Sample> sl = service.getSamplesById(id);
		if(sl == null || sl.isEmpty())
		{
			return new ResponseEntity<List<SampleProfileDAO>>(new ArrayList<SampleProfileDAO>(), HttpStatus.NOT_FOUND);		
		}
		else
		{
		    List<SampleProfileDAO> sp = new ArrayList<SampleProfileDAO>();
		    for( Sample s: sl)
		    {
		    	sp.add(s.getDAO());
		    }
			return new ResponseEntity<List<SampleProfileDAO> >(sp, HttpStatus.OK);
		}
	}

	
	@ApiOperation(value = "Get a list of sample profile by group name")
	@GetMapping(path="/samples/group",
	            headers ={"Accept=application/json,application/xml"},
			    produces={"application/json", "application/xml"})  
	@ResponseBody
	public ResponseEntity<List<SampleProfileDAO>> getSamples(@RequestParam(required = true) String name) {      
		List<Sample> sl = service.getSamplesByName(name);
		if(sl == null || sl.isEmpty())
		{
			return new ResponseEntity<List<SampleProfileDAO>>(new ArrayList<SampleProfileDAO>(), HttpStatus.NOT_FOUND);		
		}
		else
		{
		    List<SampleProfileDAO> sp = new ArrayList<SampleProfileDAO>();
		    for( Sample s: sl)
		    {
		    	sp.add(s.getDAO());
		    }
			return new ResponseEntity<List<SampleProfileDAO> >(sp, HttpStatus.OK);
		}
	}

	@ApiOperation(value = "Get a list of sample profile by group name")
	@GetMapping(path="/samples/downloadcsv/group")
    public ResponseEntity<String> downloadCSV(@RequestParam(required = true) String name, HttpServletResponse response) throws IOException {
 
		List<Sample> sl = service.getSamplesByName(name);
		if(sl == null || sl.isEmpty())
		{
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);		
		}
		else
		{
		    
	
            String csvFileName = "ecl_template.csv";

            // creates mock data
             String headerKey = "Content-Disposition";
             String headerValue = String.format("attachment; filename=\"%s\"",
                     csvFileName);
             response.setHeader(headerKey, headerValue);
 
            // uses the Super CSV API to generate CSV data from the model data
            ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
 
            String[] header = { "name", "igsn", "latitude", "longitude","latitudeEnd","longitudeEnd",
                    "elevation", "elevationUnit", "sampleType", "sampleSubType","material","navigationType",
                    "ageMin","ageMax","ageUnit","primaryLocationType","primaryLocationName","depthMin","depthMax","depthScale"};
 
	        for( Sample s: sl)
	        {
	    	    csvWriter.write(s.getDAO(),header);
	        }
	        String rnt=csvWriter.toString();
            csvWriter.close();
            return new ResponseEntity<String >(rnt, HttpStatus.OK);
		}
    }
}
