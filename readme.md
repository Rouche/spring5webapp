
## H2 console

    Adress: http://localhost:8080/h2-console/
    JDBC:   jdbc:h2:mem:testdb
    Login:  sa
    
    
## GitHub reminders

[What is GitHub](https://www.youtube.com/watch?v=HwrPhOp6-aM)

[GitHub + Git Foundations](https://www.youtube.com/watch?v=w3jLJU7DT5E)

## IntelliJ tricks

- Reset :
    File -> Invalidate Caches / Restart

- After changing JAVA location (version) :

    File -> Project Structure... -> Platform Settings -> SDKs

- Auto Import :

    Add unambiguous imports on the fly in
Settings > Editor > General > Auto Import
https://stackoverflow.com/questions/31211842/any-way-or-shortcut-to-auto-import-the-classes-in-intellij-idea-like-in-eclips

- Prevent opening last project :

    Settings -> Appearance & Behaviour -> System Settings -> Reopen last project on startup

- Add multiple project :

    In Maven Project view click + and select parent `pom.xml`
    https://stackoverflow.com/questions/8774024/intellij-working-on-multiple-projects
    
- New project with built-in spring :

    File -> New -> Project... -> Spring Initializr 

- Templates / Snippets

    File -> Settings -> Editor -> Live Templates
    https://stackoverflow.com/questions/38992114/system-out-println-shortcut-on-intellij-idea

- Show all shortcuts

    Ctrl + J
    https://www.jetbrains.com/help/idea/mastering-intellij-idea-keyboard-shortcuts.html

- Expand everything (method body) by default

    In the preferences (ctrl+alt+s on my machine)  
    Editor -> General -> Code Folding.  
    In there you can choose what's folded by default. In your case, you'll probably want to remove all the defaults.
    https://stackoverflow.com/questions/25083679/intellij-keeps-folding-my-code-by-default

- Git color

    File -> Settings -> Version Control -> File Status Color (changes #B8FF25)

- Reverse engineering
    https://intellij-support.jetbrains.com/hc/en-us/community/posts/206241309-Reverse-Engineering-in-Intellij-IDEA
    
- Search everywhere
    Double pres SHIFT
    https://www.jetbrains.com/help/idea/searching-everywhere.html