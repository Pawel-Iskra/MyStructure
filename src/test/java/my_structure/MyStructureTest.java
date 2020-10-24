package my_structure;

import org.junit.jupiter.api.*;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyStructureTest {

    private MyStructure myStructure;

    @BeforeEach
    public void setUp() {
        myStructure = new MyStructure();
    }

    // Tests fot method count() \\
    @Test
    public void when_structure_has_empty_node_list_method_count_should_return_zero() {
        Assertions.assertEquals(0, myStructure.count());
    }

    @Test
    public void when_in_structure_are_two_single_nodes_method_count_should_return_two() {
        INode node1 = new Node("code1", "renderer1");
        INode node2 = new Node("code2", "renderer2");
        myStructure.add(node1);
        myStructure.add(node2);
        Assertions.assertEquals(2, myStructure.count());
    }

    @Test
    public void when_in_structure_is_compositeNode_with_two_nodes_inside_method_count_should_return_three() {
        INode node1 = new Node("code1", "renderer1");
        INode node2 = new Node("code2", "renderer2");
        CompositeNode compositeNode =
                new CompositeNode("code3", "renderer3", Arrays.asList(node1, node2));
        myStructure.add(compositeNode);
        Assertions.assertEquals(3, myStructure.count());
    }

    // Tests fot method findByCode() \\
    @Test
    public void when_node_with_wanted_code_exist_in_structure_then_method_findByCode_should_return_it() {
        Node node = new Node("code1", "renderer1");
        myStructure.add(node);
        Assertions.assertEquals(node, myStructure.findByCode("code1"));
    }

    @Test
    public void when_compositeNode_has_node_with_wanted_code_method_findByCode_should_return_it() {
        INode node1 = new Node("code1", "renderer1");
        INode node2 = new Node("code2", "renderer2");
        CompositeNode compositeNode =
                new CompositeNode("code3", "renderer3", Arrays.asList(node1, node2));
        myStructure.add(compositeNode);
        Assertions.assertEquals(node1, myStructure.findByCode("code1"));
    }

    @Test
    public void when_compositeNode_has_wanted_code_method_findByCode_should_return_it() {
        INode node = new Node("code1", "renderer1");
        CompositeNode compositeNode1 = new CompositeNode("code2", "renderer2", Arrays.asList(node));
        myStructure.add(compositeNode1);
        Assertions.assertEquals(compositeNode1, myStructure.findByCode("code2"));
    }

    @Test
    public void when_node_with_wanted_code_does_not_exist_in_structure_then_method_findByCode_should_return_null() {
        Node node = new Node("code1", "renderer1");
        myStructure.add(node);
        Assertions.assertNull(myStructure.findByCode("code2"));
    }

    // Tests for method findByRenderer \\
    @Test
    public void when_node_with_wanted_renderer_exist_in_structure_then_method_findByRenderer_should_return_it() {
        Node node = new Node("code1", "renderer1");
        myStructure.add(node);
        Assertions.assertEquals(node, myStructure.findByRenderer("renderer1"));
    }

    @Test
    public void when_compositeNode_has_node_with_wanted_renderer_method_findByRenderer_should_return_it() {
        INode node1 = new Node("code1", "renderer1");
        INode node2 = new Node("code2", "renderer2");
        CompositeNode compositeNode =
                new CompositeNode("code3", "renderer3", Arrays.asList(node1, node2));
        myStructure.add(compositeNode);
        Assertions.assertEquals(node2, myStructure.findByRenderer("renderer2"));
    }

    @Test
    public void when_compositeNode_has_wanted_renderer_method_findByRenderer_should_return_it() {
        INode node = new Node("code1", "renderer1");
        CompositeNode compositeNode = new CompositeNode("code2", "renderer2", Arrays.asList(node));
        myStructure.add(compositeNode);
        Assertions.assertEquals(compositeNode, myStructure.findByRenderer("renderer2"));
    }

    @Test
    public void when_node_with_wanted_renderer_does_not_exist_in_structure_then_method_findByRenderer_should_return_null() {
        Node node = new Node("code1", "renderer1");
        myStructure.add(node);
        Assertions.assertNull(myStructure.findByRenderer("renderer2"));
    }

    // Tests for Exceptions \\
    @Test
    public void when_null_is_given_as_parameter_in_method_findByCode_IllegalArgumentException_should_be_thrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> myStructure.findByCode(null));
    }

    @Test
    public void when_null_is_given_as_parameter_in_method_findByRenderer_IllegalArgumentException_should_be_thrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> myStructure.findByRenderer(null));
    }

    @Test
    public void when_compositeNode_is_given_as_parameter_in_compositeNode_constructor_IllegalArgumentException_should_be_thrown() {
        INode node = new Node("code1", "renderer1");
        CompositeNode compositeNode = new CompositeNode("code3", "renderer3", Arrays.asList(node));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    CompositeNode compositeNode2 =
                            new CompositeNode("code4", "renderer4", Arrays.asList(compositeNode));
                });
    }


}