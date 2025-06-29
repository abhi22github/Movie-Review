# 🎬 Movie-Review Application

This is a **Java Swing GUI application** for collecting user preferences about movies.  
The user provides their **name**, selects a **movie language**, and chooses a **genre**.  
The application validates the input, displays a personalized welcome message, and processes the user’s preferences using placeholder logic.

---

## ✅ Features

- **User Input Form:**
  - Enter your name.
  - Select a movie language (e.g., English, Tamil, etc.).
  - Choose a genre (e.g., Comedy, Sci-Fi, etc.).

- **Validation:**
  - Ensures all fields are filled before submission.
  - Shows error dialogs if any input is missing.

- **Personalized Welcome:**
  - Displays a custom welcome message with the user’s name after successful input.

- **Preference Processing:**
  - Based on the selected language and genre, the application triggers specific placeholder classes or methods.
  - Example: selecting *English* and *Comedy* might call an `EngCom` class.

- **Error Handling:**
  - Handles invalid or missing selections gracefully with meaningful messages.
  - Ensures the app doesn’t crash with bad input.

---

## 🛠️ Tech Stack

- **Java SE:** Core Java
- **Java Swing:** For building the entire GUI (forms, buttons, combo boxes, dialogs).
- **Object-Oriented Programming:** Used to organize language & genre-specific actions with placeholder classes.

---

## 🗃️ Project Structure

- `MovieReviewMain.java` – Main class with the Swing GUI.
- `engCom.java` – Example placeholder class for English Comedy actions.
- `tamSci.java` – Example placeholder class for Tamil Sci-Fi actions.
- *Add other language-genre classes as needed.*

---

## ⚙️ How to Run

1. Ensure you have **Java JDK 17+** installed.
2. Compile the Java files:
   ```bash
   javac MovieReviewMain.java engCom.java tamSci.java
