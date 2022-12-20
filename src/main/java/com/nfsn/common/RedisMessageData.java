package com.nfsn.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: RedisMessageData
 * @Author: 团子tz
 * @CreateTime: 2022/12/20 16:45
 * @Description: 用于将Message转换为redis中data字段存储
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisMessageData{
    private String fromId;
    private String toId;
    private String type;//消息类型："apply-friend"申请好友，"friend-message"：好友消息，"delete-friend：""删除好友"
    private String content;
    private Date time;//发送时间
    private Integer isAck;//是否接收到消息："0未接收"，"1接收"
}
