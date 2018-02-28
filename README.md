# Assignment: Agents: Blackjack

The goal of this assignment is to introduce you to intelligent agents, and at the same time, get you familiar with [Git](http://git-scm.com/) and [Maven](http://maven.apache.org/), which will be used for all the assignments in this course.

## Prepare for Git and Maven use

1. If it is not already installed, [install Git on your local machine](http://git-scm.com/book/en/Getting-Started-Installing-Git).

2. If it is not already installed, [install Maven on your local machine](http://maven.apache.org/download.cgi).

3. Start reading the [Git book](http://git-scm.com/book). Minimally, read Chapter 1 (Getting Started), which will teach you basic version control concepts, and Chapter 2 (Git Basics), which will teach you the most common commands.

4. Read the [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/), which will teach you how to compile and test code using Maven.

## Get a copy of the assignment template

1. Fork the repository for the current assignment, https://git.cis.uab.edu/cs-460/agents-blackjack, by following the link, typing in your CIS credentials, and clicking on the "Fork" button on the right hand side of the "CS 460 / Agents - Blackjack" page.

2. Give your instructor access to your fork. **I cannot grade your assignment unless you complete this step.** Click on `Settings`, then `Members`, then `New Project Member`. In the `People` box, search for and add the user ``bethard``. Under ``Project Access``, select ``Reporter``. Then click ``Add users``.

3. You've successfully forked the repository and granted your instructor access, but so far your repository only exists on `git.cis.uab.edu`. To be able to work on the project, you will need to clone it to your local machine. Click on the HTTPS button and observe the URL in the box that looks like `https://git.cis.uab.edu/.../agents-blackjack.git`. Run the following command, replacing `<url>` with the URL from the box:

        git clone <url>

4. You should see that a directory named `agents-blackjack` has been created and populated. Change to that directory:

        cd agents-blackjack

## Compile and test the code

1.  Compile the code. Run the following command:

        mvn clean compile

    Everything should compile and you should see a message like:

        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------

2.  Test the code. Run the following command:

        mvn clean test

    The tests should fail, and you should see a message like:

        Tests in error: 
          testTenKing(edu.uab.cis.agents.blackjack.DealerAgentTest)
          testSixJack(edu.uab.cis.agents.blackjack.DealerAgentTest)
        
        Tests run: 2, Failures: 0, Errors: 2, Skipped: 0
        
        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD FAILURE
        [INFO] ------------------------------------------------------------------------

    Note the `clean`, which ensures that Maven alone (not your development environment) is compiling your code.

## Implement your part of the code

1. If you look closely at the test failures, you will see that the problem is that `edu.uab.cis.agents.blackjack.DealerAgent.act` is throwing a `java.lang.UnsupportedOperationException`.

2. Your task is to correctly implement `edu.uab.cis.agents.blackjack.DealerAgent.act` by modifying `src/main/java/edu/uab/cis/agents/blackjack/DealerAgent.java`. **Do not modify any other files.** Your agent should implement the following rules:

   * If the total points represented by the cards are 17 or more, `act` should return `Action.STAND`. Otherwise, it should return `Action.HIT`.
   * Even if the total points represents 22 or more (which traditionally would be a "bust") you should return `Action.STAND`.
   * In calculating the total points, the order of the cards does not matter, only the point values.
   * The numeric cards always count for the equivalent number of points (TWO=2, THREE=3, ..., TEN=10).
   * JACK, QUEEN and KING always count for 10 points.
   * Each ACE may count for either 11 points or 1 point. You should pick between these by aiming for the highest possible points without exceeding 21. That is, if counting an ACE as 11 points would cause your total points to be 22 or more, you should count that ACE as 1 point.

## Test your code

1.  Re-run the tests:

        mvn clean test

    You should now see a message like:

        [INFO] ------------------------------------------------------------------------
        [INFO] BUILD SUCCESS
        [INFO] ------------------------------------------------------------------------

    Your code is now passing the tests that were given to you. This is a good sign, but note that **a successful `mvn test` does not guarantee you full credit on an assignment**. We will run extra tests on your code when grading it. For example, the tests you have been given do not test your handling of ACE cards.

## Save your changes while you work

1. As you make changes to the code, you should regularly save them to the Git repository. First, add any files with changes to the Git staging area. For this assignment, that will typically mean running something like the following command:

        git add src/main/java/edu/uab/cis/agents/blackjack/DealerAgent.java

2.  Then commit all the staged changes to your local Git clone. Run the following command, providing an informative commit message:

        git commit -m "...your comment about what you changed in the code..."

3.  Push your local commits to your remote Git repository on `git.cis.uab.edu`. Run the following command:

        git push

4.  Verify that your changes have been pushed. Go to `https://git.cis.uab.edu/.../agents-blackjack`, where `...` is your CIS username. You should see your newest commit displayed near the top of the page.

5. You should repeat this process regularly while you edit your code to make sure that your in-progress work is always backed up.

## Submit your assignment

1.  To submit your assignment, just make sure that you have pushed all of your changes to `git.cis.uab.edu`.

2.  I will inspect the date of your last push to your `git.cis.uab.edu` repository. If it is after the deadline, your submission will be marked as late. So please **do not push changes to `git.cis.uab.edu` after the assignment deadline** unless you intend to submit a late assignment.
