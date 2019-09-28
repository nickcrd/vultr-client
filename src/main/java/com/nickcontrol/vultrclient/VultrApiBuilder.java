package com.nickcontrol.vultrclient;

import com.nickcontrol.vultrclient.internal.ConnectionManager;
import com.nickcontrol.vultrclient.internal.ImplVultrAPI;

public class VultrApiBuilder
{
    private String baseUrl;
    private String apiKey;

    public VultrApiBuilder setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
        return this;
    }

    public VultrApiBuilder setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
        return this;
    }

    public VultrAPI build() throws Exception
    {
        ConnectionManager connectionManager = new ConnectionManager(baseUrl, apiKey);

        return new ImplVultrAPI(connectionManager);
    }
}
