# Student-Schedule-Generator
Project that simulates a schedule generator for students.

This project has classes for the course identification, online courses, traditional courses, the main project class, and a csv file that contains the different courses offered to take. 

The course class initializes the course with parameters: name, crn, number, section, credits, instructor, and type. 

The OnlineCourse class extends from the Course class with parameters: days, room, start and stop. This class checks if there is a conflict with another course already on the student schedule. The toString function outputs the information in a readable way. 

The TraditionalCourse class extends the Course class with the same parameters as OnlineCourse. This class checks to see if there is a conflict with another course on the current schedule. The toString function outputs the information into a readable format. 

The main class Project1 takes in the csv file of courses and then accepts user input to search for courses, register for a course, view trial schedule, and quit. Depending on the user's choice of course number, the main function searches the course list and adds it to the trial schedule. If the course classes detect a conflict, the main function alerts the user of the conflict. 
