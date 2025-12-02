public class Renderer {
    
    public void render(Map map, Simulation simulation) { 
        
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Coordinate coord = new Coordinate(x, y);
                Entity entity = map.getEntity(coord);

                if (entity == null) {
                    System.out.print("⬜ "); 
                } else if (entity instanceof Grass) {
                   System.out.print("🌿 ");
                } else if (entity instanceof Herbivore) {
                    System.out.print("🐰 ");
                } else if (entity instanceof Rock) {
                    System.out.print("🧱 ");
                } else if (entity instanceof Tree) {
                    System.out.print("🌳 ");
                } else if (entity instanceof Predator) {
                    System.out.print("🐺 ");
                }
            }
            System.out.println();
        }
        
        System.out.println("-------------------------------------------------");
        System.out.println("| Состояние: " + (simulation.isRunning() ? "Запущено" : "Приостановлено") 
                           + " | Ход: " + simulation.getTurnCounter() + " |");
        System.out.println("-------------------------------------------------");
        System.out.println("Доступные команды: [start], [pause], [exit]");
    }
}