package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.InvoiceDTO;

import java.util.Date;
import java.util.List;

public interface IInvoiceService {
	List<InvoiceDTO> retrieveAllInvoices();

	List<InvoiceDTO> getInvoicesBySupplier(Long idSupplier);

	void cancelInvoice(Long id);

	InvoiceDTO retrieveInvoice(Long id);
	
	void assignOperatorToInvoice(Long idOperator, Long idInvoice);

	float getTotalAmountInvoiceBetweenDates(Date startDate, Date endDate);
}
