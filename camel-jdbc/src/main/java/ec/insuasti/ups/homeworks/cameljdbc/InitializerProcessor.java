package ec.insuasti.ups.homeworks.cameljdbc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializerProcessor implements Processor {
    private Logger log = LoggerFactory.getLogger(DatabaseProcessor.class);

    public void process(Exchange exchange) throws Exception {
        String sql = "CREATE TABLE PROCESSED_PAYMENTS (ID CHAR(35)  NOT NULL,DATA TEXT NOT NULL)";
        log.info(sql);
        exchange.getIn().setBody(sql);

    }
}
