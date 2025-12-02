import java.util.HashMap;
import java.util.Map.Entry;

public class MoveCreaturesAction implements Action {
    @Override
    public void execute(Map map) {
        HashMap<Coordinate,Creature> creatures = map.getCreatures();
        for (Entry<Coordinate, Creature> entry : creatures.entrySet()) {
            Coordinate position = entry.getKey();
            Creature creature = entry.getValue();
            Entity entityOnMap = map.getEntity(position);
            
            if (entityOnMap == creature) {
                creature.makeMove(map, position);
            }
        }
    }
}
