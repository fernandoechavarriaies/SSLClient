package com.smolcomm.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
/*import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;*/

import org.apache.jmeter.util.JsseSSLManager;
import org.apache.jmeter.util.SSLManager;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@PostConstruct
	public void tryToMakeSSLConection() {
	  int your_app_port = 1099;
	  String your_app_host = "localhost";
	  JsseSSLManager sslManager = (JsseSSLManager) SSLManager.getInstance();
	  try {
	  SSLSocketFactory sslsocketfactory = sslManager.getContext().getSocketFactory();
    SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket(your_app_host, your_app_port);	  
    /*
     * send http request
     *
     * Before any application data is sent or received, the
     * SSL socket will do SSL handshaking first to set up
     * the security attributes.
     *
     * SSL handshaking can be initiated by either flushing data
     * down the pipe, or by starting the handshaking by hand.
     *
     * Handshaking is started manually in this example because
     * PrintWriter catches all IOExceptions (including
     * SSLExceptions), sets an internal error flag, and then
     * returns without rethrowing the exception.
     *
     * Unfortunately, this means any error messages are lost,
     * which caused lots of confusion for others using this
     * code.  The only way to tell there was an error is to call
     * PrintWriter.checkError().
     */
    sslsocket.startHandshake();

    PrintWriter out = new PrintWriter(
                          new BufferedWriter(
                          new OutputStreamWriter(
                          sslsocket.getOutputStream())));

    //out.println("GET / HTTP/1.0");
    out.println("20191212105500&000000000001&0004&INIT&0ABEFB86C1E41D3AAB076FFE7E454BF6&HTTP/1.0");
    out.println();
    out.flush();

    /*
     * Make sure there were no surprises
     */
    /*if (out.checkError())
        System.out.println(
            "SSLSocketClient:  java.io.PrintWriter error");*/

    /* read response */
    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                            sslsocket.getInputStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);

    in.close();
    out.close();
    sslsocket.close();
	  }catch (Exception e) {
      // TODO: handle exception
    }
	}
	
	public void sendMsgToSmolComm() {
    try {
      /*SSLSocketFactory factory =
          (SSLSocketFactory)SSLSocketFactory.getDefault();
      SSLSocket socket =
          (SSLSocket)factory.createSocket("localhost", 1099);*/

      /*
       * send http request
       *
       * Before any application data is sent or received, the
       * SSL socket will do SSL handshaking first to set up
       * the security attributes.
       *
       * SSL handshaking can be initiated by either flushing data
       * down the pipe, or by starting the handshaking by hand.
       *
       * Handshaking is started manually in this example because
       * PrintWriter catches all IOExceptions (including
       * SSLExceptions), sets an internal error flag, and then
       * returns without rethrowing the exception.
       *
       * Unfortunately, this means any error messages are lost,
       * which caused lots of confusion for others using this
       * code.  The only way to tell there was an error is to call
       * PrintWriter.checkError().
       */
      /*socket.startHandshake();

      PrintWriter out = new PrintWriter(
                            new BufferedWriter(
                            new OutputStreamWriter(
                            socket.getOutputStream())));

      //out.println("GET / HTTP/1.0");
      out.println("20191030110309&000000000002&3CC6&INIT&ACAF7979E4AF8D3DE4A6F75AC677D5D8&HTTP/1.0");
      out.println();
      out.flush();*/

      /*
       * Make sure there were no surprises
       */
      /*if (out.checkError())
          System.out.println(
              "SSLSocketClient:  java.io.PrintWriter error");*/

      /* read response */
      /*BufferedReader in = new BufferedReader(
                              new InputStreamReader(
                              socket.getInputStream()));

      String inputLine;
      while ((inputLine = in.readLine()) != null)
          System.out.println(inputLine);

      in.close();
      out.close();
      socket.close();*/

    } catch (Exception e) {
        e.printStackTrace();
    }	  
	}

}
