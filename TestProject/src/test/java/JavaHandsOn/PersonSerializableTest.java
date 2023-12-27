package JavaHandsOn;

import java.io.*;

public class PersonSerializableTest implements Serializable, Cloneable {

    public String name;
    public int age;


    public PersonSerializableTest(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * came from cloneable Inteface
     * @return
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
         return super.clone();
    }
}
class SerializableAndCloneBleTest {
    public static void main(String[] args) throws Exception{
        /* serialization the object*/
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("person.ser"))){
            oos.writeObject(new PersonSerializableTest("rohan",12));
        }
        /** deserialization */

        try(ObjectInputStream ois= new ObjectInputStream(new FileInputStream("person.ser"))){
           PersonSerializableTest person= (PersonSerializableTest)ois.readObject();

            System.out.println("deserialized output ->> "+ person.getName() + "::" +person.getAge());
        }

        /* cloneable demo */
         PersonSerializableTest pers= new PersonSerializableTest("sneha",13);
          PersonSerializableTest  clonedObject=(PersonSerializableTest)pers.clone();
        System.out.println("cloned object -->  "+ clonedObject.getName()+" "+ clonedObject.getAge());



    }
}
