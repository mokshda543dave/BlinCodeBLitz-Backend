package com.smoke.screen.services;

import com.smoke.screen.payloads.SolutionDTO;
import com.smoke.screen.payloads.SolutionResponse;

public interface SolutionService {

//	For User
	SolutionDTO createSolution(SolutionDTO solutionDto, Integer userId);
	
//	For Admin
	SolutionDTO getSolutionByUser(Integer userId);
	SolutionResponse getAllSolutions(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	void deleteSolution(Integer solutionId);
	
//	Not needed in current perspective but implemented as in for further requirements
	SolutionDTO updateSolution(SolutionDTO solutionDto, Integer solutionId);
	SolutionDTO getSolutionById(Integer solutionId);
}
