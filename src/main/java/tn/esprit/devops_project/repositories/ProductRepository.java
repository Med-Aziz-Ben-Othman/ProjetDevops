package tn.esprit.devops_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devops_project.entities.ProductDTO;
import tn.esprit.devops_project.entities.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductDTO, Long> {

    List<ProductDTO> findByCategory(ProductCategory category);
    List<ProductDTO> findByStockIdStock(Long idStock);
}
