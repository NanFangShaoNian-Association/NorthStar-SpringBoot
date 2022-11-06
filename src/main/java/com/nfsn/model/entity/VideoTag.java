package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName video_tag
 */
@TableName(value ="video_tag")
@Data
public class VideoTag implements Serializable {
    /**
     * 视频标签ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 标签ID
     */
    @TableField(value = "tag_id")
    private Integer tagId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}