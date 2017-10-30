# AndroidMainClasses
How can I use Android main classes

1. different between startActivity() & the startActivityForResult()
If the newly started activity does not need to return a result, the current activity can start it by calling the startActivity() method.
    Intent intent = new Intent(this, SignInActivity.class);
    startActivity(intent);


cases

#1. trace: MainActivity->LoginActivity->AppActivity
 and in case press of the back key in AppActivity->MainActivity (skip LoginActivity)
 1.1. use onBackPressed in AppActivity
 1.2. use intent's flag FLAG_ACTIVITY_NO_HISTORY in MainActivity

#2
