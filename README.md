# Assignment 2  
This assignment has been solved with **Java** and **Spring boot** where I have followed test practises like **BDD** and **TDD** combined with test frameworks such as:  
- JUnit 5  
- Cucumber  

Furthermore, there has been made room for testing and implementing REST endpoints which can be done with a MVC library.


## 1.0 Reflections

### 1.1 Computer mouse
*Identify the types of testing you would perform on a computer mouse, to make sure that it is of the highest quality.*

**Computer mouse units:**  
- Left mouse button
- Right mouse button
- Scroll Wheel
- Scroll Wheel button
- Move the mouse to the right, left, up, down (reaction)
- Other mouse buttons

**Level:**

**Unit test:**   
**Why:** Because all the small units have to work by themselves. If one of them fails, we know for sure which part of the system is not working.

**Integration testing:**  
**Why:** We have to be able to view if the components work together as intended to get the performance as expected from the mouse.
How the units/components work together.

**System testing:**  
**Why:** System testing done by a professional testing agent on the completed product before it is introduced to the market, so we are sure that all components cooperate as expected.

**Acceptance test:**  
**Why:** Because each use case scenario, which is described from a customer, needs to be tested as a whole to confirm that a given task is completed to an acceptable degree.  
**Example:**   
**Given** that the mouse is connected to a computer,  
**When** the user moves the mouse,  
**Then** the cursor on the screen moves accordingly.

**Type:**  
You could also perform four types of testing within each test level in the form of functional, performance, security and regression.

### 1.2 Catastrophic failure  

*Find a story where a software system defect had a bad outcome. Describe what happened. Can you identify a test that would have prevented it?*  
  
The Mars Climate Orbiter crashed in September 1999 because of a "silly mistake": wrong units in a program.

One could have written several unit tests, testing the units of the program. The input units of the program should have been tested for wrong input.

To be able to figure out if the probe was working correctly together with the Mars Lander, we would have conducted a system test to make sure that the whole system was able to interact with each other as intended.

