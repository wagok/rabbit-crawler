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
package com.watchrabbit.crawler.batch.service;

import com.watchrabbit.crawler.api.AuthData;
import com.watchrabbit.crawler.auth.service.AuthService;
import com.watchrabbit.crawler.batch.ContextTestBase;
import com.watchrabbit.crawler.manager.model.Address;
import com.watchrabbit.crawler.manager.repository.AddressRepository;
import com.watchrabbit.crawler.manager.util.InternetAddress;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mariusz
 */
public class TaskSchedulerIT extends ContextTestBase {

    @Autowired
    TaskScheduler scheduler;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    AuthService authService;

    @Test
    public void shouldProcessTest() {
        authService.addNewAuthData(new AuthData.Builder()
                .withDomain("api.watchrabbit.com")
                .withLogin("mariusz.luciow@gmail.com")
                .withPassword("wkswks12")
                .withAuthEndpointUrl("https://api.watchrabbit.com/signin")
                .withSessionDuration(60)
                .build()
        );
        Address address = new Address.Builder()
                .withUrl("https://scalingapp.com")
                .withNextExecutionDate(new Date())
                .withDomainName(InternetAddress.getDomainName("https://scalingapp.com"))
                .build();
        addressRepository.save(address);

        scheduler.execute();
        System.err.println("uouo");
    }
}
