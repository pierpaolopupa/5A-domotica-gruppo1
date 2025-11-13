package domotica;
import java.util.Random;

public class SensoreContattoPorta {

    private boolean portaAperta;
    private Random random;

    public SensoreContattoPorta() {
        this.random = new Random();
        this.portaAperta = false; // stato iniziale: porta chiusa
    }

    /**
     * Simula la lettura dello stato della porta.
     * Restituisce true se la porta è aperta, false se è chiusa.
     */
    public boolean leggiStatoPorta() {
        // Simuliamo una possibilità del 20% di cambio stato
        if (random.nextDouble() < 0.2) {
            portaAperta = !portaAperta; // cambia stato (aperta/chiusa)
        }
        return portaAperta;
    }

    public static void main(String[] args) {
        SensoreContattoPorta sensore = new SensoreContattoPorta();

        System.out.println("Avvio simulazione sensore contatto porta...");
        for (int i = 0; i < 20; i++) {
            boolean stato = sensore.leggiStatoPorta();

            if (stato) {
                System.out.println("🚪 Porta APERTA!");
            } else {
                System.out.println("🔒 Porta CHIUSA.");
            }

            try {
                Thread.sleep(1000); // 1 secondo tra le letture
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Simulazione interrotta.");
            }
        }

        System.out.println("Simulazione completata.");
    }
}
