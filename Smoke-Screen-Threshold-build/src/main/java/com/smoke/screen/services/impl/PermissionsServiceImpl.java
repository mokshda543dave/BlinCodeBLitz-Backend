package com.smoke.screen.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoke.screen.entities.Permissions;
import com.smoke.screen.exceptions.ResourceNotFoundException;
import com.smoke.screen.payloads.PermissionsDTO;
import com.smoke.screen.repos.PermissionsRepo;
import com.smoke.screen.services.PermissionsService;

@Service
public class PermissionsServiceImpl implements PermissionsService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PermissionsRepo permissionsRepo;

	@Override
	public List<PermissionsDTO> getAllPermissions() {
		List<Permissions> permissions = this.permissionsRepo.findAll();
		List<PermissionsDTO> permissionDtos = permissions.stream().map(per -> this.permissionToDto(per)).collect(Collectors.toList());
		return permissionDtos;
	}

	@Override
	public PermissionsDTO updatePermission(PermissionsDTO permission, Integer PerId) {
		Permissions permissions = this.permissionsRepo.findById(PerId).orElseThrow(() -> new ResourceNotFoundException("Permission", "Id", PerId));
		permissions.setStatus(permission.getStatus());
		permissions.setId(permission.getId());
		permissions.setName(permission.getName());
		
		Permissions updated = this.permissionsRepo.save(permissions);
		PermissionsDTO dtos = this.permissionToDto(updated);
		return dtos;
	}
	
	public Permissions dtoToPermission(PermissionsDTO permisssionDTO) {
		Permissions per = this.modelMapper.map(permisssionDTO, Permissions.class);
		return per;
	}

	public PermissionsDTO permissionToDto(Permissions per) {
		PermissionsDTO perDto = this.modelMapper.map(per, PermissionsDTO.class);
		return perDto;
	}

}
