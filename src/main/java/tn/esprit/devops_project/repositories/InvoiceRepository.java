package tn.esprit.devops_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.devops_project.entities.InvoiceDTO;
import tn.esprit.devops_project.entities.Supplier;

import java.util.Date;
import java.util.List;
public interface InvoiceRepository extends JpaRepository<InvoiceDTO, Long> {

	
	@Query("SELECT i FROM InvoiceDTO i where i.supplier=:supplier and i.archived=false")
	public List<InvoiceDTO> retrieveInvoicesBySupplier(@Param("supplier") Supplier supplier);

	
	@Query("SELECT sum(i.amountInvoice) FROM InvoiceDTO i where  i.dateCreationInvoice between :startDate"
			+ " and :endDate and i.archived=false")
	float getTotalAmountInvoiceBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Modifying
	@Query("update InvoiceDTO i set i.archived=true where i.idInvoice=?1")
	void updateInvoice(Long id);
	
}
