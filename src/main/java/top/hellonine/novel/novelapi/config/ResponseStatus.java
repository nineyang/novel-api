package top.hellonine.novel.novelapi.config;

/**
 * User: Nine
 * Date: 2018/12/24
 * Time: 上午11:14
 */


public enum ResponseStatus {

    // 业务逻辑层的数据返回
    SUCCEED(200),
    FAILED(201),

    UNAUTHORIZED(400);

    private int code;

    private ResponseStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
