/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Carlos
 */
public class ServerUDP {

  public static void main (String args[]) {

    try {

      DatagramSocket socketUDP = new DatagramSocket(6789);
      byte[] bufer = new byte[1000];

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion =
          new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);

        System.out.print("Datagrama recibido del host: " +
                           peticion.getAddress());
        System.out.println(" desde el puerto remoto: " +
                           peticion.getPort());

        // Construimos el DatagramPacket para enviar la respuesta




        // Enviamos la respuesta, que es un eco

        
        String vector = new String( peticion.getData());
        String resultado[] = vector.split(",");
        String resp="";

        for(int i = 0; i < 5; i++) {
            System.out.println(resultado[i]);
            resp += Integer.toString(Integer.parseInt(resultado[i].trim()) + 5)+" "; //trim le quita espacios de adelante y detras
        }
        System.out.println(resp);
        
        System.out.println("res="+resp);
              // Y vamos concatenando cada carácter a la nueva cadena
        byte[] mensaje = resp.getBytes();
        peticion.setData(mensaje);

        DatagramPacket respuesta =
                new DatagramPacket(peticion.getData(), peticion.getLength(),
                        peticion.getAddress(), peticion.getPort());

        socketUDP.send(respuesta);
      }

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }

}

    

