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

# **Testing**
## **Testing And Data Science**
* Problems that could occur in data science aren’t always easily detectable; you might have values being encoded incorrectly, features being used inappropriately, or unexpected data breaking assumptions.
* To catch these errors, you have to check for the quality and accuracy of your analysis in addition to the quality of your code. Proper testing is necessary to avoid unexpected surprises and have confidence in your results.
* Test-driven development (TDD): A development process in which you write tests for tasks before you even write the code to implement those tasks.
* Unit test: A type of test that covers a “unit” of code—usually a single function—independently from the rest of the program.

* Resources
    * Four Ways Data Science Goes Wrong and How Test-Driven Data Analysis Can Help: [Blog Post](https://www.predictiveanalyticsworld.com/machinelearningtimes/four-ways-data-science-goes-wrong-and-how-test-driven-data-analysis-can-help/6947/)
    * Ned Batchelder: Getting Started Testing: [Slide](https://speakerdeck.com/pycon2014/getting-started-testing-by-ned-batchelder) Deck and [Presentation Video](https://www.youtube.com/watch?v=FxSsnHeWQBY)

## **Unit test**
Unit Testing Tools
* To install pytest, ```run pip install -U pytest``` in your terminal. You can see more information on getting started [here](https://docs.pytest.org/en/6.2.x/reference.html).
    * Create a test file starting with test_.
    * Define unit test functions that start with test_ inside the test file.
    * Enter pytest into your terminal in the directory of your test file and it detects these tests for you.
* test_ is the default; if you wish to change this, you can learn how in this pytest [configuration](https://docs.pytest.org/en/latest/customize.html).

* In the test output, periods represent successful unit tests and Fs represent failed unit tests. Since all you see is which test functions failed, it's wise to have only one assert statement per test. Otherwise, you won't know exactly how many tests failed or which tests failed.

* Your test won't be stopped by failed assert statements, but it will stop if you have syntax errors.

## **Test-driven development and data science**
* Test-driven development: Writing tests before you write the code that’s being tested. Your test fails at first, and you know you’ve finished implementing a task when the test passes.
* Tests can check for different scenarios and edge cases before you even start to write your function. When start implementing your function, you can run the test to get immediate feedback on whether it works or not as you tweak your function.
* When refactoring or adding to your code, tests help you rest assured that the rest of your code didn't break while you were making those changes. Tests also helps ensure that your function behavior is repeatable, regardless of external parameters such as hardware and time.

Test-driven development for data science is relatively new and is experiencing a lot of experimentation and breakthroughs. You can learn more about it by exploring the following resources.
* [Data Science TDD](https://www.linkedin.com/pulse/data-science-test-driven-development-sam-savage/)
* [TDD for Data Science](http://engineering.pivotal.io/post/test-driven-development-for-data-science/)
* [TDD is Essential for Good Data Science Here's Why](https://medium.com/uk-hydrographic-office/test-driven-development-is-essential-for-good-data-science-heres-why-db7975a03a44)
* [Testing Your Code ](http://engineering.pivotal.io/post/test-driven-development-for-data-science/) (general python TDD)

## **Logging**
Log messages
Logging is the process of recording messages to describe events that have occurred while running your software.
* Tip: Be professional and clear
* Tip: Be concise and use normal capitalization
* Tip: Choose the appropriate level for logging
* Tip: Provide any useful information

## **code reviews**
* [Code Reviews](https://github.com/lyst/MakingLyst/tree/master/code-reviews)
* [Code Review best practices](https://www.kevinlondon.com/2015/05/05/code-review-best-practices.html)

**Questions to ask yourself when conducting a code review**

**Is the code clean and modular?**
* Can I understand the code easily?
* Does it use meaningful names and whitespace?
* Is there duplicated code?
* Can I provide another layer of abstraction?
* Is each function and module necessary?
* Is each function or module too long?

**Is the code efficient?**
* Are there loops or other steps I can vectorize?
* Can I use better data structures to optimize any steps?
* Can I shorten the number of calculations needed for any steps?
* Can I use generators or multiprocessing to optimize any steps?

**Is the documentation effective?**
* Are inline comments concise and meaningful?
* Is there complex code that's missing documentation?
* Do functions use effective docstrings?
* Is the necessary project documentation provided?

**Is the code well tested?**
* Does the code high test coverage?
* Do tests check for interesting cases?
* Are the tests readable?
Can the tests be made more efficient?

**Is the logging effective?**
* Are log messages clear, concise, and professional?
* Do they include all relevant and useful information?
* Do they use the appropriate logging level?

## **Tips for conducting a code review**
* Tip: Use a code linter [pylint](https://www.pylint.org/) : will help you to check the coding conventions and errors
* Tip: Explain issues and make suggestions  
Rather than commanding people to change their code a specific way because it's better, it will go a long way to explain to them the consequences of the current code and suggest changes to improve it
* Tip: Keep your comments objective  
Try to avoid using the words "I" and "you" in your comments. You want to avoid comments that sound personal to bring the attention of the review to the code and not to themselves.
* Tip: Provide code examples   
When providing a code review, you can save the author time and make it easy for them to act on your feedback by writing out your code suggestions. 