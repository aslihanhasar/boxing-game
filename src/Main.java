public class Main {
    public static void main(String[] args) {
        Fighter fighterOne = new Fighter("Thunder", 90, 25, 120, 60);
        Fighter fighterTwo = new Fighter("Nightmare", 80, 20, 130, 60);
        Ring match = new Ring(fighterOne, fighterTwo, 70, 100);
        match.run();
    }
}
