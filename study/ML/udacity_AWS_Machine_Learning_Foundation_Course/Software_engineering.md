# **Refactoring Code**
* Refactoring: Restructuring your code to improve its internal structure without changing its external functionality. This gives you a chance to clean and modularize your program after you've got it working.
Since it isn't easy to write your best code while you're still trying to just get it working, allocating time to do this is essential to producing high-quality code. Despite the initial time and effort required, this really pays off by speeding up your development time in the long run.
You become a much stronger programmer when you're constantly looking to improve your code. The more you refactor, the easier it will be to structure and write good code the first time.

## **Writing clean code: Meaningful names**
Use meaningful names.
* Be descriptive and imply type: 
    * For booleans, you can prefix with is_ or has_ to make it clear it is a condition. 
    * Be consistent but clearly differentiate: age_list and age is easier to differentiate than ages and age.
    * Avoid abbreviations and single letters: You can determine when to make these exceptions based on the audience for your code. 
    * Long names aren't the same as descriptive names: You should be descriptive, but only with relevant information. 
Try testing how effective your names are by asking a fellow programmer to guess the purpose of a function or variable based on its name, without looking at your code. Coming up with meaningful names often requires effort to get right.
## **Writing clean code: Nice whitespace**
Use whitespace properly.
* Organize your code with consistent indentation: the standard is to use four spaces for each indent. 
* Separate sections with blank lines to keep your code well organized and readable.
* Try to limit your lines to around 79 characters, which is the guideline given in the PEP 8 style guide. 

## **Writing Modular Code**
* Tip: DRY (Don't Repeat Yourself)
* Tip: Abstract out logic to improve readability
* Tip: Minimize the number of entities (functions, classes, modules, etc.)
* Tip: Functions should do one thing
* Tip: Arbitrary variable names can be more effective in certain functions
* Tip: Try to use fewer than three arguments per function

## **Efficient Code**
Knowing how to write code that runs efficiently is another essential skill in software development. Optimizing code to be more efficient can mean making it:
* Execute faster
* Take up less space in memory/storage

## **Documentation**
* Documentation: Additional text or illustrated information that comes with or is embedded in the code of software.
* Documentation is helpful for clarifying complex parts of code, making your code easier to navigate, and quickly conveying how and why different components of your program are used.
* Several types of documentation can be added at different levels of your program:
    * Inline comments - line level
    * Docstrings - module and function level
    * Project documentation - project level

## **Inline Comments**
Inline comments are text following hash symbols throughout your code. They are used to explain parts of your code, and really help future contributors understand your work.
Comments often document the major steps of complex code. Readers may not have to understand the code to follow what it does if the comments explain it. However, others would argue that this is using comments to justify bad code, and that if code requires comments to follow, it is a sign refactoring is needed.
Comments are valuable for explaining where code cannot. For example, the history behind why a certain method was implemented a specific way. Sometimes an unconventional or seemingly arbitrary approach may be applied because of some obscure external variable causing side effects. These things are difficult to explain with code.

## **Docstrings**
Docstring, or documentation strings, are valuable pieces of documentation that explain the functionality of any function or module in your code. Ideally, each of your functions should always have a docstring.

Docstrings are surrounded by triple quotes. The first line of the docstring is a brief explanation of the function's purpose.

* One-line docstring
``` Python
def population_density(population, land_area):
    """Calculate the population density of an area."""
    return population / land_area
```

* Multi-line docstring
```Python
def population_density(population, land_area):
    """Calculate the population density of an area.

    Args:
    population: int. The population of the area
    land_area: int or float. This function is unit-agnostic, if you pass in values in terms of square km or square miles the function will return a density in those units.

    Returns:
    population_density: population/land_area. The population density of a 
    particular area.
    """
    return population / land_area
```

* [PEP 257 - Docstring Conventions](https://www.python.org/dev/peps/pep-0257/)
* [Numpy Docstring Guide](https://numpydoc.readthedocs.io/en/latest/format.html)

## **Project Documentation**
Project documentation is essential for getting others to understand why and how your code is relevant to them, whether they are potentials users of your project or developers who may contribute to your code. A great first step in project documentation is your README file. It will often be the first interaction most users will have with your project.

## **Version Control In Data Science**
* [Version Control ML Model](https://towardsdatascience.com/version-control-ml-model-4adb2db5f87c)
* [How to version control your production machine learning models
](https://algorithmia.com/blog/how-to-version-control-your-production-machine-learning-models)