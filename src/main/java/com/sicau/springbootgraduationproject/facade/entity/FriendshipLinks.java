package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 友情链接表
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_friendship_links")
public class FriendshipLinks implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 链接ID
     */
    @TableId(value = "link_id", type = IdType.AUTO)
    private Integer linkId;

    /**
     * 网站名称
     */
    @TableField("website_name")
    private String websiteName;

    /**
     * 链接地址
     */
    @TableField("url")
    private String url;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 排序字段
     */
    @TableField("sort_order")
    private Integer sortOrder;

    /**
     * 添加时间
     */
    @TableField("added_at")
    private LocalDateTime addedAt;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 类型
     */
    @TableField("type")
    private String type;


}
