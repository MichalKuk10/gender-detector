# Gender-detector

## General Info

Algorithm to determinate gender based on the name

## Features

It works on two HTTP endpoints: 

1) for using the gender guessing with selected variant and a name as a single string.  Example: /api/genders/check?variant=firstName&name=Maria 
2) for returning available tokens for each gender. Example: /api/genders/tokens 


## Technologies

  - Java 11
  - Spring
  - Maven

## Usage
Returns all available tokens: 
![alt text](https://user-images.githubusercontent.com/57062670/111437720-b2d6b800-8703-11eb-85fa-ba7520e7ff3e.png)

Determinate which gender-token has the occurance advantage and returns appropriate result: 

![alt text](https://user-images.githubusercontent.com/57062670/111437727-b4a07b80-8703-11eb-8bcb-b9b27686d67b.png)

Based on only one name return it's gender: 

![alt text](https://user-images.githubusercontent.com/57062670/111437731-b5d1a880-8703-11eb-9957-f86824a86a7e.png)

When wrong type or name not recognized returns inconclusive:

![alt text](https://user-images.githubusercontent.com/57062670/111438232-47d9b100-8704-11eb-85f1-34ff93759897.png)
