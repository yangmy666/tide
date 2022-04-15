package org.yangmy.tide.service.system.service;

import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.entity.dto.RegisterDto;

/**
 * @author YangMingYang
 * @since 2022/4/15
 */
public interface IRegisterService {

    Result sendMailCode(String mail);

    Result register(RegisterDto registerDto);
}
