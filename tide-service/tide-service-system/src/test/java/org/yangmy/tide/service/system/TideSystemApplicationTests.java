package org.yangmy.tide.service.system;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.yangmy.tide.service.system.entity.vo.QuestionVo;
import org.yangmy.tide.service.system.service.ISysUserService;
import org.yangmy.tide.service.system.service.impl.RecommendServiceImpl;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class TideSystemApplicationTests {

    @Autowired
    ISysUserService sysUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    RecommendServiceImpl questionService;

    @Test
    void contextLoads(){
        List<QuestionVo> list= questionService.recommend();
        for (QuestionVo questionVo : list) {
            System.out.println(questionVo.toString());
        }
    }

    @Test
    void gen() throws Exception {
        FastAutoGenerator.create("jdbc:mysql://47.94.147.204:3306/tide-system?serverTimezone=GMT%2B8", "root", "mysqlyyds")
                .globalConfig(builder -> {
                    builder.author("YangMingYang") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D://m"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("org.yangmy.tide.service") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://m/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("question"); // 设置需要生成的表名
                    //.addTablePrefix("demo_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
