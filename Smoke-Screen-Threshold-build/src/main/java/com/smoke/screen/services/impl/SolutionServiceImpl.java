package com.smoke.screen.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.smoke.screen.entities.Solution;
import com.smoke.screen.entities.User;
import com.smoke.screen.exceptions.ResourceNotFoundException;
import com.smoke.screen.payloads.SolutionDTO;
import com.smoke.screen.payloads.SolutionResponse;
import com.smoke.screen.repos.SolutionRepo;
import com.smoke.screen.repos.UserRepo;
import com.smoke.screen.services.SolutionService;

@Service
public class SolutionServiceImpl implements SolutionService {

	@Autowired
	private SolutionRepo solutionRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SolutionDTO createSolution(SolutionDTO solutionDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		Solution solution = this.modelMapper.map(solutionDto, Solution.class);
		solution.setAddedDate(new Date());
		solution.setUser(user);
		Solution postSolution = this.solutionRepo.save(solution);
		return this.modelMapper.map(postSolution, SolutionDTO.class);
	}

	@Override
	public SolutionDTO getSolutionByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		Solution solution = this.solutionRepo.findByUser(user);
		return this.solutionToDto(solution);
	}

	@Override
	public SolutionResponse getAllSolutions(Integer pageNumber,Integer pageSize,String sortBy,String sortDir) {

		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		Page<Solution> pageSolution = this.solutionRepo.findAll(p);
		List<Solution> allSolutions = pageSolution.getContent();
		List<SolutionDTO> solutionDtos = allSolutions.stream().map((solution) -> this.modelMapper.map(solution, SolutionDTO.class))
				.collect(Collectors.toList());
		SolutionResponse solutionResponse = new SolutionResponse();
		solutionResponse.setContent(solutionDtos);
		solutionResponse.setPageNumber(pageSolution.getNumber());
		solutionResponse.setPageSize(pageSolution.getSize());
		solutionResponse.setTotalElements(pageSolution.getTotalElements());
		solutionResponse.setTotalPages(pageSolution.getTotalPages());
		solutionResponse.setLastPage(pageSolution.isLast());
		
		return solutionResponse;
	}
	
	@Override
	public void deleteSolution(Integer solutionId) {
		Solution solution = this.solutionRepo.findById(solutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Solution", "Solution Id", solutionId));
		this.solutionRepo.delete(solution);
	}

	// Not needed but implemented
	
	@Override
	public SolutionDTO updateSolution(SolutionDTO solutionDto, Integer solutionId) {
		Solution solution = this.solutionRepo.findById(solutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Solution", "Solution Id", solutionId));
		solution.setLangQ1(solutionDto.getLangQ1());
		solution.setLangQ2(solutionDto.getLangQ2());
		solution.setLangQ3(solutionDto.getLangQ3());
		solution.setSolutionQ1(solutionDto.getSolutionQ1());
		solution.setSolutionQ2(solutionDto.getSolutionQ2());
		solution.setSolutionQ3(solutionDto.getSolutionQ3());
		solution.setFlashCount(solutionDto.getFlashCount());
		solution.setTimeTaken(solutionDto.getTimeTaken());
		Solution updatedSolution = this.solutionRepo.save(solution);
		return this.solutionToDto(updatedSolution);
	}

	@Override
	public SolutionDTO getSolutionById(Integer solutionId) {
		Solution solution = this.solutionRepo.findById(solutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Solution", "Solution Id", solutionId));
		return solutionToDto(solution);
	}

	// Mapping methods
	
	public Solution dtoToSolution(SolutionDTO solutionDto) {
		Solution solution = this.modelMapper.map(solutionDto, Solution.class);
		return solution;
	}

	public SolutionDTO solutionToDto(Solution solution) {
		SolutionDTO solutionDto = this.modelMapper.map(solution, SolutionDTO.class);
		return solutionDto;
	}

}
