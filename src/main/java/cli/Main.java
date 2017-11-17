package cli;

public class Main implements Runnable {

    private class Facade implements sleon.Facade {
    }

    public void run() {
        new Facade().start();
    }

    public static void main(String[] args) {
        new Main().run();
    }

}
