public class Renderer {
    public void render(Map map) {
        for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++) {
                Coordinate coord = new Coordinate(x, y);
                Entity entity = map.getEntity(coord);

                if (entity == null) {
                    System.out.print("⬜");
                } else if (entity instanceof Grass) {
                   System.out.print("🌿");
                } else if (entity instanceof Herbivore) {
                    System.out.print("🐰");
                } else if (entity instanceof Rock) {
                    System.out.print("🧱");
                } else if (entity instanceof Tree) {
                    System.out.print("🌳");
                } else if (entity instanceof Predator) {
                    System.out.print("🐺");
                }
            }
            System.out.println();
        }
    }
}
