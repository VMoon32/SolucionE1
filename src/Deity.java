import java.util.LinkedList;

public class Deity {
    private String name;
    private String description;
    private LinkedList<Deity> parents;

    public Deity(String name, String description){
        this.name = name;
        this. description = description;
        parents = new LinkedList<>();

    }

    public void addParent(Deity deity){
        parents.add(deity);
    }
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public LinkedList<Deity> getParents(){
        return parents;
    }
}
