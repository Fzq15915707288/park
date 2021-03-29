package park;

public class CarNode {
    public Car data;
    public CarNode next;

    public CarNode(Car data, CarNode next) {
        this.data = data;
        this.next = next;
    }

    public CarNode(Car data) {
        this(data, null);
    }

    public CarNode() {
        this(null, null);
    }

}