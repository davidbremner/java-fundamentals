package labs_examples.objects_classes_methods.labs.oop.B_polymorphism.exercise_one_two;

public interface Construction {
    int calculateSize(int constructionLength, int constructionWidth);
    String renovation(int sizeLength, int sizeWidth, String CONSTRUCTION_TYPE);
    double calculateCost(int sizeInSquareMetres, int areaCost);
}
