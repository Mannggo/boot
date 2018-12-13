package com.zhongd.bootapi.web.aspect.signature;

import com.zhongd.bootapi.exception.SignException;
import com.zhongd.bootapi.service.OrgService;
import entity.BaseRequest;
import entity.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import util.Md5SignUtils;

import static java.util.Optional.ofNullable;

/**
 * 签名验签切面
 * @author 谢仲东 2018-12-05 15:05
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class SignAspect {

    @Autowired
    private OrgService orgService;

    @Pointcut(value = "@annotation(com.zhongd.bootapi.web.aspect.signature.SignRequest)")
    public void sign(){}

    @Around("sign()")
    public BaseResponse sign(ProceedingJoinPoint point) throws Throwable {
        BaseRequest request = (BaseRequest) point.getArgs()[0];
        String secret = orgService.selectSecretByAppId(ofNullable(request.getAppId()).orElseThrow(()
                -> new SignException()));
        ofNullable(secret).orElseThrow(() -> new SignException());
        if (!validateSign(request, secret)) {
            throw new SignException();
        }
        BaseResponse response = (BaseResponse) point.proceed();
        signResponse(response, secret);
        return response;
    }

    /**
     * 给响应加上签名
     * @param response 相应对象
     * @param secret 密钥
     */
    private void signResponse(BaseResponse response, String secret) {
        response.setRandomStr(String.valueOf(System.currentTimeMillis()));
        String text = response.getRandomStr().concat(response.getRtCode()).concat(response.getRtMsg());
        response.setSign(Md5SignUtils.encrypt(text.concat(secret)));
    }

    /**
     * 校验签名
     * @param request 请求对象
     * @param secret 密钥
     * @return
     */
    private boolean validateSign(BaseRequest request, String secret) {
        String text = request.getAppId().concat(request.getRandomStr());
        return secret.equals(Md5SignUtils.encrypt(text.concat(secret)));
    }
}
