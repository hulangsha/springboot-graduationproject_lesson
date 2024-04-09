package com.sicau.springbootgraduationproject.facade.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Data
public class QueryMultimediaFile implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件id
     */
    private Integer fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否删除，0删除，1不删除
     */
    private String isDelete;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 每页显示几条
     */
    private Long pageSize;


}
