package test;

import com.company.Data.DataProvider;
import org.hamcrest.Matchers;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;

/*
    I had to use FixMethodOrder because I wanted to order the test so I could reuse the Id
    from createPerson function in deletePersonById function.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataProviderTest {
    private DataProvider dataProvider;
    private List<String> persons;
    private static int id;


    @org.junit.Before
    public void setUp() throws Exception {
        dataProvider = new DataProvider();
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getAllPersons() throws Exception {
        /*
            Test that the database is not empty
         */
        persons = dataProvider.getAllPersons();
        assertThat(persons, is(notNullValue()));
    }

    @org.junit.Test
    public void getPersonByName() throws Exception {
        /*
            Test if the given person is in the list.
         */
        persons = dataProvider.getPersonByName("Danny Nielsen");
        assertThat(persons, is(not(Matchers.<String>empty())));
    }

    @org.junit.Test
    public void createPerson() throws Exception {
        /*
            Test if the given person gets created in the database.

            NOTE: here it will not make sense in doing it this way I am doing it. Because
            the test will only work one time, and after that Julie Madsen will be en the database.
            Here we should actually delete the person after checking that he/she is added to the database.
            But here we just doing it simple and have to make a new name every time :(

            UPDATE: After I edited the createPerson function, then I can get the id for the created person.
            I then use that id when I delete a person.That way we can always use the same person!
         */
        persons = dataProvider.getPersonByName("Jeppe Test Frandsen");
        assertThat(persons, is(Matchers.<String>empty()));

        id = dataProvider.createPerson("Jeppe Test Frandsen", 18);

        persons = dataProvider.getPersonByName("Jeppe Test Frandsen");
        assertThat(persons, is(not(Matchers.<String>empty())));
        System.out.println(persons);
    }

    @org.junit.Test
    public void deletePersonById() throws Exception {
        /*
            Test if the given person by id is deleted from the database.
            Here we use the id given from the test method above.
            First we check if the person is in the database.
            Then we delete him and finally checks again if the person is in the database.
         */
        persons = dataProvider.getPersonByName("Jeppe Test Frandsen");
        assertThat(persons, is(not(Matchers.<String>empty())));

        dataProvider.deletePersonById(id);

        persons = dataProvider.getPersonByName("Jeppe Test Frandsen");
        assertThat(persons, is(Matchers.<String>empty()));

    }

}