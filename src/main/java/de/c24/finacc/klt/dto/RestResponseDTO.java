package de.c24.finacc.klt.dto;

/**
 *
 * @author sarkhanrasullu
 */
public class RestResponseDTO {

    private String msg;
    private Integer errorCode;
    private Object data;

    /**
     * no-param constructor
    */
    public RestResponseDTO() {
    }

    /**
     * constructor with-data
     * */
    public RestResponseDTO(Object data) {
        this.data = data;
    }

    /**
     * constructor with-msg
     * */
    public RestResponseDTO(String msg) {
        this.msg = msg;
    }

    /**
     *  all-params constructor
    */
    public RestResponseDTO(String msg, Integer errorCode, Object data) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }

    /**
     * @return msg
    */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
    */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return errorCode
    */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
    */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return data
    */
    public Object getData() {
        return data;
    }

    /**
     * @param data
    */
    public void setData(Object data) {
        this.data = data;
    }
}
