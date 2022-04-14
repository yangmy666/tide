package org.yangmy.tide.service.log.document;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
@Data
@Document(indexName = "log")
public class SystemLog {

    private String time;
    private String message;
}
