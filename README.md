# IMS Developed by David Algie

This project was based on knowledge that has been gained during our weeks learning Java and SQL. It is primarily focused upon these languages and has been a challenge in learning then and therefore applying them.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Planning

I used Jira for a planning board [Jira](https://davidteam3.atlassian.net/jira/software/projects/IS/boards/4) for use of a planning board.

### Prerequisites

MySQL and Eclipse were the only things really required in order to get the project started. There are dependancies that link outside sources to my Java syntax such as Maven and JUnit and these are contained within a file named "pom" within my eclipse Java syntax.

### Installing

This installation will require the use of the IDE Eclipse.

Initially, a copy of the link for this Github repository is required.

Secondly, it can then be imported into Eclipse by finding it within package explorer and then "Import".

Following this select Project from Git (with smart install) and then Clone URL.

Once "Next" has been clicked the SQL database will needed to be created.

This schema is comtained within src/main/resources/sql-schema.sql.

The system it is installed onto will need to change the db.properties file contained within resources.

With the aboves step complete, run the software within the Runner class and away it goes.

### Unit Tests 

Explain what these tests test, why and how to run them

These tests can be run within the test section of the Maven Project, simply run them as JUnit tests to see them in action.

A simple example of a unit test would be as follows:
```
	@Test
	public void testSetId() {
		Item apple = new Item("banana",1.00);
		banana.setId(2l);
		Long expected = 2l;
		assertEquals(expected,banana.getId());
	}

```
The above test is a simple item.getId() method within returns as expected for a basic example. Some unit tests are more complex and make use of the Mockito dependency to simulate submethods.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **David Algie** - *Project Work*


## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

- Thank you to our trainers Alan and Pawel for teaching us the ways of Java.
- Thank you George for listening to my cry about errors and help me through my struggles.
- Thank you to my team for being there and attempting to help my errors.