If you want to read more horror stories click on the following link:  
[Horror software stories](https://www.cs.tau.ac.il/~nachumd/horror.html)

## 2 Two katas
*Complete the following using BDD.*

### 2.1 String utility  
Use BDD to create a string utility with the following methods:  
- Reverse string (aBc -> cBa)
- Capitalize string (aBc -> ABC)
- Lowercase string (aBc -> abc)

For these tasks I am not allowed to use any built-in utility. I will have to create my own.

### 2.2 Bowling game 
I have been given a slide where I have to solve a task.  
Can be found in the following link:  
[Bowling game](http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ptt)

All test solutions can be found in the test package in my uploaded project.   
**Results:**  
![BDD tests](https://raw.githubusercontent.com/Jean-Poul/Test-Assignment-2/main/pictures/BDD-feature-test.png)  
![Red test](pictures/red.png)  
![Green test](pictures/TDD-unit-test.png)


## 3 Investigation of tools  

### 3.1 JUnit 5  
*Investigate JUnit 5 (Jupiter). Explain the following, and how they are useful:* 

- **@Tag**
Is used to declare tags for filtering tests, either at the class or method level; analogous to test groups in TestNG or Categories in JUnit 4. Such annotations are inherited at the class level but not at the method level. In short, if we want to group our test we would use **@Tag(“UnitTest”)**, **@Tag(“IntegrationTest”)**.

- **@Disabled**
is an annotation which allows you to disable a test during test runs or test automation. Examples of tests that you could disable in automation could be tests that use built in sleep methods or other things that might take too long for CI.

- **@RepeatedTest:** The term ‘repeated test’ means to repeat the execution of specific tests or tests for a certain number of times. This annotation allows you to make a test run X amount of times. 
For Example: Clicking on the ‘Payment’ link for a particular banking application shows “Exception: Page cannot be displayed” and this environment disappears after four clicks. This is a consistent and known issue for the client.
Now, we know that we cannot afford to have tests failed for such known environmental issues that would not be accepted by the client as real defects.
Thus, in this case, of course, either we could build the code logic within the test itself to handle the clicking of the payment link four times and have our test proceed further without failing or we could better take the advantage of the repeated test feature supported by JUnit 5.

- **@BeforeEach/@AfterEach** is an annotation used for a test that should be run before/after every single unit test in a given file. As an example it is helpful in integration test to revert database to the known stage, so the other test can be performed on a known dataset.

- **@BeforeAll/@AfterAll** is an annotation which is runned once and can be used as a setup or cleanup. When testing integration with e.g. databases, the test database can be populated with known entities so each unit test can be performed on that setup at first when the test class is runned, **(@BeforeAll)** and then the database can be cleaned from data after all unit test where performed **(@AfterAll)**.

- **@DisplayName**
is an annotation which allows you to define a description for your test method or class, this means that instead of showing the class name or method name when a test is completed it will print the display name instead.

- **@Nested** 
denotes that the annotated class is a nested, non-static test class. **@BeforeAll** and **@AfterAll** methods cannot be used directly in a **@Nested** test class unless the “per-class” test instance lifecycle is used. Such annotations are not inherited.  
Code example:  

```java
class SomethingTest {
	
	@BeforeEach 
	void setup()  {
		// Setup some normal state
	}

	@Nested
	class AddTest {
		@BeforeEach 
		void setup()  {
			// State specific for AddTest
		}
		
	@Test
	void testAdd() {
	// Test testAdd
	}
  }
}

```

- **assumeFalse/assumeTrue** is a set of methods useful for stating assumptions about the conditions in which a test is meaningful. A failed assumption does not mean the code is broken, but that the test provides no useful information. Assume basically means "don't run this test if these conditions don't apply". The default JUnit runner skips tests with failing assumptions. Custom runners may behave differently.

### 3.2 Mocking frameworks
*Investigate mocking frameworks for your preferred language. Choose at least two frameworks, and answer the questions. (One could be Mockito, which was seen in class).*  
In this section I will compare the two mocking frameworks for Java; **Mockito** and **EasyMock** (I have encountered a third named JMockit). 


1.**What are their similarities?**
- Both allow us to create test-doubles such as stubs, spies and mocks.
- Both allow mocking of method calls, verifying method calls and verifying arguments passed to the methods.
- Both allow us to throw exceptions at will when testing mocked methods.
- Both allow us to create mocks for objects passed as arguments.
- Both allow specific matching of arguments.
- Both can use partial mocking.

2. **What are their differences?**
- Overall Mockito syntax is slightly more compact.
- Custom argument matching and partial mocking are more complex to do in EasyMock.
- Mockito provides more readable error messages on failed tests.
- EasyMock splits mocking up into a recording phase, where you record the expected behavior, and a replay phase, where the recorded mocking behavior is used to execute a test. Whereas Mockito simply asks that you stub before execution and verify after.

3. **Which one would I prefer, if any, and why?**  
My preference between Mockito and EasyMock would be Mockito. With Mockito having simpler ways of making the same tests compared to EasyMock(for example custom argument matching), not having to call replay everytime I want to use a mock and having special annotations for partial mock, I definitely would prefer to use Mockito.

--- 

**Mock definition and basics by Martin Fowler:**  
*This has nothing to do with the assignment but just for my own knowledge so I remember :trollface:*
> **Dummy** objects are passed around but never actually used. Usually, they are just used to fill parameter lists.  
**Fake** objects have working implementations, but usually, take some shortcut which makes them not suitable for production (an in memory database is a good example).  
**Stubs** provide canned answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test. Stubs may also record information about calls, such as an email gateway stub that remembers the messages it ‘sent', or maybe only how many messages it ‘sent'.  
Mocks are what we are talking about here: objects pre-programmed with expectations which form a specification of the calls they are expected to receive.
