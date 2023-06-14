package com.problem;

import org.junit.Test;

public class RateLimiterServiceTest {

    @Test
    public void testSuccessFullCase(){

      RateLimitServiceTask rateLimitServiceTask = RateLimiterServiceFactory.initializeRateLimiter(5,5);
      int customerId=1;
      int maxRequest=10;
        for(int i=0;i<maxRequest;i++){
            System.out.println(rateLimitServiceTask.rateLimit(customerId));
        }
    }
    @Test
    public void testSuccessFulCaseWithLimit() throws InterruptedException {
        RateLimitServiceTask rateLimitServiceTask = RateLimiterServiceFactory.initializeRateLimiter(5,5);
        int customerId=1;
        int maxRequest=5;
        for(int i=0;i<maxRequest;i++){
            System.out.println(rateLimitServiceTask.rateLimit(customerId));

        }
        Thread.sleep(6000);
        for(int i=0;i<maxRequest;i++){
            System.out.println(rateLimitServiceTask.rateLimit(customerId));

        }
    }
}
