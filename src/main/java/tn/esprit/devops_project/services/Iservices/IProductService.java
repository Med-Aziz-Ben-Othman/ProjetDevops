package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.entities.ProductDTO;
import tn.esprit.devops_project.entities.ProductCategory;

import java.util.List;

public interface IProductService {

    ProductDTO addProduct(ProductDTO product, Long idStock);
    ProductDTO retrieveProduct(Long id);
    List<ProductDTO> retreiveAllProduct();
    List<ProductDTO> retrieveProductByCategory(ProductCategory category);
    void deleteProduct(Long id);
    List<ProductDTO> retreiveProductStock(Long id);


}
