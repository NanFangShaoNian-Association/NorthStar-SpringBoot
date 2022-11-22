package com.nfsn.exception;

import com.nfsn.constants.ResultCode;
import lombok.Data;

/**
 * @ClassName: UserArticleException
 * @Author: 团子tz
 * @CreateTime: 2022/11/17 20:58
 * @Description: 宠物异常类
 */
@Data
public class UserPetException extends RuntimeException {
    private ResultCode resultCode;


    public UserPetException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
