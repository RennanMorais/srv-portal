package br.com.portal.srv_portal.v1.exception.handler;

import br.com.portal.srv_portal.v1.domain.exception.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErroDTO>> handlerIllegalArgumentException(MethodArgumentNotValidException  ex) {
        List<ErroDTO> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> new ErroDTO(
                        HttpStatus.BAD_REQUEST.value(),
                        fieldError.getField().concat(": ").concat(fieldError.getDefaultMessage())
                ))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

}
