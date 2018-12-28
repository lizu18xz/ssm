package com.fayayo.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * @author dalizu on 2018/12/28.
 * @version v1.0
 * @desc 拦截器，记录sql运行时间
 */
// 声明拦截Executor的query方法，从而拦截所有的查询SQL
@Intercepts({
        @Signature(
                type= Executor.class,
                method="query",
                args = {MappedStatement.class, Object.class, RowBounds.class,
                        ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(
                type= Executor.class,
                method="query",
                args = {MappedStatement.class, Object.class,
                        RowBounds.class,ResultHandler.class})
})
public class TimePlugin implements Interceptor{

    private final static Logger logger = LoggerFactory.getLogger(TimePlugin.class);

    // 如果超过500毫秒，则认为是耗时SQL
    private static final long DEFAULT_UP_TIME = 500L;

    // 配置上限时间的键值
    private static final  String UP_TIME_KEY = "up.time";

    // 上限时间
    private long upTime = 500L;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        long startTime = System.currentTimeMillis();
        // 执行原有MyBatis的功能
        Object result = invocation.proceed();
        long endTime = System.currentTimeMillis();

        // 计算耗时
        long timeConsuming = endTime - startTime;
        if (timeConsuming > upTime) {
            // 获取第一个参数（MappedStatement类型， 请参考@Signature声明的拦截参数）
            MappedStatement statement = (MappedStatement) invocation.getArgs()[0];
            // 获取第二个参数（Object类型，SQL参数，请参考@Signature声明的拦截参数）
            Object paramObject = invocation.getArgs()[1];
            // 获取执行的SQL
            String sql = statement.getBoundSql(paramObject).getSql();
            // 记录日志提示优化
            logger.info("注意SQL【" + sql + "】耗时【"+ timeConsuming + "】毫秒,限制:【"+ upTime + "】");
        }
        return result;
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        // 从MyBatis的配置中读入上限时间，如果为空则使用默认上限时间
        String upTimeStr = properties.getProperty(UP_TIME_KEY, DEFAULT_UP_TIME + "");
        // 设置时长，超过它将打印提示信息
        this.upTime = Long.valueOf(upTimeStr);
    }
}
