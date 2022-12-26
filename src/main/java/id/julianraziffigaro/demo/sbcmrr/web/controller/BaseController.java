package id.julianraziffigaro.demo.sbcmrr.web.controller;

import id.julianraziffigaro.demo.sbcmrr.web.domain.dto.BaseDTO;
import id.julianraziffigaro.demo.sbcmrr.web.domain.dto.response.ResponseDTO;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.BaseDomain;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class BaseController {

  private BaseController() {
    throw new IllegalStateException(String.format("Can not access the class %s directly!", getClass().getName()));
  }

  public static ResponseEntity<BaseDTO> restResponse(
    HttpStatus httpStatus, ResponseDTO<? extends BaseDomain> responseDTO) {

    return ResponseEntity.status(httpStatus).body(responseDTO);
  }
}
