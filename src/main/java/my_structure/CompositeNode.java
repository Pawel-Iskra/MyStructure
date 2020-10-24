package my_structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CompositeNode extends Node implements ICompositeNode {
    private List<INode> nodes = new LinkedList<>();

    public CompositeNode(String code, String renderer, List<INode> list) {
        super(code, renderer);
        for (INode iNode : list) {
            if (iNode instanceof CompositeNode) {
                throw new IllegalArgumentException("node inside composite node can't be composite type");
            }
        }
        this.nodes = list;
    }

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CompositeNode that = (CompositeNode) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nodes);
    }

}