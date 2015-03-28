# AutoGrader
Tool I'll be using to grade homeworks as teaching assistant.

In my opinion it is easy to use:
You just have to prepare some input files with the corresponding output ones and put them in the right folders.

For example:

__input files:__
~~~~~~~~~~~~~~~{.java}
User@USER-PC ~/Documents/Tester/hw01_tests/input
$ ls
in1  in2  in3
~~~~~~~~~~~~~~~

__output files:__
~~~~~~~~~~~~~~~{.java}
User@USER-PC ~/Documents/Tester/hw01_tests/output
$ ls
out1  out2  out3
~~~~~~~~~~~~~~~

__And last - some homeworks to test:__
~~~~~~~~~~~~~~~{.java}
User@USER-PC ~/Documents/Tester/hw01
$ ls
fn001.cpp  fn002.cpp  fn003.cpp
~~~~~~~~~~~~~~~

-------------------------------------------
Now modify the <i>solutionsFolder</i>, <i>inputsFolder</i> and <i>outputsFolder</i> String variables in the <i>Main.java</i> to match yours. After runnig the app it will run each of the solutions with the given inputs and match the answers with the ones you provide. It will tell you how the tests went, and even if there were any errors:

~~~~~~~~~~~~~~~{.java}
fn0001: YES YES YES  3 points
fn0002: C:\Users\User\Documents\Tester\hw01\fn0002.cpp: In function 'int main(int, char**)':
C:\Users\User\Documents\Tester\hw01\fn0002.cpp:111:12: warning: division by zero [-Wdiv-by-zero]
  cout << a / 0;
            ^
CE           0 points
fn0003: NO  YES YES  2 points
~~~~~~~~~~~~~~~
