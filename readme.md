
## H2 console

    Adress: http://localhost:8080/h2-console/
    JDBC:   jdbc:h2:mem:testdb
    Login:  sa
    
    
## GitHub reminders

[What is GitHub](https://www.youtube.com/watch?v=HwrPhOp6-aM)

[GitHub + Git Foundations](https://www.youtube.com/watch?v=w3jLJU7DT5E)

[Fork](https://help.github.com/articles/fork-a-repo/)
[Sync a fork](https://help.github.com/articles/syncing-a-fork/)


## IntelliJ tricks

- Usefull info in Status bar :

    - File Encoding
    - Line Separators
    - Git branch

- Default file encoding :
    
    File -> Settings... -> Editors -> File Encodings
    
    Verify Global, Project and .properties
    
- Reset IntelliJ :

    File -> Invalidate Caches / Restart

- After changing JAVA location (version) :  

    File -> Project Structure... -> Platform Settings -> SDKs

- Auto Import :

    Add unambiguous imports on the fly in  
File -> Settings > Editor > General > Auto Import
https://stackoverflow.com/questions/31211842/any-way-or-shortcut-to-auto-import-the-classes-in-intellij-idea-like-in-eclips

- Organize imports

    `CTRL + ALT + O`
    
- Prevent opening last project :

    Settings -> Appearance & Behaviour -> System Settings -> Reopen last project on startup

- Multiple project support :

    In Maven Project view click + and select parent `pom.xml`
    https://stackoverflow.com/questions/8774024/intellij-working-on-multiple-projects
    
    File -> New -> Project... (Will open new IntelliJ window)  
    Project -> New -> Module (Will add the module in same project window)  
    Module VS Project
    https://intellij-support.jetbrains.com/hc/en-us/community/posts/206887325-Difference-between-project-and-module
    
- New project with built-in spring :

    File -> New -> Project... -> Spring Initializr 

- Templates / Snippets

    File -> Settings -> Editor -> Live Templates
    https://stackoverflow.com/questions/38992114/system-out-println-shortcut-on-intellij-idea

- Show all shortcuts for current context

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
    
- VCS operations popup  
    ``ALT + ` `` (back quote)
    
- Compiler options (automatic build)
    https://stackoverflow.com/questions/12744303/intellij-idea-java-classes-not-auto-compiling-on-save
    - Saving a file does not automatically rebuilt
    - Compiler  
        File -> Settings... -> Build, Execution, Deployment -> Compiler -> Build project Automatically
    - Enable Automake when the application is running
      Press: `ctrl + shift + A`  
      Type: Registry  
      Find the key `compiler.automake.allow.when.app.running` and enable it or click the checkbox next to it
    - File -> Settings... -> Build, Execution, Deployment -> Compiler -> Annotations Processor -> Enable Annotation Processing

- Plugins  
    File -> Settings... -> Plugins -> Browse repositories...
    
    - Lombok
    - Axis TCP Monitor
    
- Cygwin as shell for Terminal
    
    File -> Settings... -> Tools -> Terminal -> Shell path.
    
    ```C:\cygwin64\bin\bash.exe```