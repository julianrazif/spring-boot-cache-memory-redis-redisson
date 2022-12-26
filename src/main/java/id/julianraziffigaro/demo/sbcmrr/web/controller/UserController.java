package id.julianraziffigaro.demo.sbcmrr.web.controller;

import id.julianraziffigaro.demo.sbcmrr.cache.model.UserDetails;
import id.julianraziffigaro.demo.sbcmrr.web.domain.dto.BaseDTO;
import id.julianraziffigaro.demo.sbcmrr.web.domain.dto.response.ResponseDTO;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.Action;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.ErrorDomain;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.UserDomain;
import id.julianraziffigaro.demo.sbcmrr.web.exception.EditException;
import id.julianraziffigaro.demo.sbcmrr.web.exception.RegisterException;
import id.julianraziffigaro.demo.sbcmrr.web.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserServiceImpl userService;

  @PostMapping(value = "/register",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BaseDTO> register(@RequestBody BaseDTO requestDTO) {
    try {
      UserDetails user = userService.saveOrUpdate(Action.ADD, (UserDomain) requestDTO.getData());

      return BaseController.restResponse(
        HttpStatus.CREATED,
        new ResponseDTO<>(
          HttpStatus.CREATED.value(),
          new UserDomain(user.username(), null)
        )
      );
    } catch (RegisterException ex) {
      log.error(ex.getMessage(), ex);

      return BaseController.restResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        new ResponseDTO<>(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          new ErrorDomain(ex.hashCode(), ex.getMessage())
        )
      );
    }
  }

  @PostMapping(value = "/update",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BaseDTO> update(@RequestBody BaseDTO requestDTO) {
    try {
      UserDetails user = userService.saveOrUpdate(Action.EDIT, (UserDomain) requestDTO.getData());

      return BaseController.restResponse(
        HttpStatus.OK,
        new ResponseDTO<>(
          HttpStatus.OK.value(),
          new UserDomain(user.username(), null)
        )
      );
    } catch (EditException ex) {
      log.error(ex.getMessage(), ex);

      return BaseController.restResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        new ResponseDTO<>(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          new ErrorDomain(ex.hashCode(), ex.getMessage())
        )
      );
    }
  }
}
