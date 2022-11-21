# Instructions  

### Description:
This activity will help you understand when and how to use interfaces. An interface is an **abstract** entity, similar to an **abstract** class; however, unlike an **abstract** class, classes can inherit from multiple interfaces.

Other differences between interfaces and abstract classes, is that a subclass must use the keyword `implements` instead of `extends` when inheriting from an interface. Additionally, interface methods are implicitly public and abstract. This means that the following two examples are functionally the exact same:

```Java
interface Example {
  public abstract void doSomething();
}
```
```Java
interface Example {
  void doSomething();
}
```

Interfaces are also typically only used to inherit methods, not fields. This is because fields declared in an interface are implicitly **public**, **static** and **final**.

Interfaces and abstract classes can seem somewhat similar so you can use the following table to differentiate between them.

|Abstract Class|Interfaces|
|-|-|
|Subclasses use the `extends` Keyword to inherit functionality|Subclasses use the `implements` keyword to inherit functionality|
|Subclasses may only extend one abstract class| subclasses may implement multiple interfaces|
|Can contain abstract and non-abstract methods|All methods are implicilty abstract|
|May contain methods which are public, protected, package-private or private| All methods are implicitly public, and therefore cannot have other levels of access|
|May contain fields (variables) with different levels of access and other modifiers|All fields (variables) are implicitly public, static and final|

In this activity you will create several interfaces to describe the different actions and behaviors for different Birds.
  ## Steps
 1. Create a new file called 'Bird.java' and copy the following code into the file:
```Java
class Bird {
  String name;
}
```
The class 'Bird' will act as our superclass. Note, this class should probably be use the modifier `abstract`, since the behaviors and implementation for our birds are highly dependent on the type of subclass we instantiate; however, for the sake of this lab, we will leave this class as non-abstract.

 2. Now, lets create a subclass of Bird. Create a new file called 'Parrot.java', and copy the following code into the file:
```Java
class Parrot extends Bird {
  
}
```
Since Parrots are Birds which can fly, we could add a method called 'fly' to the Bird class. Lets do that now. 

3. Back in the Bird.java file, add the following code snippet:
```Java
public void fly() {
  System.out.println("Soaring through the air");
}
```
In the `main()` method of your Main class add the following code create an instance of Parrot and invoke the `fly()` method:
```Java
Parrot parrot = new Parrot();
parrot.fly();
```

At this point, we don't have any trouble structuring our code this way. We could create another new subclass of Bird and those objects would be able to fly; however, not all birds can fly!

4. Create a new file called 'Ostrich.java' which extends the class Bird. Your code should look like the following:
```Java
class Ostrich extends Bird {
  
}
```
In our `main()` method, we can create an instance of Ostrich and invoke `fly()`; however, our Ostrich should not have this ability! We could override the method in the Ostrich class to instead print a message stating that Ostriches cannot fly, but this solution is quite messy! Instead, we can shift the functionality of flight from our Bird class into an interface.

5. Remove the method `fly()` from our Bird class (This will cause an error message in our Main.java file where we invoke the fly() method on our parrot object, but don't worry we'll fix that in a moment!).
<br><br>
6. Now lets create a new interface! Create a new file called 'Flyer.java' and add the following code to the file:
```Java
interface Flyer {
  // this method is implicitly public abstract
  void fly();
}
```
Notice that the only difference between declaring a class and an interface is that we use the `interface` keyword instead. Additionally, note that our `fly()` method does not define a method body. Interface methods are implicitly abstract.

7. Now, lets implement this interface on our Parrot class. Back in Parrot.java, alter the class declaration to the following:
```Java
class Parrot extends Bird implements Flyer {
  @Override
  public void fly () {
    System.out.println("The Parrot is flying!");
  }
}
```
Using the keyword `implements` our Parrot now inherits functionality from the class Bird, as well as the interface Flyer. Keep in mind that we could not create a class called 'Flyer' and retain the same flexibility. Java classes may only extend one other class, meaning Parrots would either extend Bird or Flyer in that case. Using an interface gives us more flexibility. Additionally, note that we are now implementing the `fly()` method in our Parrot class, since the inherited method from our interface is abstract. Also note that it is public to match the level of access of the fly() method defined in the Flyer interface.

Now, the error in our `main()` method should be gone. At this point, you may be wondering what the advantage is. This seems like more work for functionality that we had before! Let's dive a bit deeper with another example.

8. Create a new file called 'Swimmer.java' and add the following code to the file:
```Java
interface Swimmer {
  void swim();
  void dive();
}
```
9. Create a new file called 'Penguin.java' and add the following code:
```Java
class Penguin extends Bird implements Swimmer {
  @Override
  public void swim() {
    System.out.println("Penguins are agile swimmers");
  }

  @Override
  public void dive() {
    System.out.println("Penguins can dive hundreds of feet to catch fish");
  }
}
```

10. Create an instance of the Penguin class in your main method and invoke the `swim()` and `dive()` methods and run the program. Make sure you see the following output:
```
Penguins are agile swimmers
Penguins can dive hundreds of feet to catch fish
```
As we can see, interfaces give us a lot of flexibility when creating different sub classes; but, to truly appreciate their power lets create one more class.

11. Your Turn! Create a new file called 'Duck.java'. Make sure the class extends Bird and implements the Flyer as well as the Swimmer interface! When a class implements multiple the interfaces each implemented interface should be separated using a comma. The following example highlights this syntax:
```Java
class ClassName extends SuperClassName implements InterfaceA, InterfaceB ... {
  
}
```
Classes in Java can implement as many interfaces as they need. After creating the Duck class, make sure to implement the `fly()` method inherited from the interface **Flyer** as well as the `swim()` and `dive()` methods inherited from the interface **Swimmer**. 

For the `fly()` method, print out: `Ducks can fly great distances when migrating`. 
<br>For `swim()`, print out: `Ducks swim by paddling their feet under the water`. 
<br>Finally for `dive()` print out: `Ducks can hold their breathe for several minutes when they dive for food`.

12. Verify your functionality by creating an instance of your Duck class inside of your `main()` class. Then invoke the `fly()`, `swim()` and `dive()` methods on your duck object.

Using interfaces, you've just created a structure of inheritance that allows different subtypes of Birds which can either fly, swim, do both, or do neither!

  ### Test:
Use the test provided.

#### Sample output:
```
The Parrot is flying!
Penguins are agile swimmers
Penguins can dive hundreds of feet to catch fish
Ducks can fly great distances when migrating
Ducks swim by paddling their feet under the water
Ducks can hold their breathe for several minutes when they dive for food
```
  