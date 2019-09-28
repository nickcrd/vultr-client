package com.nickcontrol.vultrclient.internal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nickcontrol.vultrclient.entities.server.ServerOS;
import com.nickcontrol.vultrclient.exceptions.VultrAPIException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public <T> T get(TypeToken<T> typeToken, String endpoint) throws VultrAPIException
    {
        return GSON.fromJson(get(endpoint), typeToken.getType());
    }

    public <T> T get(Class<T> tClass, String endpoint) throws VultrAPIException
    {
        return GSON.fromJson(get(endpoint), tClass);
    }

    public String get(String endpoint) throws VultrAPIException
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
            return data;

        } catch (IOException e) {
            e.printStackTrace();
            throw new VultrAPIException(VultrAPIException.ExceptionType.UNKNOWN_ERROR, endpoint);
        }
    }


    public String post(String endpoint, HashMap<String, Object> data) throws VultrAPIException
    {
        try {
            HttpPost post = new HttpPost(baseUrl + endpoint);
            post.setHeader("API-Key", apiKey);

            HttpResponse res = client.execute(post);

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            for (Map.Entry<String, Object> entry : data.entrySet())
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));

            post.setEntity(new UrlEncodedFormEntity(params));

            switch (res.getStatusLine().getStatusCode())
            {
                case 200:
                    break; // Everything's fine
                case 400:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INVALID_API_LOCATION, endpoint);
                case 403:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INVALID_API_KEY);
                case 405:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INVALID_HTTP_METHOD, endpoint, "POST");
                case 412:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.REQUEST_FAILED, endpoint, "POST");
                case 500:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.INTERNAL_SERVER_ERROR, endpoint, "POST");
                case 503:
                    throw new VultrAPIException(VultrAPIException.ExceptionType.RATE_LIMIT_EXCEEDED, endpoint);
            }

            String d = EntityUtils.toString(res.getEntity());
            return d;

        } catch (IOException e) {
            e.printStackTrace();
            throw new VultrAPIException(VultrAPIException.ExceptionType.UNKNOWN_ERROR, endpoint);
        }
    }


    // TODO: implement get & post
}
