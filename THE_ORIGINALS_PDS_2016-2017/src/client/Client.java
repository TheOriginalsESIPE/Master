package client;

import dto.VehicleDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import repository.ModelAuth;
import serialization.Deserialization;
import server.ControllerAuthentification;
import view.ViewAuthentification;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 *  Created by tearsyu on 15/03/17.
 *  This is client class, it will auto connect to the server when we launch the app.
 *  @author tearsyu
 */
public class Client{
    private Properties properties;
    private InputStream in;
    private Socket client;
    private static String localhost;
    private static int port;

    public Client() throws IOException {
            properties = new Properties();
            in = getClass().getClassLoader().getResourceAsStream("properties/configServer.properties");
            properties.load(in);
            localhost = properties.getProperty("serverIP");
            port = Integer.parseInt(properties.getProperty("port"));

    }

    public Socket getClient(){return client;}
    /**
     * Connect to Server in according to config file and close the file input stream.
     * @throws IOException
     * */
    public boolean connectToServer() throws IOException {
        client = new Socket(localhost, port);
        closeStream();
        return  client.isConnected();
    }


    /**
     * Close the input stream.
     */
    public void closeStream(){
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the socket.
     */
    public void closeSocket(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToServ(JSONObject jsonObject) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), StandardCharsets.UTF_8));
        out.write(jsonObject.toString());
        out.newLine();
        out.flush();
        out.close();
    }

    public VehicleDTO receiveFromServ() throws IOException, ParseException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String jsonString = in.readLine();
        Deserialization ds = new Deserialization();
        return ds.deserialAVehicle(ds.parseStringToJson(jsonString));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ModelAuth m = new ModelAuth();
                ViewAuthentification v = new ViewAuthentification();

                //Start the client and connect to the server.
                try {
                    Client client = new Client();
                    if(client.connectToServer()){
                        System.out.println("The client connect to the server.");
                        /*This controller doesn't pass the server, it connects directly to the server!!
                        * I need an other type of serialization to send object!
                        * */
                        ControllerAuthentification c = new ControllerAuthentification(m, v);
                        c.control();

                        while(client.getClient().isConnected()){

                        }
                    } else {
                        v.errorDialog(1);
                        System.out.println("Can't not to connect to server.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });
    }

}