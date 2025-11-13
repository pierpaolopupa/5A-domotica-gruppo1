package domotica;
public class SensoreMovimento {

    private Random random;
    private boolean movimentoRilevato;

    public SensoreMovimento() {
        this.random = new Random();
        this.movimentoRilevato = false;
    }

    /**
     * Simula la lettura del sensore.
     * Restituisce true se viene rilevato un movimento, false altrimenti.
     */
    public boolean leggiMovimento() {
        // Simuliamo una probabilità del 30% di rilevare un movimento
        movimentoRilevato = random.nextDouble() < 0.3;
        return movimentoRilevato;
    }

    public static void main(String[] args) {
        SensoreMovimento sensore = new SensoreMovimento();

        System.out.println("Avvio simulazione sensore di movimento...");
        for (int i = 0; i < 15; i++) { // 15 letture
            boolean movimento = sensore.leggiMovimento();

            if (movimento) {
                System.out.println("🔴 Movimento rilevato!");
            } else {
                System.out.println("🟢 Nessun movimento.");
            }

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
