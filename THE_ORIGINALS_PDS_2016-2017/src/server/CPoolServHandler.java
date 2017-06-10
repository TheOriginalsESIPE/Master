package server;
import enumeration.EnumManut;
import enumeration.EnumService;
import service.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by tearsyu on 15/03/17.
 * This class define the service of all the connection of server
 * In R2, this class is responsible to get the info of serialization from client,
 * deserialize it then pass it to DB.
 * Finally it returns a feedback to client.
 * @author tearsyu
 */
public class CPoolServHandler extends Thread {
    private Socket client;
    private Server server;

    /**
     * The constructor.
     * @param client
     * @param server
     */
    public CPoolServHandler(Socket client, Server server){
        this.client = client;
        this.server = server;
    }

    public void run() {
        server.msg.append("\nRUN...");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream out = new PrintStream(client.getOutputStream());
            Service serv = new Service();
            while (client.isConnected()) {
                //CASE: asking the authentication, here we don't implement the encryption service.
                String cmd = in.readLine();
                System.out.println(cmd);

                if (cmd.equals(EnumService.AUTH.name())) {
                    String login = in.readLine();
                    String pwd = in.readLine();
                    String res = serv.authService(login, pwd);

                    server.msg.append("\n auth = " + login + " " + pwd);
                    server.msg.append("\n response " + res);

                    out.println(res);
                    out.flush();

                } else if (cmd.equals(EnumService.PIECE.name())) {

                    String jsonString = in.readLine();
                    System.out.println(jsonString);
                    server.msg.append("\n" + jsonString);
                    String strRe = serv.pieceService(jsonString);
                    server.msg.append("\n Result search = " + strRe);
                    out.println(strRe);

                } else if (cmd.equals(EnumService.INDICATOR.name())){
                    String strMap = in.readLine();
                    server.msg.append("\n indicator request map :" + strMap);

                    String strRe = serv.indicatorService(strMap);
                    System.out.println(strRe);
                    out.println(strRe);
                    out.flush();
                }else if (cmd.equals(EnumService.BREAKDOWNLOAD.name())){
                	String jsonString = in.readLine();
                	
                	 System.out.println(jsonString);
                     server.msg.append("\n" + jsonString);
                	String strListName = serv.breakdownServices(jsonString);
                	System.out.println(strListName);
                	out.println(strListName);
                	out.flush();
                }else if(cmd.equals(EnumService.VEHICLEDOWNLOAD.name())){
                	String vehicle = in.readLine();
                	
                	String vehicleInfo = serv.vehicleNumMatService(vehicle);
                	System.out.println(vehicleInfo);
                	out.println(vehicleInfo);
                	out.flush();
                }else if(cmd.equals(EnumService.MOTIFDOWNLOAD.name())){
                	String motif = in.readLine();
                               	
                	String listVisitingMotif = serv.visitingMotifService(motif);
                	System.out.println(listVisitingMotif);
                	out.println(listVisitingMotif);
                	out.flush();
                }else if(cmd.equals(EnumService.SAVEVEHICLE.name())){
                	String infoV = in.readLine();
                               	
                	String res = serv.saveHehicle(infoV);
                	out.println(res);
                	out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
