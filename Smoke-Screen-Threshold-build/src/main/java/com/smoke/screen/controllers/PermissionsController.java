package com.smoke.screen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoke.screen.payloads.PermissionsDTO;
import com.smoke.screen.services.PermissionsService;

@RestController
@RequestMapping("/v1/api/permissions")
public class PermissionsController {
	
	@Autowired
	private PermissionsService permissionsService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{perId}")
	public ResponseEntity<PermissionsDTO> updatePermission(@RequestBody PermissionsDTO perDTO, @PathVariable Integer perId) {
		PermissionsDTO perDto = this.permissionsService.updatePermission(perDTO, perId);
		return new ResponseEntity<>(perDto, HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<PermissionsDTO>> getAllPermissions() {
		return ResponseEntity.ok(this.permissionsService.getAllPermissions());
	}
}
