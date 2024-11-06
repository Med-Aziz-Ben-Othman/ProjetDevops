package tn.esprit.devops_project.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {

    @InjectMocks
    SupplierServiceImpl supplierService;

    @Mock
    SupplierRepository supplierRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllSuppliers() {
        // Arrange
        Supplier supplier1 = new Supplier();
        Supplier supplier2 = new Supplier();
        when(supplierRepository.findAll()).thenReturn(Arrays.asList(supplier1, supplier2));

        // Act
        List<Supplier> result = supplierService.retrieveAllSuppliers();

        // Assert
        assertEquals(2, result.size());
        verify(supplierRepository, times(1)).findAll();
    }

    @Test
    void testAddSupplier() {
        // Arrange
        Supplier supplier = new Supplier();
        when(supplierRepository.save(any(Supplier.class))).thenReturn(supplier);

        // Act
        Supplier result = supplierService.addSupplier(supplier);

        // Assert
        assertNotNull(result);
        verify(supplierRepository, times(1)).save(supplier);
    }

    @Test
    void testUpdateSupplier() {
        // Arrange
        Supplier supplier = new Supplier();
        when(supplierRepository.save(any(Supplier.class))).thenReturn(supplier);

        // Act
        Supplier result = supplierService.updateSupplier(supplier);

        // Assert
        assertNotNull(result);
        verify(supplierRepository, times(1)).save(supplier);
    }

    @Test
    void testRetrieveSupplier() {
        // Arrange
        Supplier supplier = new Supplier();
        when(supplierRepository.findById(anyLong())).thenReturn(Optional.of(supplier));

        // Act
        Supplier result = supplierService.retrieveSupplier(1L);

        // Assert
        assertNotNull(result);
        verify(supplierRepository, times(1)).findById(1L);
    }

    @Test
    void testRetrieveSupplierNotFound() {
        // Arrange
        when(supplierRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            supplierService.retrieveSupplier(1L);
        });
    }

    @Test
    void testDeleteSupplier() {
        // Act
        supplierService.deleteSupplier(1L);

        // Assert
        verify(supplierRepository, times(1)).deleteById(1L);
    }
}
