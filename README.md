# Movie-Review
This Java program creates a Swing-based GUI application for collecting user preferences about movies. The user provides their name, selects a movie language, and chooses a genre. The application validates the inputs, displays a personalized welcome message, and processes the user's preferences. Based on the selected language and genre, specific actions are triggered using placeholder classes (e.g., `engCom`, `tamsci`, etc.).

Additionally, the application connects to a MySQL database to store the user's input (name, language, genre) in a table named `list`. If there is an error during the database operation, it handles the exception gracefully and notifies the user.
