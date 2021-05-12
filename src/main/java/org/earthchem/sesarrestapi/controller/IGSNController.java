package org.earthchem.sesarrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.earthchem.sesarrestapi.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1")
@Api(value="IGSN", description="IGSN information from SESAR",  tags = { "IGSN" })
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "The operation is successfully."),
        @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
        @ApiResponse(code = 403, message = "You try to access the forbidden resource."),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
}
)
public class IGSNController {

	@Autowired
	private SampleService service;
	
    @ApiOperation(value = "Get a list IGSNs from SESAR according to the geopass number")
    @GetMapping(path= {"/igsns/geopassnum/{geopassnum}"},
                produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<List<String> > getIGSNsById(@PathVariable(required = true) Integer geopassnum,
                                                      @RequestParam(required = false) @ApiParam(value = "Maximum is 50,000") Integer limit,
                                                      @RequestParam(required = false) @ApiParam(value = "start number is 0.") Integer pagenum)
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

        if(limit.intValue() > 50000)
        {   List<String> l2 = new ArrayList<String>();
            l2.add("Error: Exceed the maximum 50000 of limit");
        	return new ResponseEntity<List<String> >(l2, HttpStatus.BAD_REQUEST);
        }
        List<String> l = service.getIGSNsByGeoPassId(geopassnum,limit,pagenum);
	    if(l == null || l.isEmpty() ) {
           return new ResponseEntity<List<String> >(l, HttpStatus.NOT_FOUND);
        }
	    return new ResponseEntity<List<String> >(l, HttpStatus.OK);
    }
  	
