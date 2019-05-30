package com.github.springbootshedlock1.config;

import com.mongodb.MongoClient;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.mongo.MongoLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * 创建时间为 17:36 2019-05-29
 * 项目名称 spring-boot-shedlock
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */
@Configuration
public class ConfigShedlock {

    @Bean
    public LockProvider lockProvider(MongoClient mongo) {
        return new MongoLockProvider(mongo, "databaseName");
    }

}
