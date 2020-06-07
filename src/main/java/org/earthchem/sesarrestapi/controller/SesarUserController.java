package org.earthchem.sesarrestapi.controller;

import java.util.LinkedHashMap;

import org.earthchem.sesarrestapi.service.SesarUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
//@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/v1/users")
@Api(value="SesarUser", description="Sesar Users from SESAR",  tags = { "Users" })
public class SesarUserController {
	
	@Autowired
	private SesarUserService service;
	
	public SesarUserController() {};
	
	public void setSesarUserService(SesarUserService s)
	{
		this.service = s;
	}

	public SesarUserService getSesarUserService()
	{
		return this.service;
	}
	
    @ApiOperation(value = "Get new user count by month since SESAR inception.")
    @GetMapping(path= {"/count"}, produces = MediaType.APPLICATION_JSON_VALUE)  
    @ResponseBody
    public ResponseEntity<LinkedHashMap<String, String> > getNewUserCountByMonth()
    {
    	LinkedHashMap<String,String> a = service.getNewUserCountByMonth();
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
