package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.OperatorDTO;

import java.util.List;


public interface IOperatorService {

	List<OperatorDTO> retrieveAllOperators();

	OperatorDTO addOperator(OperatorDTO operator);

	void deleteOperator(Long id);

	OperatorDTO updateOperator(OperatorDTO operator);

	OperatorDTO retrieveOperator(Long id);

}
