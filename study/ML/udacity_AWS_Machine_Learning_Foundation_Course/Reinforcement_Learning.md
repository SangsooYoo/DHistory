# **Reinforcement Learning**
In reinforcement learning (RL), an agent is trained to achieve a goal based on the feedback it receives as it interacts with an environment. It collects a number as a reward for each action it takes. Actions that help the agent achieve its goal are incentivized with higher numbers. Unhelpful actions result in a low reward or no reward.

With a learning objective of maximizing total cumulative reward, over time, the agent learns, through trial and error, to map gainful actions to situations. The better trained the agent, the more efficiently it chooses actions that accomplish its goal.

## **New Terms**
* Agent: The piece of software you are training is called an agent. It makes decisions in an environment to reach a goal.
* Environment: The environment is the surrounding area with which the agent interacts.
* Reward: Feedback is given to an agent for each action it takes in a given state. This feedback is a numerical reward.
* Action: For every state, an agent needs to take an action toward achieving its goal.

* Agent
    * The piece of software you are training is called an agent.
    * It makes decisions in an environment to reach a goal.

* Environment
    * The environment is the surrounding area within which our agent interacts.
    
* State
    * The state is defined by the current position within the environment that is visible, or known, to an agent.
    * The car’s initial state is the starting line of the track and its terminal state is when the car finishes a lap, bumps into an obstacle, or drives off the track.

* Action
    * For every state, an agent needs to take an action toward achieving its goal.

* Reward
    * Feedback is given to an agent for each action it takes in a given state.
    * This feedback is a numerical reward.
    * A reward function is an incentive plan that assigns scores as rewards to different zones on the track.

* Episode
    * An episode represents a period of trial and error when an agent makes decisions and gets feedback from its environment.

* An algorithm is a set of instructions that tells a computer what to do. ML is special because it enables computers to learn without being explicitly programmed to do so.
* The training algorithm defines your model’s learning objective, which is **to maximize total cumulative reward**. Different algorithms have different strategies for going about this.
    * **A soft actor critic (SAC)** embraces exploration and is data-efficient, but can lack stability.
    * **A proximal policy optimization (PPO)** is stable but data-hungry.
* An action space is the set of all valid actions, or choices, available to an agent as it interacts with an environment.
    * Discrete action space represents all of an agent's possible actions for each state in a finite set of steering angle and throttle value combinations.
    * Continuous action space allows the agent to select an action from a range of values that you define for each sta te.
* Hyperparameters are variables that control the performance of your agent during training. There is a variety of different categories with which to experiment. Change the values to increase or decrease the influence of different parts of your model.
    * For example, the learning rate is a hyperparameter that controls how many new experiences are counted in learning at each step. A higher learning rate results in faster training but may reduce the model’s quality.
* **The reward function's purpose is to encourage the agent to reach its goal.** Figuring out how to reward which actions is one of your most important jobs.