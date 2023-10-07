package com.smoke.screen.services;

import java.util.List;

import com.smoke.screen.payloads.PermissionsDTO;

public interface PermissionsService {

	List<PermissionsDTO> getAllPermissions();
	
	PermissionsDTO updatePermission(PermissionsDTO permission, Integer PerId);
}
