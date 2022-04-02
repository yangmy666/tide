package mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Mapper
public interface SysUserMapper {

    int selectCount();
}
