package com.pk.annotation.editlog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditLog {

    /**
     * 变更字段
     */
    private String field;

    /**
     * 变更字段中文名
     */

    private String name;

    /**
     * 变更前记录
     */
    private String oldValue;

    /**
     * 变更后新的记录
     */
    private String newValue;

    /**
     * 操作时间
     */
    private long operatedTime;
}
