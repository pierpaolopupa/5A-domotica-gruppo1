package domotica;
public class SensoreTemperatura {

    // Simuliamo un sensore con valori tra -10°C e 40°C
    private static final double MIN_TEMPERATURA = -10.0;
    private static final double MAX_TEMPERATURA = 40.0;

    private Random random;

    public SensoreTemperatura() {
        this.random = new Random();
    }

    /**
     * Legge una temperatura casuale simulando un sensore reale.
     */
    public double leggiTemperatura() {
        return MIN_TEMPERATURA + (MAX_TEMPERATURA - MIN_TEMPERATURA) * random.nextDouble();
    }

    public static void main(String[] args) {
        SensoreTemperatura sensore = new SensoreTemperatura();

        System.out.println("Avvio simulazione sensore di temperatura...");
        for (int i = 0; i < 10; i++) { // Legge 10 volte
            double temperatura = sensore.leggiTemperatura();
            System.out.printf("Lettura %d: %.2f °C%n", i + 1, temperatura);
            try {
                Thread.sleep(1000); // Attesa di 1 secondo tra le letture
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Simulazione interrotta.");
            }
        }
        System.out.println("Simulazione completata.");
    }
}
