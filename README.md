## About this project
*Made by Kim Meyer Albrechtsen*

This project is written with Java. The frontend consist of a some queries where you can SELECT, SET and DELETE. Use the Main class to run these methods. 

The backend is a Postgresql database. The database is on a server at Digital Ocean. 

## Test plan

This section will explain my test plan for this project. It will mainly be focusing on integration testing, because that is what our assignment is about. If we look at the *Test Pyramid*, integration tests are in the middle layer ofthe pyramid:

![Test Pyramid](test_pyramid.jpg)

### Approaches
There are different approaches to choose from when doing integration testing. Here I will describe the various ones. 

**Big Bang Approach**

In this approach, all components and modules are integrated together at once, and then they are testet. This is good, if we are working with a small system. 

The disadvantages for this approach are that there could be missed some of the test on the integration, because all have to designed and implemented before the tests are written. 

**Incremental Approach**

Here the test is done by joing two or more modules that are logically related. Hereafter other related modules are added and tested. This approach is carried out by using dummy programs called *stubs and drivers*. This is a way of simulating the data communication between the modules.

We can use the incremental approach on two different ways:

**Bottom Up Approach**

In this approach, we start by testing the lower level with higher modules, and then moving up. The advantages of this approach are that faults are discovered earlier. And we don't have to wait on all the modules to be developed as in the *Big Bang Approach*.

The disadvantages of this approach are that the highest level of the modules are tested at the end, and not first. And early prototype is not possible. 

**Top Down Approach** 
This is the opposite way of doing integration testing than *Bottom Up Approach*. We start at the highest level, and then move down lower. The advantages of this approach are that faults are earlier discovered. We can make an early prototype. We test the citical modules first.

The disadvantages of this approach are that we need many stubs. And modules at lower level are tested late. 

**What I have chosen**

I have chosen to go with the *Big Bang Approach** because my project is very small, and it is only made for learning to do integration testing.


### Entry & Exit Criteria

Here I will explain some of the criterias for the integrations test to be made.

**Entry Criterias**
* If this was a real project, then I would have had made unit test for the components/modules.
* All bugs would have been fixed
* All components/modules would have been code completed and integrated.

**Exit Criterias**
* The integration tests are successful
* All executed test results are documented
* All bugs are fixed and closed

**IMPORTANT INFO**

In this project I am testing on the production database, but if this was a real/important project then I would have created a development/staging database - maybe on another server - which would reflect the production database. Maybe copy the production database once a day to this development database. Then I would base my tests on this database.

## Test Cases
In this section I will give examples on test cases based on this project.

If this was a meaningful project, then I would have unit tested before doing integration testing. 

### Prerequisites
You should NEVER test on the production database because that can result in deleting citical data - therefore I have made test database which reflects the production database. Here I can CRUD as much as I want :) 

### The Cases
Here are my integration test cases:


Test Case ID | Test Case Objective | Test Case Description | Expected Result
--- | --- | --- | ---
1 | Check the connection between the application and database | Enter in valid username and password | Should get connected
| 2 | Check that the database is not empty | Select all from database and insure that it is not empty | Should not be null
| 3 | Check that person is in the database | Enter name. List should be bigger or equals 1 | Should not be null
4 | Check that a created person is in the database | Search for person before creating. Enter name and age. Search for person again | Should return the created person
| 5 | Check that a person is deleted from the database | Search for person before deleting. Enter id. Seatch for person again | Should return null

