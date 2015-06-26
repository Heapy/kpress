package by.ibragimov.jpress.application;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Service
public class JettyServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JettyServer.class);

    @Value("${jpress.server.port:8080}")
    private Integer port;

    @Value("${jpress.server.start:false}")
    private Boolean start;

    @Value("${jpress.output:output}")
    private String path;

    public void run() {
        if (start) {
            Server server = new Server();

            NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
            connector.setPort(port);
            server.addConnector(connector);

            ResourceHandler resource_handler = new ResourceHandler();
            resource_handler.setDirectoriesListed(true);
            resource_handler.setWelcomeFiles(new String[]{"index.html"});

            resource_handler.setResourceBase(path);

            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[]{resource_handler, new DefaultHandler()});
            server.setHandler(handlers);

            try {
                LOGGER.info("Jetty server started on port '{}' and host files from folder '{}'", port, Paths.get(path).toAbsolutePath());
                server.start();
                server.join();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
