import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.lang.Exception;

public class PathFinder {
    private Queue<Coordinate> coordinates;
    private Set<Coordinate> visited;
    private java.util.HashMap<Coordinate, Coordinate> cameFrom;

    public List<Coordinate> reconstructPath(Coordinate start, Coordinate goal, java.util.HashMap<Coordinate, Coordinate> cameFrom){
        List<Coordinate> path = new ArrayList<>();
        Coordinate current = goal;
        
        while(!current.equals(start)){
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }

    public List<Coordinate> findPath(Coordinate start, Coordinate goal, Map map) {
        coordinates = new LinkedList<>();
        visited = new HashSet<>();
        cameFrom = new java.util.HashMap<>();

        coordinates.add(start);
        visited.add(start);

        while(!coordinates.isEmpty()){
            Coordinate current = coordinates.poll();

            if(current.equals(goal)){
                return reconstructPath(start, goal, cameFrom); 
            }
            Coordinate[] neighbors = {
                new Coordinate(current.getX(), current.getY() + 1),
                new Coordinate(current.getX(), current.getY() - 1),
                new Coordinate(current.getX() - 1, current.getY()),
                new Coordinate(current.getX() + 1, current.getY())
            };
            for(Coordinate neighbor : neighbors){
                if(neighbor.getX() < 0 || neighbor.getY() < 0 || neighbor.getX() >= map.getWidth() || neighbor.getY() >= map.getHeight()){
                    continue;
                }

                Entity entity = map.getEntity(neighbor);

                if(entity == null || neighbor.equals(goal)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        coordinates.add(neighbor);
                        cameFrom.put(neighbor, current);
                    }
                }
                
            }
            
        }
        return new ArrayList<>();
    }

    public Coordinate findNearestTarget(Map map, Coordinate start, Class<?> targetClass){
        Coordinate coordinateMinPath = null;
        int minPath = 10000;
        int path = 0;
        for(int y = 0; y < map.getHeight(); y++){
            for(int x = 0; x < map.getWidth(); x++){
                Entity entity = map.getEntity(new Coordinate(x, y));         
                if(targetClass.isInstance(entity)){
                    path = Math.abs(start.getX() - entity.getXPos()) + Math.abs(start.getY() - entity.getYPos());
                    if(path < minPath) { 
                        minPath = path; 
                        coordinateMinPath = new Coordinate(entity.getXPos(), entity.getYPos());
                    }
                }
            }
        }
        return coordinateMinPath;
    }
}
