package ec.insuasti.ups.homeworks.cameljdbc;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultRegistry;
import org.apache.commons.dbcp.*;
import javax.sql.DataSource;


public class MainApp {


    public static void main(String... args) throws Exception {
        // use Camels Main class

        //String url = "jdbc:h2:./data";
        String url = "jdbc:sqlite:sqlitesample.db";
        DataSource dataSource = setupDataSource(url);

        DefaultRegistry reg = new DefaultRegistry();
        reg.bind("myDataSource", dataSource);

        CamelContext context = new DefaultCamelContext(reg);
        context.addRoutes(new MainApp().new MyRouteBuilder());
        context.start();
        Thread.sleep(5000);
        context.stop();


    }
    private static DataSource setupDataSource(String connectURI) {
        BasicDataSource ds = new BasicDataSource();
        //ds.setDriverClassName("org.h2.Driver");
        ds.setDriverClassName("org.sqlite.JDBC");
        ds.setUsername("camel");
        ds.setPassword("camel");
        ds.setUrl(connectURI);
        return ds;
    }

    class MyRouteBuilder extends RouteBuilder {
       

        public void configure() {

            //from("timer://runOnce?repeatCount=1&delay=1").startupOrder(1).process(new InitializerProcessor()).to("stream:out").to("jdbc:myDataSource").end();
            
            from("sftp:localhost:2222/document/?noop=true&username=user&password=passwd").startupOrder(2)
            .to("file:src/data/?noop=True&fileName=cardsclients.csv").end();

            from("stream:file?fileName=./src/data/cardsclients.csv&scanStream=true&scanStreamDelay=1000&retry=true&fileWatcher=true")
            .startupOrder(3)
 
            .process(new SimpleProcessor())
            .choice()
            .when(header("ruta").contains("1"))
                .to("file:src/data/?noop=True&fileName=ok.log&fileExist=Append&appendChars=\\n")
                .process(new DatabaseProcessor())
                .to("jdbc:myDataSource")
            .otherwise()
                .to("file:src/data/?noop=True&fileName=error.log&fileExist=Append&appendChars=\\n")
            .end();
         

        }
    }
}