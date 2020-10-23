package my_structure;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyStructure myStructure = new MyStructure();

        Node node1 = new Node("code1", "renderer1");
        Node node2 = new Node("code2", "renderer2");

        System.out.println("node1.getCode() = " + node1.getCode());
        System.out.println();
        System.out.println("myStructure.add(node1) = " + myStructure.add(node1));
        System.out.println("myStructure = " + myStructure);
        System.out.println("myStructure.count() = " + myStructure.count());

        Node nodeInComp1 = new Node("nodeInCompCode1", "nodeInCompRenderer1");
        Node nodeInComp2 = new Node("nodeInCompCode2", "nodeInCompRenderer2");


        System.out.println("\n======================================================\n");


        CompositeNode compositeNode1 = new CompositeNode("comCode1", "compRenderer1",
                Arrays.asList(nodeInComp1, nodeInComp2));


        System.out.println("compositeNode1.getCode() = " + compositeNode1.getCode());
        System.out.println("compositeNode1 = " + compositeNode1);
        System.out.println("compositeNode1.getNodes() = " + compositeNode1.getNodes());
        System.out.println("compositeNode1.getNodes().size() = " + compositeNode1.getNodes().size());

        myStructure.add(compositeNode1);
        System.out.println("\nmyStructure = " + myStructure);

        System.out.println("myStructure.findByCode(\"code1\") = " + myStructure.findByCode("code1"));
        System.out.println("myStructure.findByRenderer(\"compRenderer1\") = " + myStructure.findByRenderer("compRenderer1"));
    }
}