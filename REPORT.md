# EduTrack Project Report

## 1. Introduction

EduTrack is an application designed to manage users, courses, tasks, and schedules efficiently. The primary objective is to provide a comprehensive tool for managing educational activities, enhancing productivity, and ensuring effective organization of academic responsibilities.

## 2. System Overview

The system comprises several key components:
- **UserManager**: Manages user signup, signin, logout, profile updates, and account deletion.
- **CourseManager**: Manages courses including adding, updating, deleting, and searching courses.
- **TaskManager**: Handles tasks related to courses.
- **ScheduleManager**: Manages daily, weekly, monthly, and semester schedules.
- **ExportManager**: Facilitates the export of user, course, and schedule information.

## 3. Implementation

### 3.1 User Management
The `UserManager` class is responsible for handling all user-related operations such as signup, signin, logout, updating profiles, and deleting accounts.

### 3.2 Course Management
The `CourseManager` class manages course-related activities including adding new courses, updating existing courses, deleting courses, and searching for courses.

### 3.3 Task Management
The `TaskManager` class handles tasks associated with courses, including adding, updating, deleting tasks, and listing tasks by course.

### 3.4 Schedule Management
The `ScheduleManager` class manages different schedules (daily, weekly, monthly, semester) and provides methods to view these schedules.

### 3.5 Export Management
The `ExportManager` class enables the export of user, course, and schedule information to external files.

## 4. Flow Chart

Refer to the document: [EduTrack Application Flow Chart](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/EduTrackAppFlowChart.png)

## 5. Team Work 
Since this is a group project, you must have a fair distribution of tasks among yourselves. To this end, you must hold meetings to discuss the distribution of tasks and to keep a track of the project progress.
Task Assignments:
**Poojan Patel**
  Task 1: Problem Definition and Design Requirements
  ●	Write the detailed problem definition section.
  ●	Research and document statistics supporting the problem.
  ●	Define the design requirements including functions, objectives, and constraints.
  Task 4: Components and Features
  ●	Document the components used in the solution.
  ●	Describe the features and constraints satisfied by the solution.
  ●	Provide a block diagram representing the connectivity and interaction between components.
  Task 7: Conclusion and Future Work
  ●	Summarize the achievements of the project.
  ●	Document the design functions, objectives, and constraints achieved.
  ●	Provide recommendations for future design improvements.
  
**Pruthvi Patel**
  Task 2: Solution Descriptions
  ●	Write detailed descriptions for Solution 1 and Solution 2.
  ●	Explain why these solutions were not selected.
  Task 5: Final Solution and Environmental, Societal, Safety, and Economic Considerations
  ●	Write a detailed description of the final solution.
  ●	Document the environmental, societal, safety, and economic considerations for the project.
  Task 8: References and Appendices
  ●	Compile all references using IEEE reference style.
  ●	Gather and organize any additional information for the appendix section.

**Bilal Alissa**
  Task 3: Testing and Limitations
  ●	Design test cases and document the testing methodology used.
  ●	Execute test cases and document the results.
  ●	Describe the limitations of the current solution.
  Task 6: Team Work and Project Management
  ●	Document the meeting details including agendas and task distributions.
  ●	Create a Gantt chart showing the progress of the project.
  ●	Identify the critical path and slack time for each task.
  Task 9: Verify and Review
  ●	Review all sections for consistency and completeness.
  ●	Ensure that the document flows logically and all parts are well-integrated.
  ●	Make final edits and prepare the document for submission.

**5.1	Meeting 1**
Time:  May 22, 2024, 10:00 AM to 11:00 AM
Agenda: Distribution of Project Tasks

| Team Member Name  | Previous Task  | Completion Task  | Next Task  |
|------------|------------|------------|
| Poojan Patel | N/A | N/A | Task 1 |
| Pruthvi Patel |N/A | N/A | Task 2 |
| Bilal Alissa |N/A | N/A | Task 3 |

  
## 5. Testing

### 5.1 Test Cases and Results

Testing for the EduTrack application includes various methodologies like path testing, data flow testing, logic coverage testing, integration testing, boundary value testing, equivalence class testing, decision table testing, state transition testing, and use case testing. The detailed test cases and results are documented in the following sections:

