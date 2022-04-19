package org.yangmy.tide.service.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.yangmy.tide.common.utils.StringUtils;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.entity.dto.RegisterDto;
import org.yangmy.tide.service.system.mapper.SysUserMapper;
import org.yangmy.tide.service.system.service.IRegisterService;
import org.yangmy.tide.service.system.utils.MailTemplate;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YangMingYang
 * @since 2022/4/15
 */
@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ThreadPoolExecutor executor;
    @Autowired
    private MailTemplate mailTemplate;

    private static final String REDIS_MAIL_CODE_DIR="register:mail:";

    @Override
    public int sendMailCode(String mail) {
        //生成4位验证码
        String code= StringUtils.generateRandomStr(4);
        String key=REDIS_MAIL_CODE_DIR+mail;
        stringRedisTemplate.opsForValue().set(key,code,60, TimeUnit.SECONDS);
        executor.execute(()-> mailTemplate.sendMessage(mail,"潮汐-邮箱注册验证码",code));
        return 60;
    }

    @Override
    public int register(RegisterDto registerDto) {
        String key=REDIS_MAIL_CODE_DIR+ registerDto.getMail();
        String code=stringRedisTemplate.opsForValue().get(key);
        if(!registerDto.getCode().equals(code)){
            return 0;
        }
        SysUser sysUser=new SysUser();
        sysUser.setUsername(registerDto.getUsername());
        sysUser.setPassword(registerDto.getPassword());
        sysUser.setMail(registerDto.getMail());
        if(sysUserMapper.insert(sysUser)==0){
            return 1;
        }
        stringRedisTemplate.delete(key);
        return 2;
    }
}
