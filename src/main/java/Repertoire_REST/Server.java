package Repertoire_REST;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";


    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {

        final ResourceConfig rc = new ResourceConfig().packages("Repertoire_REST");

        //return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI),rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */


    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
        //System.err.println("Link URL" + BASE_URI);

    }

}
