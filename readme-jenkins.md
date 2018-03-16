## Jenkins Config for Git
    
    Build that can create versions, tag, push and deploy

- This project is parameterized
    * [string] oldVersion : Ancienne version pour le find replace du pom.xml.
    * [string] version : New version to set.
    * [Git parameter] branch : Branch
    * [choice] mavenBuild :  
    If "deploy" build will deploy in artifactory        
    If "install" only normal build
    * [boolean] pushBranch : Push branch to origin
    * [boolean] tagVersion : Tag version and push tag to origin
    * [choice] profile : Maven profile build  
    -PmodeProduction
    * [string] branchFix : To fix the branch name between 2 uncompatible git plugins.

- Source Code Management
    * Git
    * Branches to build : ${branch}


    Build
    
- Execute system Groovy script
    * Use Groovy Sandbox
    ```
    //Script to adjust the value of ${branch} parameter listed by Git Parameter plugin.
    //Git publisher requires a branch name and remote is mendatory.
    //Both are then incompatible.
     
    import hudson.model.*
    import java.util.ArrayList;
     
    // get current thread / Executor
    def thr = Thread.currentThread()
    // get current build
    def build = thr?.executable
     
    // get parameters
    def parameters = build?.actions.find{ it instanceof ParametersAction }?.parameters
     
    String branchFixName = 'branchFix';
    ArrayList<ParameterValue> listParam = []
    StringParameterValue fix = null;
    parameters.each {
       if(it.name == 'branch') {
          fix = new StringParameterValue(branchFixName, it.value.substring(it.value.indexOf('/')+1))
          println "Branch [" + it.value + "] renamed to [" + fix + "]"
          listParam.add(it)
       } else if(it.name != branchFixName) {
          listParam.add(it)
       }
    }
     
    if(fix != null) {
       listParam.add(fix)
    }
     
    ParametersAction fixAction = new ParametersAction(listParam)
     
    // replace variable to current job
    build.replaceAction(fixAction)
    ```
- Conditional step (single)
    * Regular expression match : `\w+\.\w+\.\w+(-SNAPSHOT)?` (is it valid version number?)
    * Expression : `${version}`
    * Builder : Invoke top-level Maven targets
    * Goal : `versions:set -DnewVersion=${version} -DgenerateBackupPoms=false -U`
    
- Conditional step (single)
    * Regular expression match: `\w+\.\w+\.\w+(-SNAPSHOT)?` (is it valid version number?)
    * Expression: `${oldVersion}`
    * Builder: Execute Shell
    ```
    #!/bin/sh
    sed_string="s/${oldVersion}/${version}/g"
    echo ${sed_string}
    find . -name 'pom.xml' -exec sed -i ${sed_string} {} \;
    git add -A
    git commit -m"Jenkins commit version ${version}"
    ```

- Invoke top-level Maven targets
    * `clean ${mavenBuild} -e -B -U ${profile} -DskipTests=true`
    


    Post-build Actions
    
- Flexible publish
    * Conditional action : [boolean] ${tagVersion}
    * Action : Git publisher
    * Push Only If Build Succeeds : Y
    * Tags
        * Tag to push : `${version}`
        * Tag message : `Jenkins tag ${version}`
        * Create new tag : Y
        * Target remote name : `origin`
    * Conditional action : [boolean] ${pushBranch}
    * Action : Git publisher
    * Push Only If Build Succeeds : Y
    * Branches
        * Branch to push : `${branchFix}`
        * Target remote name : `origin`
    
    
