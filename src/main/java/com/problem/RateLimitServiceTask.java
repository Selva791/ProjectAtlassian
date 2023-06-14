package com.problem;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RateLimitServiceTask implements RateLimiter{
    int numberORequests;
    long allowedTime;
    Map<Integer,UserInfo> customerRequestInfo;
   public RateLimitServiceTask( int numberORequests,long allowedTime){
       this.numberORequests = numberORequests;
       this.allowedTime = allowedTime;
       customerRequestInfo = new HashMap<>();
    }

    @Override
    public boolean rateLimit(int customerId) {

        if(customerRequestInfo.containsKey(customerId)){
            UserInfo userInfo = customerRequestInfo.get(customerId);
            long lastRequestTime = userInfo.getRequestTime();
            long currentTime = Instant.now().getEpochSecond();
            if(userInfo.getCountOfRequest()<numberORequests && allowedTime>(currentTime-lastRequestTime)){
                userInfo.setCountOfRequest(userInfo.getCountOfRequest()+1);
                customerRequestInfo.put(customerId,userInfo);
                return true;
            }else if(allowedTime<(currentTime-lastRequestTime)){
                userInfo.setAllowedTime(Instant.now().getEpochSecond());
                userInfo.setCountOfRequest(1);
                customerRequestInfo.put(customerId,userInfo);
                return true;
            }else{
                return false;
            }
        }else{
            customerRequestInfo.put(customerId,new UserInfo(1, Instant.now().getEpochSecond()));
            return true;
        }
    }
}
