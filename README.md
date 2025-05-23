Link To Youtbe Video - https://youtube.com/shorts/2OwNWpSBDWA?feature=share


Link To Github repository- https://github.com/DaffyDuck2005/Assignment2.git

Report:

The primary purpose of this Android application is to provide users with an interactive quiz experience, focused on a specific subject (initially "History"). The app aims to:
Test User Knowledge: Present a series of true/false questions to the user, allowing them to test their understanding of the subject matter.
Provide Immediate Feedback: Inform users whether their selected answer is correct or incorrect for each question.
Calculate and Display Score: After completing the quiz, calculate the user's total score and display it, along with a percentage and a qualitative response based on their performance.
Allow Review of Questions: Offer users the ability to review all the questions from the quiz, showing the question text and the correct answer. This reinforces learning by allowing users to see where they went right or wrong.
Offer a Simple User Interface: Provide a clear and straightforward navigation flow, making it easy for users to start the quiz, answer questions, view their score, review answers, and exit the application. The app serves as an educational tool, a means of self-assessment, and potentially a fun way to engage with a particular topic. 2. Design Considerations Several design considerations were taken into account during the development of this application, focusing on user experience (UX), app architecture, and code maintainability:
User Flow and Navigation:
Linear Progression: The primary flow is linear: Main Screen (optional, could be directly to Questions) -> Questions -> Score Screen -> Review (optional) -> Exit.
Clear Calls to Action: Buttons like "Start Quiz," "True," "False," "Next Question," "Review," and "Exit" are used to guide the user.
Activity-Based Navigation: The app uses multiple Android Activities (MainActivity, Questions, ScoreScreen, Review) to separate distinct screens and functionalities. Intents are used for navigation between these activities.
User Interface (UI) Design:
Simplicity: The UI aims for simplicity, using standard Android UI components like TextView for displaying text (questions, answers, scores) and Button for user interaction.
Layouts: ConstraintLayout or LinearLayout (implicitly, as no specific layout managers were discussed, but these are common) are likely used to arrange UI elements on each screen.
Feedback Visibility:
Immediate feedback for answers (e.g., "Correct!", "Incorrect!") is crucial for a good quiz experience.
The final score and qualitative response are prominently displayed.
During review, both the question and the correct answer are shown.
State Management:
The current question index is managed to iterate through the questions.
The user's score is accumulated.
The visibility of UI elements (e.g., hiding score/response on ScoreScreen after review) is managed based on application state.
App Architecture (Implicit):
Separation of Concerns (Basic): Different activities handle different aspects of the app (questions, scoring, review). This is a fundamental architectural principle [4].
Data Flow:
Quiz questions and answers are defined (currently hardcoded, but could be fetched from a local database or remote server in a more advanced version).
The user's score is passed from the Questions activity to the ScoreScreen activity via Intent extras.
The list of questions (if needed for review) would ideally be passed from Questions to ScoreScreen and then to Review.
Activity Result API: Used for communication back from the Review activity to the ScoreScreen to trigger UI changes (hiding score/response text). This is a modern Android pattern replacing the older startActivityForResult/onActivityResult.
Data Handling:
Question Structure: A data class (e.g., Question or QuestionAnswer) is used to represent individual questions and their answers, promoting type safety and organization.
Question Storage: Currently, questions are hardcoded within the activities. For a more scalable app, this data would ideally be externalized (e.g., SQLite database, JSON file, or a backend API).
Code Maintainability and Readability:
Meaningful Variable Names: Efforts were made to use descriptive names for variables and functions (e.g., finalScore, totalQuestions, reviewQuestionTextView).
Comments: Comments are used to explain parts of the code.
Modularity (Basic): Functions like loadAndDisplayQuestion() and loadAndDisplayReviewQuestion() encapsulate specific logic.
Error Handling (Basic):
A check for totalQuestions > 0 before calculating the percentage to prevent division by zero errors.

What You Need:

To use this app, you'll need:
*   An Android phone or an Android emulator (a way to run Android apps on your computer).
*   To install the app on your phone or emulator.

 Author
Pranav Mahabeer


![image](https://github.com/user-attachments/assets/4202ad74-57c1-47a5-8771-e86b5fc9f496)
![image](https://github.com/user-attachments/assets/b478673b-77d9-4236-82b3-d0b18aeac6c0)
![image](https://github.com/user-attachments/assets/f6c8bd4b-526e-478e-b0f7-ca3cc9db7b23)
![image](https://github.com/user-attachments/assets/e4e2865e-ce38-4e5b-9c81-963697e4516b)
![image](https://github.com/user-attachments/assets/812a0cd9-55ad-4891-ab26-609831069f36)
![image](https://github.com/user-attachments/assets/a41f53f2-f88a-4147-91e2-583be5276cc7)












