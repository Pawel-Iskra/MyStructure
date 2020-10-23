package my_structure;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyStructureTest {

    private MyStructure myStructure;

    @BeforeEach
    public void setUp() {
        myStructure = new MyStructure();
    }

    @Test
    public void when_empty_list_count_should_return_zero() {
        int expected = 0;
        int actual = myStructure.count();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void when_node_with_wanted_code_exist_in_structure_then_method_findByCode_should_return_it() {
        String code = "code1";
        Node node = new Node(code, "renderer1");
        myStructure.add(node);
        Assertions.assertEquals(node, myStructure.findByCode(code));
    }

    @Test
    public void when_node_with_wanted_code_does_not_exist_in_structure_then_method_findByCode_should_return_null() {
        String code = "code1";
        Node node = new Node(code, "renderer1");
        myStructure.add(node);
        Assertions.assertNull(myStructure.findByCode("code2"));
    }

    @Test
    public void when_node_with_wanted_renderer_exist_in_structure_then_method_findByRenderer_should_return_it() {
        String renderer = "renderer1";
        Node node = new Node("code1", renderer);
        myStructure.add(node);
        Assertions.assertEquals(node, myStructure.findByRenderer(renderer));
    }

    @Test
    public void when_node_with_wanted_renderer_does_not_exist_in_structure_then_method_findByRenderer_should_return_null() {
        String renderer = "renderer1";
        Node node = new Node("code1", renderer);
        myStructure.add(node);
        Assertions.assertNull(myStructure.findByRenderer("renderer2"));
    }

    @Test
    public void when_null_is_given_as_parameter_in_method_findByCode_IllegalArgumentException_should_be_thrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> myStructure.findByCode(null));
    }

    @Test
    public void when_null_is_given_as_parameter_in_method_findByRenderer_IllegalArgumentException_should_be_thrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> myStructure.findByRenderer(null));
    }


}