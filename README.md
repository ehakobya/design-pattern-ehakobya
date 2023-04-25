# design-pattern-ehakobya

## Assignment 5A

> - For this project I could use decorator pattern to allow a code-a-mon to gain new abilities when they level up
>
> - Also I could use a factory pattern to create and instantiate different kindo of code-a-mon.
>
> - Mediator pattern could be used to provide communication between objects. Instaed of objects communication with each other, all object communication goes through the mediator.

## Assignment 5B

### Requirements

---

> Project attempts to tackle the option B from the requirements doc, where the design patterns are intertwined.
>> For example: Builder pattern uses the factory pattern in it to build a trainer with a code-a-mon.
> 
> Requirements satisfied:
>> 1. The world starts with min. 2 trainers with more than one code-a-mon each..
>> 2. Code-a-mons compete 1v1.
>> 3. Simulation runs on cycles with day and night shifts.
>> 4. There are 3 weather conditions (Rain, Sunny, Clear).
>> 5. Different code-a-mons get advantage over the others, and disadvantage based on who they face. For Example: Fire gets advantage over Nature, but Water gets advantage over Fire.
>> 6. There are totle of 3 types of code a mons that all have different advantages over each other.
>> 7. Battles earn experience and gold for the trainer.
>> 8. During the night, code-a-mons heal up to 50% if their health is below 50%.
>> 9. All code-a-mons have minimum stats such as health, attack, level, bonus damage etc.
>> 10. Code-a-mons are able to level up when winning battles. When they level up their health is restored.

### Checkstyle Report

---

![checkstyle-report.png](doc%2Fcheckstyle-report.png)

> - At first the checkstyle report showed over a 1000 errors. The issue was resolved by changing the IDE settings to use spaces instead of tabs. This brought down the number of errors from 1000 to approximately 200. All important errors were corrected. The remaining ones are left alone **On Purpose**.

### Spotbugs Report

---

![sportbugs-report.png](doc%2Fsportbugs-report.png)

> - Present warning in the spotbugs report are left **On Purpose** since they have to deal with the same random object generation.

### JUnit Test

---

![junit-report.png](doc%2Fjunit-report.png)

### Jacoco Test Report

--- 

![jacoco-report.png](doc%2Fjacoco-report.png)

> I believe the code coverage is decent and covers most of the important methods.

