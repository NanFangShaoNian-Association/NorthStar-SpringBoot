package com.nfsn.exception;

import com.nfsn.constants.ResultCode;
import lombok.Data;

/**
 * @ClassName: UserArticleException
 * @Author: 团子tz
 * @CreateTime: 2022/11/17 20:58
 * @Description: 用户自己的文章异常类
 */
@Data
public class UserArticleException extends RuntimeException {
    private ResultCode resultCode;


    public UserArticleException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
