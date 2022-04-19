package org.yangmy.tide.service.system.service;

import org.yangmy.tide.service.system.entity.dto.RegisterDto;

/**
 * @author YangMingYang
 * @since 2022/4/15
 */
public interface IRegisterService {

    int sendMailCode(String mail);

    int register(RegisterDto registerDto);
}
