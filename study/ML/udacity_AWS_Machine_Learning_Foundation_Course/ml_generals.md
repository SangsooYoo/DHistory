## **What is Machine Learning?**
Machine learning (ML) is a modern software development technique and a type of artificial intelligence (AI) that enables computers to solve problems by using examples of real-world data.

Within machine learning there are several different kinds of tasks or techniques:
* In **supervised learning**, **every training sample from the dataset has a corresponding label** or output value associated with it. As a result, the algorithm learns to predict labels or output values. We will explore this in-depth in this lesson.
* In **unsupervised learning**, **there are no labels for the training data. A machine learning algorithm tries to learn the underlying patterns or distributions that govern the data.** We will explore this in-depth in this lesson.
* In **reinforcement** learning, **the algorithm figures out which actions to take in a situation to maximize a reward (in the form of a number) on the way to reaching a specific goal.** This is a completely different approach than supervised and unsupervised learning. We will dive deep into this in the next lesson.

## **Components of Machine Learning**
Nearly all tasks solved with machine learning involve three primary components:
* A machine learning model
* A model training algorithm
* A model inference algorithm

## **What are machine learning models?**
A machine learning model, like a piece of clay, can be molded into many different forms and serve many different purposes. A more technical definition would be that a machine learning model is a block of code or framework that can be modified to solve different but related problems based on the data provided.

## **How are model training algorithms used to train a model?**
Model training algorithms work through an interactive process
* A model training algorithm uses the model to process data and then compares the results against some end goal.
* A model training algorithm gently nudges specific parts of the model in a direction that brings the model closer to achieving the goal.
* Repeat. By iterating over these steps over and over, you get closer and closer to what you want until you determine that you’re close enough that you can stop.

## **Model Inference: Using Your Trained Model**
We are ready to use the model inference algorithm to generate predictions using the trained model. This process is often referred to as model inference.

## **Major Steps in the Machine Learning Process**
* Step One: Define the Problem  
Define a very specific task  
Identify the machine learning task we might use to solve this problem.  
This helps you better understand the data you need for a project.  
<image src='https://video.udacity-data.com/topher/2021/April/608c44b0_snsupersuper/snsupersuper.png'/>
    
    * Supervised tasks  
    A task is supervised if you are using labeled data. We use the term labeled to refer to data that already contains the solutions, called labels.
    * Unsupervised tasks  
    A task is considered to be unsupervised if you are using unlabeled data. This means you don't need to provide the model with any kind of label or solution while the model is being trained.  
    Unsupervised learning involves using data that doesn't have a label. One common task is called clustering. Clustering helps to determine if there are any naturally occurring groupings in the data.
* Step Two: Build a Dataset  
The next step in the machine learning process is to build a dataset that can be used to solve your machine learning-based problem. Understanding the data needed helps you select better models and algorithms so you can build more effective solutions.  
    * The most important step of the machine learning process  
    Working with data is perhaps the most overlooked—yet most important—step of the machine learning process. In 2017, an O’Reilly study showed that machine learning practitioners spend 80% of their time working with their data.
    * Data collection  
    Data collection can be as straightforward as running the appropriate SQL queries or as complicated as building custom web scraper applications to collect data for your project. 
    * Data inspection  
    The quality of your data will ultimately be the largest factor that affects how well you can expect your model to perform. As you inspect your data, look for:
        * Outliers
        * Missing or incomplete values
        * Data that needs to be transformed or preprocessed so it's in the correct format to be used by your model
* Step Three: Model Training  
Splitting your Dataset
The first step in model training is to randomly split the dataset. This allows you to keep some data hidden during training, so that data can be used to evaluate your model before you put it into production.
    * Training dataset: The data on which the model will be trained. Most of your data will be here. Many developers estimate about 80%.
    * Test dataset: The data withheld from the model during training, which is used to test how well your model will generalize to new data.

    Model Training Terminology
    The model training algorithm iteratively updates a model's parameters to minimize some loss function.
    * Model parameters: Model parameters are settings or configurations the training algorithm can update to change how the model behaves. Depending on the context, you’ll also hear other more specific terms used to describe model parameters such as weights and biases. Weights, which are values that change as the model learns, are more specific to neural networks.
    * Loss function: A loss function is used to codify the model’s distance from this goal. For example, if you were trying to predict a number of snow cone sales based on the day’s weather, you would care about making predictions that are as accurate as possible. So you might define a loss function to be “the average distance between your model’s predicted number of snow cone sales and the correct number.” You can see in the snow cone example this is the difference between the two purple dots.
    * Putting it All Together
    The end-to-end training process is
        * Feed the training data into the model.
        * Compute the loss function on the results.
        * Update the model parameters in a direction that reduces loss.
    You continue to cycle through these steps until you reach a predefined stop condition. 

* Step Four: Model Evaluation
After you have collected your data and trained a model, you can start to evaluate how well your model is performing. The metrics used for evaluation are likely to be very specific to the problem you have defined.

Every step we have gone through is highly iterative and can be changed or re-scoped during the course of a project. At each step, you might find that you need to go back and reevaluate some assumptions you had in previous steps. Don't worry! This ambiguity is normal.

* Supervised learning
    * Using machine learning to predict housing prices in a neighborhood based on lot size and number of bedrooms
* Unsupervised learning
    * Using machine learning to isolate micro-genres of books by analyzing the wording on the back cover description.
* Deep neural network
    * While this type of task is beyond the scope of this lesson, we wanted to show you the power and versatility of modern machine learning. You will see how it can be used to analyze raw images from lab video footage from security cameras, trying to detect chemical spills.

