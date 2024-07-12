package solutions.pack1;

public class Dog {
    private Breed breed;
    private int weight;
    public Dog(Breed breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }

    public Breed getBreed() {
        return breed;
    }

    public int getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        return "Dog[Breed =" + breed + ", weight=" + weight + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((breed == null) ? 0 : breed.hashCode());
        result = prime * result + weight;
        return result;
    }
}
