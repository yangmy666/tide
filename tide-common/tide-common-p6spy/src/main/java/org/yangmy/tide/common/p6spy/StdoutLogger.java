package org.yangmy.tide.common.p6spy;

/**
 * @描述： 标准输出
 * @作者： Yang MingYang
 * @日期： 2022/3/18-11:33
 */
public class StdoutLogger extends com.p6spy.engine.spy.appender.StdoutLogger {

    @Override
    public void logText(String text) {
        // 打印红色 SQL 日志
        System.err.println(text);
    }
}
