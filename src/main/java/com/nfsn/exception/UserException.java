package com.nfsn.exception;

import com.nfsn.constants.ResultCode;
import lombok.Data;

/**
 * @ClassName: UserException
 * @Author: 团子tz
 * @CreateTime: 2022/11/17 20:58
 * @Description: 用户异常类
 */
@Data
public class UserException extends RuntimeException {
    private ResultCode resultCode;


    public UserException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
