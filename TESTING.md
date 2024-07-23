# EduTrack Testing Documentation

## Test Suites and Test Cases

### Use Case 1: User Signup and Login

#### Scenario: A user signs up for the system and then logs in.

| Steps | Description |
|-------|-------------|
| 1.    | **A:** User signs up with valid credentials. |
| 2.    | **S:** System validates the credentials. |
| 3.    | **A:** User logs in with the credentials. |
| 4.    | **S:** System validates the login and allows access. |

### Use Case 2: User Profile Update

#### Scenario: A user logs in and updates their profile information.

| Steps | Description |
|-------|-------------|
| 1.    | **A:** User logs in with valid credentials. |
| 2.    | **S:** System validates the login. |
| 3.    | **A:** User updates the profile information. |
| 4.    | **S:** System validates and saves the new profile information. |

### Use Case 3: User Logout

#### Scenario: A user logs out from the system.

| Steps | Description |
|-------|-------------|
| 1.    | **A:** User logs in with valid credentials. |
| 2.    | **S:** System validates the login. |
| 3.    | **A:** User logs out. |
| 4.    | **S:** System logs out the user and ends the session. |

### Use Case 4: User Account Deletion

#### Scenario: A user deletes their account.

| Steps | Description |
|-------|-------------|
| 1.    | **A:** User logs in with valid credentials. |
| 2.    | **S:** System validates the login. |
| 3.    | **A:** User deletes the account. |
| 4.    | **S:** System removes the user's account. |

## Detailed Testing Documentation

For a detailed breakdown of the testing methodologies and individual test cases, refer to the following documents:

1. **Path Testing**: [PathTesting.docx](https://github.com/bilalalissa/ENSE375-SS24-Project/blob/main/04-Final%20Design%2C%20Implementation%20and%20Testing/Testing/DataFlowTestingForUserManager.docx)
2. **Data Flow Testing**: [DataFlowTestingForUserManager.docx](DataFlowTestingForUserManager.docx)
3. **Logic Coverage Testing**: [LogicCoverageTestingForUserManager.docx](LogicCoverageTestingForUserManager.docx)
4. **Integration Testing**: [IntegrationTesting.docx](IntegrationTesting.docx)
5. **Boundary Value Testing**: [BoundaryValueTest.docx](BoundaryValueTest.docx)
6. **Equivalence Class Testing**: [EquivalenceClassTesting.docx](EquivalenceClassTesting.docx)
7. **Decision Table Testing**: [DecisionTablesTesting.docx](DecisionTablesTesting.docx)
8. **State Transition Testing**: [StateTransitionTesting.docx](StateTransitionTesting.docx)
9. **Use Case Testing**: [UseCaseTesting.docx](UseCaseTesting.docx)

These documents provide comprehensive details on each type of testing applied to the EduTrack application, including specific test cases, results, and any identified issues.
