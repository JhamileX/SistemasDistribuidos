package socketstcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args){
        int port = 5001; // puerto de comunicacion
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            //System.out.print("Introduzca una cadena : ");
            //String cadena = br.readLine();
            
            int vector[]  = new int[5];
            Scanner entrada = new Scanner(System.in);
            String cad="";
            System.out.println("Introduzca 5 numeros");
            for(int i = 0; i < 5; i++) {
                
                vector[i] = entrada.nextInt();
                cad+=Integer.toString(vector[i])+",";
            }
            
            
            
            Socket client = new Socket("localhost", port); //conectarse al socket
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            
            toServer.println(cad);  //mandar alservidor
            
            String result = fromServer.readLine();  // respuesta del servidor
            
            System.out.println(result);
                      
           

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
