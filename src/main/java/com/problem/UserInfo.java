package com.problem;

public class UserInfo {
    private int countOfRequest;
    private long requestTime;
   public UserInfo(int countOfRequest,long allowedTime){
        this.countOfRequest = countOfRequest;
        this.requestTime = allowedTime;
    }

    public int getCountOfRequest() {
        return countOfRequest;
    }

    public void setCountOfRequest(int countOfRequest) {
        this.countOfRequest = countOfRequest;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public void setAllowedTime(long allowedTime) {
        this.requestTime = allowedTime;
    }
}
