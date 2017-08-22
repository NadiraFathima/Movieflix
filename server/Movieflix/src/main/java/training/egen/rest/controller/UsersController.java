package training.egen.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import training.egen.rest.entity.Users;
import training.egen.rest.service.UsersService;

@RestController
@RequestMapping(path="/Users")
public class UsersController {

	@Autowired
	UsersService service;
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users create(@RequestBody Users user)
	{
		return service.create(user);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users findOne(@PathVariable("id") String userId)
	{
		return service.findOne(userId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, path="{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Users update(@PathVariable("id") String userId,@RequestBody Users user)
	{
		return service.update(userId,user);
	}
	@RequestMapping(method=RequestMethod.DELETE, path="{id}")
	public void delete(@PathVariable("id") String userId)
	{
		service.delete(userId);
	}

}
