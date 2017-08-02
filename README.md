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

### Feedback
https://trello.com/invite/b/9QTLgFRZ/ddbdbdc4a703f1b72f6570704c76ad23/bootcamp

### Activity 1
Open in browser https://github.com/KristineK/new_project
(the link should have also send send to you via email)

Try:
1) Running [Sample1](../master/src/selenium/sample1/Sample1.java) as jUnit and see output
2) Debug Sample1 with breakpoints
3) Change the URL, run and see how output changes
4) Commit our changes to git in our branch (<name_surname>) (see summary step 5 above)

### Activity 2
Create new “Sample2.java”Note page to use “Page Examples” -> “Locators” (https://kristinek.github.io/test-sample/examples/loc)
Create a  new test method:
1) findElementByID (where you find element by id “heading” and then printout the text of this element)  // "Base page"
2) findElementByName (where you find element by name “randomButton” and then printout “value” attribute of this element)  // "This is a button"
3) findElementByTagName (where you find element by tagName “h1” and then printout “id” attribute of this element)  // "heading"
4) findElementByClassFirst (where you find element by className “text” and then printout the text of this element) // "sample text 1"
5) findElementByClassAll (where you find elements by className “text” and then printout number of elements // 5the text of this elements  // “sample text 1”; “sample text 2”; “unbelievable sample text”; “amazing sample text”; “dummy text”3rd element) // "unbelievable sample text"
6) findElementByXPath (where you find element by xpath “//div[@id='nonStandartText']/*[contains(@class, 'amazing')]” and then printout the text of this element // amazing sample textwhere you find element by xpath “//p[@class='text' and @id='dummy']” and then printout the text of this element) // dummy text
7) findElementByCssName  (where you find element by css “div#nonStandartText > .amazing” and then printout the text of this element // amazing sample textwhere you find element by css “.text#dummy” and then printout the text of this element) // dummy text

Push all your changes to git

All implementation: [Sample2.java](../master/src/selenium/sample2/Sample2.java)
Small test: https://goo.gl/forms/6AZsHBnvBPkfjuOp2
