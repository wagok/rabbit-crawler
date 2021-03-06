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
package com.watchrabbit.crawler.api;

import java.util.List;

/**
 *
 * @author Mariusz
 */
public class CrawlResult {

    private List<LinkDto> links;

    private long miliseconds;

    private String domain;

    private String url;

    private String id;

    private double importanceFactor;

    public double getImportanceFactor() {
        return importanceFactor;
    }

    public void setImportanceFactor(double importanceFactor) {
        this.importanceFactor = importanceFactor;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public void setLinks(List<LinkDto> links) {
        this.links = links;
    }

    public long getMiliseconds() {
        return miliseconds;
    }

    public void setMiliseconds(long miliseconds) {
        this.miliseconds = miliseconds;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Builder {

        private final CrawlResult item;

        public Builder() {
            this.item = new CrawlResult();
        }

        public Builder withLinks(final List<LinkDto> links) {
            this.item.links = links;
            return this;
        }

        public Builder withMiliseconds(final long miliseconds) {
            this.item.miliseconds = miliseconds;
            return this;
        }

        public Builder withDomain(final String domain) {
            this.item.domain = domain;
            return this;
        }

        public Builder withUrl(final String url) {
            this.item.url = url;
            return this;
        }

        public Builder withId(final String id) {
            this.item.id = id;
            return this;
        }

        public Builder withImportanceFactor(final double importanceFactor) {
            this.item.importanceFactor = importanceFactor;
            return this;
        }

        public CrawlResult build() {
            return this.item;
        }
    }

}
