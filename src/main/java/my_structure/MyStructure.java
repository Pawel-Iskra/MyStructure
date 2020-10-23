package my_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new ArrayList<>();

    public boolean add(INode node) {
        return nodes.add(node);
    }

    @Override
    public INode findByCode(String code) {
        Optional<INode> foundNode = nodes.stream()
                .filter(node -> code.equals(node.getCode()))
                .findFirst();
        if (foundNode.isEmpty()) return null;
        return foundNode.get();
    }

    @Override
    public INode findByRenderer(String renderer) {
        Optional<INode> foundNode = nodes.stream()
                .filter(node -> renderer.equals(node.getRenderer()))
                .findFirst();
        if (foundNode.isEmpty()) return null;
        return foundNode.get();
    }

    @Override
    public int count() {
        return nodes.size();
    }




    @Override
    public String toString() {
        return "MyStructure{" +
                "nodes=" + nodes +
                '}';
    }
}
