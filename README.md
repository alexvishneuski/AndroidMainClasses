# AndroidMainClasses
How can I use Android main classes

1. different between startActivity() & the startActivityForResult()
If the newly started activity does not need to return a result, the current activity can start it by calling the startActivity() method.
    Intent intent = new Intent(this, SignInActivity.class);
    startActivity(intent);


cases

#1. after trace: MainActivity->LoginActivity->AppActivity
 in case press of the back key must skip LoginActivity: from AppActivity->MainActivity
 1.1. used onBackPressed in AppActivity
 1.2. used intent's flag FLAG_ACTIVITY_NO_HISTORY in MainActivity
 for 1.2. added new Activity: InStackUnSavedActivity, used intent's flag FLAG_ACTIVITY_NO_HISTORY in MainActivity too.

#2 save state after screen rotate in  LoginActivity. There must by saved press some button's count:
1.1. approach 1: used onRestoreInstanceState in LoginActivity (for login button)
1.2. approach 1: used getter in onCreate in LoginActivity (for sign up button)
There is applied onSavenstanceState in LoginActivity for both approaches

Note: in case intent in MainActivity get flag no_history, LoginActivity's state is not saved

#3 use startActivityForResult
in MainActivity through  mStartActivityForResultButton go to WithResultActivity,
there we input some name and on click return to  MainActivity and get Toast with this name
used:   in MainActivity: startActivityForResult(), getStringExtra() and onActivityResult()
        in WithResultActivity: intent.putExtra, setResult()

TODO 3.1: to apply startActivityForResult for logging(after input password and name and return this data to MainActivity. There to compare with some final data, in ok case to continue to appActivity)
like in training-project