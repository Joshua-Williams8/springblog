package com.codeup.springblog.TestingAPIs;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class okhttpTest {

//    Hidden inputs after grabbing javascript info, and post it to the java controllers to forward into to database

  public static void main(String[] args) throws IOException {
    OkHttpClient client = new OkHttpClient();

    Request request = new Request.Builder()
      .url("https://superhero-search.p.rapidapi.com/api/?hero=Spiderman")
      .get()
      .addHeader("x-rapidapi-key", "588fd40e0fmshf1a648e8bdf4c3bp1e95fbjsn652f0aeae084")
      .addHeader("x-rapidapi-host", "superhero-search.p.rapidapi.com")
      .build();

try {
  Response response = client.newCall(request).execute();

  /*
   * if (!response.isSuccessful()) throw new IOException(“Unexpected code ” +
   * response);
   *
   * // Get response headers Headers responseHeaders = response.headers(); for
   * (int i = 0; i < responseHeaders.size(); i++) {
   * System.out.println(responseHeaders.name(i) + ": " +
   * responseHeaders.value(i)); }
   */
  System.out.println(response.body().string());
  System.out.println(response);
  System.out.println(response.code());

}catch (IOException e){
  e.printStackTrace();
}
  }

}
