/*
 * Copyright 2015 Mariusz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.watchrabbit.crawler.auth;

import com.watchrabbit.crawler.auth.repository.AuthDataRepository;
import com.watchrabbit.crawler.auth.repository.InMemoryAuthDataRepository;
import com.watchrabbit.crawler.auth.repository.InMemorySessionRepository;
import com.watchrabbit.crawler.auth.repository.SessionRepository;
import com.watchrabbit.crawler.driver.EnableWebDrivers;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Mariusz
 */
@Configuration
@ComponentScan
@EnableWebDrivers
public class AuthServiceConfig {

    @Bean
    @ConditionalOnMissingBean
    AuthDataRepository getAuthDataRepository() {
        return new InMemoryAuthDataRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    SessionRepository getSessionRepository() {
        return new InMemorySessionRepository();
    }

}
