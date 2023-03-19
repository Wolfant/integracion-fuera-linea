package ec.insuasti.ups.homeworks.cameljdbc;

import java.util.UUID;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseProcessor implements Processor {
    private Logger log = LoggerFactory.getLogger(DatabaseProcessor.class);

    public void process(Exchange exchange) throws Exception {

        String line = (String)exchange.getIn().getBody();
        String[] streamLine = line.split(",");
        String uuid = UUID.randomUUID().toString();
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("INSERT INTO PROCESSED_PAYMENTS (ID, DATA) VALUES (");
        queryBuilder.append("'" + uuid + "', '" + line + "');");

       
        String query = queryBuilder.toString();
        log.info(query);
        exchange.getIn().setBody(query);

    }
}
