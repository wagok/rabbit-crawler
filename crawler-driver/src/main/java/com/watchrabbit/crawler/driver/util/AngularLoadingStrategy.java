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
package com.watchrabbit.crawler.driver.util;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariusz
 */
@Service
public class AngularLoadingStrategy implements LoadingStrategy {

    private static final String ANGULAR_GUARD = "return (window.angular != null) && "
            + "(window.angular.element(document.body).injector() != null) && "
            + "(window.angular.element(document.body).injector().get('$http').pendingRequests.length === 0)";

    @Override
    public boolean shouldWait(RemoteWebDriver driver) {
        return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular != null)").toString());
    }

    @Override
    public int getWaitTime() {
        return 5;
    }

    @Override
    public Predicate<WebDriver> hasFinishedProcessing() {
        return driver
                -> Boolean.valueOf(((JavascriptExecutor) driver).executeScript(ANGULAR_GUARD).toString());
    }

}
