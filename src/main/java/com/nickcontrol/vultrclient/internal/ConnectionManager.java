package com.nickcontrol.vultrclient.internal;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

public class ConnectionManager
{
    // Handles all connection stuff

    private String baseUrl;
    private String apiKey;

    private HttpClient client = HttpClients.createDefault();

    public ConnectionManager(String baseUrl, String apiKey)
    {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }



    // TODO: implement get & post
}
