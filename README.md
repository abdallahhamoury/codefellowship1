# codefellowship
### Labs 16 : CodeFellowship Login, Profiles & Posts
#### Feature Tasks

Build an app that allows users to create their profile on CodeFellowship
- The site must have a starting page in the root path (/) that contains basic information about the site, as well as a link to the "Registration" page. ApplicationUser must have a username, password (which will be hashed with BCrypt), first and last name Date of birth, CV and any other fields you think are useful.
- The site should be well-designed and attractive. The site should have a non-white-label error handling page that allows the user to know the error code and at least a brief message about the error that occurred.
  The site should use reusable forms for its information. (At a minimum, it should contain one part of a Thymeleaf paper to be used on multiple pages.)
- The site must allow users to create an Application User on the Registration page.
  Your console must have an Autowired Private PasswordEncoder passwordEncoder; And use that to run the site must have a page that allows data about a single user of the app to be displayed, on a path like /users/{id}passwordEncoder.encode(the password) before the password is saved in the new user.
- Make sure that user registration also automatically logs users into your app.
  Add the Post entity to your app.
  The post has text and timestamp generated.
  The logged in user must be able to create a post, and the post must belong to the user who created it.
  Hint: This is a relationship between two pieces of data
  User posts must be visible on their profile page.
- The site must have a page that allows data about a single user of the app to be displayed, on a path like /users/{id}.
  This should include the default profile picture, which is the same for each user, and their basic information.
  Using the cheat sheet above, add the ability for users to log into your app.
  When the user is logged in, the app should display the user's username on each page (maybe in the title).
-----------------------------------------------------------------------------------------------


### lab 17 : CodeFellowship Login, Profiles & Posts
#### Feature Tasks
Build an app that allows users to create their profile on CodeFellowship.
- The site should have a splash page at the root route (/) that contains basic information about the site, as well as a link to the “sign up” page.
- Using the above cheat sheet, add the ability for users to log in to your app.
  When a user is logged in, the app should display the user’s username on every page (probably in the heading).
- Ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.
- The site should be well-styled and attractive.
- The site should use reusable templates for its information. (At a minimum, it should have one Thymeleaf fragment that is used on multiple pages.)
- The site should have a non-whitelabel error handling page that lets the user know, at minimum, the error code and a brief message about what went wrong.
- Ensure that user registration also logs users into your app automatically.
- An ApplicationUser should have a username, password (will be hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
- The site should allow users to create an ApplicationUser on the “sign up” page.
- Your Controller should have an @Autowired private PasswordEncoder passwordEncoder; and use that to run passwordEncoder.encode(password) before saving the password into the new user.
- The site should have a page which allows viewing the data about a single ApplicationUser, at a route like /users/{id}.
- This should include a default profile picture, which is the same for every user, and their basic information.
- Add a Post entity to your app.
    A Post has a body and a createdAt timestamp.
    A logged-in user should be able to create a Post, and a post should belong to the user that created it.
    hint: this is a relationship between two pieces of data
    A user’s posts should be visible on their profile page.