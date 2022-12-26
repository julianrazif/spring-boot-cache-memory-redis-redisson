package id.julianraziffigaro.demo.sbcmrr.web.domain.dto.response;

import id.julianraziffigaro.demo.sbcmrr.web.domain.dto.BaseDTO;
import id.julianraziffigaro.demo.sbcmrr.web.domain.model.BaseDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO<T extends BaseDomain> implements BaseDTO {

  @Serial
  private static final long serialVersionUID = -8689018890878571648L;

  private Integer code;
  private T data;
}
