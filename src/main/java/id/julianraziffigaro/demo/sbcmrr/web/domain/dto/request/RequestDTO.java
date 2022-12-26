package id.julianraziffigaro.demo.sbcmrr.web.domain.dto.request;

import id.julianraziffigaro.demo.sbcmrr.web.domain.dto.BaseDTO;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDTO<T extends BaseDomain> implements BaseDTO {

  @Serial
  private static final long serialVersionUID = 7431278848195445309L;

  private T data;
}
