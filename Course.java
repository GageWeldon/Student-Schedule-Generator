/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentschedulegenerator;

/**
 *
 * @author Gagew
 */
public abstract class Course {
    
    protected String name;
    protected int crn;
    protected String number;
    protected int section;
    protected int credits;
    protected String instructor;
    protected String type;

    public int getCrn() {
        return crn;
    }

    public String getNumber() {
        return number;
    }
    
    public abstract boolean conflictsWith(Course c);
    
}