#### 5.1.1 Path Testing
Refer to the document: [PathTesting.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/PathTesting.pdf)

#### 5.1.2 Data Flow Testing
Refer to the document: [DataFlowTestingForUserManager.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/DataFlowTestingForUserManager.pdf)

#### 5.1.3 Logic Coverage Testing
Refer to the document: [LogicCoverageTestingForUserManager.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/LogicCoverageTestingForUserManager.pdf)

#### 5.1.4 Integration Testing
Refer to the document: [IntegrationTesting.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/IntegrationTesting.pdf)

#### 5.1.5 Boundary Value Testing
Refer to the document: [BoundaryValueTest.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/BoundaryValueTest.pdf)

#### 5.1.6 Equivalence Class Testing
Refer to the document: [EquivalenceClassTesting.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/EquivalenceClassTesting.pdf)

#### 5.1.7 Decision Table Testing
Refer to the document: [DecisionTablesTesting.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/DecisionTablesTesting.pdf)

#### 5.1.8 State Transition Testing
Refer to the document: [StateTransitionTesting.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/StateTransitionTesting.pdf)

#### 5.1.9 Use Case Testing
Refer to the document: [UseCaseTesting.pdf](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/UseCaseTesting.pdf)

## 6. Conclusion and Future Work

●	Conclusion: In this project, we successfully designed and developed EduTrack, a Java-based academic planner that meets the functional, objective, and constraint requirements outlined at the project's start. The application includes features for organizing, tracking, notifying, analyzing, personalizing, and integrating academic activities. By focusing on software testing and validation, we ensured a reliable and user-friendly solution. Our structured engineering design process and rigorous testing methodologies, including boundary value testing, equivalence class testing, and use case testing, helped deliver a robust application aimed at improving students' academic performance through better time management and study habits.

●	Future Work: Given the limitations of the current solution, future design improvements could include:
  1.	Implementing persistent storage to retain user data across sessions.
  2.	Enhancing scalability to handle larger datasets and more concurrent users.
  3.	Integrating with other academic and productivity tools like Learning Management Systems (LMS) and email clients.
  4.	Adding engaging features such as gamification elements, progress rewards, or social sharing options to increase user 
      motivation and consistent usage.
  5.	Improving Task Management: Future versions could focus on enhancing task management features, such as adding 
      reminders, task prioritization, and better user interfaces for task tracking.
  6.	Improving Schedule Management: Enhancing the schedule management system with features like calendar integration, 
      automatic reminders, and a more user-friendly interface could greatly improve user experience.


## 7. References

  1. https://psycnet.apa.org/record/2018-35570-001
  2. https://cew.georgetown.edu/cew-reports/workinglearners/

## 8. List of Figures

| Name of Figure   | Page Number   |
|------------|------------|
| Figure 1 | 13 |
| Figure 2 | 17 |
| Figure 3 | 19 |
| Figure 4 | 34 |
| Figure 5 | 59 |
| Figure 6 | 63 |
| Figure 7 | 68 |


## 9. List of Tables

| Title   | Page Number   |
|------------|------------|
| Table 1 (Test Case Table) | 40 |
| Table 2 (Valid Cases Table (Weak Normal ECT))	 | 46 |
| Table 3 (Valid Cases Table (Strong Normal ECT))	 | 46 |
| Table 4 (Invalid Cases Table (Weak Robust ECT))	 | 47 |
| Table 5 (Invalid Cases Table (Strong Robust ECT))	 | 48 |
| Table 6 (Example Combinations) | 51 |
| Table 7 (Decision Table) | 52 |
| Table 8 (State Transition Table) | 55 |
| Table 9 (Use Case 1: User Signup and Login)	 | 61 |
| Table 10 (Use Case 2: User Profile Update)	 | 61 |
| Table 11 (Use Case 3: User Logout)	 | 61 |
|Table 12 (Use Case 4: User Account Deletion)	 | 62 |
|Table 13 (Meeting 1) | 67 |
| Table 14 (Meeting 2) | 67 |
|Table 15 (Meeting 3) | 68 |
| Table 16 (Meeting 4) | 68 |
