package my_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new ArrayList<>();

    public boolean add(INode node) {
        if (node == null) throw new IllegalArgumentException("Node can't be null.");
        return nodes.add(node);
    }

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("code can't be null.");
        }
        Optional<INode> foundNode = nodes.stream()
                .filter(node -> code.equals(node.getCode()))
                .findFirst();
        if (foundNode.isEmpty()) return null;
        return foundNode.get();
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("renderer can't be null.");
        }
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
