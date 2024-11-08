package co.edu.unicauca.gestion_horarios.infraestructura.outputs;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class RestApiExceptionHandler {

    // Manejo de excepciones genéricas
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(HttpServletRequest req, Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Error interno del servidor");
        response.put("details", "Ocurrió un error inesperado. Por favor, contacte al soporte.");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Manejo de excepciones de validación de argumentos en métodos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Manejo de violaciones de restricciones de validación
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = ex.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                    violation -> violation.getPropertyPath().toString(),
                    ConstraintViolation::getMessage));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    // Manejo de excepciones de lógica de negocio
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Datos inválidos");
        response.put("details", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
