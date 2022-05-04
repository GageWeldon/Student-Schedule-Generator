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

public class TraditionalCourse extends Course {
    
    private String days;
    private String room;
    private LocalTime start;
    private LocalTime stop;

    @Override
    public boolean conflictsWith(Course c) {
        
        boolean conflicts = false;
        boolean sharesDay = false;
        
        if (c instanceof TraditionalCourse) {
            
            TraditionalCourse t = (TraditionalCourse)(c);
            
            for ( int i = 0; i < this.days.length(); ++i ) {
                
                for ( int j = 0; j < t.days.length(); ++j ) {
                    
                    if ( days.charAt(i) == t.days.charAt(j) ) {
                        
                        sharesDay = true;
                        
                    }
                    
                }
                
            }
            
            if ( sharesDay ) {
                
                if (
                        /* Starts Before and Ends During or After */
                        
                        ( start.isBefore( t.start) &&
                          stop.isAfter( t.start ) ) ||
                        
                        /* Starts During and Ends After */

                        ( start.equals( t.start ) &&
                          stop.isAfter(t.stop)) ||
                        
                        /* Starts During and Stops During */

                        ( start.equals( t.start ) &&
                          stop.equals( t.stop ) ) ||
                        
                        
                        /* Starts or Stops At The Same Time */

                        ( start.equals( t.start ) ||
                          stop.equals( t.stop ) )
                        
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
           Output Format Example: "#21712: CS 201-001 (Introduction to Information \
           Technology), Cynthia Gunter Jensen, Lecture, 08:45 - 09:45, MWF, Ayers \
           Hall 359"
        */
        
        StringBuilder s = new StringBuilder();
        
        s.append("#").append(crn).append(": ");
        s.append(number).append('-').append(String.format("%03d", section)).append(' ');
        s.append('(').append(name).append(")");
        s.append(", ").append(instructor);
        s.append(", ").append(type);
        s.append(", ").append(start).append(" - ").append(stop).append(", ").append(days);
        s.append(", ").append(room);
        
        return ( s.toString() );
        
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public void setStop(LocalTime stop) {
        this.stop = stop;
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
