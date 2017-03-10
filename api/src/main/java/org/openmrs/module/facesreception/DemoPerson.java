package org.openmrs.module.facesreception;

import java.util.Date;

/**
 * Created by root on 3/10/17.
 */
public class DemoPerson {

    private int personID;
    private String personName;
    private Date DOB;
    private String gender;



    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
