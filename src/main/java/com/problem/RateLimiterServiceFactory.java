package com.problem;

public class RateLimiterServiceFactory {

    public static RateLimitServiceTask initializeRateLimiter(int numberOfRequests,long allowedTime){
        return new RateLimitServiceTask(numberOfRequests,allowedTime);
    }
}
