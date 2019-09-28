package com.nickcontrol.vultrclient.exceptions;

public class VultrAPIException  extends Exception
{
    public VultrAPIException(ExceptionType type)
    {
        this.type = type;
    }

    public VultrAPIException(ExceptionType type, String endpoint)
    {
        this.type = type;
        this.endpoint = endpoint;
    }

    public VultrAPIException(ExceptionType type, String endpoint, String httpMethod)
    {
        this.type = type;
        this.endpoint = endpoint;
        this.httpMethod = httpMethod;
    }

    public enum ExceptionType {
        INVALID_API_LOCATION,
        INVALID_API_KEY,
        INVALID_HTTP_METHOD,
        REQUEST_FAILED,
        INTERNAL_SERVER_ERROR,
        RATE_LIMIT_EXCEEDED,

        UNKNOWN_ERROR
    }

    private ExceptionType type;
    private String endpoint;
    private String httpMethod;

    @Override
    public String getMessage() {
        return type.toString() + ": " + (endpoint != null ? endpoint : "") + " " + (httpMethod != null ? httpMethod : "");
    }
}
