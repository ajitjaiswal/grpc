package calculator.server;

import com.proto.calculator.CalculatorServiceGrpc;
import com.proto.calculator.SumRequest;
import com.proto.calculator.SumResponse;
import io.grpc.stub.StreamObserver;

public class CalculatorServerImpl  extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void sum(SumRequest request , StreamObserver<SumResponse> responseStreamObserver) {

        responseStreamObserver.onNext(SumResponse.newBuilder().setResult(
                request.getFirstNumber() + request.getSecondNumber()

        ).build());
        responseStreamObserver.onCompleted();
    }

}
