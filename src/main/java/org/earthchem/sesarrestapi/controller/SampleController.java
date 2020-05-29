package org.earthchem.sesarrestapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.earthchem.sesarrestapi.dao.SampleJSONLDDAO;
import org.earthchem.sesarrestapi.dao.SampleProfileDAO;
import org.earthchem.sesarrestapi.model.Sample;
import org.earthchem.sesarrestapi.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1")
@Api(value="Sample", description="Sampe Metadata from SESAR",  tags = { "Sample" })
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
	@GetMapping(path="/sample/igsn/{igsn}", 
                headers ={"Accept=application/json,application/xml"},
		        produces={"application/json", "application/xml"})  
	@ResponseBody
	public ResponseEntity<SampleProfileDAO> getByIGSN(@PathVariable String igsn) {
		Sample s = service.getByIGSN(igsn);
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
	
	
    @ApiOperation(value = "Get a list IGSNs from SESAR according to the geopass number")
    @GetMapping(path= {"/igsns/geopassnum/{geopassnum}"},
                produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<List<String> > getIGSNsById(@PathVariable(required = true) Integer geopassnum,
                                                      @RequestParam(required = false) Integer limit,
                                                      @RequestParam(required = false) Integer pagenum)
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

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
                                                        @RequestParam(required = false) Integer limit,
                                                        @RequestParam(required = false) Integer pagenum) 
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

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
                                                                      @RequestParam(required = false) Integer limit,
                                                                      @RequestParam(required = false) Integer pagenum)
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

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
                                                            @RequestParam(required = false) Integer hideprivate,
                                                            @RequestParam(required = false) Integer limit,
                                                            @RequestParam(required = false) Integer pagenum
                                                            )
    {
        if(limit != null && pagenum == null) pagenum = new Integer(0); //Default to first page
        if(limit == null && pagenum != null) limit = new Integer(100); //Default to first page
        if(limit == null && pagenum == null) {limit = new Integer(100);pagenum = new Integer(0);}; //Default to first page

	    List<String> l = service.getIGSNsByUserCode(usercode,hideprivate,limit, pagenum);
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
    
    
    @ApiOperation(value = "Get total number of IGSN from SESAR according to geopass number")
    @GetMapping(path="/igsns/total/geopassnum", params = "id", produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<Integer > getIGSNCountById(@RequestParam(required = true) Integer id) {  
	    Integer l = service.getIGSNCountByGeoPassId(id);      
	    return new ResponseEntity<Integer >(l, HttpStatus.OK);
    }
    
	
	
	@ApiOperation(value = "Get Sample JSON-LD content by igsn.")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrive the content."),
            @ApiResponse(code = 401, message = "You are not authorized to access the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping(path="/sample/json-ld/igsn/{igsn}", produces = MediaType.APPLICATION_JSON_VALUE)  
	@ResponseBody
	public ResponseEntity<SampleJSONLDDAO> getJSONLDByIGSN(@PathVariable String igsn) {
		   Sample sobj = service.getByIGSN(igsn);
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
}
