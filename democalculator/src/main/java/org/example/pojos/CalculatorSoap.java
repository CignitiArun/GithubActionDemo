package org.example.pojos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.4.1
 * 2021-10-28T18:00:07.417+01:00
 * Generated source version: 3.4.1
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "CalculatorSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface CalculatorSoap {

    @WebMethod(operationName = "Subtract", action = "http://tempuri.org/Subtract")
    @RequestWrapper(localName = "Subtract", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.Subtract")
    @ResponseWrapper(localName = "SubtractResponse", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.SubtractResponse")
    @WebResult(name = "SubtractResult", targetNamespace = "http://tempuri.org/")
    public int subtract(

        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB
    );

    @WebMethod(operationName = "Divide", action = "http://tempuri.org/Divide")
    @RequestWrapper(localName = "Divide", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.Divide")
    @ResponseWrapper(localName = "DivideResponse", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.DivideResponse")
    @WebResult(name = "DivideResult", targetNamespace = "http://tempuri.org/")
    public int divide(

        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB
    );

    /**
     * Adds two integers. This is a test WebService. ©DNE Online
     */
    @WebMethod(operationName = "Add", action = "http://tempuri.org/Add")
    @RequestWrapper(localName = "Add", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.Add")
    @ResponseWrapper(localName = "AddResponse", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.AddResponse")
    @WebResult(name = "AddResult", targetNamespace = "http://tempuri.org/")
    public int add(

        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB
    );

    @WebMethod(operationName = "Multiply", action = "http://tempuri.org/Multiply")
    @RequestWrapper(localName = "Multiply", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.Multiply")
    @ResponseWrapper(localName = "MultiplyResponse", targetNamespace = "http://tempuri.org/", className = "org.example.pojos.MultiplyResponse")
    @WebResult(name = "MultiplyResult", targetNamespace = "http://tempuri.org/")
    public int multiply(

        @WebParam(name = "intA", targetNamespace = "http://tempuri.org/")
        int intA,
        @WebParam(name = "intB", targetNamespace = "http://tempuri.org/")
        int intB
    );
}
