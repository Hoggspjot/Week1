public class PatternBuilder {
    public static void main(String[] args) throws CloneNotSupportedException {

        Person person = new Person.Builder().setName("Bob").setAge(25).build();

        System.out.println(person);

        Person cloned = (Person) person.clone();
        System.out.println(cloned);
    }

}


class Person implements Cloneable{
    private String name;
    private int age;

    public Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }


    public static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public Person build() {
            return new Person(this);
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
