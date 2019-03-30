### Setup
1. In IDEA open project `new_project` from "C:/Users/Student/Desktop/new_project"
2. In IDEA check in project structure, that:
   * Project has Project SDK: 1.8
   * Modules has "new_project" with "src" folder selected as "Sources"
   * Libraries has all the jars from "lib" folder:
     * hamcrest-core-1.3
     * junit-4.12
     * selenium-server-standalone-3.4.0
3. Pull the latest changes:
   ![Alt text](img/git_pull.png?raw=true "git pull via IDEA")
5. Create a branch:
   ![Alt text](img/git_new_branch_1.png?raw=true "git new branch 1 via IDEA")
   ![Alt text](img/git_new_branch_2.png?raw=true "git new branch 2 via IDEA")
   ![Alt text](img/git_new_branch_3.png?raw=true "git new branch 3 via IDEA")

Note: replace branch_name with your name and surname (NO SPACES)

---
### How to add, commit and push changes to 
Open git bash from project folder (new_project) and do:
   ![Alt text](img/git_add.png?raw=true "git add via IDEA")
   ![Alt text](img/git_commit_1.png?raw=true "git commit 1 via IDEA")
   ![Alt text](img/git_commit_2.png?raw=true "git commit 2 via IDEA")
   ![Alt text](img/git_commit_3.png?raw=true "git commit 3 via IDEA")
   ![Alt text](img/git_push_1.png?raw=true "git push 1 via IDEA")
   ![Alt text](img/git_push_2.png?raw=true "git push 2 via IDEA")
   
Note: replace branch_name with your name and surname (NO SPACES)
  
---
### Feedback

---
### Samples and SampleTask so far...
* Opening a page and printing out url/page title:
    * [Sample1.java](../master/src/selenium/sample/Sample1.java)
    * [Sample1Task.java](../master/src/selenium/sample/Sample1Task.java)

---
### Bonuses in case of boredom
* Driver Navigation:
    * [extra1.java](../master/src/selenium/sample/extra/extra1.java)
    * [extra1Task.java](../master/src/selenium/sample/extra/extra1Task.java)
* Using different browsers:
    * [extra2.java](../master/src/selenium/sample/extra2.java)
    * [extra2Task.java](../master/src/selenium/sample/extra2Task.java)
 * Calendar picker:   
    * [Sample7Task.java](../master/src/selenium/sample/Sample7Task.java) -> `chooseDateViaCalendarBonus()` and `chooseDateViaTextBoxBonus()`
 * Page Object + Page Factory:
    * [Task3Bonus.java](../master/src/selenium/tasks/Task3Bonus.java)
    
---
### Switching to Cucumber project
1. open Idea
2. File -> New -> Project from version control -> git 
2. enter page https://github.com/KristineK/cucumber_project
4. click save
5. open in browser https://github.com/KristineK/cucumber_project
6. do "In IDEA check in project structure, that: Project settings" and  "In IDEA check in project structure, that: Modules settings"
