package com.codeup.springblog.controllers;

import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestTest {
  public static void main(String[] args) throws UnirestException {
//    String host = "https://superhero-search.p.rapidapi.com/api/";
//    String charset = "UTF-8";
//    String x_rapidapi_host = "https://superhero-search.p.rapidapi.com/api/";
      HttpResponse<String> response = Unirest.get("https://superhero-search.p.rapidapi.com/api/?hero=Spiderman")
        .header("x-rapidapi-key", "588fd40e0fmshf1a648e8bdf4c3bp1e95fbjsn652f0aeae084")
        .header("x-rapidapi-host", "superhero-search.p.rapidapi.com")
        .asString();

    System.out.println(response.getStatus());
//    System.out.println(response.getHeaders().get("type"));

  }
}
