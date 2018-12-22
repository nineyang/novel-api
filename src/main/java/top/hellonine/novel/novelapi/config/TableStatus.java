package top.hellonine.novel.novelapi.config;

/**
 * User: Nine
 * Date: 2018/12/22
 * Time: 下午10:29
 */


public enum TableStatus {

    AVAILABLE(0),

    DELETED(10);

    private final int value;

    private TableStatus(int value) {
        this.value = value;
    }
}
