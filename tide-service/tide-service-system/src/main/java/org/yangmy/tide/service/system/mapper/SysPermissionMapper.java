package org.yangmy.tide.service.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yangmy.tide.service.system.entity.SysPermission;

import java.util.List;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<String> selectPermissionCodeByUserId(@Param("userId") long userId,@Param("type") int type);
}
