# 10DashingDigits

Well Paula, this is it. Here is my final project. Please keep in mind that I need at least 70 points to pass the course. That is why I
am writing this readme, so that I can explain a few things and perhaps help my case a bit.

Following are features of the syllabus:

Project Scope: In my opinion, it should at least be in the good category. Project solves problem of interest form me. As in, it records
the timestamps for correct keystrokes and is capable of playing it back later. Project includes database, web service, assorted libraries,
and at the very least, an attempt on security, logging, and unit testing. Before I move on, for security, I never was able to get it
working. I think that when I set up tomcat or something, I managed to screw up. Anyways, I will include all of the necessary jsps,
web.xml file, and tomcat-users.xml file in my project. As for logging, I had to kind of leave it out of my project. I had it coded into
the project, but I have all references to it commented out. If I leave it in there, it causes a stack overflow. I don't know why. It
made the project impossible to run. Still, I at least made an attempt at it. In regards to testing, I tried to make the tests as good as
possible. It has pretty decent coverage in my opinion, so hopefully it is enough. There were naturally a few things that I didn't write
tests for. Those would include the servlets, because I don't even know if I could, and my custom-made exceptions.

Independent Research: jQuery, Gson. Jquery is what makes the jsps call the servlets and get back information. I didn't really remember
anything from the AJAX class last spring, and therefore had to relearn the basics. Gson was a small library used to transform a java
object to JSON. Anyways, I was able to solve a good number of problems on my own.

Code Quality: I personally think it is in the excellent category. I did quite a bit of javadocs, except for the servlets. There is good
structure to the project. The code should be pretty readable since I wanted to keep it simple for my own viewing. The tests are as good
as I could think to make them.

Staying On Schedule: You got me there. I wasn't too good about keeping a schedule to even begin with. I did at least make an initial
problem statement. Also, I completed the project. So...that's keeping the ultimate schedule. Isn't it?...Isn't it?

Revision From Feedback: Of the few code reviews that I got back, I knew it would say that I needed to make changes. I mean, I knew
that I would start out small and work my way up to something much better. In essence, I think I followed the code review check list.

Complexity: I asked you in class, you said all of our things fell into the complex or difficult range. I'm sure mine has become more
complex since then.

Presentation: I think we both know that everybody's presentation was great.

Final Notes: If by chance you want to recreate the database on your own system, I'll include a sql file. After that run the populate
database file. Actually, before you do that, edit the values in the two for loops. First value is word lists, and the second value is
game sessions. Don't make the second value larger than 10, otherwise it would be pointless. Be aware, it takes quite a bit of time
for the process to complete. Going back to the security thing. I'm going to include those files because, even though it doesn't work
for me, perhaps it will run correctly for you assuming you have the truly good setup. Also, you may wan't to run the tests lastly.
Some bad data might end up in the database and as a result could break the program if it is selected out of there.
