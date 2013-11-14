package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@RequestMapping("person")
public class PersonController {

    private List<Person> peeps = new ArrayList<Person>();
 
    public PersonController(){
    	Person p;
    	
    	p = new Person();
    	p.name = "name one";
    	p.age = 48;
    	peeps.add(p);
    	
    	p = new Person();
    	p.name = "name two";
    	p.age = 39;
    	peeps.add(p);
    	
    	p = new Person();
    	p.name = "name three";
    	p.age = 92;
    	peeps.add(p);    	
    }
    
    /**
     * GET /person
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Person>> query() {
        return new ResponseEntity<List<Person>>(peeps, HttpStatus.OK);
    }
 
    /**
     * GET /person/{id}
     * @param id
     * @return
     */
    @RequestMapping(value="{personId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Person> get(@PathVariable final Long personId) {
    	if(personId >= peeps.size()){
    		return new ResponseEntity<Person>(null, null, HttpStatus.NOT_FOUND);
    	}
    	
    	Person value = peeps.get(personId.intValue());
    	return new ResponseEntity<Person>(value, HttpStatus.OK);
    }

    /**
     * POST /person
     * @param p
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Person> create(@RequestBody final Person p) {
    	System.out.println("person: " + p);
        return new ResponseEntity<Person>(p, HttpStatus.CREATED);
    }
    
    /**
     * PUT /person
     * @param p
     * @return
     */
    @RequestMapping(value="{personId}", method=RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Person> update(@PathVariable final Long personId, @RequestBody final Person p) {
    	System.out.println("updating person: " + personId +" to " + p);    	
        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }
}