package org.yangmy.tide.common.p6spy;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * @描述： 自定义sql打印格式
 * @作者： Yang MingYang
 * @日期： 2022/3/17-9:55
 */
public class P6SpyLogger implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return "SQL: "+sql+"\n"+"耗时: "+elapsed+"毫秒\n";
    }
}
