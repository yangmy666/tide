package org.yangmy.tide.common.result;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public enum Status {

    load(0),//加载数据
    success(1),//操作成功
    warning(2),//操作警告
    failure(3),//操作失败
    unAuthorized(-1),//未登录
    permissionDenied(-2);//权限不足

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
