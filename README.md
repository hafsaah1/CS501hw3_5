# CS501 - Homework 3 - Question 5: Themed Form with Validation

This is a simple Android app that shows a basic login form. It was built using Jetpack Compose and demonstrates fundamental concepts like state management, input fields, and Material 3 theming as covered in the lecture.

## How to Use the App

1.  **Run the App**: When you launch the app, you will see a simple login screen with fields for "Username" and "Password," and a "Submit" button.

2.  **Test the Validation**: Click the "Submit" button without typing anything in the fields.
    * You will see the borders of the text fields turn red.
    * An error message ("Username cannot be empty" or "Password cannot be empty") will appear below each empty field.

3.  **Enter Text**: Start typing in the username and password fields. As you type, the red error indicators will disappear.

## Explanation of the App

This app is built around a few core Jetpack Compose concepts from the lecture:

* **Layout**: The form is organized using a `Column`, which stacks the title, text fields, and button vertically on the screen (as seen on slide 8).

* **Input Fields (`TextField`)**: The app uses `OutlinedTextField` for both username and password entry. These are standard Material 3 components for user input (mentioned on slide 43).

* **State Management**: The app uses `remember { mutableStateOf("") }` to keep track of the text the user types into each field. It also uses separate `remember` blocks for boolean flags (`isUsernameError`, `isPasswordError`) to control when to show validation errors.

* **Material 3 Theming**: The form is styled using `MaterialTheme` (slides 35-41).
    * The title's font comes from `MaterialTheme.typography`.
    * The colors of the text fields, button, and the red error indicators are all pulled directly from the app's `ColorScheme`. This is why we don't have to manually set any colors.

* **Validation Logic**: The validation is handled inside the `Button`'s `onClick` function. It simply checks if the `username` or `password` state is blank. If it is, it sets the corresponding error state (e.g., `isUsernameError = true`), which causes the UI to recompose and show the error styling on the `OutlinedTextField`.
