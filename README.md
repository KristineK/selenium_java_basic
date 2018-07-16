### Setup
1. On C:/ create new folder "bootcamp"
2. In folder Desktop open git bash and fo: `git clone https://github.com/KristineK/new_project.git`
3. In IDEA open project `new_project` from "C:/Users/Student/Desktop/new_project"
4. In IDEA check in project structure, that:
   * Project has Project SDK: 1.8
   * Modules has "new_project" with "src" folder selected as "Sources"
   * Libraries has all the jars from "lib" folder:
     * hamcrest-core-1.3
     * junit-4.12
     * selenium-server-standalone-3.4.0
5. In git bash do `git checkout -b branch_name`

Note: replace branch_name with your name and surname (NO SPACES)

---
### How to add, commit and push changes to 
Open git bash from project folder (new_project) and do:
   * `git add  src/selenium/sample1/Sample1.java` for adding 1 file or `git add .` for all the changes files
   * `git commit -m "increase sleep"`
   * `git push origin branch_name`
   
Note: replace branch_name with your name and surname (NO SPACES)
  
### How to switch to your branch from other laptop
1. open git bash where you would like to open have project (see step 1 in setup)
2. clone project (see step 2 in setup)
3. write in bash:
```
git fetch origin
git checkout -b branch_name origin/branch_name
git pull
```

Note: if you are pushing from 2 laptops, after push on one laptop, do pull on the other before making any changes (or be ready for git conflics, which you will google how to resolve)

---
### Feedback

---
### Samples and SampleTask so far...
* Opening a page and printing out url/page title:
    * [Sample1.java](../master/src/selenium/sample/Sample1.java)
    * [Sample1Task.java](../master/src/selenium/sample/Sample1Task.java)
* Locators (id, class, name):
    * [Sample2.java](../master/src/selenium/sample/Sample2.java)
    * [Sample2Task.java](../master/src/selenium/sample/Sample2Task.java)
* Asserts:
    * [Sample3.java](../master/src/selenium/sample/Sample3.java)
    * [Sample3Task.java](../master/src/selenium/sample/Sample3Task.java)
* Actions (click, send keys):
    * [Sample4.java](../master/src/selenium/sample/Sample4.java)
    * [Sample4Task.java](../master/src/selenium/sample/Sample4Task.java)
* Alerts:
    * [Sample5.java](../master/src/selenium/sample/Sample5.java)
    * [Sample5Task.java](../master/src/selenium/sample/Sample5Task.java)
* Locators (xPath, CSS):
    * [Sample6.java](../master/src/selenium/sample/Sample6.java)
    * [Sample6Task.java](../master/src/selenium/sample/Sample6Task.java)
* Actions (checkbox, radio button and option selector) + bonus of calendar:
    * [Sample7.java](../master/src/selenium/sample/Sample7.java)
    * [Sample7Task.java](../master/src/selenium/sample/Sample7Task.java)
* Styles:
    * [Sample8.java](../master/src/selenium/sample/Sample8.java)
    * [Sample8Task.java](../master/src/selenium/sample/Sample8Task.java)
* Waits:
    * [Sample9.java](../master/src/selenium/sample/Sample9.java)
* Into to Page Object:    
    * [Sample10.java](../master/src/selenium/sample/Sample10.java)
    * [GenericPageSample.java](../master/src/pages/GenericPageSample.java)
    * [MainPageSample.java](../master/src/pages/MainPageSample.java)
    * [PageSample.java](../master/src/pages/PageSample.java)
    
---
### Individual Tasks:
* Tasks:
    * [Task1.java](../master/src/selenium/tasks/Task1.java)
    * [Task3.java](../master/src/selenium/tasks/Task3.java)

#### Test on locators

---
### Bonuses in case of boredom
* Driver Navigation:
    * [extra1.java](../master/src/selenium/sample/extra/extra1.java)
    * [extra1Task.java](../master/src/selenium/sample/extra/extra1Task.java)
* Using different browsers:
    * [extra2.java](../master/src/selenium/sample/extra2.java)
    * [extra2Task.java](../master/src/selenium/sample/extra2Task.java)
* Wait:
    * [Task2.java](../master/src/selenium/tasks/Task2.java) -> `loadGreenAndBlueBonus()`
 * Calendar picker:   
    * [Sample7Task.java](../master/src/selenium/sample/Sample7Task.java) -> `chooseDateViaCalendarBonus()` and `chooseDateViaTextBoxBonus()`
 * Page Object + Page Factory:
    * [Task4.java](../master/src/selenium/tasks/Task4.java)
    
---
### Switching to Cucumber project
1. open git on Desktop (but your project) and do:
``git clone https://github.com/KristineK/cucumber_project.git``
2. see set-up from page https://github.com/KristineK/cucumber_project
