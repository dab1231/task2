import java.util.List;

public class MoveCreaturesAction implements Action{
    @Override
    public void execute(Map map){
        List<Creature> creatures = map.getAllCreatures();
        for(Creature creature : creatures){
            creature.makeMove(map);
        }
    }
}
