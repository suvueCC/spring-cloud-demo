package com.example.hystrixservice;

public interface UserService {
    Result testFallback(Long id);
}
