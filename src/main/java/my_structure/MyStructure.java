package my_structure;

import java.util.LinkedList;
import java.util.List;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new LinkedList<>();

    public boolean add(INode node) {
        if (node == null) throw new IllegalArgumentException("node can't be null");
        return nodes.add(node);
    }

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("code can't be null");
        }
        for (INode iNode : nodes) {
            if (iNode instanceof CompositeNode) {
                CompositeNode current = (CompositeNode) iNode;
                if (code.equals(current.getCode())) {
                    return current;
                }
                for (INode node : current.getNodes()) {
                    if (code.equals(node.getCode())) {
                        return node;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("renderer can't be null");
        }
        for (INode iNode : nodes) {
            if (iNode instanceof CompositeNode) {
                CompositeNode current = (CompositeNode) iNode;
                if (renderer.equals(current.getRenderer())) {
                    return current;
                }
                for (INode node : current.getNodes()) {
                    if (renderer.equals(node.getRenderer())) {
                        return node;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public int count() {
        int amount = 0;
        for (INode iNode : nodes) {
            if (iNode instanceof CompositeNode) {
                amount = amount + (((CompositeNode) iNode).getNodes().size());
            }
            amount++;
        }
        return amount;
    }

}