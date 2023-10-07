package com.smoke.screen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoke.screen.payloads.SolutionDTO;
import com.smoke.screen.payloads.SolutionResponse;
import com.smoke.screen.services.SolutionService;
import com.smoke.screen.utilities.ApiResponse;
import com.smoke.screen.utilities.AppConstants;

@RestController
@RequestMapping("/v1/api/")
public class SolutionController {

	@Autowired
	private SolutionService solutionService;

	// For User
//	@PreAuthorize("hasRole('NORMAL')")
	@PostMapping("/user/{userId}/submission")
	public ResponseEntity<SolutionDTO> createSolution(@RequestBody SolutionDTO solutionDto,
			@PathVariable Integer userId) {
		SolutionDTO postSolution = this.solutionService.createSolution(solutionDto, userId);
		return new ResponseEntity<>(postSolution, HttpStatus.CREATED);
	}

	// Only for Admin
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/adm/auth/submission/user/{userId}")
	public ResponseEntity<SolutionDTO> getSolutionByUser(@PathVariable Integer userId) {
		SolutionDTO solution = this.solutionService.getSolutionByUser(userId);
		return new ResponseEntity<SolutionDTO>(solution, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/adm/auth/submissions")
	public ResponseEntity<SolutionResponse> getAllSolutions(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		SolutionResponse solutionResponse = this.solutionService.getAllSolutions(pageNumber, pageSize, sortBy, sortDir);
		return new ResponseEntity<SolutionResponse>(solutionResponse, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/adm/auth/{solutionId}")
	public ApiResponse deletePost(@PathVariable Integer solutionId) {
		this.solutionService.deleteSolution(solutionId);
		return new ApiResponse("Solution is successfully deleted !!", true);
	}
}
