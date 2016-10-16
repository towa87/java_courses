package ru.stqa.pft.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Антон on 12.10.2016.
 */
public class HttpSession {
  private CloseableHttpClient httpclient;
  private ApplicationManager app;
  public HttpSession(ApplicationManager app)
  {
    this.app = app;
    httpclient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
  }
  public boolean login(String username, String password) throws IOException {
    HttpPost post = new HttpPost(app.getProperty("web.baseURl") + "/login.php");
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("username", username));
    params.add(new BasicNameValuePair("password", password));
    params.add(new BasicNameValuePair("secure_session", "on"));
    params.add(new BasicNameValuePair("return", "index.php"));
    post.setEntity(new UrlEncodedFormEntity(params));
    CloseableHttpResponse responce = httpclient.execute(post);
    String body = getTextFrom(responce);
   System.out.println(body);
    return body.contains(String.format("<span id=\"logged-in-user\">%s</span>", username));
  }
  private String getTextFrom(CloseableHttpResponse response) throws IOException {
    try{
      return EntityUtils.toString(response.getEntity());
    } finally {response.close();
    }
  }
  public boolean isLoggedInAs(String username) throws IOException {
    HttpGet get = new HttpGet(app.getProperty("web.baseURl") + "/index.php");
    CloseableHttpResponse response = httpclient.execute(get);
    String body = getTextFrom(response);
    return body.contains(String.format("<span id=\"logged-in-user\">%s</span>", username));
  }
}
