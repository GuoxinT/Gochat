package com.example.gochat.Exception;

public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected String errorStatus;
    protected String errorMsg;

    public MyException() {
        super();
    }

    public MyException(ExceptionEnum e) {
        super(e.getResultMsg());
        errorStatus = e.getResultStatus();
        errorMsg = e.getResultMsg();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getResultStatus());
        this.errorStatus = errorInfoInterface.getResultStatus();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultStatus(), cause);
        this.errorStatus = errorInfoInterface.getResultStatus();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyException(String errorStatus, String errorMsg) {
        super(errorStatus);
        this.errorStatus = errorStatus;
        this.errorMsg = errorMsg;
    }

    public MyException(String errorStatus, String errorMsg, Throwable cause) {
        super(errorStatus, cause);
        this.errorStatus = errorStatus;
        this.errorMsg = errorMsg;
    }


    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}

