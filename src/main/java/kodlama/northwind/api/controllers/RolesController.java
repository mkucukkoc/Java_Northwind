package kodlama.northwind.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.northwind.businness.abstracts.RoleService;
import kodlama.northwind.core.entities.Role;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessResult;

//@RestController
//@RequestMapping("/api/roles")
public class RolesController {

	/*
	private RoleService _roleService;

	@Autowired
	public RolesController(RoleService roleService) {
		super();
		this._roleService = roleService;
	}
	
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Role role)
	{
		return this._roleService.add(role);

		
	}*/
	
}
