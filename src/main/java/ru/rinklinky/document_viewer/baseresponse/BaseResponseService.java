package ru.rinklinky.document_viewer.baseresponse;

import org.springframework.stereotype.Service;
import ru.rinklinky.document_viewer.exception.CommonException;

@Service
public class BaseResponseService {

    public <T> ResponseWrapper<T> wrapSuccessResponse(T body) {
        return ResponseWrapper
                .<T>builder()
                .success(true)
                .body(body)
                .build();
    }

    public ResponseWrapper<?> wrapErrorResponse(CommonException exception) {
        ErrorDto error = ErrorDto.builder()
                .status(exception.getType().name())
                .title(exception.getType().getTitle())
                .text(((exception.isUserMessage()) ? exception.getMessage() : exception.getType().getText()))
                .build();

        return ResponseWrapper
                .builder()
                .success(false)
                .error(error)
                .build();
    }

}