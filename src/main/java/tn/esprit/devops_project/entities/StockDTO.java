package tn.esprit.devops_project.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockDTO implements Serializable {

    long idStock;
    String title;
    private Set<ProductDTO> products; // Ajoutez un DTO pour le produit si ce n'est pas encore fait
}
