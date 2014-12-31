package com.redhat.gss.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import org.jboss.logging.Logger;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This servlet will simply dump the contents of the HTTP POST body to
 * 'dump.txt' in the JVM working dir.
 */
public class ServletDumper extends HttpServlet {
  private static Logger log = Logger.getLogger(ServletDumper.class);

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.warn("Dumping HTTP POST body to dump.txt...");
    BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
    FileWriter writer = new FileWriter("dump.txt");
    String line = null;
    while((line = reader.readLine()) != null) {
      writer.write(line);
    }
    writer.close();
    response.setStatus(200);
  }
}
