package org.earthchem.sesarrestapi.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import org.earthchem.sesarrestapi.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "https://www.geosamples.org")
@RequestMapping("/v1")
@Api(value="Statistics", description="SESAR Statistics API",  tags = { "Statistics" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The operation is successfully."),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You try to access the forbidden resource."),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
}
)
public class StatisticsController {
	@Autowired
	private SampleService service;
    
    @ApiOperation(value = "Get published IGSN total number")
    @GetMapping(path="/igsns/publishedtotal", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<Integer> getAllPublishedIGSNTotalNumber() 
    {  
    	Integer l = service.getAllPublishedIGSNTotalNumber();      
	    return new ResponseEntity<Integer>(l, HttpStatus.OK);
    }
  
    @ApiOperation(value = "Get published top level IGSN total number")
    @GetMapping(path="/rootigsns/publishedtotal", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<Integer> getAllPublishedParentIGSNTotalNumber() 
    {  
    	Integer l = service.getAllPublishedParentIGSNTotalNumber();      
	    return new ResponseEntity<Integer>(l, HttpStatus.OK);
    }

    @ApiOperation(value = "Get registered IGSN count by institution and country between start date and end date. If the end date is omitted, current date will be the end date. If hideprivate is 1, unpublished IGSNs will not be counted.")
    @GetMapping(path= {"/igsns/count/institution"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String> > getIGSNCountByInstitude(@ApiParam(value = "Registration date in a format of YYYY-MM-DD", required=true) @RequestParam(required = true) String start_date,
                                                                      @RequestParam(required = true) @ApiParam(value = "Registration date in a format of YYYY-MM-DD",required=true) String end_date,
                                                                      @RequestParam(required = false) @ApiParam(value = "If 1, sample with unpublished metadata will be excluded in the count.") Integer hideprivate)
    {
        LinkedHashMap<String,String> a = service.getIGSNCountByInstitude(start_date, end_date, hideprivate);
        if(a == null)  return new ResponseEntity<LinkedHashMap<String,String> >(new LinkedHashMap<String,String>(), 
		                                                                 HttpStatus.NOT_FOUND);
        if(a.size() == 0 )
        {
            return new ResponseEntity<LinkedHashMap<String,String> >(a, HttpStatus.NOT_FOUND);
        }
        else if(a.size() == 1 )
        {
            if(a.get("error") == null)
                return new ResponseEntity<LinkedHashMap<String,String> >(a, HttpStatus.BAD_REQUEST);
            //System.err.println(a.toString());
        }
        return new ResponseEntity<LinkedHashMap<String,String> >(a, HttpStatus.OK);
    }
	
    @ApiOperation(value = "Get registered IGSN count by sample type from inception up to end date. If the end date is omitted, current date will be the end date. If hideprivate is 1, unpublished IGSNs will not be counted.")
    @GetMapping(path= {"/igsns/count/sampletype"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String> > getIGSNCountBySampleType(@RequestParam(required = false) @ApiParam(value = "Registration date: end date. E.G. YYYY-MM-DD") String end_date,
                                                                                   @RequestParam(required = false) @ApiParam(value = "If 1, sample with unpublished metadata will be excluded.") Integer hideprivate)
    {
    	String edate=null;
    	if(end_date == null)
    	{
    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    edate = dateFormat.format(new Date());	
    	}
    	else edate = end_date;
        LinkedHashMap<String,String> a = service.getIGSNCountBySampleType(edate, hideprivate);
        if(a == null)  return new ResponseEntity<LinkedHashMap<String,String> >(new LinkedHashMap<String,String>(), 
		                                                                 HttpStatus.NOT_FOUND);
        if(a.size() == 0 )
        {
            return new ResponseEntity<LinkedHashMap<String,String> >(a, HttpStatus.NOT_FOUND);
        }
        else if(a.size() == 1 )
        {
            if(a.get("error") == null)
                return new ResponseEntity<LinkedHashMap<String,String> >(a, HttpStatus.BAD_REQUEST);
            //System.err.println(a.toString());
        }
        return new ResponseEntity<LinkedHashMap<String,String> >(a, HttpStatus.OK);
    }
}
