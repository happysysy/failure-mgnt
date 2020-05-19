package com.lottevn.core.model.api;

import com.lottevn.core.enums.ApiResultCodeEnum;
import com.lottevn.core.model.Dto;
import com.lottevn.core.util.AgentUtil;
import com.lottevn.core.util.DateUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;

@Data
@NoArgsConstructor
public class ErrorLog implements Dto {
    private static final long serialVersionUID = 3503699198638838890L;

    /** request ip */
    private String ip;
    /** request channel 구분 */
    private String channel;
    /** request uri */
    private String uri;
    /** 에러발생 클래스명 */
    private String clazz;
    /** 에러발생 메소드명 */
    private String method;
    /** error code */
    private int code;
    /** error message */
    private String message;
    /** request parameter */
    private String request;
    /** 에러발생시간 */
    private String stime;

    public ErrorLog(HttpServletRequest req) {
        this.ip = AgentUtil.getIp(req);
        this.channel = AgentUtil.getChannel(req);
        this.uri = req.getRequestURI();
        this.request = "";
        this.message = "";
    }

    public static ErrorLog create(HttpServletRequest req, Throwable ex, HandlerMethod handler) {
        ErrorLog error = new ErrorLog(req);
        error.setCode(ApiResultCodeEnum.ERROR_SYSTEM.getCode());
        error.setStime(DateUtil.getDateTimeByPattern("yyyyMMddHHmmss"));
        if (handler != null) {
            error.setClazz(handler.getBean().getClass().getName());
            error.setMethod(handler.getMethod().getName());
        }
        return error;
    }

    public static ErrorLog create(HttpServletRequest req, Throwable ex, String clazz, String method) {
        ErrorLog error = new ErrorLog(req);

        error.setCode(ApiResultCodeEnum.ERROR_SYSTEM.getCode());
        error.setMessage(ex.getLocalizedMessage() == null ? "" : ex.getLocalizedMessage());
        error.setStime(DateUtil.getDateTimeByPattern("yyyyMMddHHmmss"));
        error.setClazz(clazz);
        error.setMethod(method);
        return error;
    }

    public static String stackTraceToString(Throwable ex) {
        String result = ex.toString() + "\n";
        StackTraceElement[] trace = ex.getStackTrace();
        for (int i = 0; i < trace.length; i++) {
            result += trace[i].toString() + "\n";
        }
        return result;
    }
}
