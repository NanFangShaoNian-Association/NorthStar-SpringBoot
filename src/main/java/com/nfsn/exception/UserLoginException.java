package com.nfsn.exception;

import com.nfsn.common.ResultCode;
import lombok.Data;

/**
 * @ClassName: UserLoginException
 * @Author: 团子tz
 * @CreateTime: 2022/11/14 22:26
 * @Description: 想想此类的作用，写在这里吧。
 */
@Data
public class UserLoginException extends RuntimeException{
    private ResultCode resultCode;


    public UserLoginException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
