package com.example.gochat.Exception;

public enum ExceptionEnum implements BaseErrorInfoInterface {

    SUCCESS("200", "请求成功!"),
    BODY_NOT_MATCH("400", "数据类型不匹配, 请检查键名是否出现错误"),

    ILLEGAL_NULL("401", "出现非法NULL, 检查是否缺少参数"),
    PERMISSION_DENIED("403", "权限不足, 请检查是否遗漏外键"),
    NOT_FOUND("404", "没有找到该资源, 请检查参数"),
    PROJECT_MULTI_NAME("405", "项目重名"),
    EXPECTATION_FAILED("417", "上传文件过大"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误"),
    SEGMENT_FAULT("500", "发生越界"),
    UN_EXIST_BRANCH("500", "不存在的 if 分支"),
    THIS_IS_TEST("999", "这里还在测试"),
    MODEL_MULTI_NAME("406", "模型重名");

    private final String resultStatus;
    private final String resultMsg;

    ExceptionEnum(String resultStatus, String resultMsg) {
        this.resultStatus = resultStatus;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultStatus() {
        return resultStatus;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
