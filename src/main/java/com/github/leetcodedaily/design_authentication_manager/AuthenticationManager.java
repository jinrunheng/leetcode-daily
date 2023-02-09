package com.github.leetcodedaily.design_authentication_manager;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author Dooby Kim
 * @Date 2023/2/9 11:13 上午
 * @Version 1.0
 */
public class AuthenticationManager {

    class Token implements Comparable<Token> {
        private String tokenId;
        private int expiredTime;

        public Token(String tokenId, int expiredTime) {
            this.tokenId = tokenId;
            this.expiredTime = expiredTime;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

        public int getExpiredTime() {
            return expiredTime;
        }

        public void setExpiredTime(int expiredTime) {
            this.expiredTime = expiredTime;
        }

        @Override
        public int compareTo(Token token) {
            return this.expiredTime - token.expiredTime;
        }
    }

    private PriorityQueue<Token> minHeap;
    private Map<String, Token> tokenMap;
    private int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.minHeap = new PriorityQueue<>();
        this.tokenMap = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        if (tokenMap.containsKey(tokenId)) {
            throw new RuntimeException("tokenId 已存在");
        }
        Token token = new Token(tokenId, currentTime + timeToLive);
        tokenMap.put(tokenId, token);
        minHeap.add(token);
    }

    private void filterExpiredToken(int currentTime) {
        while (minHeap.size() > 0 && minHeap.peek().getExpiredTime() <= currentTime) {
            Token poll = minHeap.poll();
            assert poll != null;
            if (poll.getExpiredTime() == tokenMap.get(poll.getTokenId()).getExpiredTime()) {
                tokenMap.remove(poll.getTokenId());
            }
        }
    }

    public void renew(String tokenId, int currentTime) {
        filterExpiredToken(currentTime);
        if (tokenMap.containsKey(tokenId)) {
            Token token = new Token(tokenId, currentTime + timeToLive);
            minHeap.add(token);
            tokenMap.put(tokenId, token);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        filterExpiredToken(currentTime);
        return tokenMap.size();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
