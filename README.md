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

#2 save state after screen rotate in  LoginActivity. There must by saved press some button's count:
1.1. approach 1: used onRestoreInstanceState in LoginActivity (for login button)
1.2. approach 1: used getter in onCreate in LoginActivity (for sign up button)
There is applied onSavenstanceState in LoginActivity for both approaches

Note: in case intent in MainActivity get flag no_history, LoginActivity's state is not saved
