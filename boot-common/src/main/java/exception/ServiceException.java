package exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 谢仲东
 * @description 业务异常
 * @since 15:53 星期日 2019/2/3
 */
@AllArgsConstructor
@Data
public class ServiceException extends RuntimeException{
    String code;
    String message;
}