    @ApiOperation(value = "Get a list IGSNs from SESAR according to the user GeoPass login name")
    @GetMapping(path= {"/igsns/geopass"}, 
                 produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<List<String> > getIGSNsByName(@RequestParam(required = true) String username,  
                                                        @RequestParam(required = false) @ApiParam(value = "Maximum is 50,000") Integer limit,
                                                        @RequestParam(required = false) @ApiParam(value = "start number is 0.") Integer pagenum) 
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

        if(limit.intValue() > 50000)
        {   List<String> l2 = new ArrayList<String>();
            l2.add("Error: Exceed the maximum 50000 of limit");
        	return new ResponseEntity<List<String> >(l2, HttpStatus.BAD_REQUEST);
        }
	    List<String> l = service.getIGSNsByGeoPassUserName(username,limit,pagenum);
	    if(l == null || l.isEmpty() ) {
           return new ResponseEntity<List<String> >(l, HttpStatus.NOT_FOUND);
        }       
	    return new ResponseEntity<List<String> >(l, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get a list IGSNs from SESAR according to cruise or field program name")
    @GetMapping(path= {"/igsns/field_program"}, 
                produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<List<String> > getIGSNsByCruiseFieldProgram(@RequestParam(required = true) String name,
                                                                      @RequestParam(required = false) Integer hideprivate,
                                                                      @RequestParam(required = false) @ApiParam(value = "Maximum is 50,000") Integer limit,
                                                                      @RequestParam(required = false) @ApiParam(value = "start number is 0.") Integer pagenum)
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

        if(limit.intValue() > 50000)
        {   List<String> l2 = new ArrayList<String>();
            l2.add("Error: Exceed the maximum 50000 of limit");
        	return new ResponseEntity<List<String> >(l2, HttpStatus.BAD_REQUEST);
        }
	    List<String> l = service.getIGSNsByCruiseFieldProgram(name, hideprivate, limit, pagenum);
	    if(l == null || l.isEmpty() ) {
           return new ResponseEntity<List<String> >(l, HttpStatus.NOT_FOUND);
        }
	    return new ResponseEntity<List<String> >(l, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get a list IGSNs from SESAR according to user code. If hideprivate is set to 1, only IGSNs with public metadata will be returned. For large set of IGSNs, you can set limit and page number. Limit is for total numbers to be returned each time. Page number is for which page will be returned and starts with 0.")
    @GetMapping(path= { "/igsns/usercode/{usercode}"},
                produces = MediaType.APPLICATION_JSON_VALUE
               )
    @ResponseBody
    public ResponseEntity<List<String> > getIGSNsByUserCode(@PathVariable String usercode,
    		                                                @RequestParam(required = false)  @ApiParam(value = "Sample Name") String name,
                                                            @RequestParam(required = false) Integer hideprivate,
                                                            @RequestParam(required = false) @ApiParam(value = "Maximum is 50,000") Integer limit,
                                                            @RequestParam(required = false) @ApiParam(value = "start number is 0.") Integer pagenum
                                                            )
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page
        List<String> l = null;

        if(limit.intValue() > 50000)
        {   l = new ArrayList<String>();
            l.add("Error: Exceed the maximum 50000 of limit");
        	return new ResponseEntity<List<String> >(l, HttpStatus.BAD_REQUEST);
        }
        if(name != null )
        {
        	l = service.getIGSNBySampleNameUserCode(name, usercode, hideprivate);
        }
        else
        {
	        l = service.getIGSNsByUserCode(usercode,hideprivate,limit, pagenum);
        }
	    if(l == null || l.isEmpty() ) {
           return new ResponseEntity<List<String> >(l, HttpStatus.NOT_FOUND);
        }
	    return new ResponseEntity<List<String> >(l, HttpStatus.OK);
    }

    @ApiOperation(value = "Get total number of IGSN from SESAR according to geopass username")
    @GetMapping(path="/igsns/total/username", params = "username", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<Integer > getIGSNCountByName(@RequestParam(required = true) String username) {  
	    Integer l = service.getIGSNCountByGeoPassUserName(username);      
	    return new ResponseEntity<Integer >(l, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get published IGSNs. It is paginated.")
    @GetMapping(path="/igsns/published", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<HashMap<String, ArrayList<String>> > getAllPublishedIGSNs(@RequestParam(required = true) @ApiParam(value = "Number of IGSNs each page, maximum is 50000.") Integer limit,
    		                                                                        @RequestParam(required = true) @ApiParam(value = "Start with 0.")  Integer pagenum
    		                                                                       ) 
    {  

        if(limit.intValue() > 50000)
        {   HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
            ArrayList<String> a = new ArrayList<String>();
            l.put("Error:Exceed the maximum 50000 of limit", a);
        	return new ResponseEntity<HashMap<String, ArrayList<String>>>(l, HttpStatus.BAD_REQUEST);
        }
    	HashMap<String, ArrayList<String>> l = service.getAllPublishedIGSNs(limit,pagenum);      
	    return new ResponseEntity<HashMap<String, ArrayList<String>> >(l, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get published top level IGSNs with sample type. It is paginated.")
    @GetMapping(path="/rootigsns/sampletype", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<HashMap<String, ArrayList<String>> > getAllPublishedParentIGSNs(@RequestParam(required = true) @ApiParam(value = "Number of IGSNs each page, maximum is 50000.") Integer limit,
    		                                                                        @RequestParam(required = true) @ApiParam(value = "Start with 0.")  Integer pagenum
    		                                                                       ) 
    {  
        if(limit.intValue() > 50000)
        {   HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
            ArrayList<String> a = new ArrayList<String>();
            l.put("Error:Exceed the maximum 50000 of limit", a);
        	return new ResponseEntity<HashMap<String, ArrayList<String>>>(l, HttpStatus.BAD_REQUEST);
        }
    	HashMap<String, ArrayList<String>> l = service.getAllPublishedParentIGSNs(limit,pagenum);      
	    return new ResponseEntity<HashMap<String, ArrayList<String>> >(l, HttpStatus.OK);
    }
   
    @ApiOperation(value = "Get published top level IGSNs with last update date. It is paginated.")
    @GetMapping(path="/rootigsns/lastupdatedate", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<HashMap<String, ArrayList<String>> > getAllPublishedRootIGSNWithLastUpdate(@RequestParam(required = true) @ApiParam(value = "Number of IGSNs each page, maximum is 50000.") Integer limit,
    		                                                                        @RequestParam(required = true) @ApiParam(value = "Start with 0.")  Integer pagenum
    		                                                                       ) 
    {  
        if(limit.intValue() > 50000)
        {   HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
            ArrayList<String> a = new ArrayList<String>();
            l.put("Error:Exceed the maximum 50000 of limit", a);
        	return new ResponseEntity<HashMap<String, ArrayList<String>>>(l, HttpStatus.BAD_REQUEST);
        }
    	HashMap<String, ArrayList<String>> l = service.getAllPublishedRootIGSNWithLastUpdate(limit,pagenum);      
	    return new ResponseEntity<HashMap<String, ArrayList<String>> >(l, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get published IGSNs with last update date. It is paginated.")
    @GetMapping(path="/igsns/lastupdatedate", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<HashMap<String, ArrayList<String>> > getAllPublishedIGSNWithLastUpdate(@RequestParam(required = true) @ApiParam(value = "Number of IGSNs each page, maximum is 50000.") Integer limit,
    		                                                                        @RequestParam(required = true) @ApiParam(value = "Start with 0.")  Integer pagenum
    		                                                                       ) 
    {  
        if(limit.intValue() > 50000)
        {   HashMap<String, ArrayList<String>> l = new HashMap<String, ArrayList<String>>();
            ArrayList<String> a = new ArrayList<String>();
            l.put("Error:Exceed the maximum 50000 of limit", a);
        	return new ResponseEntity<HashMap<String, ArrayList<String>>>(l, HttpStatus.BAD_REQUEST);
        }
    	HashMap<String, ArrayList<String>> l = service.getAllPublishedIGSNWithLastUpdate(limit,pagenum);      
	    return new ResponseEntity<HashMap<String, ArrayList<String>> >(l, HttpStatus.OK);
    }
  
    @ApiOperation(value = "Get total number of IGSN from SESAR according to geopass number")
    @GetMapping(path="/igsns/total/geopassnum", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<Integer > getIGSNCountById(@RequestParam(required = true) Integer id) {  
	    Integer l = service.getIGSNCountByGeoPassId(id);      
	    return new ResponseEntity<Integer >(l, HttpStatus.OK);
    }	
	
}
