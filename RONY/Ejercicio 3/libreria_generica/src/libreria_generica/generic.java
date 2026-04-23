package libreria_generica;

import java.util.ArrayList;
import java.util.List;

public class generic<T, S> {

    private List<T> listElements = new ArrayList<>();

    private T attributeT1, attributeT2;
    private S attributeS3, attributeS4;

    public generic() {
        this.attributeT1 = null;
        this.attributeT2 = null;
        this.attributeS3 = null;
        this.attributeS4 = null;
    }

    public generic(T attributeT1, T attributeT2, S attributeS3, S attributeS4) {
        this.attributeT1 = attributeT1;
        this.attributeT2 = attributeT2;
        this.attributeS3 = attributeS3;
        this.attributeS4 = attributeS4;
    }

    public generic(T attributeT1, T attributeT2, S attributeS3) {
        this.attributeT1 = attributeT1;
        this.attributeT2 = attributeT2;
        this.attributeS3 = attributeS3;
    }

    public generic(T attributeT1, T attributeT2) {
        this.attributeT1 = attributeT1;
        this.attributeT2 = attributeT2;
    }

    public generic(T attributeT1) {
        this.attributeT1 = attributeT1;
    }

    public T getAttributeT1() {
        return attributeT1;
    }

    public void setAttributeT1(T attributeT1) {
        this.attributeT1 = attributeT1;
    }

    public T getAttributeT2() {
        return attributeT2;
    }

    public void setAttributeT2(T attributeT2) {
        this.attributeT2 = attributeT2;
    }

    public S getAttributeS3() {
        return attributeS3;
    }

    public void setAttributeS3(S attributeS3) {
        this.attributeS3 = attributeS3;
    }

    public S getAttributeS4() {
        return attributeS4;
    }

    public void setAttributeS4(S attributeS4) {
        this.attributeS4 = attributeS4;
    }

    @Override
    public String toString() {
        return "generic [attributeT1=" + attributeT1 +
               ", attributeT2=" + attributeT2 +
               ", attributeS3=" + attributeS3 +
               ", attributeS4=" + attributeS4 + "]";
    }

    public void addNElements(T... elements) {
        for (T element : elements) {
            this.listElements.add(element);
        }
    }
}
	
