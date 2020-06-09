package com.example.feignservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 结果封装
 *
 * @author suvue
 * @date 2020/6/8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private T data;

    private String message;

    private int code;


    public Result(String message, Integer code) {
        this(null, message, code);
    }

    public Result(T data) {
        this(data, "操作成功", 200);
    }
}
