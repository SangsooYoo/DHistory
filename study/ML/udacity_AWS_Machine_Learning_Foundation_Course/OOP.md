


## **Procedural versus object-oriented programming**

* Objects are defined by characteristics and actions  
You can also think about characteristics and actions is in terms of English grammar. A characteristic corresponds to a noun and an action corresponds to a verb.

* Object-oriented programming (OOP) vocabulary
    * Class: A blueprint consisting of methods and attributes.
    * Object: An instance of a class. It can help to think of objects as something in the real world like a yellow pencil, a small dog, or a blue shirt. However, as you'll see later in the lesson, objects can be more abstract.
    * Attribute: A descriptor or characteristic. Examples would be color, length, size, etc. These attributes can take on specific values like blue, 3 inches, large, etc.
    * Method: An action that a class or object could take.
    * OOP: A commonly used abbreviation for object-oriented programming.
    * Encapsulation: One of the fundamental ideas behind object-oriented programming is called encapsulation: you can combine functions and data all into a single entity. In object-oriented programming, this single entity is called a class. Encapsulation allows you to hide implementation details, much like how the scikit-learn package hides the implementation of machine learning algorithms.

## **Object-oriented programming syntax**
* Function versus method  
A function and a method look very similar. They both use the def keyword. They also have inputs and return outputs. The difference is that a method is inside of a class whereas a function is outside of a class.
* ```Self``` tells Python where to look in the computer's memory for the ```shirt_one``` object. Then, Python changes the price of the ```shirt_one``` object. When you call the ```change_price``` method, ```shirt_one.change_price(12)```, ```self``` is implicitly passed in.  
The word ```self``` is just a convention. You could actually use any other name as long as you are consisten, but you should use ```self``` to avoid confusing people.