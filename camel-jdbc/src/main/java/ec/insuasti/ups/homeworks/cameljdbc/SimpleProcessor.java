package ec.insuasti.ups.homeworks.cameljdbc;

import java.util.ArrayList;
import java.util.ListIterator;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SimpleProcessor implements Processor {
    private Logger log = LoggerFactory.getLogger(SimpleProcessor.class);
    
    public void process(Exchange exchange) throws Exception {

        
        String line = (String)exchange.getIn().getBody();
        String[] streamLine = line.split(",");
         
        PaymentData paymentData = new PaymentData();
        if (!"ID".equals(streamLine[0])){
            

            paymentData.setId(Integer.parseInt(streamLine[0]));
            paymentData.setLimitBalance(Integer.parseInt(streamLine[1]));
            paymentData.setSex(Integer.parseInt(streamLine[2]));
            paymentData.setEducation(Integer.parseInt(streamLine[3]));
            paymentData.setMarriage(Integer.parseInt(streamLine[4]));
            paymentData.setAge(Integer.parseInt(streamLine[5]));
            paymentData.setPay0(Integer.parseInt(streamLine[6]));
            paymentData.setPay2(Integer.parseInt(streamLine[7]));
            paymentData.setPay3(Integer.parseInt(streamLine[8]));
            paymentData.setPay4(Integer.parseInt(streamLine[9]));
            paymentData.setPay5(Integer.parseInt(streamLine[10]));
            paymentData.setPay6(Integer.parseInt(streamLine[11]));
            paymentData.setBill1(Integer.parseInt(streamLine[12]));
            paymentData.setBill2(Integer.parseInt(streamLine[13]));
            paymentData.setBill3(Integer.parseInt(streamLine[14]));
            paymentData.setBill4(Integer.parseInt(streamLine[15]));
            paymentData.setBill5(Integer.parseInt(streamLine[16]));
            paymentData.setBill6(Integer.parseInt(streamLine[17]));
            paymentData.setPayv1(Integer.parseInt(streamLine[18]));
            paymentData.setPayv2(Integer.parseInt(streamLine[19]));
            paymentData.setPayv3(Integer.parseInt(streamLine[20]));
            paymentData.setPayv4(Integer.parseInt(streamLine[21]));
            paymentData.setPayv5(Integer.parseInt(streamLine[22]));
            paymentData.setPayv6(Integer.parseInt(streamLine[23]));
            paymentData.setDefaultPaymentNextMonth(Integer.parseInt(streamLine[24]));
        }
        if (paymentData.isValidEntry()){
            exchange.getIn().setHeader("ruta", "1");
        }
        else {
            exchange.getIn().setHeader("ruta", "2");
        }
        
       
        exchange.getIn().setBody(paymentData.toString());
    }
}