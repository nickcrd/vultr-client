package com.nickcontrol.vultrclient.internal;

import com.google.gson.Gson;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ConnectionManager
{
    // Handles all connection stuff

    private String baseUrl;
    private String apiKey;

    private HttpClient client = HttpClients.createDefault();
    private Gson GSON = new Gson();

    public ConnectionManager(String baseUrl, String apiKey)
    {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public <T> T get(Class<T> tClass, String endpoint) throws VultrAPIException
    {
        try {
            HttpGet get = new HttpGet(baseUrl + endpoint);
            get.setHeader("API-Key", apiKey);

            HttpResponse res = client.execute(get);

            switch (res.getStatusLine().getStatusCode())
            {
                case 200:
                    break; // Everything's fine
                case 400:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INVALID_API_LOCATION, endpoint);
                case 403:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INVALID_API_KEY);
                case 405:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INVALID_HTTP_METHOD, endpoint, "GET");
                case 412:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.REQUEST_FAILED, endpoint, "GET");
                case 500:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INTERNAL_SERVER_ERROR, endpoint, "GET");
                case 503:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.RATE_LIMIT_EXCEEDED, endpoint);
            }

            String data = EntityUtils.toString(res.getEntity());

            return GSON.fromJson(data, tClass);

        } catch (IOException e) {
            e.printStackTrace();
            throw new VultrAPIException(VultrAPIException.ExceptionType.UNKNOWN_ERROR, endpoint);
        }
    }


    // TODO: implement get & post
}
