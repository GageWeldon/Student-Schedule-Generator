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
import java.time.LocalTime;
public class OnlineCourse extends Course {
    private String days;
    private String room;
    private LocalTime start;
    private LocalTime stop;

    @Override
    public boolean conflictsWith(Course c) {
        
        boolean conflicts = false;
        boolean sharesDay = false;
        
        if (c instanceof OnlineCourse) {
            
            OnlineCourse o = (OnlineCourse)(c);
            
            for ( int i = 0; i < this.days.length(); ++i ) {
                
                for ( int j = 0; j < o.days.length(); ++j ) {
                    
                    if ( days.charAt(i) == o.days.charAt(j) ) {
                        
                        sharesDay = true;
                        
                    }
                    
                }
                
            }
            
            if ( sharesDay ) {
                
                if (
                        /* Starts Before and Ends During or After */
                        
                        ( start.isBefore( o.start) &&
                          stop.isAfter( o.start ) ) ||
                        
                        /* Starts During and Ends After */

                        ( start.equals( o.start ) &&
                          stop.isAfter(o.stop)) ||
                        
                        /* Starts During and Stops During */

                        ( start.equals( o.start ) &&
                          stop.equals( o.stop ) ) ||
                        
                        /* Starts or Stops At The Same Time */

                        ( start.equals( o.start ) ||
                          stop.equals( o.stop ) )
                        
                ) {
                
                conflicts = true;
                
                }
            
            }
        
        }
        
        return conflicts;
        
    }
        
    
    
    @Override
    public String toString() {
        
        /* 
           Output Format Example: "#21719: CS 201-008 (Introduction to Information \
           Technology), Thomas D White, World Wide Web"
        */
        
        StringBuilder s = new StringBuilder();
        
        s.append("#").append(crn).append(": ");
        s.append(number).append('-').append(String.format("%03d", section)).append(' ');
        s.append('(').append(name).append(")");
        s.append(", ").append(instructor);
        s.append(", ").append(type);
        
        return ( s.toString() );
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCrn(int crn) {
        this.crn = crn;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setType(String type) {
        this.type = type;
    }
        
}