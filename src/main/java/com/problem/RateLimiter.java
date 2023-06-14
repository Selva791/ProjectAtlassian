package com.problem;

public interface RateLimiter {
    boolean rateLimit(int customerId);
}
