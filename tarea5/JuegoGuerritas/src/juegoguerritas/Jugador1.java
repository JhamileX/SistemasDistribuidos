package juegoguerritas;

import java.rmi.Naming;
import java.util.Scanner;

public class Jugador1 {
    public static void main(String[] args) {
        IGuerrita guerrita ;
        Scanner sc = new Scanner(System.in);
        try {
            guerrita = (IGuerrita)  Naming.lookup("rmi://localhost/Guerrita");
            System.out.println("Digite 10 posiciones:");
            int posiciones[][] = new int[10][2];
            for (int i = 0; i < 1; i++) {
                System.out.print("X:");
                posiciones[i][0] = sc.nextInt();
                System.out.println("Y:");
                posiciones[i][1] = sc.nextInt();

            }
            guerrita.ponerfichas(1,posiciones);

            int x,y;
            boolean b=true;
            while (true){
                //System.out.println(guerrita.turno());
                if (b && guerrita.turno()!=1){
                    b=false;
                    System.out.println("Esperando al otro jugador");
                }
                if(guerrita.turno()==1){
                    System.out.println("Disparar:");
                    System.out.print("X: ");
                    x = sc.nextInt();
                    System.out.print("Y: ");
                    y = sc.nextInt();
                    guerrita.disparar(1,x,y);
                    b=true;
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
