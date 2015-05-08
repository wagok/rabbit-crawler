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

import java.util.Collection;
import java.util.Date;
import org.openqa.selenium.Cookie;

/**
 *
 * @author Mariusz
 */
public interface SessionRepository {

    Collection<Cookie> findByDomain(String domain);

    void save(String domain, Collection<Cookie> cookies, Date validTo);
}
