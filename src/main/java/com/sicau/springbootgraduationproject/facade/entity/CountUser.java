package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_count_user")
public class CountUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 统计Id
     */
    @TableId(value = "count_id", type = IdType.AUTO)
    private Integer countId;

    /**
     * 访问量
     */
    @TableField("page_view")
    private Integer pageView;

    /**
     * 下载量
     */
    @TableField("downloads")
    private Integer downloads;

    /**
     * 月份
     */
    @TableField("the_month")
    private Integer theMonth;


}
