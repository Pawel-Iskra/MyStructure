package my_structure;

import java.util.List;
import java.util.Objects;

public class CompositeNode extends Node implements ICompositeNode {
    private String code;
    private String renderer;
    private List<INode> nodes;

    public CompositeNode(String code, String renderer,
                         List<INode> list) {
        super(code, renderer);
        this.nodes = list;
    }

    @Override
    public List<INode> getNodes() {
        return nodes;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeNode that = (CompositeNode) o;
        return Objects.equals(code, that.code)
                && Objects.equals(renderer, that.renderer)
                && Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, renderer, nodes);
    }
}