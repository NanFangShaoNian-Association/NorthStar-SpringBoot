package com.nfsn.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: Message
 * @Author: 团子tz
 * @CreateTime: 2022/12/20 15:13
 * @Description: websocket聊天实体，此时仅考虑文本消息，不考虑表情视频图片等情况
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String fromId;
    private String toId;
    private String type;//消息类型："apply-friend"申请好友，"friend-message"：好友消息，"delete-friend：""删除好友"
    private Date time;//发送时间
}
