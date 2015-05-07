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
package com.watchrabbit.crawler.auth.repository;

import com.watchrabbit.crawler.auth.model.AuthData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Mariusz
 */
public class InMemoryAuthDataRepository implements AuthDataRepository {

    private final Map<String, AuthData> authData = new ConcurrentHashMap<>();

    @Override
    public AuthData findByDomain(String domain) {
        return authData.get(domain);
    }

    @Override
    public void addNewAuthData(AuthData authData) {
        this.authData.put(authData.getDomain(), authData);
    }

}