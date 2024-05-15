package ru.rinklinky.document_viewer.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.rinklinky.document_viewer.baseresponse.BaseResponseService;
import ru.rinklinky.document_viewer.baseresponse.ResponseWrapper;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionApiHandler {
    private final BaseResponseService baseResponseService;

    @ExceptionHandler(Throwable.class)
    public ResponseWrapper<?> handleOtherException(Throwable t) {
        log.error("Got the exception: ", t);

        return baseResponseService.wrapErrorResponse(new CommonException(ErrorType.SERVER_ERROR, t));
    }

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<?> handleCommonException(CommonException exception) {
        return new ResponseEntity<>(baseResponseService.wrapErrorResponse(exception), exception.getType().getCode());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseWrapper<?> handleNotFoundResource(NoHandlerFoundException exception) {
        return baseResponseService.wrapErrorResponse(new CommonException(ErrorType.NOT_FOUND, exception));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class, BindException.class,
                        HttpMessageNotReadableException.class})
    public ResponseWrapper<?> handleValidationException(Exception exception) {
        log.error("Got validation exception {}: {}", exception.getClass(), exception.getMessage());

        return baseResponseService.wrapErrorResponse(new CommonException(ErrorType.CLIENT_ERROR, exception));
    }

}