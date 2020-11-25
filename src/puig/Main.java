package puig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HombreDelTiempo hombreDelTiempo = new HombreDelTiempo();
        Scanner scanner = new Scanner(System.in);

        while(true){
            if(scanner.nextLine().equals("i")){
                System.out.println("Iniciando hombre del tiempo...");
                hombreDelTiempo.iniciarPrediccion(new HombreDelTiempo.PrediccionListener() {

                    @Override
                    public void cuandoCambieElTiempo(String tiempo) {
                        System.out.println(tiempo);
                    }
                });
            } else {
                System.out.println("Parando entrenador...");
                hombreDelTiempo.pararPrediccion();
            }
        }
    }
}