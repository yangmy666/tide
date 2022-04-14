package org.yangmy.tide.service.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.yangmy.tide.service.log.document.SystemLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@SpringBootTest
class TideLogApplicationTests {

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void contextLoads() {
        SystemLog systemLog=new SystemLog();
        systemLog.setTime(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        systemLog.setMessage("报错");
        elasticsearchRestTemplate.save(systemLog);
/*        IndexQuery indexQuery=new IndexQueryBuilder()
                .withObject(systemLog)
                .build();
        String documentId=elasticsearchRestTemplate.index(indexQuery,IndexCoordinates.of("log"));
        System.out.println(documentId);*/
    }

}
