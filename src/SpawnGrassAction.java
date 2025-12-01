public class SpawnGrassAction implements Action{
    @Override
    public void execute(Map map){
        int count = map.getGrassCount();
        if(count <= 2){
            for(int i = 0; i < 3; i++){
                Coordinate coordinate = InitMapActions.getRandomFreeCoordinate(map);
                map.addEntity(coordinate, new Grass());
            }
        }
    }
}
