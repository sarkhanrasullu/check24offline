package de.c24.finacc.klt.entity;

/**
 *
 * @author Sarkhan Rasullu
 */
public class Request {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;

    /**
     * constructor with-no-param
     */
    public Request() {
    }

    /**
     * constructor with-id
     */
    public Request(Integer id) {
        this.id = id;
    }

    /**
     * constructor with-all-params
     */
    public Request(Integer id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * getId
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setId
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * getName
     * @return name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstname
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getSurname
     * @return name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setName
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getAge
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * setAge
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Request[ id=" + id + " ]";
    }

}
