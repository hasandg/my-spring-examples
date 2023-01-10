package com.hasandag.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    int sayac = 0;

    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunningMethod() throws InterruptedException {
        System.out.println("longRunningMethod method run!");
        Thread.sleep(5000L);
        return "method run";
    }

    @Cacheable(cacheNames = "mySpecialCache")
    public String shortRunningMethod() throws InterruptedException {
        System.out.println("shortRunningMethod method run!");

        return "short method run";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache(){
        System.out.println("cache cleared");
    }
}
