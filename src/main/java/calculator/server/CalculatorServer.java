package calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class CalculatorServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(new CalculatorServerImpl())
                .build();
        server.start();
        System.out.println("Server started on port " + port);


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            System.out.println("Received server shutdown request");
            server.shutdown();
            System.out.println("Server stopped");
        }));

        server.awaitTermination();


    }
}
