package stringmethods.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrlManager {

  private String protocol;
  private String host;
  private Integer port;
  private String path;
  private String query;

  public UrlManager(String url) {
    String[] splittedUrlByQuery = splitByQuery(url);
    String rawUrl = splittedUrlByQuery[0];
    this.protocol = findProtocol(rawUrl).toLowerCase();
    String urlFromHost = rawUrl.substring(rawUrl.indexOf("//") + 2);
    String hostToPort = fromHostToPort(urlFromHost);
    String[] hAP = findHostAndPort(hostToPort);
    this.host = hAP[0].toLowerCase();
    if (hAP[1] == null) {
      this.port = null;
    } else {
      this.port = Integer.parseInt(hAP[1]);
    }
    this.path = findPath(urlFromHost);
    this.query = splittedUrlByQuery[1];
  }

  public String fromHostToPort(String url) {
    if (url.contains("/")) {
      return url.substring(0, url.indexOf("/"));
    }
    if (url.length() == 0) {
      throw new IllegalArgumentException("Invalid url");
    } else {
      return url;
    }
  }

  public String[] splitByQuery(String url) {
    int indexOfStartingQuery = url.indexOf("?");
    String[] urlSplitByQuery = new String[2];
    if (indexOfStartingQuery > 0) {
      urlSplitByQuery[0] = url.substring(0, indexOfStartingQuery);
      urlSplitByQuery[1] = url.substring(indexOfStartingQuery + 1);
    } else {
      urlSplitByQuery[0] = url;
      urlSplitByQuery[1] = null;
    }
    return urlSplitByQuery;
  }

  public String findProtocol(String url) {
    if (url.contains(":")) {
      return url.substring(0, url.indexOf(":"));
    }
    if (url.indexOf("://") < 0 || url.length() == 0) {
      throw new IllegalArgumentException("Invalid url");
    } else {
      return url.substring(0, url.indexOf(":"));
    }
  }

  public String findPath(String url) {
    if (url.contains("/")) {
      return url.substring(url.indexOf("/"));
    }
    return "";
  }

  public String[] findHostAndPort(String url) {
    String[] hostAndPort = new String[2];
    if (url.contains(":")) {
      hostAndPort = url.split(":"); //new String[2];
    } else {
      hostAndPort[0] = url;
      hostAndPort[1] = null;
    }
    return hostAndPort;
  }

  public String getProtocol() {
    return protocol;
  }

  public Integer getPort() {
    return port;
  }

  public String getHost() {
    return host;
  }

  public String getPath() {
    return path;
  }

  public String getQuery() {
    return query;
  }

  public boolean hasProperty(String key) {
    String queryWithQ = "?".concat(query);
    if (key == null || key.trim().isBlank()) {
      throw new IllegalArgumentException();
    } else if (queryWithQ.contains("?".concat(key.concat("=")))
            || queryWithQ.contains("&".concat(key.concat("=")))) {
      return true;
    }
  return false;
  }

  public String getProperty(String key) {
    String queryWithQ = "?".concat(query);
    if (queryWithQ.contains("?".concat(key.concat("=")))
            || queryWithQ.contains("&".concat(key.concat("=")))) {
      String prop = query.substring((query.indexOf(key) + key.length()+1));
      if (prop.contains("&")) {
        return prop.substring(0, prop.indexOf("&"));
      } else {
        return prop.substring(0);
      }
    }
  return null;
  }

  public boolean isEmpty(String str) {
    return (str != null || str.isBlank());
  }
}
