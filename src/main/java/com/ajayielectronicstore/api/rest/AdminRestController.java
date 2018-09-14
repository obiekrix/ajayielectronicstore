/**
 * 
 */
package com.ajayielectronicstore.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajayielectronicstore.api.entity.Admin;
import com.ajayielectronicstore.api.service.AdminService;

/**
 * @author Christian
 *
 */
@RestController
@RequestMapping("/adminapi")
public class AdminRestController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admins")
	public List<Admin> getAdmins(){
		return adminService.getAdmins();
	}

	@GetMapping("/admin/{id}")
	public Admin getAdmin(@PathVariable int id){
		return adminService.getAdmin(id);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin theAdmin) {
		adminService.saveAdmin(theAdmin);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateAdmin(@RequestBody Admin theAdmin) {
		
		adminService.updateAdmin(theAdmin);
		
		return ResponseEntity.ok().build();
	}
}
