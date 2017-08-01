### Summary
1. On C:/ create new folder "bootcamp"
2. In folder "bootcamp" open git bash and fo: `git clone https://github.com/KristineK/new_project.git`
3. In IDEA open project `new_project` from "C:/bootcamp/new_project"
4. In IDEA check in project structure, that:
   * Project has Project SDK: 1.8
   * Modules has "new_project" with "src" folder selected as "Sources"
   * Libraries has all the jars from "lib" folder:
     * hamcrest-core-1.3
     * junit-4.12
     * selenium-server-satndalone-3.4.0
5. In git bash do `git checkout -b "<name_surname>"` 
Note: replace <name_surname> with your name and surname
6. In IDEA go to Sample1.java and change line 27 to `Thread.sleep(50000);`
5. In git bash do 
   * `git add  src/selenium/sample1/Sample1.java`
   * `git commit -m "increase sleep"`
   *  `git push origin <name_surname>` 
   Note: replace <name_surname> with your name and surname

### Jar and chrome driver resources:
* http://docs.seleniumhq.org/download/
* https://sites.google.com/a/chromium.org/chromedriver/downloads
* <http://search.maven.org/#search|gav|1|g:"org.hamcrest" AND a:"hamcrest-core">
* https://sites.google.com/a/chromium.org/chromedriver/downloads
