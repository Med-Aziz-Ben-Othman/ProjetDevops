package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.SupplierDTO;

import java.util.List;

public interface ISupplierService {

	List<SupplierDTO> retrieveAllSuppliers();

	SupplierDTO addSupplier(SupplierDTO supplier);

	void deleteSupplier(Long id);

	SupplierDTO updateSupplier(SupplierDTO supplier);

	SupplierDTO retrieveSupplier(Long id);

}
