package org.yangmy.tide.common.utils.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.yangmy.tide.common.security.SecurityUtils;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * MybatisPlus自动填充
 * @author YangMingYang
 * @since 2022/4/13
 */
@Component
public class TideMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "createBy", Long.class, Objects.requireNonNull(SecurityUtils.getUserInfo()).getId());
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateBy", Long.class, Objects.requireNonNull(SecurityUtils.getUserInfo()).getId());
        this.strictInsertFill(metaObject, "delFlag", Integer.class, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "updateBy", Long.class, Objects.requireNonNull(SecurityUtils.getUserInfo()).getId());
    }
}
