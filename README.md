# Virtual-Moped-Simulation-Game

This program allows a user to drive a virtual Moped around the virtual streets of Manhattan.

<ul>
The program accepts the following commands from the user:
  <li>"go left"</li>
  <li>"go right"</li>
  <li>"straight on"</li>
  <li>"back up"</li>
  <li>"how we doin'?"</li>
  <li>"fill 'er up"</li>
  <li>"park"</li>
  <li>"go to Bluestone Lane"</li>
  <li>"help"</li>
</ul>

<br/>
<br/>

<h1>More about the command</h1>
<br/>
<h2>Driving</h2>
  <p>
    The user can instructs the Moped to "go left", "go right", "straight on", or "back up", and Moped <strong>moves one block</strong> in the chosen direction.
     <br/>
    The Moped always starts out its life at 10th St. and 5th Ave., facing South.
     <br/>
    The program announce the Moped's current location and orientation (which cardinal direction it is facing), when it starts, and with every move.
     <br/>
    If the user commands the Moped to "park", then the program outputs a message indicating the Moped has been parked on the sidewalk, and quits. 
     <br/>
    (For player: turning left while going forwards is a different thing from turning left while in reverse)
     <br/>
  <p>
<br/>

<h2>Gas</h2>
  <p>
    The moped's gas tank stores up to <strong>1 gallon</strong>. It comes pre-filled.
     <br/>
    Driving the moped burns <strong>1/20th of gallon per city block</strong>.
     <br/>
    If the user enters the command, <strong>"how we doin'?"</strong>, the program outputs the current level of gasoline in the tank, as a percentage.
     <br/>
    If the Moped runs out of gas, the user is notified that the Moped has run out of gas and no longer drives, and the program should quit.
     <br/>
    To refill the gas tank, the user simply instructs the program to <strong>"fill 'er up"</strong>.
     <br/>
  </p>
<br/>

<h2>Homing</h2>
  <p>
    The Moped has a special "go to Bluestone Lane" command that automatically drives the Moped from wherever it happens to be to Bluestone Lane restaurant at 8th St. and 4th Ave.
     <br/>
    The Moped will auto-drive itself one block at a time to the address of Bluestone Lane, outputting its location with each block.
     <br/>
    the Moped will use the same methods to move block-by-block and same amount of gas when homing as when being manually driven. 
     <br/>
    If it needs to fill up gas while homing, it will do so automatically and then continue. The only difference between homing and manual driving is that the user is not being asked what the Moped should do, the Moped is deciding for itself.
  </p>
  <br/>
  
<h2>Location-based advertising</h2>
  <p>
    Our Moped is paid for by advertising, and should output ads when it reaches the locations of our current clients:
     <br/>
      <br/>

    at 79th St. and 8th Ave., the Moped should output an ad for the American Museum of Natural History.
     <br/>
    at 74th St. and 1st Ave., the Moped should output an ad for Memorial Sloan Kettering.
     <br/>
    at 12th St. and 4th Ave., the Moped should output an ad for The Strand book shop.
     <br/>
    at 3rd St. and 6th Ave., the Moped should output an ad for Fayda Coffee Tea Cookies Cake shop.
     <br/>
  </p>
 
 <h2>Help</h2>
   <p>
    If the user enters the command, "help", the program will display a list of commands that the program understands.
   </p>
 <br/>

 <h1>Extra "drunk driver" Mopeds Introduced!</h1>
 <p>
  <strong>There are two "drunk driver" Mopeds that drive themselves around erratically one block at a time.</strong>
  <br/>
  <ul>
    <li>Drunk driver Mopeds must be instantiated from the same class as user-driven Mopeds. Your job is to modify the code in this class to allow for both kinds of Mopeds.  </li>
    <li>These robotic self-driving Mopeds should automatically follow a random path, or any path you design for them, as they move one block at a time around Manhattan.  </li>
    <li>Drunk driver Mopeds perform all the same behaviors as user-driven Mopeds, except they do so without human intervention.  </li>
    <li>Drunk driver Mopeds use gas like the user's Moped, but they never run out of gas - they automatically fill up their gas when they are nearly out of gas.  </li>
    <li>Drunk driver Mopeds never crash into each other. They only crash into the user's Moped.  </li>
    <li>If the user's Moped and either of the robotic Mopeds are at the same location at the same time, they should crash into each other and the user should be notified that their Moped has crashed, is totally unusable, and the program should quit.  </li>
    <li>Like the human-driven moped, each drunk driver moped must announce its location and orientation after every move. All output in this version must clearly identify which Moped is at which position.  </li>
  </ul>
 </p>
 
 <h2>Sample Game Sample</h2>
 <p>
  Still don't know how to play? Here is a sample! User input is <strong>bold</strong>.
 <br/>
 <br/>
 Thanks for jumping on the moped.  We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave, facing South.  May I say your teeth look very clean.
  <br/>
 What would you like to do?  At any time, say "help" for assistance.  
   <br/>
  <strong>back up</strong>
   <br/>
  Now at 11th St. and 5th Ave, facing South.
   <br/>
   <strong>back up</strong>
   <br/>
  Now at 12th St. and 5th Ave, facing South.
   <br/>
   <strong>go left</strong>
   <br/>
  Now at 12th St. and 4th Ave, facing West.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927? 
   <br/>
   <strong>how we doin'?</strong>
   <br/>
  The gas tank is currently 85% full.
   <br/>
   <strong>go to Bluestone Lane</strong>
   <br/>
  Now at 12th St. and 5th Ave, facing West.
   <br/>
  Now at 11th St. and 5th Ave, facing South.
   <br/>
  Now at 11th St. and 4th Ave, facing East.
   <br/>
  Now at 10th St. and 4th Ave, facing South.
   <br/>
  Now at 9th St. and 4th Ave, facing South.
   <br/>
  Now at 8th St. and 4th Ave, facing South.  We have reached the Bluestone Lane.  Enjoy your cappuccino.
   <br/>
   <strong>go left</strong>
   <br/>
  ...etc...
   <br/>
 </p>
   
 <h1> Enjoy! </h1>
