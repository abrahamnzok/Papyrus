# Papyrus

School project made by Abrahamnzok (Abraham MUBANZO) and Luctum (Hugo PALLA).

The goal of this project is to implement some Design Patterns seen in the ACO module of M1 MIAGE.

The project takes the form of a text editor declined in 3 versions.

We made the UI with JavaFX.

This project Require Mockito test library and Java8.

What it does :
- Insert, Select, Copy, Paste and Cut characters
- Register a sequence of Commands as a Macro and replay it in the same order.
- Undo and Redo actions multiple times.

What it does not :
- Use keyboard shortcuts
- Delete multiple characters at a time.

Even if we made the binding between the Delete function and Del / Backspace keys, we hightly recommend to only use the buttons on the UI.
