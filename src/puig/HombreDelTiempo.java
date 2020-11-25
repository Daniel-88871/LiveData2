package puig;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HombreDelTiempo {

    interface PrediccionListener {
        void cuandoCambieElTiempo(String orden);
    }

    Random random = new Random();
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    ScheduledFuture<?> prediccion;

    void iniciarPrediccion(PrediccionListener prediccionListener) {

        if (prediccion == null || prediccion.isCancelled()) {


            prediccion = scheduler.scheduleAtFixedRate(new Runnable() {
                String[] tiempo = {"Lluvia", "Sol", "Viento", "Nubes"};
                int repeticiones = -1;

                @Override
                public void run() {
                    if (repeticiones < 0) {
                        repeticiones = random.nextInt(4);
                    }
                    prediccionListener.cuandoCambieElTiempo(tiempo[repeticiones]);
                    repeticiones--;
                }
            }, 0, 2, SECONDS);
        }
    }

    void pararPrediccion() {
        if (prediccion != null) {
            prediccion.cancel(true);
        }
    }
}