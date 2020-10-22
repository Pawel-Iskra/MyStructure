package my_structure;

public interface IMyStructure {

    // zwraca węzeł o podanym kodzie lub null
    INode findByCode(String code);

    // zwraca węzęł o podanym rendererze lub null
    INode findByRenderer(String renderer);

    // zwraca liczbę węzłów
    int count();
}
