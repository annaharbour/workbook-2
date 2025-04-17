Prompt the user for a game score.
The user will input a score in the following format:
Home:Visitor|21:9
Based on the user input, you should determine which team had the higher score
and display the name of the winning team.
Hint: You will have to split the user input multiple times to get all of the information

- one split will be on the pipe ( | )
- one split will be on the colon ( : )

- A sample trace of your program output is shown below. Bolded code is what the
  user entered.
  Please enter a game score: Home:Visitor|21:9↵
  Winner: Home
  A different trace would be:
  Please enter a score: Slytherin:Gryffindor|23:59↵
  Winner: Gryffindor