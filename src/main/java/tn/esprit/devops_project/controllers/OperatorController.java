package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.OperatorDTO;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@RestController
@AllArgsConstructor
@Data

public class OperatorController {

	IOperatorService operatorService;
	
	@GetMapping("/operator")
	public List<OperatorDTO> getOperators() {
		return operatorService.retrieveAllOperators();
	}

	@GetMapping("/operator/{operatorId}")
	public OperatorDTO retrieveoperator(@PathVariable Long operatorId) {
		return operatorService.retrieveOperator(operatorId);
	}

	@PostMapping("/operator")
	public OperatorDTO addOperator(@RequestBody OperatorDTO operator) {
		return operatorService.addOperator(operator);
	}

	@DeleteMapping("/operatot/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		operatorService.deleteOperator(operatorId);
	}

	@PutMapping("/operator")
	public OperatorDTO modifyOperateur(@RequestBody OperatorDTO operator) {
		return operatorService.updateOperator(operator);
	}

	
}
