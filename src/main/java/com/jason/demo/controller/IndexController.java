package com.jason.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Annotation @RequestMapping 教學範例
 * 
 */
@RestController
@RequestMapping("/home")
public class IndexController {
	
	
	@RequestMapping("/")
	String get() {
		// mapped to hostname:port/home/
		return "Hello from get";
	}

	@RequestMapping("/index")
	String index() {
		// mapped to hostname:port/home/index/
		return "Hello from index";
	}

//	@RequestMapping(value = { "", "/page", "page*", "view/*", "**/msg" })
	@RequestMapping(value = { "/page", "page*", "view/*", "**/msg" })
	String indexMultipleMapping() {
		return "Hello from index multiple mapping.";
	}

	@RequestMapping(value = "/id")
	String getIdByValue(@RequestParam("id") String personId) {
		System.out.println("ID is " + personId);
		return "Get ID from query string of URL with value element";
	}

	@RequestMapping(value = "/personId")
	String getId(@RequestParam String personId) {
		System.out.println("ID is " + personId);
		return "Get ID from query string of URL without value element";
	}

	@RequestMapping(value = "/name")
	String getName(@RequestParam(value = "person", required = false) String personName) {
		return "Required element of request param. personName is " + personName;
	}

	@RequestMapping(value = "/name2")
	String getName2(@RequestParam(value = "person", defaultValue = "John") String personName) {
		return "Required element of request param. personName is " + personName;
	}

	@RequestMapping(method = RequestMethod.GET)
	String get2() {
		return "Hello from get";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	String delete() {
		return "Hello from delete";
	}

	@RequestMapping(method = RequestMethod.POST)
	String post() {
		return "Hello from post";
	}

	@RequestMapping(method = RequestMethod.PUT)
	String put() {
		return "Hello from put";
	}

	@RequestMapping(method = RequestMethod.PATCH)
	String patch() {
		return "Hello from patch";
	}

	@RequestMapping(value = "/prod", produces = { "application/JSON" })
	@ResponseBody
	String getProduces() {
		return "Produces attribute";
	}

	@RequestMapping(value = "/cons", consumes = { "application/JSON", "application/XML" })
	String getConsumes() {
		return "Consumes attribute";
	}

	@RequestMapping(value = "/head", headers = { "content-type=text/plain" })
	String head() {
		return "Mapping applied along with headers";
	}

	@RequestMapping(value = "/head", headers = { "content-type=text/plain", "content-type=text/html" })
	String head2() {
		return "Mapping applied along with headers";
	}

	@RequestMapping(value = "/fetch", params = { "personId=10" })
	String getParams(@RequestParam("personId") String id) {
		return "Fetched parameter using params attribute = " + id;
	}

	@RequestMapping(value = "/fetch", params = { "personId=20" })
	String getParamsDifferent(@RequestParam("personId") String id) {
		return "Fetched parameter using params attribute = " + id;
	}

	@RequestMapping(value = "/fetch/{id}", method = RequestMethod.GET)
	String getDynamicUriValue(@PathVariable String id) {
		System.out.println("ID is " + id);
		return "Dynamic URI parameter fetched";
	}

	@RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
	String getDynamicUriValueRegex(@PathVariable("name") String name) {
		System.out.println("Name is " + name);
		return "Dynamic URI parameter fetched using regex";
	}

	@RequestMapping()
	String defaultMethod() {
		return "This is a default method for the class";
	}

	@GetMapping("/person")
	public @ResponseBody ResponseEntity<String> getPerson() {
		return new ResponseEntity<String>("Response from GET", HttpStatus.OK);
	}

	@GetMapping("/person/{id}")
	public @ResponseBody ResponseEntity<String> getPersonById(@PathVariable String id) {
		return new ResponseEntity<String>("Response from GET with id " + id, HttpStatus.OK);
	}

	@PostMapping("/person")
	public @ResponseBody ResponseEntity<String> postPerson() {
		return new ResponseEntity<String>("Response from POST method", HttpStatus.OK);
	}

	@PutMapping("/person")
	public @ResponseBody ResponseEntity<String> putPerson() {
		return new ResponseEntity<String>("Response from PUT method", HttpStatus.OK);
	}

	@DeleteMapping("/person")
	public @ResponseBody ResponseEntity<String> deletePerson() {
		return new ResponseEntity<String>("Response from DELETE method", HttpStatus.OK);
	}

	@PatchMapping("/person")
	public @ResponseBody ResponseEntity<String> patchPerson() {
		return new ResponseEntity<String>("Response from PATCH method", HttpStatus.OK);
	}
}