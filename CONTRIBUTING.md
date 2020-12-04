# Issues  
There are three types of issues: Bugs, Questions and Enhcanements.   
## Bugs  
Bugs are things that are supposed to work but don't.   
Some examples include:
* An error or exception
* A flaw in a security feature
* Encoded messages not decoding properly

Non examples include:
* A security issue not yet advertised (such as adding RSA encrytion)
* Adding something new, instead of fixing something old
* Asking a question about something you don't get
If you find a bug, label it with the "bugs" tag, as well as the "security" tag if the bug relates to security. Then, be sure to label it as follows:
``` 
**Issue Description**
Description of your issue
**System Details**
* Interpreter version X (i.e. repl.it or IDLE version 2020-09). If using a command prompt, say the name of the program you enter, like "python3", and the version, using --version.
* HOP Encode/Decode (which program is malfunctioning)
**Steps to reproduce**
Make sure that the steps can be easily followed.
1. Do step 1
2. Do step 2
3. Do step 3
etc.
**Expected behavior**
What is supposed to happen
**Actual behavior**
What actually happened
**Exception**
If you got an exception, list it below.
`Exception`
**Screenshots**
Any screenshots you deem necessary. Optional, but helpful.
```
## Questions
Questions are things that you are unsure about. When in doubt, mark it as a question. If you have a question, label it in the following manner: 
```
**Question**
Make sure you are clear and concise. Clear means the average person can understand what you want to know, and concise means the question isn't too long.
**System Details**
* Interpreter version X (i.e. repl.it or IDLE version 2020-09). If using a command prompt, say the name of the program you enter, like "python3", and the version, using --version.
* HOP Encode/Decode (which program you are confused about)
**Screenshots**
Any screenshots you deem necessary. Optional, but helpful.
```
## Enhancements
Enhancements are things you want to improve. Be sure to list it both as an enhancement and label it based on what type of enhancement it is:  
Security: This is an improvement to security you would like to see, such as RSA encryption.  
QOL: This is an improvement to quality of life you would like to see, such as more lanugages as codes. If in doubt, mark it as QOL.  
Documentation: This is an improvement to documentation you would like to see.  
Be sure to label the enhancement as follows:
```
**Program to Enhance**
What you want to enhance. Examples include HOP Encode and HOP Decode.
**Description of Enhancement**
A clear and concise descrpition of how you want to enhance the program.
**Approach**
Possible ways to accomplish this enhancement.
**Screenshots**
Any screenshots you deem necessary. Optional, but helpful.
```
# Pull Requests
Pull requests are when you want to change the code yourself. Please link to any relavent issues by clicking on the gear next to "linked issues". 
Additionally, add this to the milestone the issues are linked to, and label it based on what you are trying to solve (Bug or Enhancement and what type if necessary).
They should be formatted as follows:
```
**Changes**
A bulleted list of the changes you made. Will be used in release notes.
**Reasoning**
Why you want to make these changes. Should be clear and concise.
**Drawback Handling**
Potential drawbacks in this change and how you addressed them.
```
