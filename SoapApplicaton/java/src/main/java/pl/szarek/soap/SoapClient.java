package pl.szarek.soap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pl.szarek.soap.wsdl.RegisterCallRequest;
import pl.szarek.soap.wsdl.RegisterCallResponse;
import pl.szarek.soap.wsdl.ResultsRequest;
import pl.szarek.soap.wsdl.ResultsResponse;


public class SoapClient extends WebServiceGatewaySupport {

    public ResultsResponse getResults(String value){
        ResultsRequest request = new ResultsRequest();
        request.setStudent(value);

        return (ResultsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/mockApiPortSoap11", request);
    }

    public RegisterCallResponse getRegisterCall(String student){
        RegisterCallRequest request = new RegisterCallRequest();
        request.setStudent(student);

        return (RegisterCallResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8088/mockApiPortSoap11", request);
    }
}
