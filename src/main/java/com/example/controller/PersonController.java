package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
@RequestMapping("person")
public class PersonController {

//    private List<Person> names = Arrays.asList(new Person("name one"), new Person("name two"), new Person("name three"));
// 
//    /**
//     * GET /person
//     * @return
//     */
//    @RequestMapping(method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<Person>> query() {
//        return new ResponseEntity<List<Person>>(names, HttpStatus.OK);
//    }
// 
//    /**
//     * GET /person/{id}
//     * @param id
//     * @return
//     */
//    @RequestMapping(value="{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<Person> get(@PathVariable Long id) {
//    	if(id >= names.size()){
//    		return new ResponseEntity<Person>(null, null, HttpStatus.NOT_FOUND);
//    	}
//    	
//    	Person value = names.get(id.intValue());
//    	return new ResponseEntity<Person>(value, HttpStatus.OK);
//    }

    /**
     * POST /person
     * @param person
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Person> create(Person person) {
    	System.out.println("name4: "+person.getName());
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }
}