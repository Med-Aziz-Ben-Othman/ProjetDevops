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

import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

@ExtendWith(MockitoExtension.class)
class OperatorServiceImplTest {

    @InjectMocks
    OperatorServiceImpl operatorService;

    @Mock
    OperatorRepository operatorRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllOperators() {
        // Arrange
        Operator operator1 = new Operator();
        Operator operator2 = new Operator();
        when(operatorRepository.findAll()).thenReturn(Arrays.asList(operator1, operator2));

        // Act
        List<Operator> result = operatorService.retrieveAllOperators();

        // Assert
        assertEquals(2, result.size());
        verify(operatorRepository, times(1)).findAll();
    }

    @Test
    void testAddOperator() {
        // Arrange
        Operator operator = new Operator();
        when(operatorRepository.save(any(Operator.class))).thenReturn(operator);

        // Act
        Operator result = operatorService.addOperator(operator);

        // Assert
        assertNotNull(result);
        verify(operatorRepository, times(1)).save(operator);
    }

    @Test
    void testUpdateOperator() {
        // Arrange
        Operator operator = new Operator();
        when(operatorRepository.save(any(Operator.class))).thenReturn(operator);

        // Act
        Operator result = operatorService.updateOperator(operator);

        // Assert
        assertNotNull(result);
        verify(operatorRepository, times(1)).save(operator);
    }

    @Test
    void testRetrieveOperator() {
        // Arrange
        Operator operator = new Operator();
        when(operatorRepository.findById(anyLong())).thenReturn(Optional.of(operator));

        // Act
        Operator result = operatorService.retrieveOperator(1L);

        // Assert
        assertNotNull(result);
        verify(operatorRepository, times(1)).findById(1L);
    }

    @Test
    void testRetrieveOperatorNotFound() {
        // Arrange
        when(operatorRepository.findById(anyLong())).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            operatorService.retrieveOperator(1L);
        });
    }

    @Test
    void testDeleteOperator() {
        // Act
        operatorService.deleteOperator(1L);

        // Assert
        verify(operatorRepository, times(1)).deleteById(1L);
    }
}
