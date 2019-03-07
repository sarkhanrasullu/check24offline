package de.c24.finacc.klt.form;

import de.c24.finacc.klt.util.MathUtil;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sarkhan Rasullu
 */
public class RequestForm {

    private String firstName;
    private String lastName;
    private Integer age;
    private boolean hasError;
    /**
     * constructor with-no-param
     */
    public RequestForm() {
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

    /**
     * hasError
     * @return hasError
     */
    public boolean hasError() {
        return hasError;
    }

    /**
     * setHasError
     * @param hasError
     */
    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    /**
     * validate
     * @return validation result
     */
    public Map<String, String> validate() {
        Map<String, String> messages = new HashMap<>();

        if (getFirstName() == null || getFirstName().trim().isEmpty()) {
            messages.put("firstnameMsg", "firstname can not be empty");
            hasError = true;
        }

        if (getLastName() == null || getLastName().trim().isEmpty()) {
            messages.put("lastnameMsg", "lastname can not be empty");
            hasError = true;
        }

        if (age == null) {
            messages.put("ageMsg", "age can not be null");
            hasError = true;
        } else {
            if (age < 18) {
                messages.put("ageMsg", "too young");
                hasError = true;
            } else if (age > 67) {
                messages.put("ageMsg", "too old");
                hasError = true;
            } else if (MathUtil.isPrime(age)) {
                messages.put("ageMsg", "funny");
            }
        }

        return messages;
    }

    @Override
    public String toString() {
        return "RequestForm[ firstName=" + firstName + ",lastName=" + lastName + ",age=" + age + " ]";
    }
}
