
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

## **Set and get methods**
the general object-oriented programming convention is to use methods to access attributes or change attribute values. These methods are called ```set``` and ```get``` methods or ```setter``` and ```getter``` methods.

Following the Python convention, the underscore in front of price is to let a programmer know that price should only be accessed with ```get``` and ```set``` methods rather than accessing ```price``` directly with ```shirt_one._price```. However, a programmer could still access _price directly because there is nothing in the Python language to prevent the direct access.

## **Attributes**
Changing values via a method gives you more flexibility in the long-term. What if the units of measurement change, like if the store was originally meant to work in US dollars and now has to handle Euros? 


## **Docstrings and object-oriented code**
The following example shows a class with docstrings. Here are a few things to keep in mind:
* Make sure to indent your docstrings correctly or the code will not run. A docstring should be indented one indentation underneath the class or method being described.
* You don't have to define self in your method docstrings. It's understood that any method will have self as the first method input.
```Python
class Pants:
    """The Pants class represents an article of clothing sold in a store
    """

    def __init__(self, color, waist_size, length, price):
        """Method for initializing a Pants object

        Args: 
            color (str)
            waist_size (int)
            length (int)
            price (float)

        Attributes:
            color (str): color of a pants object
            waist_size (str): waist size of a pants object
            length (str): length of a pants object
            price (float): price of a pants object
        """

        self.color = color
        self.waist_size = waist_size
        self.length = length
        self.price = price

    def change_price(self, new_price):
        """The change_price method changes the price attribute of a pants object

        Args: 
            new_price (float): the new price of the pants object

        Returns: None

        """
        self.price = new_price

    def discount(self, percentage):
        """The discount method outputs a discounted price of a pants object

        Args:
            percentage (float): a decimal representing the amount to discount

        Returns:
            float: the discounted price
        """
        return self.price * (1 - percentage)
```

## **Masic Methods**
pre-defined methods but a user can override those

