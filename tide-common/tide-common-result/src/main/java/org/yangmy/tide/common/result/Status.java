package org.yangmy.tide.common.result;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public enum Status {

    ok(0),
    success(1),
    warning(2),
    failure(3),
    unAuthorized(-1),
    permissionDenied(-2);

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    Status(Integer value){
        this.value=value;
    }
}
