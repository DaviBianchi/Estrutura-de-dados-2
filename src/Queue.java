
public class Queue {

    private String[] elements;
    private int size;
    private int base = 0;

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public String doCheck() {
        return this.elements[this.base];
    }

    public Queue(int value) {
        this.elements = new String[value];
    }

    public void inQueue(String element) {
        if (!(this.size < this.elements.length)) {
            this.elements[size] = element;
            this.size++;
        }
        this.elements[size] = element;
        this.size++;
    }

    public void outQueue() {

        if (this.empty()) {
            throw new IllegalArgumentException("Empty");
        }

        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        --size;
    }
}
